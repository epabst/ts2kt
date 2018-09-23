declare function foo(a: null): null;
declare function bar(a: undefined): undefined;

interface InterfaceWithUndefinedAndNullTypes {
    foo(a: null): undefined
    bar(a: undefined): null
}

declare class ClassWithUndefinedAndNullTypes {
    foo(a: null): undefined
    bar(a: undefined): null
}
