package ch.tbz.pirasleandro;
public interface ExperimentalToken {
    public static final ExperimentalToken
        BOOLEAN = new DataType("TROOF"),
        STRING = new DataType("YARN"),
        STRING_VALUE = new Value(""),
        INTEGER_VALUE = new Value(""),
        FLOAT_VALUE = new Value("");

    public String regex();
    public class Value implements ExperimentalToken {
        ;

        private final String REGEX;
        private Value(String regex) {
            this.REGEX = regex;
        }
        @Override
        public String regex() {
            return REGEX;
        }
    }
    public class DataType implements ExperimentalToken {
        private final String REGEX;
        private DataType(String regex) {
            this.REGEX = regex;
        }
        @Override
        public String regex() {
            return REGEX;
        }
    }
}
