package ch.tbz.pirasleandro;

public interface Snippet {
    public interface Block extends Snippet {
        public class IfStatement implements Block {

        }
        public class SwitchStatement implements Block {

        }
    }
    public interface Line extends Snippet {
        public class Expression implements Line {

        }
        public class Declaration implements Line {

        }
    }
}