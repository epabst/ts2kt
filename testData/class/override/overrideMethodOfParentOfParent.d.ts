declare module TypeScript.Syntax {
    class EmptySyntaxList implements ISyntaxList {
        public kind(): SyntaxKind;
        childAt(index: number): ISyntaxNodeOrToken;
        toArray(): ISyntaxNodeOrToken[];
        insertChildrenInto(array: ISyntaxElement[], index: number): void;
    }
}

declare module TypeScript {
    interface ISyntaxElement {
        kind(): SyntaxKind;
    }
    interface SyntaxKind;
    interface ISyntaxNodeOrToken;
}

declare module TypeScript {
    interface ISyntaxList extends ISyntaxElement {
        childAt(index: number): ISyntaxNodeOrToken;
        toArray(): ISyntaxNodeOrToken[];
        insertChildrenInto(array: ISyntaxElement[], index: number): void;
    }
}

