// TODO: review

// based on fibers.d.ts
declare module "fibers" {

    interface FiberWithTrait {
        reset: () => any;
        run: (param?: any) => any;
        throwInto: (ex: any) => any;
    }

    function FiberWithTrait(fn: Function): Fiber;

    module FiberWithTrait {
        export var current: FiberWithTrait;
        export function yield(value?: any): any
    }

    export = FiberWithTrait;
}
