import org.antlr.v4.runtime.tree.*;
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
    public Object visitProgram(SimpleParser.ProgramContext ctx) {
        System.out.println("=== Starte Programmausführung ===");
        
        // Besuche alle Kinder (statements und lines)
        for (int i = 0; i < ctx.getChildCount(); i++) {
            Object result = visit(ctx.getChild(i));
            if (result != null) {
                System.out.println("Ausgeführt: " + ctx.getChild(i).getText() + " -> " + result);
            }
        }
        
        System.out.println("=== Programm beendet ===");
        
        // Zeige alle Variablen am Ende
        System.out.println("\n=== Alle Variablen ===");
        variables.forEach((name, value) -> System.out.println(name + " = " + value));
        
        return null;
    }

    @Override
    public Object visitStatement(SimpleParser.StatementContext ctx) {
        System.out.println("Besuche Statement: " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public Object visitAssignment(SimpleParser.AssignmentContext ctx) {
        String varName = ctx.IDENTIFIER().getText();
        Object value = visit(ctx.expression());
        variables.put(varName, value);
    
        // AUTOMATISCHE AUSGABE für bestimmte Variablen
        if (varName.startsWith("ERGEBNIS") || varName.equals("ausgabe") || varName.equals("c")) {
            System.out.println("=== AUSGABE: " + value + " ===");
        }
    
        System.out.println("Variable: " + varName + " = " + value);
        return value;
    }

    @Override
    public Object visitFunctionCall(SimpleParser.FunctionCallContext ctx) {
        String functionName = ctx.IDENTIFIER().getText();
        System.out.println("Funktionsaufruf: " + functionName);
        
        if ("print".equals(functionName)) {
            Object value = null;
            if (ctx.expression() != null) {
                value = visit(ctx.expression());
                System.out.println("AUSGABE: " + value);
            } else {
                System.out.println(); // Leere Zeile
            }
            return value;
        } else {
            throw new RuntimeException("Unbekannte Funktion: " + functionName);
        }
    }

    @Override
    public Object visitConstantExpression(SimpleParser.ConstantExpressionContext ctx) {
        if (ctx.constant().NUMBER() != null) {
            return Double.parseDouble(ctx.constant().NUMBER().getText());
        } else if (ctx.constant().STRING() != null) {
            String text = ctx.constant().STRING().getText();
            return text.substring(1, text.length() - 1); // Entferne Anführungszeichen
        }
        throw new RuntimeException("Unbekannter Konstanter Ausdruck: " + ctx.getText());
    }

    @Override
    public Object visitAdditiveExpression(SimpleParser.AdditiveExpressionContext ctx) {
        Object left = visit(ctx.expression(0));
        Object right = visit(ctx.expression(1));
        String operator = ctx.addOp().getText();

        // String-Konkatenation
        if (left instanceof String || right instanceof String) {
            String leftStr = left.toString();
            String rightStr = right.toString();
            if (operator.equals("+")) {
                return leftStr + rightStr;
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
        String varName = ctx.IDENTIFIER().getText();
        if (!variables.containsKey(varName)) {
            throw new RuntimeException("Variable nicht definiert: " + varName);
        }
        Object value = variables.get(varName);
        System.out.println("Lese Variable " + varName + " = " + value);
        return value;
    }

    @Override
    public Object visitParenthesizedExpression(SimpleParser.ParenthesizedExpressionContext ctx) {
        return visit(ctx.expression());
    }
}