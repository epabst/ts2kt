/*
 * Copyright 2013-2014 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ts2kt

import node.fs
import node.module
import node.path
import node.process
import ts2kt.kotlin.ast.stringify
import ts2kt.utils.DiagnosticLevel
import ts2kt.utils.diagnosticLevel
import ts2kt.utils.reportUnsupportedKinds
import ts2kt.utils.trackUnsupportedKinds

private val KOTLIN_FILE_EXT = ".kt"

// Used from tests
@Suppress("unused")
fun translateToFile(srcPath: String, outPath: String) {
    val fileContentByPath = translateToFileContentByPath(listOf(srcPath))

    val out =
            if (fileContentByPath.isNotEmpty()) {
                fileContentByPath.values.joinToString("\n// ${"-".repeat(90)}\n")
            }
            else "// NO DECLARATIONS"

    fs.writeFileSync(outPath, out)
}

private fun mkDirs(dirs: String): Boolean {
    val parts = dirs.split(path.sep)
    if (parts.isEmpty()) return true

    if (!fs.existsSync(parts[0])) {
        fs.mkdirSync(parts[0])
    }

    parts.reduce { parent, name ->
        val cur = parent + path.sep + name

        if (!fs.existsSync(cur)) {
            fs.mkdirSync(cur)
        }

        cur
    }

    return true
}

private fun translateToFileContentByPath(
        sources: List<String>,
        basePackage: String? = null,
        declareModifierIsOptional: Boolean = false): Map<String,String> {

    val result = mutableMapOf<String,String>()
    for (src in sources) {
        console.log("Converting $src")
        val baseSrcName = path.basename(src, TYPESCRIPT_DEFINITION_FILE_EXT)
        val packageParts = translate(src, basePackage ?: "", declareModifierIsOptional)

        if (packageParts.isEmpty()) {
            console.log("Nothing was converted")
            continue
        }

        packageParts.forEach {
            val outFileName = (listOf(baseSrcName) + it.fqName).joinToString(".") + KOTLIN_FILE_EXT

            val imports = listOf(
                    "kotlin.js.*",
                    "kotlin.js.Json",
                    "org.khronos.webgl.*",
                    "org.w3c.dom.*",
                    "org.w3c.dom.events.*",
                    "org.w3c.dom.parsing.*",
                    "org.w3c.dom.svg.*",
                    "org.w3c.dom.url.*",
                    "org.w3c.fetch.*",
                    "org.w3c.files.*",
                    "org.w3c.notifications.*",
                    "org.w3c.performance.*",
                    "org.w3c.workers.*",
                    "org.w3c.xhr.*")

            val suppressedDiagnostics = listOf(
                    "INTERFACE_WITH_SUPERCLASS",
                    "OVERRIDING_FINAL_MEMBER",
                    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
                    "CONFLICTING_OVERLOADS",
                    "EXTERNAL_DELEGATION",
                    "NESTED_CLASS_IN_EXTERNAL_INTERFACE")

            result.put(outFileName, it.stringify(packagePartPrefix = basePackage, topLevel = true, additionalImports = imports, suppressedDiagnostics = suppressedDiagnostics))
        }
    }
    return result
}

fun translateToDir(
        sources: List<String>,
        outDir: String, basePackage: String? = null,
        libraries: List<String> = emptyList(),
        declareModifierIsOptional: Boolean = false
) {
    val fileContentByPath = translateToFileContentByPath(sources, basePackage, declareModifierIsOptional)

    console.log("Save declarations:")

    fileContentByPath.forEach { (relativeOutPath, content) ->
        val outFilePath = outDir + "/" + relativeOutPath
        console.log("\t$outFilePath")

        val fileDir = path.dirname(outFilePath)
        if (!fs.existsSync(fileDir)) mkDirs(fileDir)
        fs.writeFileSync(outFilePath, content)
    }
}

data class CliArguments(
        val sources: List<String>,
        val outDir: String,
        val basePackage: String?,
        val libraries: List<String>,
        val declareModifierIsOptional: Boolean
)

private fun printUsage(program: String) {
    console.log("""
                Usage: $program [<options>] <d.ts files>
                where possible options include:
                    -d <path>                   Destination directory for files with converted declarations,
                                                current directory is used by default
                    -h                          Print a synopsis of standard options
                    -v, -version                Print version
                    -X                          Print a synopsis of advanced options
                """.trimIndent())
}

fun parseArguments(): CliArguments? {
    fun Iterator<String>.readArg(): String? {
        if (!hasNext()) return null
        val v = next()
        if (v.startsWith("-")) return null
        return v
    }

    val program = "ts2kt"

    fun printVersion() {
        val version = try {
            js("require('./package.json')").version
        }
        catch (e: Throwable) {
            "<unknown>"
        }
        console.log("$program version: $version")
    }

    val args = process.argv.drop(2)

    if (args.isEmpty()) {
        printUsage(program)
        return null
    }

    val it = args.iterator()

    val other = mutableListOf<String>()

    var destination: String? = null
    var basePackage: String? = null
    var declareModifierIsOptional = false

    while (it.hasNext()) {
        val arg = it.next()

        when (arg) {
            "-h" -> {
                printUsage(program)
                return null
            }
            "-d" -> {
                val p = it.readArg()
                if (p == null) {
                    console.error("'-d' should be followed by path to destination directory")
                    return null
                }
                destination = p
            }
            "-l" -> {
                console.error("'-l' not supported yet")
                return null
            }
            // TODO add to "usage"
            "-p" -> {
                val p = it.readArg()
                if (p == null) {
                    console.error("$arg should be followed by base package fq-name")
                    return null
                }

                basePackage = p
            }
            "-v", "-version" -> {
                printVersion()
                return null
            }
            "-X" -> {
                console.log("""
                            Usage: $program <options> <d.ts files>
                            where possible options include:
                                -Xdeclare-is-optional       Treat declare keyword for top level declarations as optional
                                -Xdiagnostic-level <level>  How report diagnostics, ${DiagnosticLevel.DEFAULT} by default,
                                        where level can be any of {${DiagnosticLevel.values().joinToString()}}
                                -Xtrack-unsupported-kinds   Enable tracking unsupported node kinds and print statistic at the finish
                            """.trimIndent())
                return null
            }
            "-Xdiagnostic-level" -> {
                val p = it.readArg()
                val level = p?.let { DiagnosticLevel.valueOf(p) }
                if (level == null) {
                    console.error("'-Xdiagnostic-level' should be followed by one of " + DiagnosticLevel.values().joinToString())
                    return null
                }
                diagnosticLevel = level
            }
            "-Xtrack-unsupported-kinds" -> {
                trackUnsupportedKinds = true
            }
            "-Xdeclare-is-optional" -> {
                declareModifierIsOptional = true
            }
            else -> {
                other += arg
            }
        }
    }

    val (_, allSources) = other.partition { it.startsWith("-") }

    val sources = allSources.filter { it.endsWith(TYPESCRIPT_DEFINITION_FILE_EXT) }

    printVersion()

    if (sources.size != allSources.size) {
        console.error("$program supports to convert only TypeScript definition files (d.ts)")
        return null
    }

    if (sources.isEmpty()) {
        console.error("No files to convert")
        return null
    }

    return CliArguments(sources, destination ?: ".", basePackage, emptyList(), declareModifierIsOptional)
}

fun main(args: Array<String>) {
    // do nothing when it loaded as library
    if (module.parent != null) return

    val (sources, destination, basePackage, libraries, declareModifierIsOptional) = parseArguments() ?: return

    translateToDir(sources, destination, basePackage, libraries, declareModifierIsOptional)

    if (trackUnsupportedKinds) {
        reportUnsupportedKinds()
    }
}
