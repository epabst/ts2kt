declare enum SomeEnumWithValues {
    Foo = 1,
    Bar,
    $ = 2,
    BAZ$,
    UnaryExpressionValue = -123,
    ExpressionValue = -123 + 23
}

declare enum AnotherEnum {
    StringValue = "my string value",
    UnaryExpressionValue = -123
}
