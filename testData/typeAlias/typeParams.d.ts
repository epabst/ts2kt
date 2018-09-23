interface Map1<K, V> {
}
interface List1<T> {
}

type Values<V> = List1<V>;
type MultiMap<K,V> = Map1<K,Values<V>>;
type MyHeaders = MultiMap<String,String>
type Ref<T> = string | ((instance: T) => any);

declare var fooMap: MultiMap<string,number>;

declare function mapKey(a: MultiMap<number,String>);

declare var fooStringOrMap: string | MultiMap<string,number>;

declare function stringOrMapKey(a: string | MultiMap<number,String>);

declare var listOfStringOrNumber: string | List1<string | number>;

declare function listOfNumberOrString(a: List1<number | String>);

declare var headers: MyHeaders;

declare function getHeaders(): MyHeaders;

declare function addHeaders(headers: MyHeaders);

declare var someRef: Ref<number>;

declare function addRef(ref: Ref<number>);
