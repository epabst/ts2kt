declare class FooWithStaticMembers {
    bar(): number;
    static variable: string;
    static bar();
}

declare module FooWithStaticMembers {
    export function baz(a);
}
