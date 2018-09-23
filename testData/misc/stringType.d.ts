declare function foo(s: "number"): number;
declare function foo(s: "string"): string;

interface InterfaceWithStringTypes {
    bar(s: "number"): number
    bar(s: "string"): string
}

declare class ClassWithStringTypes {
    baz(s: "number"): number
    baz(s: "string"): string
}
