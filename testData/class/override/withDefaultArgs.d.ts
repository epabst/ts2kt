declare class FooWithDefaultArgs {
    bar(a: number = 1);
    baz(a?);
}

declare class BooWithDefaultArgs extends FooWithDefaultArgs {
    bar(a: number = 1);
    baz(a?);
}
