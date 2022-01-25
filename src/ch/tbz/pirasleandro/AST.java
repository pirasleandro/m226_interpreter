package ch.tbz.pirasleandro;

import java.util.HashMap;

import ch.tbz.pirasleandro.AST.Expression.Value;

public interface AST {
    public interface Line extends AST {
        public class Version implements Line {
            public final String version;
            public Version(String version) {
                this.version = version;
            }
        }
        public class LibraryImport implements Line {
            public final String libId;
            public LibraryImport(String libId) {
                this.libId = libId;
            }
        }
        public class Print implements Line {
            public final Expression<?> value;
            public Print(Expression<?> value) {
                this.value = value;
            }
        }
        public class Input implements Line {
            public final ID id;
            public Input(ID id) {
                this.id = id;
            }
        }
        public class VariableDeclaration implements Line {
            public final ID id;
            public final ID typeOf;
            public final DataType type;
            public final Expression<?> value;
            private VariableDeclaration(ID id, ID typeOf, DataType type, Expression<?> value) {
                this.id = id;
                this.typeOf = typeOf;
                this.type = type;
                this.value = value;
            }
            public VariableDeclaration(ID id, Expression<?> value) {
                this(id, null, null, value);
            }
            public VariableDeclaration(ID id) {
                this(id, null, null, null);
            }
            public VariableDeclaration(ID id, DataType type) {
                this(id, null, type, null);
            }
            public VariableDeclaration(ID id, ID typeOf) {
                this(id, typeOf, null, null);
            }
        }
        public class AssignToVariable {
            public final ID id;
            public final Expression<?> value;
            public AssignToVariable(ID id, Expression<?> value) {
                this.id = id;
                this.value = value;
            }
        }
        public class Concatenate {
            public final Value<String>[] strings;
            public Concatenate(Value<String>[] strings) {
                this.strings = strings;
            }
        }
        public class Cast {
            public final Expression<?> expression;
            public final DataType type;
            public Cast(Expression<?> expression, DataType type) {
                this.expression = expression;
                this.type = type;
            }
        }
    }
    public interface Block extends AST {
        public class FunctionDeclaration implements AST {
            public final ID id;
            public final HashMap<String, DataType> parameters;
            public final AST[] body;
            public FunctionDeclaration(ID id, HashMap<String, DataType> parameters, AST[] body) {
                this.id = id;
                this.parameters = parameters;
                this.body = body;
            }
        }
        public class BuckitDeclaration implements AST {
            public final ID id;
            public final AST[] body;
            public BuckitDeclaration(ID id, AST[] body) {
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
            public final ID id;
            public VariableReference(ID id) {
                this.id = id;
            }
        }
    }
    public class ID {
        public final String id;
        public ID(String id) {
            this.id = id;
        }
        public ID(Value<String> id) {
            this.id = id.value;
        }
    }
    public enum DataType implements AST {
        STRING,
        INTEGER,
        FLOAT,
        BUCKIT;
    }
}