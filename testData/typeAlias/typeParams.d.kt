package typeParams

@native
var fooMap: Map<String, List<Number>> = noImpl
@native
fun mapKey(a: Map<Number, List<String>>): Unit = noImpl
@native
var fooStringOrMap: dynamic /* String | Map<String, List<Number>> */ = noImpl
@native
fun stringOrMapKey(a: String): Unit = noImpl
@native
fun stringOrMapKey(a: Map<Number, List<String>>): Unit = noImpl
@native
var listOfStringOrNumber: dynamic /* String | List<dynamic /* String | Number */> */ = noImpl
@native
fun listOfNumberOrString(a: List<dynamic /* Number | String */>): Unit = noImpl
