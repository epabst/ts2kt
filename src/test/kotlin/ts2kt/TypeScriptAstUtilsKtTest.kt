package ts2kt

import kotlin.test.Test
import kotlin.test.assertEquals

class TypeScriptAstUtilsKtTest {
    @Test
    fun sanitizeAndEscapeIfNeed() {
        val packageName = listOf("class", "hello").joinToString(".", transform = { it.sanitize().escapeIfNeed() })
        assertEquals("package `class`.hello", "package " + packageName)
    }
}
