package ch.tbz.pirasleandro;

import java.util.ArrayList;

public class Parser {
    private ArrayList<ArrayList<Token>> tokens;
    private ArrayList<AST> ast = new ArrayList<>();
    
    public Parser(ArrayList<ArrayList<Token>> tokens) {
        this.tokens = tokens;
    }

    public ArrayList<AST> parse() {
        for (int i = 0; i < tokens.size(); i++) {
            
        }
        return ast;
    }

    public ArrayList<AST> getBlocks() {
        return ast;
    }
}
