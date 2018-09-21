@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")
@file:JsQualifier("Ext")
package mergeDeclarations.moduleWith.Ext

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

external interface IBase
external interface IAbstractComponent : mergeDeclarations.moduleWith.Ext.IBase, mergeDeclarations.moduleWith.Ext.util.IPositionable, mergeDeclarations.moduleWith.Ext.util.IObservable, mergeDeclarations.moduleWith.Ext.util.IAnimate, mergeDeclarations.moduleWith.Ext.util.IElementContainer, mergeDeclarations.moduleWith.Ext.util.IRenderable, mergeDeclarations.moduleWith.Ext.state.IStateful {
    var autoEl: Any
    var autoLoad: Any? get() = definedExternally; set(value) = definedExternally
    var autoRender: Any
}
external var num: Number = definedExternally
external fun foo(): Unit = definedExternally
external interface IAbstractPlugin : mergeDeclarations.moduleWith.Ext.IBase {
    var pluginId: String? get() = definedExternally; set(value) = definedExternally
    var isPlugin: Boolean? get() = definedExternally; set(value) = definedExternally
}
external var str: String = definedExternally
external fun bar(): Unit = definedExternally
