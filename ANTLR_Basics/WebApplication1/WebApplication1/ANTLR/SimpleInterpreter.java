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
        System.out.println("visitAssignment aufgerufen: " + ctx.getText());
        String varName = ctx.IDENTIFIER().getText();
        Object value = visit(ctx.expression());
        variables.put(varName, value);
        System.out.println("Variable: " + varName + " = " + value);
        return null;
    }

    @Override
    public Object visitConstantExpression(SimpleParser.ConstantExpressionContext ctx) {
        return Double.parseDouble(ctx.constant().getText());
         // Gibt den konstanten Wert als String zurück
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
        System.out.println("visitAdditiveExpression aufgerufen: " + ctx.getText());
        Object left = visit(ctx.expression(0));
        Object right = visit(ctx.expression(1));
        String op = ctx.addOp().getText();
        System.out.println("Linker Operand: " + left);
        System.out.println("Rechter Operand: " + right);
        System.out.println("Operator: " + op);

        double l = toNumber(left);
        double r = toNumber(right);


        double result = switch (op) {
            case "+" -> l + r;
            case "-" -> l - r;
            default -> throw new RuntimeException("Unbekannter Operator: " + op);
        };
        System.out.println("Ergebnis der Addition/Subtraktion: " + result);
        return result;
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
