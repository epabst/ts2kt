declare module Foo {
    module Bar {
        export interface InterfaceWithNonExportDeclarations {
            baz();
        }
        class ClassWithNonExportDeclarations {
            boo();
        }
        var varWithNonExportDeclaration: number;
        export function d(a: boolean, b, c: InterfaceWithNonExportDeclarations);
    }
    interface InterfaceWithNonExportDeclarations {
        baz();
    }
    class ClassWithNonExportDeclarations {
        boo();
    }
    var varWithNonExportDeclaration: number;
    function d(a: boolean, b, c: InterfaceWithNonExportDeclarations);
}

