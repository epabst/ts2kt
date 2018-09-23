interface Map2<K, V> {
}
interface List2<T> {
}

type Values<V> = List2<V>;
type ListOrMultiMap<K,V> = List2<V> | Map2<K,Values<V>>;

declare var aliasUnionVar: ListOrMultiMap<string,number>;

declare function aliasUnionFunction(a: ListOrMultiMap<number,String>);

declare var listOfUnionVar: Values<string | number>;

declare function listOfUnionFunction(a: Values<number | String>);
