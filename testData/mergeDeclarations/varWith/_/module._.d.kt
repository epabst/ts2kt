@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")
@file:JsModule("lodash")
package mergeDeclarations.varWith.`_`

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

external interface LoDashStatic {
    @nativeInvoke
    operator fun invoke(value: Number): LoDashWrapper<Number>
    var VERSION: String
    var support: mergeDeclarations.varWith.`_`.Support
}
external interface Support {
    var argsClass: Boolean
    var argsObject: Boolean
}
external interface LoDashArrayWrapper<T> {
    fun difference(vararg others: Array<T>): mergeDeclarations.varWith.`_`.LoDashArrayWrapper<T>
    fun difference(vararg others: List<T>): mergeDeclarations.varWith.`_`.LoDashArrayWrapper<T>
}
