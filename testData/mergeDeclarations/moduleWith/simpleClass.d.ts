declare class SimpleFoo {
    bar(): number;
}

declare module SimpleFoo {
    export function baz(a);
    export function bar(): number;
}
