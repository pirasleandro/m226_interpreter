package ch.tbz.pirasleandro;

import java.util.ArrayList;
import java.util.Arrays;

public class Token {
    private final Type type;
    private final String val;

    public Token(Type type, String val) {
        this.type = type;
        this.val = val;
    }

    public Token(Type type) {
        this(type, null);
    }

    public Type get() {
        return type;
    }

    public String[] getRegexes() {
        return type.REGEXES;
    }

    public String toString() {
        if (val == null) return type.toString();
        else return type + "[" + val + "]";
    }

    public enum Type {
        VALID_NAME(0, "[a-zA-Z]+[a-zA-Z0-9]*"),
        NULL(0, "NOOB"),
        BOOLEAN("TROOF"),
        TRUE("WIN"),
        FALSE("FAIL"),
        INTEGER("NUMBR"),
        INTEGER_VALUE(0, "[0-9]+"),
        FLOAT("NUMBAR"),
        FLOAT_VALUE(0, "[0-9]+.[0-9]+"),
        STRING("YARN"),
        STRING_VALUE(0, "\".+?\""),
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
        public final Integer VAL_INDEX;

        private Type(Integer valIndex, String... regexes) {
            this.VAL_INDEX = valIndex;
            this.REGEXES = regexes;
        }

        private Type(String... regexes) {
            this(null, regexes);
        }

        public Type tokenOf(String... regexes) {
            ArrayList<String[]> regexList = new ArrayList<>();
            Arrays.asList(values()).forEach((t) -> regexList.add(t.REGEXES));
            if (regexList.contains(regexes)) {
                return values()[regexList.indexOf(regexes)];
            } else {
                return null;
            }
        }

        public boolean hasVal() {
            return VAL_INDEX != null;
        }

        public int getValIndex() {
            if (hasVal()) {
                return VAL_INDEX;
            } else {
                throw new UnsupportedOperationException("Type " + this.toString() + " has no value");
            }
        }
    }
}

