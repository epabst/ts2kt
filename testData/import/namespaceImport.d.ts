declare namespace libImport {
    interface I {
        x: String
    }
}

declare namespace lib2 {
    import q = libImport

    function foo(): q.I
}