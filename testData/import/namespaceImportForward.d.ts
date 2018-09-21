declare namespace libImportForward {
    interface I {
        x: String
    }
}

declare namespace libImportForward2 {
    function foo(): q.I

    import q = libImportForward
}