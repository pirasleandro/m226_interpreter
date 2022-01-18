package ch.tbz.pirasleandro;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ch.tbz.pirasleandro.Token.Type;

public class Lexer {
    private ArrayList<ArrayList<Token>> tokens = new ArrayList<>();
    private ArrayList<ArrayList<String>> code;

    public Lexer(String input) {
        code = new ArrayList<>();
        String[] lines = input.split("[\n\r]+\s*");
        for (String line : lines) {
            ArrayList<String> words = new ArrayList<>();
            Pattern pattern = Pattern.compile("[^\s\"']+|\"[^\"]*\"");
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                words.add(matcher.group());
            }
            code.add(words);
        }
    }

    public ArrayList<ArrayList<Token>> lex() {
        // iterate through lines of code
        for (int i = 0; i < code.size(); i++) {
            if (code.get(i).size() == 0) continue; // skip empty lines
            ArrayList<String> line = code.get(i);
            ArrayList<Token> lineTokens = new ArrayList<>();
            // iterate through segments in [line]
            for (int j = 0; j < line.size(); j++) {
                // iterate through every token type
                for (Type tokenType : Type.values()) {
                    // skip token if less segments than regexes in [tokenType]
                    if (tokenType.REGEXES.length > line.size()) continue;
                    int matchingRegexes = 0;
                    // iterate through [REGEXES] of [tokenType]
                    for (int k = 0; k < tokenType.REGEXES.length; k++) {
                        // increase [matchingRegexes] if regex at [k] matches segment at [j]+[k]
                        try {
                            if (line.get(j+k).matches(tokenType.REGEXES[k])) {
                                matchingRegexes++;
                                j += tokenType.REGEXES.length-1;
                            } else break;
                        } catch (IndexOutOfBoundsException e) { break; }
                    }
                    // add token to lineTokens 
                    if (matchingRegexes == tokenType.REGEXES.length) {
                        if (tokenType.hasVal()) {
                            lineTokens.add(new Token(tokenType, line.get(j+tokenType.VAL_INDEX)));
                        } else {
                            lineTokens.add(new Token(tokenType));
                        }
                        break;
                    }
                }
            }
            if (lineTokens.size() > 0) tokens.add(lineTokens);
        }
        return tokens;
    }

    public ArrayList<ArrayList<Token>> getTokens() {
        return tokens;
    }
}
