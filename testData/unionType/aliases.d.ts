declare class FooForAlias {}

type Key = Key2 | number;
type Key2 = string | FooForAlias;
declare var fooKey: Key;

declare function barKey(a: Key|number);
declare function barList(a: List<Key>);
declare function barArray(a: Key[]);

interface Parent {
    (...children: Key[]): FooForAlias;
}
