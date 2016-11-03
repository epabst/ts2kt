type Values<V> = List<V>;
type MultiMap<K,V> = Map<K,Values<V>>;

declare var fooMap: MultiMap<string,number>;

declare function mapKey(a: MultiMap<number,String>);

declare var fooStringOrMap: string | MultiMap<string,number>;

declare function stringOrMapKey(a: string | MultiMap<number,String>);

declare var listOfStringOrNumber: string | List<string | number>;

declare function listOfNumberOrString(a: List<number | String>);
