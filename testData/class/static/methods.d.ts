declare interface Bar

declare class FooWithMethods {
    static methodWithOutArgs();
    static methodWithString(s: string): string;
    static methodWithManyArgs(n: number, settings: Bar): boolean;
}
