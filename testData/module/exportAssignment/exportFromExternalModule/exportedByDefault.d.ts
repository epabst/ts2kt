declare module "Boo" {
	function foo(): string;
	var bar: number;

    interface InterfaceExportedByDefault {
        doSomething();
    }

    class ClassExportedByDefault {
        method(s): string;
    }
}
