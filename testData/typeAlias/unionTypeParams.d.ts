type Values<V> = List<V>;
type ListOrMultiMap<K,V> = List<V> | Map<K,Values<V>>;

declare var fooMap: ListOrMultiMap<string,number>;

declare function mapKey(a: ListOrMultiMap<number,String>);

declare var fooStringOrMap: ListOrMultiMap<string,number>;

declare function stringOrMapKey(a: ListOrMultiMap<number,String>);

declare var listOfStringOrNumber: List<string | number>;

declare function listOfNumberOrString(a: List<number | String>);
