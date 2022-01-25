package ch.tbz.pirasleandro;

import java.util.ArrayList;
import ch.tbz.pirasleandro.AST.Line.*;
import ch.tbz.pirasleandro.AST.Block.*;
import ch.tbz.pirasleandro.AST.Expression.*;
import ch.tbz.pirasleandro.AST.Expression.Comparison.ComparisonType;

public class Starter {
    public static void main(String[] args) {
        Lexer lexer = new Lexer(
            "HAI 1.3" + "\n" +
            "   VISIBLE \"Hai world!\"\n" +
            "   I HAS A uwu ITZ \"OWO\"\n" +
            "   VISIBLE uwu\n" +
            "   BOTH SAEM uwu AN \"uwu\", O RLY?\n" +
            "   YA RLY\n" +
            "       VISIBLE \"true\"\n" +
            "   NO WAI\n" +
            "       VISIBLE \"false\"\n" +
            "   OIC\n" +
            "KTHXBYE"
        );

        // Abstract syntax tree for code above
        @SuppressWarnings("unused")
        AST[] code = {
            new Version("1.3"),
            new Print(new Value<String>("Hai World!!!1!!")),
            new VariableDeclaration("uwu", new Value<String>("OWO")),
            new Print(new VariableReference("uwu")),
            new IfStatement(
                new Comparison(
                    new VariableReference("uwu"),
                    ComparisonType.EQUALS,
                    new Value<String>("uwu")
                ),
                new AST[] {
                    new Print(new Value<String>("true"))
                },
                new AST[] {
                    new Print(new Value<String>("false"))
                }
            )
        };
        
        for (ArrayList<Token> line : lexer.lex()) {
            for (Token token : line) {
                System.out.print(token.toString() + " ");
            }
            System.out.print("\n");
        }
    }
}
