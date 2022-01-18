package ch.tbz.pirasleandro;

import java.util.ArrayList;

public class Starter {
    public static void main(String[] args) {
        Lexer lexer = new Lexer(
            "HAI 1.3" + "\n" +
            "    VISIBLE \"Hai world!\"\n" +
            "    I HAS A uwu ITZ \"OWO\"\n" +
            "KTHXBYE"
        );
        for (ArrayList<Token> line : lexer.lex()) {
            for (Token token : line) {
                System.out.print(token + " ");
            }
            System.out.print("\n");
        }
    }
}
