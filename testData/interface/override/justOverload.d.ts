interface FooWithOverload {
    bar(a:number);
}

interface BooWithOverload extends FooWithOverload {
    bar(a: string);
}
