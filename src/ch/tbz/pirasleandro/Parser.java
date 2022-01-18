package ch.tbz.pirasleandro;

import java.util.ArrayList;

public class Parser {
    @SuppressWarnings("unused")
    private ArrayList<ArrayList<Token>> tokens;
    private ArrayList<Snippet> blocks = new ArrayList<>();
    
    public Parser(ArrayList<ArrayList<Token>> tokens) {
        this.tokens = tokens;
    }

    public ArrayList<Snippet> parse() {
        return null; // TODO
    }

    public ArrayList<Snippet> getBlocks() {
        return blocks;
    }
}
