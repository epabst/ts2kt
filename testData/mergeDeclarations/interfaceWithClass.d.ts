declare namespace React {
    interface InterfaceBeforeClassComponent<P, S> extends ComponentLifecycle<P, S> {
        foo: string
        bar(): number
        baz(a: any)
    }
    class InterfaceBeforeClassComponent<P, S> extends Bar implements Foo {
        boo(p: P, s: S)
    }
}
