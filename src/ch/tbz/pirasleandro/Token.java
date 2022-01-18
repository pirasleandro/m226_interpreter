package ch.tbz.pirasleandro;

import java.util.ArrayList;
import java.util.Arrays;

public enum Token {
    NAME("[a-zA-Z]*[a-z]+[a-zA-Z]*"),
    NULL("NOOB"),
    BOOLEAN("TROOF"),
    TRUE("WIN"),
    FALSE("FAIL"),
    INTEGER("NUMBR"),
    INTEGER_VALUE("[0-9]+"),
    FLOAT("NUMBAR"),
    FLOAT_VALUE("[0-9]+.[0-9]+"),
    STRING("YARN"),
    STRING_VALUE("\".+?\""),
    ARRAY("BUKKIT"),
    VERSION("HAI", "\\S+"),
    COMMENT("BTW .*"),
    MULTILINE_COMMENT("OBTW"),
    END_MULTILINE_COMMENT("TLDR"),
    IMPORT("CAN", "HAS"),
    PRINT("VISIBLE"),
    INPUT("GIMMEH"),
    DECLARE_VAR("I", "HAS", "A"),
    DECLARE_BUKKIT("O", "HAI", "IM"),
    END_DECLARE_BUKKIT("KTHX"),
    IS_VALUE("ITZ"),
    REQUEST_TYPE("A"),
    OF("LIEK"),
    SET_VALUE("R"),
    EQUALS("BOTH", "SAEM"),
    FIRST_VALUE("OF"),
    NEXT_VALUE("AN"),
    NOT_EQUALS("DIFFRINT"),
    BIGGER("BIGGR"),
    SMALLER("SMALLR"),
    ADD("SUM"),
    SUBTRACT("DIFF"),
    MULTIPLY("PRODUKT"),
    DIVIDE("QUOSHUNT"),
    MODULO("MOD"),
    START_CONCATENATE("SMOOSH"),
    END_CONCATENATE("MKAY"),
    CAST("MAEK"),
    CONVERT_TO("IS", "NOW"),
    VALUE_OF("SRS"),
    IF(",", "O", "RLY", "\\?"),
    THEN("YA", "RLY"),
    ELSE("NO", "WAI"),
    END_STATEMENT("OIC"),
    SWITCH(",", "WTF", "\\?"),
    CASE("OMG"),
    DEFAULT("OMGWTF"),
    LOOP("IM", "IN", "YR"),
    INCREASING("UPPIN", "YR"),
    DECREASING("NERFIN", "YR"),
    UNTIL("TIL"),
    WHILE("WILE"),
    BREAK("GFTO"),
    END_LOOP("IM", "OUTTA", "YR"),
    FUNCTION("HOW", "IZ", "I"),
    CALL_FUNCTION("I", "IZ"),
    END_FUNCTION("IF", "U", "SAY", "SO"),
    TERMINATE("KTHXBYE");

    public final String[] REGEXES;
    private Token(String... regexes) {
        this.REGEXES = regexes;
    }

    public Token tokenOf(String... regexes) {
        ArrayList<String[]> regexList = new ArrayList<>();
        Arrays.asList(values()).forEach((t) -> regexList.add(t.REGEXES));
        if (regexList.contains(regexes)) {
            return values()[regexList.indexOf(regexes)];
        } else {
            return null;
        }
    }
}
