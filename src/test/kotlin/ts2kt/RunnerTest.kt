package ts2kt

import node.EncodingOptions
import node.fs
import node.path
import kotlin.test.Test
import kotlin.test.assertEquals

class RunnerTest {
    val TS_EXT = ".ts"
    val KT_EXT = ".kt"
    val UNVERIFIED_FILE_PREFIX = "// OUT:"

    @Test
    fun translateToFile() {
        translateDirectory("testData", emptyList())
        verifyDirectory("testData", emptyList())
    }

    private fun translateDirectory(srcDir: String, fqNames: List<String>) {
        val path = (listOf(srcDir) + fqNames).joinToString("/")
        console.info("Looking in $path")
        fs.readdirSync(path).forEach { file ->
            if (file.endsWith(".ts")) {
                val srcPath = path + "/" + file
                val outPath = srcPath.replace(TS_EXT, KT_EXT) + ".out"
                val basePackage = if (fqNames.isEmpty()) null else fqNames.joinToString(".")
                translateToFile(srcPath, outPath, basePackage = basePackage)
            } else if (!file.contains(".")) {
                translateDirectory(srcDir, fqNames + file)
            }
        }
    }

    private fun verifyDirectory(srcDir: String, fqNames: List<String>) {
        val path = (listOf(srcDir) + fqNames).joinToString("/")
        console.info("Looking in $path")
        fs.readdirSync(path).forEach { file ->
            if (file.endsWith(".ts")) {
                verifyFile(path + "/" + file)
            } else if (!file.contains(".")) {
                verifyDirectory(srcDir, fqNames + file)
            }
        }
    }

    fun verifyFile(srcPath: String, expectedUberPath: String = srcPath.replace(TS_EXT, KT_EXT)) {
        val expectedUberDir = path.dirname(expectedUberPath)
        val actualUberPath = expectedUberPath + ".out"
        console.log("\n--------\nsrcPath = " + srcPath +
                ", outPath = " + actualUberPath +
                ", expectedPath = " + expectedUberPath + "\n")
        val encodingOptions = EncodingOptions(encoding = "utf8")
        val actual = fs.readFileSync(actualUberPath, encodingOptions)
        val comparisons = actual.split(FILE_DELIMITER).map { actualContentWithHeader ->
            val match = Regex("// File: (.*?)\n").find(actualContentWithHeader)
            val expectedPath = match?.let { expectedUberDir + "/" + match.groups.get(1)?.value } ?: expectedUberPath
            val expectedDir = path.dirname(expectedPath)
            val actualContent = if (match != null) actualContentWithHeader.substringAfter('\n') else actualContentWithHeader
            val expected: String?
            if (!fs.existsSync(expectedPath)) {
                if (!fs.existsSync(expectedDir)) {
                    fs.mkdirSync(expectedDir)
                }
                expected = UNVERIFIED_FILE_PREFIX + "\n" + actualContent
                fs.writeFileSync(expectedPath, expected)
            } else {
                expected = fs.readFileSync(expectedPath, encodingOptions)
            }
            FileComparison(actualContent, expectedPath, expected)
        }
        comparisons.forEach { comparison ->
            assertEquals(comparison.expectedContent, comparison.actualContent, "expectedPath: ${comparison.expectedPath}, outPath=$actualUberPath")
        }
    }
}

private class FileComparison(val actualContent: String, val expectedPath: String, val expectedContent: String)
