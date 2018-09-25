// based on fibers.d.ts
declare module "fibers" {

	function fibers(callback: () => void): fibers.Fiber;

	namespace fibers {
		export var poolSize: number;
		export var fibersCreated: number;
		export var current: fibers.Fiber;
		export function yield(value: any): any;

		export interface Fiber {
			run(step?: number): any;
		}
	}

	export = fibers;
}
