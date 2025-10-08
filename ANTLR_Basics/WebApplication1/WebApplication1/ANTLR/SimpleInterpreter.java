import java.util.HashMap;
import java.util.Map;

public class SimpleInterpreter extends SimpleBaseVisitor<Object> {

    private final Map<String, Object> variables = new HashMap<>();

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
        return ctx.constant().getText(); // Gibt den konstanten Wert als String zurück
    }

    @Override
    public Object visitAdditiveExpression(SimpleParser.AdditiveExpressionContext ctx) {
        System.out.println("visitAdditiveExpression aufgerufen: " + ctx.getText());
        Object left = visit(ctx.expression(0));
        Object right = visit(ctx.expression(1));
        String op = ctx.addOp().getText();
        System.out.println("Linker Operand: " + left);
        System.out.println("Rechter Operand: " + right);
        System.out.println("Operator: " + op);

        double l = Double.parseDouble(left.toString());
        double r = Double.parseDouble(right.toString());

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

        double l = Double.parseDouble(left.toString());
        double r = Double.parseDouble(right.toString());

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
            Object value = visit(ctx.expression(0));
            System.out.println(value);
        }
        return null;
    }

    @Override
    public Object visitParenthesizedExpression(SimpleParser.ParenthesizedExpressionContext ctx) {
        return visit(ctx.expression()); // Klammern einfach ignorieren
    }

    @Override
    public Object visitSqrtFunctionStmt(SimpleParser.SqrtFunctionStmtContext ctx) {
        // Hole die beiden Argumente aus der Regel
        Object arg1 = visit(ctx.getChild(4)); // Erstes Argument (NUMBER oder IDENTIFIER)
        Object arg2 = visit(ctx.getChild(6)); // Zweites Argument (NUMBER oder IDENTIFIER)

        // Konvertiere die Argumente in Zahlen
        double number1 = Double.parseDouble(arg1.toString());
        double number2 = Double.parseDouble(arg2.toString());

        // Berechne die Quadratwurzel des ersten Arguments
        double result = Math.sqrt(number1);

        // Gib das Ergebnis aus (oder speichere es in einer Variablen)
        System.out.println("Ergebnis: " + result);

        return result;
    }

    // Weitere Methoden für andere Regeln hinzufügen...
}
