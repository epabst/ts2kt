package jquery

@native
interface JQueryAjaxSettings {
    var accepts: Any? get() = noImpl
    var async: Boolean? get() = noImpl
    val beforeSend: ((jqXHR: JQueryXHR, settings: JQueryAjaxSettings) -> Any)? get() = noImpl
    var cache: Boolean? get() = noImpl
    val complete: ((jqXHR: JQueryXHR, textStatus: String) -> Any)? get() = noImpl
    var contents: Json? get() = noImpl
    var contentType: Any? get() = noImpl
    var context: Any? get() = noImpl
    var converters: Json? get() = noImpl
    var crossDomain: Boolean? get() = noImpl
    var data: Any? get() = noImpl
    val dataFilter: ((data: Any, ty: Any) -> Any)? get() = noImpl
    var dataType: String? get() = noImpl
    val error: ((jqXHR: JQueryXHR, textStatus: String, errorThrown: String) -> Any)? get() = noImpl
    var global: Boolean? get() = noImpl
    var headers: Json? get() = noImpl
    var ifModified: Boolean? get() = noImpl
    var isLocal: Boolean? get() = noImpl
    var jsonp: Any? get() = noImpl
    var jsonpCallback: Any? get() = noImpl
    var method: String? get() = noImpl
    var mimeType: String? get() = noImpl
    var password: String? get() = noImpl
    var processData: Boolean? get() = noImpl
    var scriptCharset: String? get() = noImpl
    var statusCode: Json? get() = noImpl
    val success: ((data: Any, textStatus: String, jqXHR: JQueryXHR) -> Any)? get() = noImpl
    var timeout: Number? get() = noImpl
    var traditional: Boolean? get() = noImpl
    var type: String? get() = noImpl
    var url: String? get() = noImpl
    var username: String? get() = noImpl
    var xhr: Any? get() = noImpl
    var xhrFields: Json? get() = noImpl
}
@native
interface JQueryXHR : XMLHttpRequest, JQueryPromise<Any> {
    // TODO: investigate
    fun overrideMimeType(mimeType: String): Any
    fun abort(statusText: String? = null)
    fun <R> then(doneCallback: (data: Any, textStatus: String, jqXHR: JQueryXHR) -> R, failCallback: ((jqXHR: JQueryXHR, textStatus: String, errorThrown: Any) -> Unit)? = null): JQueryPromise<R>
    var responseJSON: Any? get() = noImpl
    fun error(xhr: JQueryXHR, textStatus: String, errorThrown: String)
}
@native
interface JQueryCallback {
    fun add(callbacks: Function): JQueryCallback
    fun add(callbacks: Array<Function>): JQueryCallback
    fun disable(): JQueryCallback
    fun disabled(): Boolean
    fun empty(): JQueryCallback
    fun fire(vararg arguments: Any): JQueryCallback
    fun fired(): Boolean
    fun fireWith(context: Any? = null, args: Array<Any>? = null): JQueryCallback
    fun has(callback: Function): Boolean
    fun lock(): JQueryCallback
    fun locked(): Boolean
    fun remove(callbacks: Function): JQueryCallback
    fun remove(callbacks: Array<Function>): JQueryCallback
}
@native
interface JQueryGenericPromise<T> {
    fun <U> then(doneFilter: (value: T? = null, vararg values: Any) -> dynamic /* U | JQueryPromise<U> */, failFilter: ((vararg reasons: Any) -> Any)? = null, progressFilter: ((vararg progression: Any) -> Any)? = null): JQueryPromise<U>
    fun then(doneFilter: (value: T? = null, vararg values: Any) -> Unit, failFilter: ((vararg reasons: Any) -> Any)? = null, progressFilter: ((vararg progression: Any) -> Any)? = null): JQueryPromise<Unit>
}
@native
interface JQueryPromiseCallback<T> {
    @nativeInvoke
    fun invoke(value: T? = null, vararg args: Any)
}
@native
interface JQueryPromiseOperator<T, U> {
    @nativeInvoke
    fun invoke(callback1: JQueryPromiseCallback<T>, vararg callbacksN: JQueryPromiseCallback<Any>): JQueryPromise<U>
    @nativeInvoke
    fun invoke(callback1: JQueryPromiseCallback<T>, vararg callbacksN: Array<JQueryPromiseCallback<Any>>): JQueryPromise<U>
    @nativeInvoke
    fun invoke(callback1: Array<JQueryPromiseCallback<T>>, vararg callbacksN: JQueryPromiseCallback<Any>): JQueryPromise<U>
    @nativeInvoke
    fun invoke(callback1: Array<JQueryPromiseCallback<T>>, vararg callbacksN: Array<JQueryPromiseCallback<Any>>): JQueryPromise<U>
}
@native
interface JQueryPromise<T> : JQueryGenericPromise<T> {
    fun state(): String
    fun always(alwaysCallback1: JQueryPromiseCallback<Any>? = null, vararg alwaysCallbacksN: JQueryPromiseCallback<Any>): JQueryPromise<T>
    fun always(alwaysCallback1: JQueryPromiseCallback<Any>? = null, vararg alwaysCallbacksN: Array<JQueryPromiseCallback<Any>>): JQueryPromise<T>
    fun always(alwaysCallback1: Array<JQueryPromiseCallback<Any>>? = null, vararg alwaysCallbacksN: JQueryPromiseCallback<Any>): JQueryPromise<T>
    fun always(alwaysCallback1: Array<JQueryPromiseCallback<Any>>? = null, vararg alwaysCallbacksN: Array<JQueryPromiseCallback<Any>>): JQueryPromise<T>
    fun done(doneCallback1: JQueryPromiseCallback<T>? = null, vararg doneCallbackN: JQueryPromiseCallback<T>): JQueryPromise<T>
    fun done(doneCallback1: JQueryPromiseCallback<T>? = null, vararg doneCallbackN: Array<JQueryPromiseCallback<T>>): JQueryPromise<T>
    fun done(doneCallback1: Array<JQueryPromiseCallback<T>>? = null, vararg doneCallbackN: JQueryPromiseCallback<T>): JQueryPromise<T>
    fun done(doneCallback1: Array<JQueryPromiseCallback<T>>? = null, vararg doneCallbackN: Array<JQueryPromiseCallback<T>>): JQueryPromise<T>
    fun fail(failCallback1: JQueryPromiseCallback<Any>? = null, vararg failCallbacksN: JQueryPromiseCallback<Any>): JQueryPromise<T>
    fun fail(failCallback1: JQueryPromiseCallback<Any>? = null, vararg failCallbacksN: Array<JQueryPromiseCallback<Any>>): JQueryPromise<T>
    fun fail(failCallback1: Array<JQueryPromiseCallback<Any>>? = null, vararg failCallbacksN: JQueryPromiseCallback<Any>): JQueryPromise<T>
    fun fail(failCallback1: Array<JQueryPromiseCallback<Any>>? = null, vararg failCallbacksN: Array<JQueryPromiseCallback<Any>>): JQueryPromise<T>
    fun progress(progressCallback1: JQueryPromiseCallback<Any>? = null, vararg progressCallbackN: JQueryPromiseCallback<Any>): JQueryPromise<T>
    fun progress(progressCallback1: JQueryPromiseCallback<Any>? = null, vararg progressCallbackN: Array<JQueryPromiseCallback<Any>>): JQueryPromise<T>
    fun progress(progressCallback1: Array<JQueryPromiseCallback<Any>>? = null, vararg progressCallbackN: JQueryPromiseCallback<Any>): JQueryPromise<T>
    fun progress(progressCallback1: Array<JQueryPromiseCallback<Any>>? = null, vararg progressCallbackN: Array<JQueryPromiseCallback<Any>>): JQueryPromise<T>
    fun pipe(doneFilter: ((x: Any) -> Any)? = null, failFilter: ((x: Any) -> Any)? = null, progressFilter: ((x: Any) -> Any)? = null): JQueryPromise<Any>
    fun promise(target: Any? = null): JQueryPromise<T>
}
@native
interface JQueryDeferred<T> : JQueryGenericPromise<T> {
    fun state(): String
    fun always(alwaysCallback1: JQueryPromiseCallback<Any>? = null, vararg alwaysCallbacksN: JQueryPromiseCallback<Any>): JQueryDeferred<T>
    fun always(alwaysCallback1: JQueryPromiseCallback<Any>? = null, vararg alwaysCallbacksN: Array<JQueryPromiseCallback<Any>>): JQueryDeferred<T>
    fun always(alwaysCallback1: Array<JQueryPromiseCallback<Any>>? = null, vararg alwaysCallbacksN: JQueryPromiseCallback<Any>): JQueryDeferred<T>
    fun always(alwaysCallback1: Array<JQueryPromiseCallback<Any>>? = null, vararg alwaysCallbacksN: Array<JQueryPromiseCallback<Any>>): JQueryDeferred<T>
    fun done(doneCallback1: JQueryPromiseCallback<T>? = null, vararg doneCallbackN: JQueryPromiseCallback<T>): JQueryDeferred<T>
    fun done(doneCallback1: JQueryPromiseCallback<T>? = null, vararg doneCallbackN: Array<JQueryPromiseCallback<T>>): JQueryDeferred<T>
    fun done(doneCallback1: Array<JQueryPromiseCallback<T>>? = null, vararg doneCallbackN: JQueryPromiseCallback<T>): JQueryDeferred<T>
    fun done(doneCallback1: Array<JQueryPromiseCallback<T>>? = null, vararg doneCallbackN: Array<JQueryPromiseCallback<T>>): JQueryDeferred<T>
    fun fail(failCallback1: JQueryPromiseCallback<Any>? = null, vararg failCallbacksN: JQueryPromiseCallback<Any>): JQueryDeferred<T>
    fun fail(failCallback1: JQueryPromiseCallback<Any>? = null, vararg failCallbacksN: Array<JQueryPromiseCallback<Any>>): JQueryDeferred<T>
    fun fail(failCallback1: Array<JQueryPromiseCallback<Any>>? = null, vararg failCallbacksN: JQueryPromiseCallback<Any>): JQueryDeferred<T>
    fun fail(failCallback1: Array<JQueryPromiseCallback<Any>>? = null, vararg failCallbacksN: Array<JQueryPromiseCallback<Any>>): JQueryDeferred<T>
    fun progress(progressCallback1: JQueryPromiseCallback<Any>? = null, vararg progressCallbackN: JQueryPromiseCallback<Any>): JQueryDeferred<T>
    fun progress(progressCallback1: JQueryPromiseCallback<Any>? = null, vararg progressCallbackN: Array<JQueryPromiseCallback<Any>>): JQueryDeferred<T>
    fun progress(progressCallback1: Array<JQueryPromiseCallback<Any>>? = null, vararg progressCallbackN: JQueryPromiseCallback<Any>): JQueryDeferred<T>
    fun progress(progressCallback1: Array<JQueryPromiseCallback<Any>>? = null, vararg progressCallbackN: Array<JQueryPromiseCallback<Any>>): JQueryDeferred<T>
    fun notify(value: Any? = null, vararg args: Any): JQueryDeferred<T>
    fun notifyWith(context: Any, value: Array<Any>? = null): JQueryDeferred<T>
    fun reject(value: Any? = null, vararg args: Any): JQueryDeferred<T>
    fun rejectWith(context: Any, value: Array<Any>? = null): JQueryDeferred<T>
    fun resolve(value: T? = null, vararg args: Any): JQueryDeferred<T>
    fun resolveWith(context: Any, value: Array<T>? = null): JQueryDeferred<T>
    fun promise(target: Any? = null): JQueryPromise<T>
    fun pipe(doneFilter: ((x: Any) -> Any)? = null, failFilter: ((x: Any) -> Any)? = null, progressFilter: ((x: Any) -> Any)? = null): JQueryPromise<Any>
}
@native
interface BaseJQueryEventObject : Event {
    override var currentTarget: Element
    var data: Any
    var delegateTarget: Element
    fun isDefaultPrevented(): Boolean
    fun isImmediatePropagationStopped(): Boolean
    fun isPropagationStopped(): Boolean
    var namespace: String
    var originalEvent: Event
    fun preventDefault(): Any
    var relatedTarget: Element
    var result: Any
    override fun stopImmediatePropagation()
    override fun stopPropagation()
    override var target: Element
    var pageX: Number
    var pageY: Number
    var which: Number
    var metaKey: Boolean
}
@native
interface JQueryInputEventObject : BaseJQueryEventObject {
    var altKey: Boolean
    var ctrlKey: Boolean
    override var metaKey: Boolean
    var shiftKey: Boolean
}
@native
interface JQueryMouseEventObject : JQueryInputEventObject {
    var button: Number
    var clientX: Number
    var clientY: Number
    var offsetX: Number
    var offsetY: Number
    override var pageX: Number
    override var pageY: Number
    var screenX: Number
    var screenY: Number
}
@native
interface JQueryKeyEventObject : JQueryInputEventObject {
    var char: Any
    var charCode: Number
    var key: Any
    var keyCode: Number
}
@native
interface JQueryEventObject : BaseJQueryEventObject, JQueryInputEventObject, JQueryMouseEventObject, JQueryKeyEventObject
@native
interface JQuerySupport {
    var ajax: Boolean? get() = noImpl
    var boxModel: Boolean? get() = noImpl
    var changeBubbles: Boolean? get() = noImpl
    var checkClone: Boolean? get() = noImpl
    var checkOn: Boolean? get() = noImpl
    var cors: Boolean? get() = noImpl
    var cssFloat: Boolean? get() = noImpl
    var hrefNormalized: Boolean? get() = noImpl
    var htmlSerialize: Boolean? get() = noImpl
    var leadingWhitespace: Boolean? get() = noImpl
    var noCloneChecked: Boolean? get() = noImpl
    var noCloneEvent: Boolean? get() = noImpl
    var opacity: Boolean? get() = noImpl
    var optDisabled: Boolean? get() = noImpl
    var optSelected: Boolean? get() = noImpl
    val scriptEval: (() -> Boolean)? get() = noImpl
    var style: Boolean? get() = noImpl
    var submitBubbles: Boolean? get() = noImpl
    var tbody: Boolean? get() = noImpl
}
@native
interface JQueryParam {
    @nativeInvoke
    fun invoke(obj: Any): String
    @nativeInvoke
    fun invoke(obj: Any, traditional: Boolean): String
}
@native
interface JQueryEventConstructor {
    @nativeInvoke
    fun invoke(name: String, eventProperties: Any? = null): JQueryEventObject
    @native("new")
    fun invoke(name: String, eventProperties: Any? = null): JQueryEventObject
}
@native
interface JQueryCoordinates {
    var left: Number
    var top: Number
}
@native
interface JQuerySerializeArrayElement {
    var name: String
    var value: String
}
@native
interface JQueryAnimationOptions {
    var duration: Any? get() = noImpl
    var easing: String? get() = noImpl
    var complete: Function? get() = noImpl
    var step: ((now: Number, tween: Any) -> Any)? get() = noImpl
    var progress: ((animation: JQueryPromise<Any>, progress: Number, remainingMs: Number) -> Any)? get() = noImpl
    var start: ((animation: JQueryPromise<Any>) -> Any)? get() = noImpl
    var done: ((animation: JQueryPromise<Any>, jumpedToEnd: Boolean) -> Any)? get() = noImpl
    var fail: ((animation: JQueryPromise<Any>, jumpedToEnd: Boolean) -> Any)? get() = noImpl
    var always: ((animation: JQueryPromise<Any>, jumpedToEnd: Boolean) -> Any)? get() = noImpl
    var queue: Any? get() = noImpl
    var specialEasing: Object? get() = noImpl
}
@native
interface JQueryEasingFunction {
    @nativeInvoke
    fun invoke(percent: Number): Number
}
@native
interface JQueryEasingFunctions {
    @nativeGetter
    fun get(name: String): JQueryEasingFunction?
    @nativeSetter
    fun set(name: String, value: JQueryEasingFunction)
    var linear: JQueryEasingFunction
    var swing: JQueryEasingFunction
}
@native
interface `T$0` {
    var slow: Number
    var fast: Number
}
@native
interface `T$1` {
    var tick: () -> Unit
    var interval: Number
    var stop: () -> Unit
    var speeds: `T$0`
    var off: Boolean
    var step: Any
}
@native
interface JQueryStatic {
    fun ajax(settings: JQueryAjaxSettings): JQueryXHR
    fun ajax(url: String, settings: JQueryAjaxSettings? = null): JQueryXHR
    fun ajaxPrefilter(dataTypes: String, handler: (opts: Any, originalOpts: JQueryAjaxSettings, jqXHR: JQueryXHR) -> Any)
    fun ajaxPrefilter(handler: (opts: Any, originalOpts: JQueryAjaxSettings, jqXHR: JQueryXHR) -> Any)
    var ajaxSettings: JQueryAjaxSettings
    fun ajaxSetup(options: JQueryAjaxSettings)
    fun get(url: String, success: ((data: Any, textStatus: String, jqXHR: JQueryXHR) -> Any)? = null, dataType: String? = null): JQueryXHR
    fun get(url: String, data: Object? = null, success: ((data: Any, textStatus: String, jqXHR: JQueryXHR) -> Any)? = null, dataType: String? = null): JQueryXHR
    fun get(url: String, data: String? = null, success: ((data: Any, textStatus: String, jqXHR: JQueryXHR) -> Any)? = null, dataType: String? = null): JQueryXHR
    fun get(settings: JQueryAjaxSettings): JQueryXHR
    fun getJSON(url: String, success: ((data: Any, textStatus: String, jqXHR: JQueryXHR) -> Any)? = null): JQueryXHR
    fun getJSON(url: String, data: Object? = null, success: ((data: Any, textStatus: String, jqXHR: JQueryXHR) -> Any)? = null): JQueryXHR
    fun getJSON(url: String, data: String? = null, success: ((data: Any, textStatus: String, jqXHR: JQueryXHR) -> Any)? = null): JQueryXHR
    fun getScript(url: String, success: ((script: String, textStatus: String, jqXHR: JQueryXHR) -> Any)? = null): JQueryXHR
    var param: JQueryParam
    fun post(url: String, success: ((data: Any, textStatus: String, jqXHR: JQueryXHR) -> Any)? = null, dataType: String? = null): JQueryXHR
    fun post(url: String, data: Object? = null, success: ((data: Any, textStatus: String, jqXHR: JQueryXHR) -> Any)? = null, dataType: String? = null): JQueryXHR
    fun post(url: String, data: String? = null, success: ((data: Any, textStatus: String, jqXHR: JQueryXHR) -> Any)? = null, dataType: String? = null): JQueryXHR
    fun post(settings: JQueryAjaxSettings): JQueryXHR
    fun Callbacks(flags: String? = null): JQueryCallback
    fun holdReady(hold: Boolean)
    @nativeInvoke
    fun invoke(selector: String, context: Element? = null): JQuery
    @nativeInvoke
    fun invoke(selector: String, context: JQuery? = null): JQuery
    @nativeInvoke
    fun invoke(element: Element): JQuery
    @nativeInvoke
    fun invoke(elementArray: Array<Element>): JQuery
    @nativeInvoke
    fun invoke(callback: (jQueryAlias: JQueryStatic? = null) -> Any): JQuery
    @nativeInvoke
    fun invoke(`object`: Any): JQuery
    @nativeInvoke
    fun invoke(`object`: JQuery): JQuery
    @nativeInvoke
    fun invoke(): JQuery
    @nativeInvoke
    fun invoke(html: String, ownerDocument: Document? = null): JQuery
    @nativeInvoke
    fun invoke(html: String, attributes: Object): JQuery
    fun noConflict(removeAll: Boolean? = null): JQueryStatic
    fun <T> `when`(vararg deferreds: T): JQueryPromise<T>
    fun <T> `when`(vararg deferreds: JQueryPromise<T>): JQueryPromise<T>
    var cssHooks: Json
    var cssNumber: Any
    fun <T> data(element: Element, key: String, value: T): T
    fun data(element: Element, key: String): Any
    fun data(element: Element): Any
    fun dequeue(element: Element, queueName: String? = null)
    fun hasData(element: Element): Boolean
    fun queue(element: Element, queueName: String? = null): Array<Any>
    fun queue(element: Element, queueName: String, newQueue: Array<Function>): JQuery
    fun queue(element: Element, queueName: String, callback: Function): JQuery
    fun removeData(element: Element, name: String? = null): JQuery
    fun <T> Deferred(beforeStart: ((deferred: JQueryDeferred<T>) -> Any)? = null): JQueryDeferred<T>
    var easing: JQueryEasingFunctions
    var fx: `T$1`
    fun proxy(fnction: (vararg args: Any) -> Any, context: Object, vararg additionalArguments: Any): Any
    fun proxy(context: Object, name: String, vararg additionalArguments: Any): Any
    var Event: JQueryEventConstructor
    fun error(message: Any): JQuery
    var expr: Any
    var fn: Any
    var isReady: Boolean
    var support: JQuerySupport
    fun contains(container: Element, contained: Element): Boolean
    fun <T> each(collection: Array<T>, callback: (indexInArray: Number, valueOfElement: T) -> Any): Any
    fun each(collection: Any, callback: (indexInArray: Any, valueOfElement: Any) -> Any): Any
    fun extend(target: Any, object1: Any? = null, vararg objectN: Any): Any
    fun extend(deep: Boolean, target: Any, object1: Any? = null, vararg objectN: Any): Any
    fun globalEval(code: String): Any
    fun <T> grep(array: Array<T>, func: (elementOfArray: T? = null, indexInArray: Number? = null) -> Boolean, invert: Boolean? = null): Array<T>
    fun <T> inArray(value: T, array: Array<T>, fromIndex: Number? = null): Number
    fun isArray(obj: Any): Boolean
    fun isEmptyObject(obj: Any): Boolean
    fun isFunction(obj: Any): Boolean
    fun isNumeric(value: Any): Boolean
    fun isPlainObject(obj: Any): Boolean
    fun isWindow(obj: Any): Boolean
    fun isXMLDoc(node: Node): Boolean
    fun makeArray(obj: Any): Array<Any>
    fun <T, U> map(array: Array<T>, callback: (elementOfArray: T? = null, indexInArray: Number? = null) -> U): Array<U>
    fun map(arrayOrObject: Any, callback: (value: Any? = null, indexOrKey: Any? = null) -> Any): Any
    fun <T> merge(first: Array<T>, second: Array<T>): Array<T>
    fun noop(): Any
    fun now(): Number
    fun parseJSON(json: String): Any
    fun parseXML(data: String): XMLDocument
    fun trim(str: String): String
    fun type(obj: Any): String
    fun unique(array: Array<Element>): Array<Element>
    fun parseHTML(data: String, context: HTMLElement? = null, keepScripts: Boolean? = null): Array<Any>
    fun parseHTML(data: String, context: Document? = null, keepScripts: Boolean? = null): Array<Any>
}
@native
interface JQuery {
    fun ajaxComplete(handler: (event: JQueryEventObject, XMLHttpRequest: XMLHttpRequest, ajaxOptions: Any) -> Any): JQuery
    fun ajaxError(handler: (event: JQueryEventObject, jqXHR: JQueryXHR, ajaxSettings: JQueryAjaxSettings, thrownError: Any) -> Any): JQuery
    fun ajaxSend(handler: (event: JQueryEventObject, jqXHR: JQueryXHR, ajaxOptions: JQueryAjaxSettings) -> Any): JQuery
    fun ajaxStart(handler: () -> Any): JQuery
    fun ajaxStop(handler: () -> Any): JQuery
    fun ajaxSuccess(handler: (event: JQueryEventObject, XMLHttpRequest: XMLHttpRequest, ajaxOptions: JQueryAjaxSettings) -> Any): JQuery
    fun load(url: String, data: String? = null, complete: ((responseText: String, textStatus: String, XMLHttpRequest: XMLHttpRequest) -> Any)? = null): JQuery
    fun load(url: String, data: Object? = null, complete: ((responseText: String, textStatus: String, XMLHttpRequest: XMLHttpRequest) -> Any)? = null): JQuery
    fun serialize(): String
    fun serializeArray(): Array<JQuerySerializeArrayElement>
    fun addClass(className: String): JQuery
    fun addClass(func: (index: Number, className: String) -> String): JQuery
    fun addBack(selector: String? = null): JQuery
    fun attr(attributeName: String): String
    fun attr(attributeName: String, value: String): JQuery
    fun attr(attributeName: String, value: Number): JQuery
    fun attr(attributeName: String, func: (index: Number, attr: String) -> dynamic /* String | Number */): JQuery
    fun attr(attributes: Object): JQuery
    fun hasClass(className: String): Boolean
    fun html(): String
    fun html(htmlString: String): JQuery
    fun html(func: (index: Number, oldhtml: String) -> String): JQuery
    fun prop(propertyName: String): Any
    fun prop(propertyName: String, value: String): JQuery
    fun prop(propertyName: String, value: Number): JQuery
    fun prop(propertyName: String, value: Boolean): JQuery
    fun prop(properties: Object): JQuery
    fun prop(propertyName: String, func: (index: Number, oldPropertyValue: Any) -> Any): JQuery
    fun removeAttr(attributeName: String): JQuery
    fun removeClass(className: String? = null): JQuery
    fun removeClass(func: (index: Number, className: String) -> String): JQuery
    fun removeProp(propertyName: String): JQuery
    fun toggleClass(className: String, swtch: Boolean? = null): JQuery
    fun toggleClass(swtch: Boolean? = null): JQuery
    fun toggleClass(func: (index: Number, className: String, swtch: Boolean) -> String, swtch: Boolean? = null): JQuery
    fun `val`(): Any
    fun `val`(value: String): JQuery
    fun `val`(value: Array<String>): JQuery
    fun `val`(value: Number): JQuery
    fun `val`(func: (index: Number, value: String) -> String): JQuery
    fun css(propertyName: String): String
    fun css(propertyName: String, value: String): JQuery
    fun css(propertyName: String, value: Number): JQuery
    fun css(propertyName: String, value: (index: Number, value: String) -> dynamic /* String | Number */): JQuery
    fun css(properties: Object): JQuery
    fun height(): Number
    fun height(value: Number): JQuery
    fun height(value: String): JQuery
    fun height(func: (index: Number, height: Number) -> dynamic /* Number | String */): JQuery
    fun innerHeight(): Number
    fun innerHeight(height: Number): JQuery
    fun innerHeight(height: String): JQuery
    fun innerWidth(): Number
    fun innerWidth(width: Number): JQuery
    fun innerWidth(width: String): JQuery
    fun offset(): JQueryCoordinates
    fun offset(coordinates: JQueryCoordinates): JQuery
    fun offset(func: (index: Number, coords: JQueryCoordinates) -> JQueryCoordinates): JQuery
    fun outerHeight(includeMargin: Boolean? = null): Number
    fun outerHeight(height: Number): JQuery
    fun outerHeight(height: String): JQuery
    fun outerWidth(includeMargin: Boolean? = null): Number
    fun outerWidth(width: Number): JQuery
    fun outerWidth(width: String): JQuery
    fun position(): JQueryCoordinates
    fun scrollLeft(): Number
    fun scrollLeft(value: Number): JQuery
    fun scrollTop(): Number
    fun scrollTop(value: Number): JQuery
    fun width(): Number
    fun width(value: Number): JQuery
    fun width(value: String): JQuery
    fun width(func: (index: Number, width: Number) -> dynamic /* Number | String */): JQuery
    fun clearQueue(queueName: String? = null): JQuery
    fun data(key: String, value: Any): JQuery
    fun data(key: String): Any
    fun data(obj: Json): JQuery
    fun data(): Any
    fun dequeue(queueName: String? = null): JQuery
    fun removeData(name: String): JQuery
    fun removeData(list: Array<String>): JQuery
    fun removeData(): JQuery
    fun promise(type: String? = null, target: Object? = null): JQueryPromise<Any>
    fun animate(properties: Object, duration: String? = null, complete: Function? = null): JQuery
    fun animate(properties: Object, duration: Number? = null, complete: Function? = null): JQuery
    fun animate(properties: Object, duration: String? = null, easing: String? = null, complete: Function? = null): JQuery
    fun animate(properties: Object, duration: Number? = null, easing: String? = null, complete: Function? = null): JQuery
    fun animate(properties: Object, options: JQueryAnimationOptions): JQuery
    fun delay(duration: Number, queueName: String? = null): JQuery
    fun fadeIn(duration: Number? = null, complete: Function? = null): JQuery
    fun fadeIn(duration: String? = null, complete: Function? = null): JQuery
    fun fadeIn(duration: Number? = null, easing: String? = null, complete: Function? = null): JQuery
    fun fadeIn(duration: String? = null, easing: String? = null, complete: Function? = null): JQuery
    fun fadeIn(options: JQueryAnimationOptions): JQuery
    fun fadeOut(duration: Number? = null, complete: Function? = null): JQuery
    fun fadeOut(duration: String? = null, complete: Function? = null): JQuery
    fun fadeOut(duration: Number? = null, easing: String? = null, complete: Function? = null): JQuery
    fun fadeOut(duration: String? = null, easing: String? = null, complete: Function? = null): JQuery
    fun fadeOut(options: JQueryAnimationOptions): JQuery
    fun fadeTo(duration: String, opacity: Number, complete: Function? = null): JQuery
    fun fadeTo(duration: Number, opacity: Number, complete: Function? = null): JQuery
    fun fadeTo(duration: String, opacity: Number, easing: String? = null, complete: Function? = null): JQuery
    fun fadeTo(duration: Number, opacity: Number, easing: String? = null, complete: Function? = null): JQuery
    fun fadeToggle(duration: Number? = null, complete: Function? = null): JQuery
    fun fadeToggle(duration: String? = null, complete: Function? = null): JQuery
    fun fadeToggle(duration: Number? = null, easing: String? = null, complete: Function? = null): JQuery
    fun fadeToggle(duration: String? = null, easing: String? = null, complete: Function? = null): JQuery
    fun fadeToggle(options: JQueryAnimationOptions): JQuery
    fun finish(queue: String? = null): JQuery
    fun hide(duration: Number? = null, complete: Function? = null): JQuery
    fun hide(duration: String? = null, complete: Function? = null): JQuery
    fun hide(duration: Number? = null, easing: String? = null, complete: Function? = null): JQuery
    fun hide(duration: String? = null, easing: String? = null, complete: Function? = null): JQuery
    fun hide(options: JQueryAnimationOptions): JQuery
    fun show(duration: Number? = null, complete: Function? = null): JQuery
    fun show(duration: String? = null, complete: Function? = null): JQuery
    fun show(duration: Number? = null, easing: String? = null, complete: Function? = null): JQuery
    fun show(duration: String? = null, easing: String? = null, complete: Function? = null): JQuery
    fun show(options: JQueryAnimationOptions): JQuery
    fun slideDown(duration: Number? = null, complete: Function? = null): JQuery
    fun slideDown(duration: String? = null, complete: Function? = null): JQuery
    fun slideDown(duration: Number? = null, easing: String? = null, complete: Function? = null): JQuery
    fun slideDown(duration: String? = null, easing: String? = null, complete: Function? = null): JQuery
    fun slideDown(options: JQueryAnimationOptions): JQuery
    fun slideToggle(duration: Number? = null, complete: Function? = null): JQuery
    fun slideToggle(duration: String? = null, complete: Function? = null): JQuery
    fun slideToggle(duration: Number? = null, easing: String? = null, complete: Function? = null): JQuery
    fun slideToggle(duration: String? = null, easing: String? = null, complete: Function? = null): JQuery
    fun slideToggle(options: JQueryAnimationOptions): JQuery
    fun slideUp(duration: Number? = null, complete: Function? = null): JQuery
    fun slideUp(duration: String? = null, complete: Function? = null): JQuery
    fun slideUp(duration: Number? = null, easing: String? = null, complete: Function? = null): JQuery
    fun slideUp(duration: String? = null, easing: String? = null, complete: Function? = null): JQuery
    fun slideUp(options: JQueryAnimationOptions): JQuery
    fun stop(clearQueue: Boolean? = null, jumpToEnd: Boolean? = null): JQuery
    fun stop(queue: String? = null, clearQueue: Boolean? = null, jumpToEnd: Boolean? = null): JQuery
    fun toggle(duration: Number? = null, complete: Function? = null): JQuery
    fun toggle(duration: String? = null, complete: Function? = null): JQuery
    fun toggle(duration: Number? = null, easing: String? = null, complete: Function? = null): JQuery
    fun toggle(duration: String? = null, easing: String? = null, complete: Function? = null): JQuery
    fun toggle(options: JQueryAnimationOptions): JQuery
    fun toggle(showOrHide: Boolean): JQuery
    fun bind(eventType: String, eventData: Any, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun bind(eventType: String, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun bind(eventType: String, eventData: Any, preventBubble: Boolean): JQuery
    fun bind(eventType: String, preventBubble: Boolean): JQuery
    fun bind(events: Any): JQuery
    fun blur(): JQuery
    fun blur(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun blur(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    fun change(): JQuery
    fun change(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun change(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    fun click(): JQuery
    fun click(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun click(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    fun contextmenu(): JQuery
    fun contextmenu(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun contextmenu(eventData: Object, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun dblclick(): JQuery
    fun dblclick(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun dblclick(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    fun delegate(selector: Any, eventType: String, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun delegate(selector: Any, eventType: String, eventData: Any, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun focus(): JQuery
    fun focus(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun focus(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    fun focusin(): JQuery
    fun focusin(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun focusin(eventData: Object, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun focusout(): JQuery
    fun focusout(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun focusout(eventData: Object, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun hover(handlerIn: (eventObject: JQueryEventObject) -> Any, handlerOut: (eventObject: JQueryEventObject) -> Any): JQuery
    fun hover(handlerInOut: (eventObject: JQueryEventObject) -> Any): JQuery
    fun keydown(): JQuery
    fun keydown(handler: (eventObject: JQueryKeyEventObject) -> Any): JQuery
    fun keydown(eventData: Any? = null, handler: ((eventObject: JQueryKeyEventObject) -> Any)? = null): JQuery
    fun keypress(): JQuery
    fun keypress(handler: (eventObject: JQueryKeyEventObject) -> Any): JQuery
    fun keypress(eventData: Any? = null, handler: ((eventObject: JQueryKeyEventObject) -> Any)? = null): JQuery
    fun keyup(): JQuery
    fun keyup(handler: (eventObject: JQueryKeyEventObject) -> Any): JQuery
    fun keyup(eventData: Any? = null, handler: ((eventObject: JQueryKeyEventObject) -> Any)? = null): JQuery
    fun load(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun load(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    fun mousedown(): JQuery
    fun mousedown(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mousedown(eventData: Object, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mouseenter(): JQuery
    fun mouseenter(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mouseenter(eventData: Object, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mouseleave(): JQuery
    fun mouseleave(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mouseleave(eventData: Object, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mousemove(): JQuery
    fun mousemove(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mousemove(eventData: Object, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mouseout(): JQuery
    fun mouseout(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mouseout(eventData: Object, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mouseover(): JQuery
    fun mouseover(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mouseover(eventData: Object, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mouseup(): JQuery
    fun mouseup(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mouseup(eventData: Object, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun off(): JQuery
    fun off(events: String, selector: String? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    fun off(events: String, handler: (eventObject: JQueryEventObject, vararg args: Any) -> Any): JQuery
    fun off(events: String, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun off(events: Json, selector: String? = null): JQuery
    fun on(events: String, handler: (eventObject: JQueryEventObject, vararg args: Any) -> Any): JQuery
    fun on(events: String, data: Any, handler: (eventObject: JQueryEventObject, vararg args: Any) -> Any): JQuery
    fun on(events: String, selector: String, handler: (eventObject: JQueryEventObject, vararg eventData: Any) -> Any): JQuery
    fun on(events: String, selector: String, data: Any, handler: (eventObject: JQueryEventObject, vararg eventData: Any) -> Any): JQuery
    fun on(events: Json, selector: String? = null, data: Any? = null): JQuery
    fun on(events: Json, data: Any? = null): JQuery
    fun one(events: String, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun one(events: String, data: Object, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun one(events: String, selector: String, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun one(events: String, selector: String, data: Any, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun one(events: Json, selector: String? = null, data: Any? = null): JQuery
    fun one(events: Json, data: Any? = null): JQuery
    fun ready(handler: (jQueryAlias: JQueryStatic? = null) -> Any): JQuery
    fun resize(): JQuery
    fun resize(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun resize(eventData: Object, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun scroll(): JQuery
    fun scroll(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun scroll(eventData: Object, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun select(): JQuery
    fun select(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun select(eventData: Object, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun submit(): JQuery
    fun submit(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun submit(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    fun trigger(eventType: String, extraParameters: Array<Any>? = null): JQuery
    fun trigger(eventType: String, extraParameters: Object? = null): JQuery
    fun trigger(event: JQueryEventObject, extraParameters: Array<Any>? = null): JQuery
    fun trigger(event: JQueryEventObject, extraParameters: Object? = null): JQuery
    fun triggerHandler(eventType: String, vararg extraParameters: Any): Object
    fun triggerHandler(event: JQueryEventObject, vararg extraParameters: Any): Object
    fun unbind(eventType: String? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    fun unbind(eventType: String, fls: Boolean): JQuery
    fun unbind(evt: Any): JQuery
    fun undelegate(): JQuery
    fun undelegate(selector: String, eventType: String, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    fun undelegate(selector: String, events: Object): JQuery
    fun undelegate(namespace: String): JQuery
    fun unload(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun unload(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    var context: Element
    var jquery: String
    fun error(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun error(eventData: Any, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun pushStack(elements: Array<Any>): JQuery
    fun pushStack(elements: Array<Any>, name: String, arguments: Array<Any>): JQuery
    fun after(content1: JQuery, vararg content2: Any): JQuery
    fun after(content1: Array<Any>, vararg content2: Any): JQuery
    fun after(content1: Element, vararg content2: Any): JQuery
    fun after(content1: DocumentFragment, vararg content2: Any): JQuery
    fun after(content1: Text, vararg content2: Any): JQuery
    fun after(content1: String, vararg content2: Any): JQuery
    fun after(func: (index: Number, html: String) -> dynamic /* String | Element | JQuery */): JQuery
    fun append(content1: JQuery, vararg content2: Any): JQuery
    fun append(content1: Array<Any>, vararg content2: Any): JQuery
    fun append(content1: Element, vararg content2: Any): JQuery
    fun append(content1: DocumentFragment, vararg content2: Any): JQuery
    fun append(content1: Text, vararg content2: Any): JQuery
    fun append(content1: String, vararg content2: Any): JQuery
    fun append(func: (index: Number, html: String) -> dynamic /* String | Element | JQuery */): JQuery
    fun appendTo(target: JQuery): JQuery
    fun appendTo(target: Array<Any>): JQuery
    fun appendTo(target: Element): JQuery
    fun appendTo(target: String): JQuery
    fun before(content1: JQuery, vararg content2: Any): JQuery
    fun before(content1: Array<Any>, vararg content2: Any): JQuery
    fun before(content1: Element, vararg content2: Any): JQuery
    fun before(content1: DocumentFragment, vararg content2: Any): JQuery
    fun before(content1: Text, vararg content2: Any): JQuery
    fun before(content1: String, vararg content2: Any): JQuery
    fun before(func: (index: Number, html: String) -> dynamic /* String | Element | JQuery */): JQuery
    fun clone(withDataAndEvents: Boolean? = null, deepWithDataAndEvents: Boolean? = null): JQuery
    fun detach(selector: String? = null): JQuery
    fun empty(): JQuery
    fun insertAfter(target: JQuery): JQuery
    fun insertAfter(target: Array<Any>): JQuery
    fun insertAfter(target: Element): JQuery
    fun insertAfter(target: Text): JQuery
    fun insertAfter(target: String): JQuery
    fun insertBefore(target: JQuery): JQuery
    fun insertBefore(target: Array<Any>): JQuery
    fun insertBefore(target: Element): JQuery
    fun insertBefore(target: Text): JQuery
    fun insertBefore(target: String): JQuery
    fun prepend(content1: JQuery, vararg content2: Any): JQuery
    fun prepend(content1: Array<Any>, vararg content2: Any): JQuery
    fun prepend(content1: Element, vararg content2: Any): JQuery
    fun prepend(content1: DocumentFragment, vararg content2: Any): JQuery
    fun prepend(content1: Text, vararg content2: Any): JQuery
    fun prepend(content1: String, vararg content2: Any): JQuery
    fun prepend(func: (index: Number, html: String) -> dynamic /* String | Element | JQuery */): JQuery
    fun prependTo(target: JQuery): JQuery
    fun prependTo(target: Array<Any>): JQuery
    fun prependTo(target: Element): JQuery
    fun prependTo(target: String): JQuery
    fun remove(selector: String? = null): JQuery
    fun replaceAll(target: JQuery): JQuery
    fun replaceAll(target: Array<Any>): JQuery
    fun replaceAll(target: Element): JQuery
    fun replaceAll(target: String): JQuery
    fun replaceWith(newContent: JQuery): JQuery
    fun replaceWith(newContent: Array<Any>): JQuery
    fun replaceWith(newContent: Element): JQuery
    fun replaceWith(newContent: Text): JQuery
    fun replaceWith(newContent: String): JQuery
    fun replaceWith(func: () -> dynamic /* Element | JQuery */): JQuery
    fun text(): String
    fun text(text: String): JQuery
    fun text(text: Number): JQuery
    fun text(text: Boolean): JQuery
    fun text(func: (index: Number, text: String) -> String): JQuery
    fun toArray(): Array<HTMLElement>
    fun unwrap(): JQuery
    fun wrap(wrappingElement: JQuery): JQuery
    fun wrap(wrappingElement: Element): JQuery
    fun wrap(wrappingElement: String): JQuery
    fun wrap(func: (index: Number) -> dynamic /* String | JQuery */): JQuery
    fun wrapAll(wrappingElement: JQuery): JQuery
    fun wrapAll(wrappingElement: Element): JQuery
    fun wrapAll(wrappingElement: String): JQuery
    fun wrapAll(func: (index: Number) -> String): JQuery
    fun wrapInner(wrappingElement: JQuery): JQuery
    fun wrapInner(wrappingElement: Element): JQuery
    fun wrapInner(wrappingElement: String): JQuery
    fun wrapInner(func: (index: Number) -> String): JQuery
    fun each(func: (index: Number, elem: Element) -> Any): JQuery
    fun get(index: Number): HTMLElement
    fun get(): Array<HTMLElement>
    fun index(): Number
    fun index(selector: String): Number
    fun index(selector: JQuery): Number
    fun index(selector: Element): Number
    var length: Number
    var selector: String
    @nativeGetter
    fun get(index: String): Any?
    @nativeSetter
    fun set(index: String, value: Any)
    @nativeGetter
    fun get(index: Number): HTMLElement?
    @nativeSetter
    fun set(index: Number, value: HTMLElement)
    fun add(selector: String, context: Element? = null): JQuery
    fun add(vararg elements: Element): JQuery
    fun add(html: String): JQuery
    fun add(obj: JQuery): JQuery
    fun children(selector: String? = null): JQuery
    fun closest(selector: String): JQuery
    fun closest(selector: String, context: Element? = null): JQuery
    fun closest(obj: JQuery): JQuery
    fun closest(element: Element): JQuery
    fun closest(selectors: Any, context: Element? = null): Array<Any>
    fun contents(): JQuery
    fun end(): JQuery
    fun eq(index: Number): JQuery
    fun filter(selector: String): JQuery
    fun filter(func: (index: Number, element: Element) -> Any): JQuery
    fun filter(element: Element): JQuery
    fun filter(obj: JQuery): JQuery
    fun find(selector: String): JQuery
    fun find(element: Element): JQuery
    fun find(obj: JQuery): JQuery
    fun first(): JQuery
    fun has(selector: String): JQuery
    fun has(contained: Element): JQuery
    fun `is`(selector: String): Boolean
    fun `is`(func: (index: Number, element: Element) -> Boolean): Boolean
    fun `is`(obj: JQuery): Boolean
    fun `is`(elements: Any): Boolean
    fun last(): JQuery
    fun map(callback: (index: Number, domElement: Element) -> Any): JQuery
    fun next(selector: String? = null): JQuery
    fun nextAll(selector: String? = null): JQuery
    fun nextUntil(selector: String? = null, filter: String? = null): JQuery
    fun nextUntil(element: Element? = null, filter: String? = null): JQuery
    fun nextUntil(obj: JQuery? = null, filter: String? = null): JQuery
    fun not(selector: String): JQuery
    fun not(func: (index: Number, element: Element) -> Boolean): JQuery
    fun not(elements: Element): JQuery
    fun not(elements: Array<Element>): JQuery
    fun not(obj: JQuery): JQuery
    fun offsetParent(): JQuery
    fun parent(selector: String? = null): JQuery
    fun parents(selector: String? = null): JQuery
    fun parentsUntil(selector: String? = null, filter: String? = null): JQuery
    fun parentsUntil(element: Element? = null, filter: String? = null): JQuery
    fun parentsUntil(obj: JQuery? = null, filter: String? = null): JQuery
    fun prev(selector: String? = null): JQuery
    fun prevAll(selector: String? = null): JQuery
    fun prevUntil(selector: String? = null, filter: String? = null): JQuery
    fun prevUntil(element: Element? = null, filter: String? = null): JQuery
    fun prevUntil(obj: JQuery? = null, filter: String? = null): JQuery
    fun siblings(selector: String? = null): JQuery
    fun slice(start: Number, end: Number? = null): JQuery
    fun queue(queueName: String? = null): Array<Any>
    fun queue(newQueue: Array<Function>): JQuery
    fun queue(callback: Function): JQuery
    fun queue(queueName: String, newQueue: Array<Function>): JQuery
    fun queue(queueName: String, callback: Function): JQuery
}
@module
object jquery {

}
@native
var jQuery: JQueryStatic = noImpl
@native
@module("jquery")
var `$`: JQueryStatic = noImpl
