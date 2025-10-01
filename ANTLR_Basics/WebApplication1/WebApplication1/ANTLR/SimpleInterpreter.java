public class SimpleInterpreter extends SimpleBaseVisitor<Object> {

    @Override
    public Object visitAssignment(SimpleParser.AssignmentContext ctx) {
        String varName = ctx.IDENTIFIER().getText();
        Object value = visit(ctx.expression());
        System.out.println("Variable: " + varName + " = " + value);
        // Du kannst hier später in eine Map speichern
        return null;
    }

    @Override
    public Object visitConstantExpression(SimpleParser.ConstantExpressionContext ctx) {
        return ctx.getText(); // Einfach als String zurückgeben
    }

    @Override
    public Object visitAdditiveExpression(SimpleParser.AdditiveExpressionContext ctx) {
        Object left = visit(ctx.expression(0));
        Object right = visit(ctx.expression(1));
        String op = ctx.addOp().getText();

        double l = Double.parseDouble(left.toString());
        double r = Double.parseDouble(right.toString());

        return switch (op) {
            case "+" -> l + r;
            case "-" -> l - r;
            default -> null;
        };
    }

    // Und so weiter für andere visit-Methoden...
}
