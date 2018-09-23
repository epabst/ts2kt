declare namespace React {
    class Bar;
    interface Foo;
    interface ComponentLifecycle<P,S>
    class ClassBeforeInterfaceComponent<P, S> extends Bar implements Foo {
        boo(p: P, s: S)
    }
    interface ClassBeforeInterfaceComponent<P, S> extends ComponentLifecycle<P, S> {
        foo: string
        bar(): number
        baz(a: any)
    }
}
