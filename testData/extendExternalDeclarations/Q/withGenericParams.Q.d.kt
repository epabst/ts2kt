@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")
package extendExternalDeclarations.Q

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

fun <T, B> Promise<T>.foo(b: B): T = this.asDynamic().foo(b)
fun <T0, T, B> Promise<T0>.foo(a: Any, b: B): T = this.asDynamic().foo(a, b)
var <T> Promise<T>.bar: Array<T> get() = this.asDynamic().bar; set(value) { this.asDynamic().bar = value }
