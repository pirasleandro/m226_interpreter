package ch.tbz.pirasleandro;

import java.util.ArrayList;

public class Starter {
    public static void main(String[] args) {
        Lexer lexer = new Lexer(
            "HAI 1.3" + "\n" +
            "   VISIBLE \"Hai world!\"\n" +
            "   I HAS A uwu ITZ \"OWO\"\n" +
            "   I HAS A heehee ITZ \"HEEHEE\"\n" +
            "   I HAS A aBC ITZ 1\n" +
            "   I HAS A ABc ITZ 2\n" +
            "   I HAS A a1c ITZ 3\n" +
            "   I HAS A NAW ITZ 4\n" +
            "   OBTW\n" +
            "       commentline1\n" +
            "       COMMENTLINE2\n" +
            "       commentLINE3\n" +
            "   TLDR\n" +
            "KTHXBYE"
        );
        for (ArrayList<Token> line : lexer.lex()) {
            for (Token token : line) {
                System.out.print(token.toString() + " ");
            }
            System.out.print("\n");
        }
    }
}
