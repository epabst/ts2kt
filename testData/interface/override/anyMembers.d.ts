interface ExpectedOverrides {
    equals(a: any | undefined);
    hashCode(): number;
    toString(): String;
}

interface ExpectedOverrides2 {
    equals(a);
}

interface ExpectedNoOverrides {
    equals();
    equals(a: number);
    equals(a: string);
    hashCode(a: String): number;
    toString(a: number = 1);
}
