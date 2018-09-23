declare var nullableFoo: string | undefined;
declare var bar: string | null;

declare function bar(a: string | undefined): FooWithNullable | null;

declare function baz(a: FooWithNullable | null, b?: number | undefined): any | undefined;

declare class FooWithNullable {
    constructor(a: string | null);

    someMethod(): string | number | undefined;

    foo: FooWithNullable | null;
    optionalFoo?: string | null;
    optionalFoo2?: string | undefined;
    optionalFoo3?: string | undefined | null;
    refs: {
        [key: string | undefined]: string | null;
    };
}

interface IBar {
    someMethod(): string | number | undefined;

    foo: FooWithNullable | null;
    optionalFoo?: string | null;
    optionalFoo2?: string | undefined;
    optionalFoo3?: string | undefined | null;
}