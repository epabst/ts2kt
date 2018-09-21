declare module TypeScript.Syntax {
    interface ISyntaxList
    interface ISyntaxToken
    interface SourceUnitSyntax

    interface IFactory {
        sourceUnit(moduleElements: ISyntaxList, endOfFileToken: ISyntaxToken): SourceUnitSyntax;
    }
    class NormalModeFactory implements IFactory {
        public sourceUnit(moduleElements: ISyntaxList, endOfFileToken: ISyntaxToken): SourceUnitSyntax;
    }
}
