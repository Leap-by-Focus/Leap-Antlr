import java.util.HashMap;
import java.util.Map;

public class SimpleInterpreter extends SimpleBaseVisitor<Object> {

    private final Map<String, Object> variables = new HashMap<>();

    private double toNumber(Object obj) {
        if (obj instanceof Number) return ((Number) obj).doubleValue();
        if (obj instanceof String s) return Double.parseDouble(s);
        throw new RuntimeException("Kein numerischer Wert: " + obj);
    }


    @Override
    public Object visitAssignment(SimpleParser.AssignmentContext ctx) {
        String varName = ctx.IDENTIFIER().getText();
        Object value = visit(ctx.expression());
        variables.put(varName, value);
        System.out.println("Variable: " + varName + " = " + value);
        return null;
    }

    @Override
    public Object visitConstantExpression(SimpleParser.ConstantExpressionContext ctx) {
        if (ctx.constant().NUMBER() != null) {
            return Double.parseDouble(ctx.constant().NUMBER().getText());
        } else if (ctx.constant().STRING() != null) {
            return ctx.constant().STRING().getText().replace("\"", "").replace("'", ""); // Entferne Anführungszeichen
        }
        throw new RuntimeException("Unbekannter Konstanter Ausdruck: " + ctx.getText());
    }

    /*@Override
    public Object visitExpression(SimpleParser.ExpressionContext ctx) {
        if (ctx.getChildCount() == 3) { // also: expression op expression
            Object left = visit(ctx.getChild(0));
            String op = ctx.getChild(1).getText();
            Object right = visit(ctx.getChild(2));

            double l = Double.parseDouble(left.toString());
            double r = Double.parseDouble(right.toString());

            return switch (op) {
                case "+" -> l + r;
                case "-" -> l - r;
                case "*" -> l * r;
                case "/" -> {
                    if (r == 0) throw new ArithmeticException("Division durch Null");
                    yield l / r;
                }
                default -> throw new RuntimeException("Unbekannter Operator: " + op);
            };
        } else if (ctx.constant() != null) {
            return Double.parseDouble(ctx.constant().getText());
        } else if (ctx.IDENTIFIER() != null) {
            String var = ctx.IDENTIFIER().getText();
            if (!variables.containsKey(var)) {
                throw new RuntimeException("Variable nicht definiert: " + var);
            }
            return variables.get(var);
        }
        return visitChildren(ctx);
    }*/


    @Override
    public Object visitAdditiveExpression(SimpleParser.AdditiveExpressionContext ctx) {
        Object left = visit(ctx.expression(0)); // Linker Operand
        Object right = visit(ctx.expression(1)); // Rechter Operand
        String operator = ctx.addOp().getText(); // Operator (+ oder -)

        // String-Konkatenation
        if (left instanceof String || right instanceof String) {
            String leftStr = left.toString();
            String rightStr = right.toString();
            if (operator.equals("+")) {
                return leftStr + rightStr; // Konkatenation
            } else {
                throw new RuntimeException("Operator '-' ist für Strings nicht erlaubt.");
            }
        }

        // Numerische Berechnung
        double leftNum = toNumber(left);
        double rightNum = toNumber(right);
        return switch (operator) {
            case "+" -> leftNum + rightNum;
            case "-" -> leftNum - rightNum;
            default -> throw new RuntimeException("Unbekannter Operator: " + operator);
        };
    }

    @Override
    public Object visitMultiplicateExpression(SimpleParser.MultiplicateExpressionContext ctx) {
        Object left = visit(ctx.expression(0));
        Object right = visit(ctx.expression(1));
        String op = ctx.multiOp().getText();

        double l = toNumber(left);
        double r = toNumber(right);


        return switch (op) {
            case "*" -> l * r;
            case "/" -> {
                if (r == 0) throw new ArithmeticException("Division durch Null");
                yield l / r;
            }
            default -> throw new RuntimeException("Unbekannter Operator: " + op);
        };
    }

    @Override
    public Object visitIdentifierExpression(SimpleParser.IdentifierExpressionContext ctx) {
        System.out.println("visitIdentifierExpression aufgerufen: " + ctx.getText());
        String varName = ctx.IDENTIFIER().getText();
        if (!variables.containsKey(varName)) {
            throw new RuntimeException("Variable nicht definiert: " + varName);
        }
        Object value = variables.get(varName);
        System.out.println("Wert der Variable " + varName + ": " + value);
        return value;
    }

    @Override
    public Object visitFunctionCall(SimpleParser.FunctionCallContext ctx) {
        if (ctx.IDENTIFIER().getText().equals("print")) {
            Object value = null;
            if (ctx.expression() != null) { // optional!
                value = visit(ctx.expression());
                System.out.println(value);
            } else {
                System.out.println();
            }
        }
        return null;
    }


    @Override
    public Object visitParenthesizedExpression(SimpleParser.ParenthesizedExpressionContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public Object visitSqrtFunctionStmt(SimpleParser.SqrtFunctionStmtContext ctx) {
        String varName = ctx.IDENTIFIER(0).getText();

        String arg1Text = ctx.getChild(5).getText(); // nach '('
        String arg2Text = ctx.getChild(7).getText(); // nach ','

        double number1 = variables.containsKey(arg1Text)
                ? Double.parseDouble(variables.get(arg1Text).toString())
                : Double.parseDouble(arg1Text);

        double number2 = variables.containsKey(arg2Text)
                ? Double.parseDouble(variables.get(arg2Text).toString())
                : Double.parseDouble(arg2Text);

        double result = Math.sqrt(number1); // number2 ist evtl. ungenutzt

        variables.put(varName, result);
        System.out.println("Variable " + varName + " = " + result);
        return result;
    }


    // Weitere Methoden für andere Regeln hinzufügen...
}
