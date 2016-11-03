package unionTypeParams

@native
var fooMap: dynamic /* List<Number> | Map<String, List<Number>> */ = noImpl
@native
fun mapKey(a: List<String>): Unit = noImpl
@native
fun mapKey(a: Map<Number, List<String>>): Unit = noImpl
@native
var fooStringOrMap: dynamic /* List<Number> | Map<String, List<Number>> */ = noImpl
@native
fun stringOrMapKey(a: List<String>): Unit = noImpl
@native
fun stringOrMapKey(a: Map<Number, List<String>>): Unit = noImpl
@native
var listOfStringOrNumber: List<dynamic /* String | Number */> = noImpl
@native
fun listOfNumberOrString(a: List<dynamic /* Number | String */>): Unit = noImpl
