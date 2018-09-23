// TODO: review

// based on fibers.d.ts
declare module "fibers" {

    interface Fiber {
        reset: () => any;
        run: (param?: any) => any;
        throwInto: (ex: any) => any;
    }

    function Fiber(fn: Function): Fiber;

    module Fiber {
        export var current: Fiber;
        export function yield(value?: any): any
    }

    export = Fiber;
}
