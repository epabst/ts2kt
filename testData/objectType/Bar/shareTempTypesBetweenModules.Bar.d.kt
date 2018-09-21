@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")
@file:JsQualifier("Bar")
package objectType.Bar

import kotlin.js.*
import kotlin.js.Json
import org.khronos.webgl.*
import org.w3c.dom.*
import org.w3c.dom.events.*
import org.w3c.dom.parsing.*
import org.w3c.dom.svg.*
import org.w3c.dom.url.*
import org.w3c.fetch.*
import org.w3c.files.*
import org.w3c.notifications.*
import org.w3c.performance.*
import org.w3c.workers.*
import org.w3c.xhr.*

external interface `T$2` {
    fun bar(a: Any): Number
    var baz: Any? get() = definedExternally; set(value) = definedExternally
    var boo: Any? get() = definedExternally; set(value) = definedExternally
    var show: (overrideChecks: Boolean) -> Unit
}
external fun someFunction(opt: `T$2`): Unit = definedExternally
external interface `T$3` {
    var value: Any? get() = definedExternally; set(value) = definedExternally
    var done: Boolean
}
external fun anotherReturnsObjectType(): `T$3` = definedExternally
external object foo {
    fun bar(a: Any): Number = definedExternally
    fun baz(a: Any, b: Any, c: String): Boolean = definedExternally
}
