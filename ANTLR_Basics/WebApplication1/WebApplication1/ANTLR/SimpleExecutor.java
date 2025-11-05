import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.*;
import java.nio.file.*;
import java.io.IOException;

public class SimpleExecutor {
    
    private static Map<String, Object> variables = new HashMap<>();
    
    public static void main(String[] args) throws Exception {
        String code = readFile("test.simple");
        execute(code);
    }
    
    private static String readFile(String filename) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filename));
        return String.join("\n", lines);
    }
    
    public static void execute(String code) throws Exception {
        System.out.println("Ausführbarer Code:\n" + code);
        System.out.println("\n=== START AUSFÜHRUNG ===");
        
        SimpleLexer lexer = new SimpleLexer(CharStreams.fromString(code));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SimpleParser parser = new SimpleParser(tokens);
        
        ParseTree tree = parser.program();
        processTree(tree);
        
        System.out.println("\n=== FINALE AUSGABE ===");
        variables.forEach((name, value) -> System.out.println(name + " = " + value));
    }
    
    private static void processTree(ParseTree tree) {
        if (tree instanceof SimpleParser.ProgramContext) {
            SimpleParser.ProgramContext program = (SimpleParser.ProgramContext) tree;
            for (var child : program.children) {
                processTree(child);
            }
        }
        else if (tree instanceof SimpleParser.StatementContext) {
            processTree(((SimpleParser.StatementContext) tree).getChild(0));
        }
        else if (tree instanceof SimpleParser.AssignmentContext) {
            processAssignment((SimpleParser.AssignmentContext) tree);
        }
        else if (tree instanceof SimpleParser.FunctionCallContext) {
            processFunctionCall((SimpleParser.FunctionCallContext) tree);
        }
        else if (tree instanceof SimpleParser.ForStmtContext) {
            processForLoop((SimpleParser.ForStmtContext) tree);
        }
        else if (tree instanceof SimpleParser.RepeatStmtContext) {
            processRepeatLoop((SimpleParser.RepeatStmtContext) tree);
        }
        else if (tree instanceof SimpleParser.LoopStmtContext) {
            processLoopStmt((SimpleParser.LoopStmtContext) tree);
        }
        else if (tree instanceof SimpleParser.LineContext) {
            for (int i = 0; i < tree.getChildCount(); i++) {
                ParseTree child = tree.getChild(i);
                if (!(child instanceof TerminalNode)) {
                    processTree(child);
                }
            }
        }
        else if (tree instanceof SimpleParser.BlockContext) {
            processBlock((SimpleParser.BlockContext) tree);
        }
    }
    
    private static void processAssignment(SimpleParser.AssignmentContext assign) {
        String varName = assign.IDENTIFIER().getText();
        Object value = evaluateExpression(assign.expression());
        variables.put(varName, value);
        System.out.println("Variable gesetzt: " + varName + " = " + value);
    }
    
    private static void processFunctionCall(SimpleParser.FunctionCallContext func) {
        if ("print".equals(func.IDENTIFIER().getText()) && func.expression() != null) {
            Object value = evaluateExpression(func.expression());
            System.out.println("AUSGABE: " + value);
        }
    }
    
    // ==========================
    // SCHLEIFEN-IMPLEMENTIERUNG
    // ==========================
    
    // FOR-Schleife: for i from 1 to 3 { ... }
    private static void processForLoop(SimpleParser.ForStmtContext ctx) {
        // Extrahiere Informationen aus dem Text
        String loopVar = ctx.IDENTIFIER().getText();
        int start = 1;
        int end = 3;
        
        // Durchsuche Kinder nach Zahlen
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            if (child instanceof TerminalNode) {
                TerminalNode node = (TerminalNode) child;
                if (node.getSymbol().getType() == SimpleLexer.NUMBER) {
                    if (start == 1) {
                        start = Integer.parseInt(node.getText());
                    } else {
                        end = Integer.parseInt(node.getText());
                    }
                }
            }
        }
        
        System.out.println("FOR-Schleife: " + loopVar + " von " + start + " bis " + end);
        
        for (int i = start; i <= end; i++) {
            variables.put(loopVar, (double) i);
            System.out.println("FOR: " + loopVar + " = " + i);
            processBlock(findBlockInFor(ctx));
        }
        
        variables.remove(loopVar);
    }
    
    private static SimpleParser.BlockContext findBlockInFor(SimpleParser.ForStmtContext ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (ctx.getChild(i) instanceof SimpleParser.BlockContext) {
                return (SimpleParser.BlockContext) ctx.getChild(i);
            }
        }
        return null;
    }
    
    // REPEAT-Schleife: repeat 5 times { ... }
    private static void processRepeatLoop(SimpleParser.RepeatStmtContext ctx) {
        int times = 2; // Default
        
        // Durchsuche Kinder nach Zahl
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            if (child instanceof TerminalNode) {
                TerminalNode node = (TerminalNode) child;
                if (node.getSymbol().getType() == SimpleLexer.NUMBER) {
                    times = Integer.parseInt(node.getText());
                    break;
                }
            }
        }
        
        System.out.println("REPEAT: " + times + " mal");
        
        for (int i = 1; i <= times; i++) {
            System.out.println("REPEAT: Iteration " + i + "/" + times);
            processBlock(findBlockInRepeat(ctx));
        }
    }
    
    private static SimpleParser.BlockContext findBlockInRepeat(SimpleParser.RepeatStmtContext ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (ctx.getChild(i) instanceof SimpleParser.BlockContext) {
                return (SimpleParser.BlockContext) ctx.getChild(i);
            }
        }
        return null;
    }
    
    // LOOP-Schleife: loop from 1 to 10 { ... }
    private static void processLoopStmt(SimpleParser.LoopStmtContext ctx) {
        int start = 1;
        int end = 2;
        int numberIndex = 0;
        
        // Durchsuche Kinder nach Zahlen
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            if (child instanceof TerminalNode) {
                TerminalNode node = (TerminalNode) child;
                if (node.getSymbol().getType() == SimpleLexer.NUMBER) {
                    if (numberIndex == 0) {
                        start = Integer.parseInt(node.getText());
                        numberIndex++;
                    } else {
                        end = Integer.parseInt(node.getText());
                    }
                }
            }
        }
        
        System.out.println("LOOP: von " + start + " bis " + end);
        
        for (int i = start; i <= end; i++) {
            System.out.println("LOOP: Iteration " + i);
            processBlock(findBlockInLoop(ctx));
        }
    }
    
    private static SimpleParser.BlockContext findBlockInLoop(SimpleParser.LoopStmtContext ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (ctx.getChild(i) instanceof SimpleParser.BlockContext) {
                return (SimpleParser.BlockContext) ctx.getChild(i);
            }
        }
        return null;
    }
    
    // Block verarbeiten
    private static void processBlock(SimpleParser.BlockContext block) {
        if (block != null) {
            for (int i = 0; i < block.getChildCount(); i++) {
                ParseTree child = block.getChild(i);
                if (child instanceof SimpleParser.LineContext) {
                    processTree(child);
                }
            }
        }
    }
    
    // ==========================
    // EXPRESSION AUSWERTUNG
    // ==========================
    
    private static Object evaluateExpression(SimpleParser.ExpressionContext expr) {
        if (expr instanceof SimpleParser.IdentifierExpressionContext) {
            String varName = ((SimpleParser.IdentifierExpressionContext) expr).IDENTIFIER().getText();
            if (!variables.containsKey(varName)) {
                throw new RuntimeException("Variable nicht definiert: " + varName);
            }
            return variables.get(varName);
        }
        else if (expr instanceof SimpleParser.ConstantExpressionContext) {
            SimpleParser.ConstantContext constant = ((SimpleParser.ConstantExpressionContext) expr).constant();
            if (constant.NUMBER() != null) return Double.parseDouble(constant.NUMBER().getText());
            if (constant.STRING() != null) return constant.STRING().getText().replaceAll("^\"|\"$", "");
        }
        else if (expr instanceof SimpleParser.AdditiveExpressionContext) {
            SimpleParser.AdditiveExpressionContext addExpr = (SimpleParser.AdditiveExpressionContext) expr;
            Object left = evaluateExpression(addExpr.expression(0));
            Object right = evaluateExpression(addExpr.expression(1));
            
            if (left instanceof String || right instanceof String) {
                return left.toString() + right.toString();
            } else {
                double l = ((Number) left).doubleValue();
                double r = ((Number) right).doubleValue();
                if ("+".equals(addExpr.addOp().getText())) return l + r;
                if ("-".equals(addExpr.addOp().getText())) return l - r;
            }
        }
        else if (expr instanceof SimpleParser.MultiplicateExpressionContext) {
            SimpleParser.MultiplicateExpressionContext multExpr = (SimpleParser.MultiplicateExpressionContext) expr;
            Object left = evaluateExpression(multExpr.expression(0));
            Object right = evaluateExpression(multExpr.expression(1));
            
            double l = ((Number) left).doubleValue();
            double r = ((Number) right).doubleValue();
            
            if ("*".equals(multExpr.multiOp().getText())) return l * r;
            if ("/".equals(multExpr.multiOp().getText())) {
                if (r == 0) throw new ArithmeticException("Division durch Null");
                return l / r;
            }
        }
        else if (expr instanceof SimpleParser.ParenthesizedExpressionContext) {
            return evaluateExpression(((SimpleParser.ParenthesizedExpressionContext) expr).expression());
        }
        
        throw new RuntimeException("Unbekannter Expression-Typ: " + expr.getClass().getSimpleName());
    }
}