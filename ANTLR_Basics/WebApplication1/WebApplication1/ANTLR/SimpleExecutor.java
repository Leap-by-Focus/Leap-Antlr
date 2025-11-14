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
        
        System.out.println("\n=== AUSGABE ===");
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
        else if (tree instanceof SimpleParser.WriteFileStmtContext) {
            processWriteFileStmt((SimpleParser.WriteFileStmtContext) tree);
        }
        else if (tree instanceof SimpleParser.ReadFileStmtContext) {
            processReadFileStmt((SimpleParser.ReadFileStmtContext) tree);
        }
        else if (tree instanceof SimpleParser.DeleteFileStmtContext) {
            processDeleteFileStmt((SimpleParser.DeleteFileStmtContext) tree);
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
            System.out.println("Ausgabe: " + value);
        }
    }
    
    // ==========================
    // SCHLEIFEN-IMPLEMENTIERUNG
    // ==========================
    
    // FOR-Schleife
    // FOR-Schleife
    private static void processForLoop(SimpleParser.ForStmtContext ctx) {
        String loopVar = ctx.IDENTIFIER().getText();
        int start = 5;
        int end = 10;

        // ... (existierender Code für start/end) ...

        System.out.println("FOR-Schleife: " + loopVar + " von " + start + " bis " + end);

        // Finde die Line im Block
        SimpleParser.LineContext blockLine = findLineInFor(ctx);
    
        if (blockLine != null) {
            System.out.println("Block-Line gefunden: " + blockLine.getText());
        
            for (int i = start; i <= end; i++) {
                variables.put(loopVar, (double) i);
                System.out.println("FOR: " + loopVar + " = " + i);
            
                // Verarbeite die Line für jede Iteration
                processTree(blockLine);
            }
        } else {
            System.out.println("Keine Line im Block gefunden!");
        }

        variables.remove(loopVar);
    }

    private static SimpleParser.LineContext findLineInFor(SimpleParser.ForStmtContext ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            if (child instanceof SimpleParser.LineContext) {
                return (SimpleParser.LineContext) child;
            }
        }
        return null;
    }
    
    private static SimpleParser.BlockContext findBlockInFor(SimpleParser.ForStmtContext ctx) {
        System.out.println("=== DEBUG BLOCK SEARCH ===");
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            System.out.println("Child " + i + ": " + child.getClass().getSimpleName() + " -> '" + child.getText() + "'");
            if (child instanceof SimpleParser.BlockContext) {
                System.out.println("BLOCK GEFUNDEN!");
                return (SimpleParser.BlockContext) child;
            }
        }
        System.out.println("KEIN BLOCK GEFUNDEN!");
        return null;
    }
    
    // REPEAT-Schleife
    private static void processRepeatLoop(SimpleParser.RepeatStmtContext ctx) {
        int times = 2; // Default
    
        // Parse times
        SimpleParser.ExprContext timesExpr = null;
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            if (child instanceof SimpleParser.ExprContext) {
                timesExpr = (SimpleParser.ExprContext) child;
                break;
            }
        }
    
        try {
            if (timesExpr != null) {
                Object timesObj = evaluateSimpleExpr(timesExpr);
                times = ((Number) timesObj).intValue();
            }
        } catch (Exception e) {
            System.out.println("Kann Wiederholungszahl nicht auswerten: " + e.getMessage());
        }
    
        System.out.println("REPEAT: " + times + " mal");

        // Finde die Line im Block
        SimpleParser.LineContext blockLine = findLineInRepeat(ctx);
    
        if (blockLine != null) {
            for (int i = 1; i <= times; i++) {
                System.out.println("REPEAT: Iteration " + i + "/" + times);
            
                // Verarbeite die Line für jede Iteration
                processTree(blockLine);
            }
        } else {
            System.out.println("Keine Line im Block gefunden!");
        }
    }

    private static SimpleParser.LineContext findLineInRepeat(SimpleParser.RepeatStmtContext ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            if (child instanceof SimpleParser.LineContext) {
                return (SimpleParser.LineContext) child;
            }
        }
        return null;
    }
    
    private static SimpleParser.BlockContext findBlockInRepeat(SimpleParser.RepeatStmtContext ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (ctx.getChild(i) instanceof SimpleParser.BlockContext) {
                return (SimpleParser.BlockContext) ctx.getChild(i);
            }
        }
        return null;
    }
    
    // LOOP-Schleife
    private static void processLoopStmt(SimpleParser.LoopStmtContext ctx) {
        int start = 1;
        int end = 2;
    
        // Parse start und end
        SimpleParser.ExprContext startExpr = null;
        SimpleParser.ExprContext endExpr = null;
        int exprCount = 0;
    
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            if (child instanceof SimpleParser.ExprContext) {
                if (exprCount == 0) {
                    startExpr = (SimpleParser.ExprContext) child;
                } else if (exprCount == 1) {
                    endExpr = (SimpleParser.ExprContext) child;
                }
                exprCount++;
            }
        }
    
        try {
            if (startExpr != null) {
                Object startObj = evaluateSimpleExpr(startExpr);
                start = ((Number) startObj).intValue();
            }
            if (endExpr != null) {
                Object endObj = evaluateSimpleExpr(endExpr);
                end = ((Number) endObj).intValue();
            }
        } catch (Exception e) {
            System.out.println("Kann Loop-Parameter nicht auswerten: " + e.getMessage());
        }
    
        System.out.println("LOOP: von " + start + " bis " + end);

        // Finde die Line im Block
        SimpleParser.LineContext blockLine = findLineInLoop(ctx);
    
        if (blockLine != null) {
            for (int i = start; i <= end; i++) {
                System.out.println("LOOP: Iteration " + i);
            
                // Verarbeite die Line für jede Iteration
                processTree(blockLine);
            }
        } else {
            System.out.println("Keine Line im Block gefunden!");
        }
    }

    private static SimpleParser.LineContext findLineInLoop(SimpleParser.LoopStmtContext ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            if (child instanceof SimpleParser.LineContext) {
                return (SimpleParser.LineContext) child;
            }
        }
        return null;
    }
    
    private static SimpleParser.BlockContext findBlockInLoop(SimpleParser.LoopStmtContext ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (ctx.getChild(i) instanceof SimpleParser.BlockContext) {
                return (SimpleParser.BlockContext) ctx.getChild(i);
            }
        }
        return null;
    }
    
    // ==========================
    // EXPRESSION AUSWERTUNG
    // ==========================
    
    // Einfache Expression-Auswertung für Schleifen
    private static Object evaluateSimpleExpr(SimpleParser.ExprContext expr) {
        System.out.println("Evaluate SimpleExpr: " + expr.getText());
        
        if (expr.NUMBER() != null) {
            return Double.parseDouble(expr.NUMBER().getText());
        }
        if (expr.IDENTIFIER() != null) {
            String varName = expr.IDENTIFIER().getText();
            if (!variables.containsKey(varName)) {
                throw new RuntimeException("Variable nicht definiert: " + varName);
            }
            return variables.get(varName);
        }
        if (expr.getChildCount() == 3) { // expr OP expr
            Object left = evaluateSimpleExpr((SimpleParser.ExprContext) expr.getChild(0));
            Object right = evaluateSimpleExpr((SimpleParser.ExprContext) expr.getChild(2));
            String operator = expr.getChild(1).getText();
            
            if (left instanceof Number && right instanceof Number) {
                double l = ((Number) left).doubleValue();
                double r = ((Number) right).doubleValue();
                
                switch (operator) {
                    case "+": return l + r;
                    case "-": return l - r;
                    case "*": return l * r;
                    case "/": return l / r;
                    case "%": return l % r;
                    default: throw new RuntimeException("Unbekannter Operator: " + operator);
                }
            }
        }
        
        throw new RuntimeException("Unbekannter Expression-Typ: " + expr.getText());
    }
    
    // Komplexe Expression-Auswertung (existierende Methode)
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
    
    // File-Methoden (existierende Methoden)
    private static void processWriteFileStmt(SimpleParser.WriteFileStmtContext ctx){
        String varName = ctx.IDENTIFIER().getText();
        String filename = ctx.STRING().getText().replaceAll("^\"|\"$", "");

        System.out.println("Schreibe " + varName + " in die Datei " + filename);

        if (!variables.containsKey(varName)) {
            throw new RuntimeException("Variable nicht definiert: " + varName);
        }

        Object value = variables.get(varName);
        System.out.println("Inhalt: " + value);

        try{
            Files.writeString(Path.of(filename), value.toString());
            System.out.println("Datei erfolgreich geschrieben: " + filename);
        } catch (IOException e){
            throw new RuntimeException("Fehler beim Schreiben der Datei: " + e.getMessage());
        }
    }

    private static void processReadFileStmt(SimpleParser.ReadFileStmtContext ctx){
        String varName = ctx.IDENTIFIER().getText();
        String filename = ctx.STRING().getText().replaceAll("^\"|\"$", "");

        System.out.println("Lese die Datei " + filename + " in die Variable " + varName);

        try{
            String content = Files.readString(Path.of(filename));
            variables.put(varName, content);
            System.out.println("Datei erfolgreich gelesen: " + filename + ", Inhalt: " + content);
        } catch (IOException e){
            throw new RuntimeException("Fehler beim Lesen der Datei: " + e.getMessage());
        } 
    }

    private static void processDeleteFileStmt(SimpleParser.DeleteFileStmtContext ctx){
        String fileName = ctx.STRING().getText().replaceAll("^\"|\"$", "");

        System.out.println("Datei " + fileName + " wird gelöscht.");

        try {
            if (!Files.exists(Path.of(fileName))) {
                throw new RuntimeException("Datei existiert nicht: " + fileName);
            }

            Files.delete(Path.of(fileName));
            System.out.println("Datei erfolgreich gelöscht: " + fileName);
        } catch (IOException e) {
            throw new RuntimeException("Fehler beim Löschen der Datei: " + fileName + ", Grund: " + e.getMessage());
        }
    }
}