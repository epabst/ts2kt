declare namespace Foo {
    export interface InterfaceInSameModuleName {
        baz();
    }
    export namespace Foo {
        export class ClassInSameModuleName {
            boo() : InterfaceInSameModuleName;
        }
        export var c: number;
    }

    export function d(a: InterfaceInSameModuleName, b, c: Foo.ClassInSameModuleName);
}
