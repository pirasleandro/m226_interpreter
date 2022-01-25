package ch.tbz.pirasleandro;

import java.util.HashMap;

public interface AST {
    public interface Line extends AST {
        public class Version implements Line {
            public final String version;
            public Version(String version) {
                this.version = version;
            }
        }
        public class Print implements Line {
            public final Expression<?> value;
            public Print(Expression<?> value) {
                this.value = value;
            }
        }
        public class VariableDeclaration implements Line {
            public final String id;
            public final Expression<?> value;
            public VariableDeclaration(String id, Expression<?> value) {
                this.id = id;
                this.value = value;
            }
        }
        
    }
    public interface Block extends AST {
        public class FunctionDeclaration implements AST {
            public final String id;
            public final HashMap<String, DataType> parameters;
            public final AST[] body;
            public FunctionDeclaration(String id, HashMap<String, DataType> parameters, AST[] body) {
                this.id = id;
                this.parameters = parameters;
                this.body = body;
            }
        }
        public class BuckitDeclaration implements AST {
            public final String id;
            public final AST[] body;
            public BuckitDeclaration(String id, AST[] body) {
                this.id = id;
                this.body = body;
            }
        }
        public class IfStatement implements Block {
            public final Expression<Boolean> condition;
            public final AST[] body;
            public final AST[] altBody;
            public IfStatement(Expression<Boolean> condition, AST[] body, AST[] altBody) {
                this.condition = condition;
                this.body = body;
                this.altBody = altBody;
            }
        }
        public class Switch implements Block {
            public final Expression<?> value;
            public final HashMap<?, AST[]> cases;
            public Switch(Expression<?> value, HashMap<?, AST[]> cases) {
                this.value = value;
                this.cases = cases;
            }
        }
    }
    public interface Expression<T> extends AST {
        public class Value<T> implements Expression<T> {
            public final T value;
            public Value(T value) {
                this.value = value;
            }
        }
        public class Operation<T extends Number> implements Expression<T> {
            public final Expression<T> first;
            public final OperationType type;
            public final Expression<T> second;
            public Operation(Expression<T> first, OperationType type, Expression<T> second) {
                this.first = first;
                this.type = type;
                this.second = second;
            }
            public enum OperationType {
                ADD, SUBTRACT, MULTIPLY, DIVIDE, MODULO, BIGGER_OF, SMALLER_OF;
            }
        }
        public class Comparison implements Expression<Boolean> {
            public final Expression<?> first;
            public final ComparisonType type;
            public final Expression<?> second;
            public Comparison(Expression<?> first, ComparisonType type, Expression<?> second) {
                this.first = first;
                this.type = type;
                this.second = second;
            }
            public enum ComparisonType {
                EQUALS, NOT_EQUALS;
            }
        }
        public class VariableReference implements Expression<Object> {
            public final String id;
            public VariableReference(String id) {
                this.id = id;
            }
        }
    }
    public enum DataType implements AST {
        STRING,
        INTEGER,
        FLOAT,
        BUCKIT;
    }
}