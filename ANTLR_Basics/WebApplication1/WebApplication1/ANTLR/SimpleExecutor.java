import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.*;
import java.nio.file.*;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class SimpleExecutor {
    
    private static Map<String, Object> variables = new HashMap<>();

    //Memory Management Erweiterungen
    private static List<WeakReference<Object>> allocatedObjects = new ArrayList<>();
    private static long totalMemoryUsed = 0;
    private static final long MEMORY_LIMIT = 100 * 1024 * 1024; // 100MB Limit
    
    //Memory Statistics
    private static class MemoryStats {
        long totalAllocated;
        int activeVariables;
        int garbageCollected;
    }
    
    private static MemoryStats memoryStats = new MemoryStats();
    
    //Start
    public static void main(String[] args) throws Exception {
        String code = readFile("test.simple");
        execute(code);
    }
    
    private static String readFile(String filename) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filename));
        return String.join("\n", lines);
    }
    
    public static void execute(String code) throws Exception {
        //Reset Memory Stats
        memoryStats = new MemoryStats();
    
        System.out.println("Ausführbarer Code:\n" + code);
        System.out.println("\n=== START AUSFÜHRUNG ===");
    
        SimpleLexer lexer = new SimpleLexer(CharStreams.fromString(code));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
    
        //DEBUG: Zeige Tokens
        tokens.fill();
        System.out.println("=== TOKENS ===");
        for (Token token : tokens.getTokens()) {
            if (token.getType() != Token.EOF) {
                System.out.println(token.toString() + " -> " + lexer.getVocabulary().getDisplayName(token.getType()));
            }
        }
    
        SimpleParser parser = new SimpleParser(tokens);
    
        try {
            ParseTree tree = parser.program();
            System.out.println("=== PARSE TREE ===");
            System.out.println(tree.toStringTree(parser));
        
            processTree(tree);
        
        } catch (Exception e) {
            System.out.println("PARSER FEHLER: " + e.getMessage());
        }
    
        //Final Memory Report
        showFinalMemoryReport();
    
        System.out.println("\n=== AUSGABE ===");
        variables.forEach((name, value) -> System.out.println(name + " = " + value));
    }
    
    //der ganze Parse-Tree
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
        else if (tree instanceof SimpleParser.WhileStmtContext) {
            processWhileLoop((SimpleParser.WhileStmtContext) tree);
        }
        else if (tree instanceof SimpleParser.UntilStmtContext) {
            processUntilLoop((SimpleParser.UntilStmtContext) tree);
        }
        else if (tree instanceof SimpleParser.DoWhileStmtContext) {
            processDoWhileLoop((SimpleParser.DoWhileStmtContext) tree);
        }
        else if (tree instanceof SimpleParser.AsLongStmtContext) {
            processAsLongLoop((SimpleParser.AsLongStmtContext) tree);
        }
        else if (tree instanceof SimpleParser.RepeatAsLongStmtContext) {
            processRepeatAsLongLoop((SimpleParser.RepeatAsLongStmtContext) tree);
        }
        else if (tree instanceof SimpleParser.RepeatUntilStmtContext) {
            processRepeatUntilLoop((SimpleParser.RepeatUntilStmtContext) tree);
        }
        else if (tree instanceof SimpleParser.DoAsLongStmtContext) {
            processDoAsLongLoop((SimpleParser.DoAsLongStmtContext) tree);
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
        // --- Dateimethoden ---
        else if (tree instanceof SimpleParser.WriteFileStmtContext) {
            processWriteFileStmt((SimpleParser.WriteFileStmtContext) tree);
        }
        else if (tree instanceof SimpleParser.ReadFileStmtContext) {
            processReadFileStmt((SimpleParser.ReadFileStmtContext) tree);
        }
        else if (tree instanceof SimpleParser.DeleteFileStmtContext) {
            processDeleteFileStmt((SimpleParser.DeleteFileStmtContext) tree);
        }
        else if (tree instanceof SimpleParser.IsNullStmtContext) {
            processIsNullStmt((SimpleParser.IsNullStmtContext) tree);
        }
        else if (tree instanceof SimpleParser.ExistsStmtContext) {
            processExistsStmt((SimpleParser.ExistsStmtContext) tree);
        }
        else if (tree instanceof SimpleParser.SleepStmtContext) {
            processSleepStmt((SimpleParser.SleepStmtContext) tree);
        }
        else if (tree instanceof SimpleParser.CreateFolderStmtContext) {
            processCreateFolderStmt((SimpleParser.CreateFolderStmtContext) tree);
        }
        else if (tree instanceof SimpleParser.DeleteFolderStmtContext) {
            processDeleteFolderStmt((SimpleParser.DeleteFolderStmtContext) tree);
        }
        else if (tree instanceof SimpleParser.OpenFileStmtContext) {
            processOpenFileStmt((SimpleParser.OpenFileStmtContext) tree);
        }
        // --- Mathematische Funktionen ---
        else if (tree instanceof SimpleParser.MinListFunctionStmtContext) {
            processMinListFunctionStmt((SimpleParser.MinListFunctionStmtContext) tree);
        }
        else if (tree instanceof SimpleParser.AbsFunctionStmtContext) {
            processAbsFunctionStmt((SimpleParser.AbsFunctionStmtContext) tree);
        }
        else if (tree instanceof SimpleParser.SqrtFunctionStmtContext) {
            processSqrtFunctionStmt((SimpleParser.SqrtFunctionStmtContext) tree);
        }
        else if (tree instanceof SimpleParser.RoundFunctionStmtContext) {
            processRoundFunctionStmt((SimpleParser.RoundFunctionStmtContext) tree);
        }
        else if (tree instanceof SimpleParser.RandomFunctionStmtContext) {
            processRandomFunctionStmt((SimpleParser.RandomFunctionStmtContext) tree);
        }
        else if (tree instanceof SimpleParser.MeanFunctionStmtContext) {
            processMeanFunctionStmt((SimpleParser.MeanFunctionStmtContext) tree);
        }
        else if (tree instanceof SimpleParser.MedianFunctionStmtContext) {
            processMedianFunctionStmt((SimpleParser.MedianFunctionStmtContext) tree);
        }
        else if (tree instanceof SimpleParser.MaxFunctionStmtContext) {
            processMaxFunctionStmt((SimpleParser.MaxFunctionStmtContext) tree);
        }
        else if (tree instanceof SimpleParser.MaxFromListStmtContext) {
            processMaxListFunctionStmt((SimpleParser.MaxFromListStmtContext) tree);
        }
        // --- String-Funktionen ---
        else if (tree instanceof SimpleParser.ToLowerFunctionStmtContext){
            processToLowerFunctionStmt((SimpleParser.ToLowerFunctionStmtContext) tree);
        }
        else if (tree instanceof SimpleParser.ToUpperFunctionStmtContext){
            processToUpperFunctionStmt((SimpleParser.ToUpperFunctionStmtContext) tree);
        }
        else if (tree instanceof SimpleParser.TrimFunctionStmtContext){
            processTrimFunctionStmt((SimpleParser.TrimFunctionStmtContext) tree);
        }
        else if (tree instanceof SimpleParser.TrimStartFunctionStmtContext) {
            processTrimStartFunctionStmt((SimpleParser.TrimStartFunctionStmtContext) tree);
        }
        else if (tree instanceof SimpleParser.TrimEndFunctionStmtContext) {
            processTrimEndFunctionStmt((SimpleParser.TrimEndFunctionStmtContext) tree);
        }
        else if (tree instanceof SimpleParser.ReplaceFunctionStmtContext){
            processReplaceFunctionStmt((SimpleParser.ReplaceFunctionStmtContext) tree);
        }
        else if (tree instanceof SimpleParser.SplitFunctionStmtContext){
            processSplitFunctionStmt((SimpleParser.SplitFunctionStmtContext) tree);
        }
        else if (tree instanceof SimpleParser.RightFunctionStmtContext) {
            processRightFunctionStmt((SimpleParser.RightFunctionStmtContext) tree);
        }
        else if (tree instanceof SimpleParser.LeftFunctionStmtContext){
            processLeftFunctionStmt((SimpleParser.LeftFunctionStmtContext) tree);
        }
        else if (tree instanceof SimpleParser.LeftRangeFunctionStmtContext){
            processLeftRangeFunctionStmt((SimpleParser.LeftRangeFunctionStmtContext) tree);
        }
        else if (tree instanceof SimpleParser.ConcatFunctionStmtContext){
            processConcatFunctionStmt((SimpleParser.ConcatFunctionStmtContext) tree);
        }
        else if (tree instanceof SimpleParser.ContainsFunctionStmtContext){
            processContainsFunctionStmt((SimpleParser.ContainsFunctionStmtContext) tree);
        }
        else if (tree instanceof TerminalNode){
            return;
        }
        // ---Bedingungen---
        else if (tree instanceof SimpleParser.IfStmtContext) {
            processIfStmt((SimpleParser.IfStmtContext) tree);
        }
        else if (tree instanceof SimpleParser.SwitchStmtContext) {
            processSwitchStmt((SimpleParser.SwitchStmtContext) tree);
        }
    }

    private static void updateVariable(String name, Object value) {
        trackMemoryBeforeAssignment(name, value);
        variables.put(name, value);
        trackMemoryAfterAssignment(name, value);
        printMemoryStats();
    }

    private static Object resolve(ParseTree node) {
        if (node == null) return null;

        // wenn es ein komplexer Ausdruck ist (z.B. a + 5)
        if (node instanceof SimpleParser.ExpressionContext) {
            return evaluateExpression((SimpleParser.ExpressionContext) node);
        }
        if (node instanceof SimpleParser.ExprContext) {
            return evaluateSimpleExpr((SimpleParser.ExprContext) node);
        }

        String text = node.getText();

        // Anführungszeichen für Strings entfernen
        if (text.startsWith("\"") && text.endsWith("\"") || text.startsWith("'") && text.endsWith("'")) {
            return text.substring(1, text.length() - 1);
        }

        // in der Variablen-Map nachsehen
        if (variables.containsKey(text)) {
            return variables.get(text);
        }

        //als Zahl versuchen
        try {
            return Double.parseDouble(text);
        } catch (NumberFormatException e) {
            // 5. Als Boolean versuchen
            if (text.equalsIgnoreCase("true")) return true;
            if (text.equalsIgnoreCase("false")) return false;
            if (text.equalsIgnoreCase("null")) return null;
            
            return text; // Fallback
        }
    }
    
    private static void processAssignment(SimpleParser.AssignmentContext assign) {
        String varName = assign.IDENTIFIER().getText();
        Object value = evaluateExpression(assign.expression());
    
        //Track Memory vor der Zuweisung
        trackMemoryBeforeAssignment(varName, value);
    
        variables.put(varName, value);
    
        //Track Memory nach der Zuweisung
        trackMemoryAfterAssignment(varName, value);
    
        System.out.println("Variable gesetzt: " + varName + " = " + value);
        printMemoryStats();
    }

    private static void trackMemoryBeforeAssignment(String varName, Object newValue) {
        //Wenn Variable bereits existiert, berechne alten Speicher
        if (variables.containsKey(varName)) {
            Object oldValue = variables.get(varName);
            long oldSize = estimateMemoryUsage(oldValue);
            memoryStats.totalAllocated -= oldSize;
        }
    }

    private static void trackMemoryAfterAssignment(String varName, Object newValue) {
        long newSize = estimateMemoryUsage(newValue);
        memoryStats.totalAllocated += newSize;
    
        //Prüfe Memory-Limit
        if (memoryStats.totalAllocated > MEMORY_LIMIT) {
            System.out.println("WARNUNG: Memory Limit erreicht! Starte Garbage Collection...");
            performGarbageCollection();
        }
    
        //Track allocated object
        allocatedObjects.add(new WeakReference<>(newValue));
    }

    private static long estimateMemoryUsage(Object obj) {
        if (obj == null) return 0;
    
        if (obj instanceof String) {
            //String: Object overhead + char array
            return 24 + ((String) obj).length() * 2L;
        }
        else if (obj instanceof Number) {
            //Double: 8 bytes + object overhead
            return 16;
        }
        else if (obj instanceof Character) {
            //Character: 2 bytes + object overhead  
            return 16;
        }
        else if (obj instanceof Boolean) {
            //Boolean: 1 byte + object overhead
            return 16;
        }
    
        //Default estimation
        return 16;
    }

    private static void performGarbageCollection() {
        System.out.println("Führe Garbage Collection aus...");
    
        int collectedBefore = memoryStats.garbageCollected;
    
        //Entferne null WeakReferences (vom GC collected)
        allocatedObjects.removeIf(ref -> ref.get() == null);
    
        //Manuelle "GC" für nicht mehr referenzierte Variablen
        Iterator<Map.Entry<String, Object>> iterator = variables.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> entry = iterator.next();
            if (!isVariableReferenced(entry.getKey())) {
                System.out.println("🗑️  Collecting unused variable: " + entry.getKey());
                long freedMemory = estimateMemoryUsage(entry.getValue());
                memoryStats.totalAllocated -= freedMemory;
                memoryStats.garbageCollected++;
                iterator.remove();
            }
        }
    
        int collected = memoryStats.garbageCollected - collectedBefore;
        if (collected > 0) {
            System.out.println(collected + " ungenutzte Variablen freigegeben");
        }
    }

    private static boolean isVariableReferenced(String varName) {
        //Einfache Referenz-Prüfung: Variable wird referenziert wenn sie in anderen Expressions vorkommt
        //In einer echten Implementierung würdest du den AST analysieren
        return true; //Vereinfacht für jetzt
    }

    private static void printMemoryStats() {
        memoryStats.activeVariables = variables.size();
    
        System.out.println("MEMORY STATS: " +
            "Aktive Variablen: " + memoryStats.activeVariables + ", " +
            "Allokiert: " + (memoryStats.totalAllocated / 1024) + "KB, " +
            "GC'd: " + memoryStats.garbageCollected);
    }

    public static void showFinalMemoryReport() {
        System.out.println("FINAL MEMORY REPORT:");
        System.out.println("=======================");
        System.out.println("Aktive Variablen: " + memoryStats.activeVariables);
        System.out.println("Total allokiert: " + (memoryStats.totalAllocated / 1024) + " KB");
        System.out.println("Garbage collected: " + memoryStats.garbageCollected + " Variablen");
        System.out.println("Memory Limit: " + (MEMORY_LIMIT / 1024 / 1024) + " MB");
    
        // Zeige alle aktiven Variablen
        System.out.println("\nAktive Variablen:");
        variables.forEach((name, value) -> {
            long size = estimateMemoryUsage(value);
            System.out.println("  " + name + " = " + value + " (" + size + " bytes)");
        });
    }
    
    private static void processFunctionCall(SimpleParser.FunctionCallContext func) {
        // Holt den Namen entweder vom IDENTIFIER oder vom PRINT Token
        String funcName = "";
        if (func.IDENTIFIER() != null) {
            funcName = func.IDENTIFIER().getText();
        } else if (func.PRINT() != null) {
            funcName = func.PRINT().getText();
        }

        if ("print".equals(funcName) && func.expression() != null) {
            Object value = evaluateExpression(func.expression());
            System.out.println("Ausgabe: " + value);
        }
    }
    
    //---Schleifen---
    
    // FOR-Schleife
    private static void processForLoop(SimpleParser.ForStmtContext ctx) {
        String loopVar = ctx.IDENTIFIER().getText();
        
        // Extrahiere Start und Ende
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
        
        int start = 1;
        int end = 1;
        
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
            System.out.println("Fehler beim Auswerten der Schleifenparameter: " + e.getMessage());
        }
        
        System.out.println("FOR-Schleife: " + loopVar + " von " + start + " bis " + end);
        
        // Gehe durch alle Children und verarbeite die Lines
        for (int i = start; i <= end; i++) {
            variables.put(loopVar, (double) i);
            System.out.println("FOR: " + loopVar + " = " + i);
            
            // Verarbeite alle Children des ForStmtContext
            for (int j = 0; j < ctx.getChildCount(); j++) {
                ParseTree child = ctx.getChild(j);
                // Überspringe die Schleifenparameter (IDENTIFIER, 'from', expr, 'to', expr)
                if (!(child instanceof TerminalNode) && 
                    !(child instanceof SimpleParser.ExprContext) &&
                    !child.getText().equals(loopVar)) {
                    processTree(child);
                }
            }
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
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            if (child instanceof SimpleParser.BlockContext) {
                return (SimpleParser.BlockContext) child;
            }
        }
        return null;
    }
    
    // REPEAT-Schleife
    private static void processRepeatLoop(SimpleParser.RepeatStmtContext ctx) {
        int times = 1; // Default
        
        // Finde das expr für die Wiederholungen
        SimpleParser.ExprContext timesExpr = null;
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            if (child instanceof SimpleParser.ExprContext) {
                timesExpr = (SimpleParser.ExprContext) child;
                break;
            }
        }
        
        if (timesExpr != null) {
            try {
                Object timesObj = evaluateSimpleExpr(timesExpr);
                if (timesObj instanceof Number) {
                    times = ((Number) timesObj).intValue();
                    System.out.println("REPEAT: " + times + " mal");
                }
            } catch (Exception e) {
                System.out.println("Kann Wiederholungszahl nicht auswerten: " + e.getMessage());
                times = 1;
            }
        }
        
        // Verarbeite den Inhalt der Schleife
        for (int i = 1; i <= times; i++) {
            System.out.println("REPEAT: Iteration " + i + "/" + times);
            
            // Verarbeite alle Children des RepeatStmtContext
            for (int j = 0; j < ctx.getChildCount(); j++) {
                ParseTree child = ctx.getChild(j);
                // Überspringe das 'repeat', expr, 'times'
                if (!(child instanceof TerminalNode) && 
                    !(child instanceof SimpleParser.ExprContext) &&
                    !child.getText().equals("repeat") &&
                    !child.getText().equals("times")) {
                    processTree(child);
                }
            }
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
        SimpleParser.ExprContext startExpr = ctx.expr(0);
        SimpleParser.ExprContext endExpr = ctx.expr(1);

        String loopVarName = null;
        if (startExpr.IDENTIFIER() != null) {
            loopVarName = startExpr.IDENTIFIER().getText();
        }

        Object startObj = resolve(startExpr);
        Object endObj = resolve(endExpr);

        if (!(startObj instanceof Number && endObj instanceof Number)) {
            throw new RuntimeException("Loop-Parameter müssen numerisch sein.");
        }

        int start = ((Number) startObj).intValue();
        int end = ((Number) endObj).intValue();

        System.out.println("LOOP: von " + start + " bis " + end + 
                        (loopVarName != null ? " (Variable: " + loopVarName + ")" : ""));

        double currentCounter = start;
        while (currentCounter <= end) {
            if (loopVarName != null) {
                variables.put(loopVarName, currentCounter);
            }

            for (int i = 0; i < ctx.getChildCount(); i++) {
                ParseTree child = ctx.getChild(i);
                if (!(child instanceof TerminalNode) && !(child instanceof SimpleParser.ExprContext)) {
                    processTree(child);
                }
            }
            
            currentCounter++;
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

    // WHILE-Schleife
    private static void processWhileLoop(SimpleParser.WhileStmtContext ctx) {
        System.out.println("=== WHILE SCHLEIFE GESTARTET ===");
        
        // Extrahiere die Bedingungskomponenten
        SimpleParser.ExprContext leftExpr = null;
        SimpleParser.CompareOpContext compareOp = null;
        SimpleParser.ExprContext rightExpr = null;
        
        // Durch Children suchen
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            if (child instanceof SimpleParser.ExprContext) {
                if (leftExpr == null) {
                    leftExpr = (SimpleParser.ExprContext) child;
                } else if (rightExpr == null) {
                    rightExpr = (SimpleParser.ExprContext) child;
                }
            } else if (child instanceof SimpleParser.CompareOpContext) {
                compareOp = (SimpleParser.CompareOpContext) child;
            }
        }
        
        if (leftExpr == null || compareOp == null || rightExpr == null) {
            System.out.println("FEHLER: Unvollständige WHILE-Bedingung!");
            return;
        }
        
        int iteration = 0;
        final int MAX_ITERATIONS = 1000;
        
        // Solange die Bedingung wahr ist
        while (evaluateWhileCondition(leftExpr, compareOp, rightExpr)) {
            iteration++;
            System.out.println("WHILE: Iteration " + iteration);
            
            // Verarbeite den Block-Inhalt
            for (int i = 0; i < ctx.getChildCount(); i++) {
                ParseTree child = ctx.getChild(i);
                if (child instanceof SimpleParser.LineContext) {
                    processTree(child);
                } else if (child instanceof SimpleParser.BlockContext) {
                    processTree(child);
                }
            }
            
            // Schutz gegen Endlosschleifen
            if (iteration >= MAX_ITERATIONS) {
                System.out.println("WARNUNG: WHILE nach " + MAX_ITERATIONS + " Iterationen abgebrochen!");
                break;
            }
        }
        
        System.out.println("WHILE-Schleife beendet nach " + iteration + " Iterationen");
    }

    // Verarbeite ALLE Lines im WHILE-Block
    private static void processAllLinesInWhile(SimpleParser.WhileStmtContext ctx) {
        // Suche den BlockContext
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            if (child instanceof SimpleParser.BlockContext) {
                SimpleParser.BlockContext block = (SimpleParser.BlockContext) child;
                System.out.println("Block gefunden mit " + block.getChildCount() + " Children");
                
                // Verarbeite alle Lines im Block
                for (int j = 0; j < block.getChildCount(); j++) {
                    ParseTree blockChild = block.getChild(j);
                    if (blockChild instanceof SimpleParser.LineContext) {
                        System.out.println("  -> Verarbeite Line: " + blockChild.getText());
                        processTree(blockChild);
                    }
                }
                return;
            }
        }
        
        System.out.println("KEIN BLOCK GEFUNDEN!");
    }

    private static SimpleParser.LineContext findLineInWhile(SimpleParser.WhileStmtContext ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            if (child instanceof SimpleParser.LineContext) {
                return (SimpleParser.LineContext) child;
            }
        }
        return null;
    }

    // UNTIL-Schleife
    private static void processUntilLoop(SimpleParser.UntilStmtContext ctx) {
        System.out.println("=== UNTIL SCHLEIFE GESTARTET ===");
        
        // Extrahiere die Bedingungskomponenten
        SimpleParser.ExprContext leftExpr = null;
        SimpleParser.CompareOpContext compareOp = null;
        SimpleParser.ExprContext rightExpr = null;
        
        // Durch Children suchen
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            if (child instanceof SimpleParser.ExprContext) {
                if (leftExpr == null) {
                    leftExpr = (SimpleParser.ExprContext) child;
                } else if (rightExpr == null) {
                    rightExpr = (SimpleParser.ExprContext) child;
                }
            } else if (child instanceof SimpleParser.CompareOpContext) {
                compareOp = (SimpleParser.CompareOpContext) child;
            }
        }
        
        if (leftExpr == null || compareOp == null || rightExpr == null) {
            System.out.println("FEHLER: Unvollständige UNTIL-Bedingung!");
            return;
        }
        
        int iteration = 0;
        final int MAX_ITERATIONS = 1000;
        
        // Solange die Bedingung FALSCH ist (until = bis die Bedingung wahr wird)
        while (!evaluateWhileCondition(leftExpr, compareOp, rightExpr)) {
            iteration++;
            System.out.println("UNTIL: Iteration " + iteration);
            
            // Verarbeite den Block-Inhalt
            for (int i = 0; i < ctx.getChildCount(); i++) {
                ParseTree child = ctx.getChild(i);
                if (child instanceof SimpleParser.LineContext) {
                    processTree(child);
                } else if (child instanceof SimpleParser.BlockContext) {
                    processTree(child);
                }
            }
            
            // Schutz gegen Endlosschleifen
            if (iteration >= MAX_ITERATIONS) {
                System.out.println("WARNUNG: UNTIL nach " + MAX_ITERATIONS + " Iterationen abgebrochen!");
                break;
            }
        }
        
        System.out.println("UNTIL-Schleife beendet nach " + iteration + " Iterationen");
    }

    private static SimpleParser.LineContext findLineInUntil(SimpleParser.UntilStmtContext ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            if (child instanceof SimpleParser.LineContext) {
                return (SimpleParser.LineContext) child;
            }
        }
        return null;
    }

    // Bedingung für while/until auswerten
    private static boolean evaluateWhileCondition(SimpleParser.ExprContext left, 
                                              SimpleParser.CompareOpContext op, 
                                              SimpleParser.ExprContext right) {
        try {
            Object leftVal = evaluateSimpleExpr(left);
            Object rightVal = evaluateSimpleExpr(right);
            String operator = op.getText();
            
            System.out.println("Bedingung prüfen: " + leftVal + " " + operator + " " + rightVal);
            
            // Für Zahlen
            if (leftVal instanceof Number && rightVal instanceof Number) {
                double l = ((Number) leftVal).doubleValue();
                double r = ((Number) rightVal).doubleValue();
                
                switch (operator) {
                    case "==": return Math.abs(l - r) < 0.000001; // Fließkomma-Vergleich
                    case "!=": return Math.abs(l - r) > 0.000001;
                    case "<": return l < r;
                    case "<=": return l <= r;
                    case ">": return l > r;
                    case ">=": return l >= r;
                    default: 
                        System.out.println("Unbekannter Vergleichsoperator: " + operator);
                        return false;
                }
            }
            
            // Für Strings
            if (leftVal instanceof String && rightVal instanceof String) {
                String l = (String) leftVal;
                String r = (String) rightVal;
                
                switch (operator) {
                    case "==": return l.equals(r);
                    case "!=": return !l.equals(r);
                    default: 
                        System.out.println("String-Vergleich nur mit == und != möglich: " + operator);
                        return false;
                }
            }
            
            // Für Booleans
            if (leftVal instanceof Boolean && rightVal instanceof Boolean) {
                boolean l = (Boolean) leftVal;
                boolean r = (Boolean) rightVal;
                
                switch (operator) {
                    case "==": return l == r;
                    case "!=": return l != r;
                    default: 
                        System.out.println("Boolean-Vergleich nur mit == und != möglich: " + operator);
                        return false;
                }
            }
            
            System.out.println("Inkompatible Typen für Vergleich: " + leftVal + " und " + rightVal);
            return false;
            
        } catch (Exception e) {
            System.out.println("Fehler beim Auswerten der Bedingung: " + e.getMessage());
            return false;
        }
    }

    // DO-WHILE-Schleife
    private static void processDoWhileLoop(SimpleParser.DoWhileStmtContext ctx) {
        System.out.println("=== DO-WHILE SCHLEIFE GESTARTET ===");
        
        // Extrahiere die Bedingungskomponenten
        SimpleParser.ExprContext leftExpr = null;
        SimpleParser.CustomCompOpContext customOp = null;
        SimpleParser.ExprContext rightExpr = null;
        
        // Suche nach den Bedingungskomponenten
        List<SimpleParser.ExprContext> exprs = new ArrayList<>();
        
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            if (child instanceof SimpleParser.ExprContext) {
                exprs.add((SimpleParser.ExprContext) child);
            } else if (child instanceof SimpleParser.CustomCompOpContext) {
                customOp = (SimpleParser.CustomCompOpContext) child;
            }
        }
        
        if (exprs.size() >= 2 && customOp != null) {
            leftExpr = exprs.get(0);
            rightExpr = exprs.get(1);
        } else {
            System.out.println("FEHLER: Unvollständige DO-WHILE-Bedingung!");
            return;
        }
        
        int iteration = 0;
        final int MAX_ITERATIONS = 1000;
        
        do {
            iteration++;
            System.out.println("DO-WHILE: Iteration " + iteration);
            
            // Verarbeite den Block-Inhalt (mindestens einmal)
            for (int i = 0; i < ctx.getChildCount(); i++) {
                ParseTree child = ctx.getChild(i);
                if (child instanceof SimpleParser.LineContext) {
                    processTree(child);
                } else if (child instanceof SimpleParser.BlockContext) {
                    processTree(child);
                }
            }
            
            // Bedingung prüfen (NACH der Ausführung)
            boolean conditionTrue = evaluateCustomCondition(leftExpr, customOp, rightExpr);
            System.out.println("DO-WHILE Bedingung nach Iteration " + iteration + ": " + conditionTrue);
            
            if (iteration >= MAX_ITERATIONS) {
                System.out.println("WARNUNG: DO-WHILE nach " + MAX_ITERATIONS + " Iterationen abgebrochen!");
                break;
            }
            
        } while (evaluateCustomCondition(leftExpr, customOp, rightExpr));
        
        System.out.println("DO-WHILE-Schleife beendet nach " + iteration + " Iterationen");
    }

    private static SimpleParser.LineContext findLineInDoWhile(SimpleParser.DoWhileStmtContext ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            if (child instanceof SimpleParser.LineContext) {
                return (SimpleParser.LineContext) child;
            }
        }
        return null;
    }

    // Custom Condition für asLong/doWhile etc.
    private static boolean evaluateCustomCondition(SimpleParser.ExprContext left, 
                                                SimpleParser.CustomCompOpContext op, 
                                                SimpleParser.ExprContext right) {
        try {
            Object leftVal = evaluateSimpleExpr(left);
            Object rightVal = evaluateSimpleExpr(right);
            String operator = op.getText();

            System.out.println("Custom Bedingung prüfen: " + leftVal + " " + operator + " " + rightVal);

            // Für Zahlen
            if (leftVal instanceof Number && rightVal instanceof Number) {
                double l = ((Number) leftVal).doubleValue();
                double r = ((Number) rightVal).doubleValue();

                switch (operator) {
                    case ">":
                    case "isBigger":
                    case "isBiggerThan": return l > r;
                    case "<":
                    case "isSmaller":
                    case "isSmallerThan": return l < r;
                    case "==":
                    case "isEqual": return Math.abs(l - r) < 0.000001;
                    case "!=":
                    case "isNotEqual":
                    case "isNotEqualThan": return Math.abs(l - r) > 0.000001;
                    case ">=": return l >= r;
                    case "<=": return l <= r;
                }
            }

            // Für Strings
            if (leftVal instanceof String && rightVal instanceof String) {
                String l = (String) leftVal;
                String r = (String) rightVal;

                switch (operator) {
                    case "==":
                    case "isEqual": return l.equals(r);
                    case "!=":
                    case "isNotEqual": return !l.equals(r);
                    case "isBigger": return l.compareTo(r) > 0;
                    case "isSmaller": return l.compareTo(r) < 0;
                }
            }

            // Für Booleans
            if (leftVal instanceof Boolean && rightVal instanceof Boolean) {
                boolean l = (Boolean) leftVal;
                boolean r = (Boolean) rightVal;

                switch (operator) {
                    case "==":
                    case "isEqual": return l == r;
                    case "!=":
                    case "isNotEqual": return l != r;
                }
            }

            System.out.println("Unbekannter oder inkompatibler Custom-Operator: " + operator);
            return false;

        } catch (Exception e) {
            System.out.println("Fehler beim Auswerten der Custom-Bedingung: " + e.getMessage());
            return false;
        }
    }

    // AS-LONG-Schleife { ... }
    private static void processAsLongLoop(SimpleParser.AsLongStmtContext ctx) {
        System.out.println("=== AS-LONG SCHLEIFE GESTARTET ===");
        
        // Extrahiere die Bedingungskomponenten
        SimpleParser.ExprContext leftExpr = null;
        SimpleParser.CustomCompOpContext customOp = null;
        SimpleParser.ExprContext rightExpr = null;
        
        // Suche nach den Bedingungskomponenten
        List<SimpleParser.ExprContext> exprs = new ArrayList<>();
        
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            if (child instanceof SimpleParser.ExprContext) {
                exprs.add((SimpleParser.ExprContext) child);
            } else if (child instanceof SimpleParser.CustomCompOpContext) {
                customOp = (SimpleParser.CustomCompOpContext) child;
            }
        }
        
        if (exprs.size() >= 2 && customOp != null) {
            leftExpr = exprs.get(0);
            rightExpr = exprs.get(1);
        } else {
            System.out.println("FEHLER: Unvollständige AS-LONG-Bedingung!");
            // Debug-Ausgabe
            System.out.println("DEBUG: Children von AsLongStmt:");
            for (int i = 0; i < ctx.getChildCount(); i++) {
                ParseTree child = ctx.getChild(i);
                System.out.println("  [" + i + "] " + child.getClass().getSimpleName() + ": '" + child.getText() + "'");
            }
            return;
        }
        
        int iteration = 0;
        final int MAX_ITERATIONS = 1000;
        
        // Solange die Bedingung wahr ist
        while (evaluateCustomCondition(leftExpr, customOp, rightExpr)) {
            iteration++;
            System.out.println("AS-LONG: Iteration " + iteration);
            
            // Verarbeite den Block-Inhalt
            for (int i = 0; i < ctx.getChildCount(); i++) {
                ParseTree child = ctx.getChild(i);
                if (child instanceof SimpleParser.LineContext) {
                    processTree(child);
                } else if (child instanceof SimpleParser.BlockContext) {
                    processTree(child);
                }
            }
            
            // Schutz gegen Endlosschleifen
            if (iteration >= MAX_ITERATIONS) {
                System.out.println("WARNUNG: AS-LONG nach " + MAX_ITERATIONS + " Iterationen abgebrochen!");
                break;
            }
        }
        
        System.out.println("AS-LONG-Schleife beendet nach " + iteration + " Iterationen");
    }

    private static SimpleParser.LineContext findLineInAsLong(SimpleParser.AsLongStmtContext ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            if (child instanceof SimpleParser.LineContext) {
                return (SimpleParser.LineContext) child;
            }
        }
        return null;
    }

    // REPEAT-AS-LONG-Schleife
    private static void processRepeatAsLongLoop(SimpleParser.RepeatAsLongStmtContext ctx) {
        System.out.println("=== REPEAT-AS-LONG SCHLEIFE GESTARTET ===");
        
        // Extrahiere die Bedingungskomponenten
        SimpleParser.ExprContext leftExpr = null;
        SimpleParser.CustomCompOpContext customOp = null;
        SimpleParser.ExprContext rightExpr = null;
        
        // Suche nach den Bedingungskomponenten
        List<SimpleParser.ExprContext> exprs = new ArrayList<>();
        
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            if (child instanceof SimpleParser.ExprContext) {
                exprs.add((SimpleParser.ExprContext) child);
            } else if (child instanceof SimpleParser.CustomCompOpContext) {
                customOp = (SimpleParser.CustomCompOpContext) child;
            }
        }
        
        if (exprs.size() >= 2 && customOp != null) {
            leftExpr = exprs.get(0);
            rightExpr = exprs.get(1);
        } else {
            System.out.println("FEHLER: Unvollständige REPEAT-AS-LONG-Bedingung!");
            return;
        }
        
        int iteration = 0;
        final int MAX_ITERATIONS = 1000;
        
        do {
            iteration++;
            System.out.println("REPEAT-AS-LONG: Iteration " + iteration);
            
            // Block ausführen (mindestens einmal)
            boolean blockExecuted = false;
            for (int i = 0; i < ctx.getChildCount(); i++) {
                ParseTree child = ctx.getChild(i);
                if (child instanceof SimpleParser.BlockContext) {
                    processTree(child);
                    blockExecuted = true;
                    break;
                } else if (child instanceof SimpleParser.LineContext) {
                    processTree(child);
                    blockExecuted = true;
                }
            }
            
            if (!blockExecuted) {
                System.out.println("WARNUNG: Kein Block in REPEAT-AS-LONG-Schleife gefunden!");
            }
            
            // Bedingung prüfen (NACH der Ausführung)
            boolean conditionTrue = evaluateCustomCondition(leftExpr, customOp, rightExpr);
            System.out.println("REPEAT-AS-LONG Bedingung nach Iteration " + iteration + ": " + conditionTrue);
            
            if (iteration >= MAX_ITERATIONS) {
                System.out.println("WARNUNG: REPEAT-AS-LONG nach " + MAX_ITERATIONS + " Iterationen abgebrochen!");
                break;
            }
            
        } while (evaluateCustomCondition(leftExpr, customOp, rightExpr));
        
        System.out.println("REPEAT-AS-LONG-Schleife beendet nach " + iteration + " Iterationen");
    }

    private static SimpleParser.LineContext findLineInRepeatAsLong(SimpleParser.RepeatAsLongStmtContext ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            if (child instanceof SimpleParser.LineContext) {
                return (SimpleParser.LineContext) child;
            }
        }
        return null;
    }

    // REPEAT-UNTIL-Schleife
    private static void processRepeatUntilLoop(SimpleParser.RepeatUntilStmtContext ctx) {
        System.out.println("=== REPEAT-UNTIL SCHLEIFE GESTARTET ===");
        
        // Extrahiere die Bedingungskomponenten
        SimpleParser.ExprContext leftExpr = null;
        SimpleParser.CustomCompOpContext customOp = null;
        SimpleParser.ExprContext rightExpr = null;
        
        // Suche nach den Bedingungskomponenten
        List<SimpleParser.ExprContext> exprs = new ArrayList<>();
        
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            if (child instanceof SimpleParser.ExprContext) {
                exprs.add((SimpleParser.ExprContext) child);
            } else if (child instanceof SimpleParser.CustomCompOpContext) {
                customOp = (SimpleParser.CustomCompOpContext) child;
            }
        }
        
        if (exprs.size() >= 2 && customOp != null) {
            leftExpr = exprs.get(0);
            rightExpr = exprs.get(1);
        } else {
            System.out.println("FEHLER: Unvollständige REPEAT-UNTIL-Bedingung!");
            return;
        }
        
        int iteration = 0;
        final int MAX_ITERATIONS = 1000;
        
        do {
            iteration++;
            System.out.println("REPEAT-UNTIL: Iteration " + iteration);
            
            // Block ausführen (mindestens einmal)
            boolean blockExecuted = false;
            for (int i = 0; i < ctx.getChildCount(); i++) {
                ParseTree child = ctx.getChild(i);
                if (child instanceof SimpleParser.BlockContext) {
                    processTree(child);
                    blockExecuted = true;
                    break;
                } else if (child instanceof SimpleParser.LineContext) {
                    processTree(child);
                    blockExecuted = true;
                }
            }
            
            if (!blockExecuted) {
                System.out.println("WARNUNG: Kein Block in REPEAT-UNTIL-Schleife gefunden!");
            }
            
            // Bedingung prüfen (until = solange NICHT die Bedingung wahr ist)
            boolean conditionTrue = evaluateCustomCondition(leftExpr, customOp, rightExpr);
            System.out.println("REPEAT-UNTIL Bedingung nach Iteration " + iteration + ": " + conditionTrue);
            
            if (iteration >= MAX_ITERATIONS) {
                System.out.println("WARNUNG: REPEAT-UNTIL nach " + MAX_ITERATIONS + " Iterationen abgebrochen!");
                break;
            }
            
        } while (!evaluateCustomCondition(leftExpr, customOp, rightExpr)); // until = solange NICHT
        
        System.out.println("REPEAT-UNTIL-Schleife beendet nach " + iteration + " Iterationen");
    }

    private static SimpleParser.LineContext findLineInRepeatUntil(SimpleParser.RepeatUntilStmtContext ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            if (child instanceof SimpleParser.LineContext) {
                return (SimpleParser.LineContext) child;
            }
        }
        return null;
    }

    // DO-AS-LONG-Schleife
    private static void processDoAsLongLoop(SimpleParser.DoAsLongStmtContext ctx) {
        System.out.println("=== DO-AS-LONG SCHLEIFE GESTARTET ===");
        
        // Extrahiere die Bedingungskomponenten
        SimpleParser.ExprContext leftExpr = null;
        SimpleParser.CustomCompOpContext customOp = null;
        SimpleParser.ExprContext rightExpr = null;
        
        // Suche nach den Bedingungskomponenten
        List<SimpleParser.ExprContext> exprs = new ArrayList<>();
        
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            if (child instanceof SimpleParser.ExprContext) {
                exprs.add((SimpleParser.ExprContext) child);
            } else if (child instanceof SimpleParser.CustomCompOpContext) {
                customOp = (SimpleParser.CustomCompOpContext) child;
            }
        }
        
        if (exprs.size() >= 2 && customOp != null) {
            leftExpr = exprs.get(0);
            rightExpr = exprs.get(1);
        } else {
            System.out.println("FEHLER: Unvollständige DO-AS-LONG-Bedingung!");
            return;
        }
        
        int iteration = 0;
        final int MAX_ITERATIONS = 1000;
        
        do {
            iteration++;
            System.out.println("DO-AS-LONG: Iteration " + iteration);
            
            // Block ausführen (mindestens einmal)
            boolean blockExecuted = false;
            for (int i = 0; i < ctx.getChildCount(); i++) {
                ParseTree child = ctx.getChild(i);
                if (child instanceof SimpleParser.BlockContext) {
                    processTree(child);
                    blockExecuted = true;
                    break;
                } else if (child instanceof SimpleParser.LineContext) {
                    processTree(child);
                    blockExecuted = true;
                }
            }
            
            if (!blockExecuted) {
                System.out.println("WARNUNG: Kein Block in DO-AS-LONG-Schleife gefunden!");
            }
            
            // Bedingung prüfen (NACH der Ausführung)
            boolean conditionTrue = evaluateCustomCondition(leftExpr, customOp, rightExpr);
            System.out.println("DO-AS-LONG Bedingung nach Iteration " + iteration + ": " + conditionTrue);
            
            if (iteration >= MAX_ITERATIONS) {
                System.out.println("WARNUNG: DO-AS-LONG nach " + MAX_ITERATIONS + " Iterationen abgebrochen!");
                break;
            }
            
        } while (evaluateCustomCondition(leftExpr, customOp, rightExpr));
        
        System.out.println("DO-AS-LONG-Schleife beendet nach " + iteration + " Iterationen");
    }

    private static SimpleParser.LineContext findLineInDoAsLong(SimpleParser.DoAsLongStmtContext ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            if (child instanceof SimpleParser.LineContext) {
                return (SimpleParser.LineContext) child;
            }
        }
        return null;
    }
    
    //---Ausdrücke / Expressions---
    
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
        if (expr.STRING() != null) {
            String text = expr.STRING().getText();
            // Entferne die Anführungszeichen
            if (text.length() >= 2) {
                return text.substring(1, text.length() - 1);
            }
            return text;
        }
        if (expr.getChildCount() == 3) { // expr OP expr
            Object left = evaluateSimpleExpr((SimpleParser.ExprContext) expr.getChild(0));
            Object right = evaluateSimpleExpr((SimpleParser.ExprContext) expr.getChild(2));
            String operator = expr.getChild(1).getText();
            
            if (left instanceof String || right instanceof String) {
                // String-Konkatenation
                if ("+".equals(operator)) {
                    return left.toString() + right.toString();
                }
                throw new RuntimeException("String-Operation nur mit + möglich: " + operator);
            }
            
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
                // Variable existiert nicht - für IsNull-Funktion wichtig
                return null;
            }
            return variables.get(varName);
        }
        else if (expr instanceof SimpleParser.ConstantExpressionContext) {
            SimpleParser.ConstantContext constant = ((SimpleParser.ConstantExpressionContext) expr).constant();
            
            if (constant.NUMBER() != null) {
                try {
                    return Double.parseDouble(constant.NUMBER().getText());
                } catch (NumberFormatException e) {
                    return 0.0;
                }
            }
            
            if (constant.STRING() != null) {
                String text = constant.STRING().getText();
                // Entferne die Anführungszeichen
                if (text.length() >= 2) {
                    text = text.substring(1, text.length() - 1);
                }
                // Ersetze Escape-Sequenzen
                text = text.replace("\\n", "\n")
                        .replace("\\t", "\t")
                        .replace("\\r", "\r")
                        .replace("\\\"", "\"")
                        .replace("\\'", "'")
                        .replace("\\\\", "\\");
                return text;
            }
            
            if (constant.CHARACTER() != null) {
                String text = constant.CHARACTER().getText();
                if (text.length() >= 3) {
                    char c = text.charAt(1);
                    if (c == '\\' && text.length() >= 4) {
                        // Escape-Sequenz
                        char esc = text.charAt(2);
                        switch (esc) {
                            case 'n': return '\n';
                            case 't': return '\t';
                            case 'r': return '\r';
                            case '"': return '"';
                            case '\'': return '\'';
                            case '\\': return '\\';
                        }
                    }
                    return c;
                }
                return ' ';
            }
            
            if (constant.NULL() != null) {
                return null;  // null zurückgeben
            }
            
            throw new RuntimeException("Unbekannter Constant-Typ");
        }
        else if (expr instanceof SimpleParser.AdditiveExpressionContext) {
            SimpleParser.AdditiveExpressionContext addExpr = (SimpleParser.AdditiveExpressionContext) expr;
            Object left = evaluateExpression(addExpr.expression(0));
            Object right = evaluateExpression(addExpr.expression(1));
            
            // Für String-Konkatenation
            if (left == null || right == null) {
                // null + etwas = etwas als String
                return (left == null ? "null" : left.toString()) + 
                    (right == null ? "null" : right.toString());
            }
            
            if (left instanceof String || right instanceof String) {
                return left.toString() + right.toString();
            } 
            // Für numerische Operationen
            else if (left instanceof Number && right instanceof Number) {
                double l = ((Number) left).doubleValue();
                double r = ((Number) right).doubleValue();
                if ("+".equals(addExpr.addOp().getText())) return l + r;
                if ("-".equals(addExpr.addOp().getText())) return l - r;
            }
            throw new RuntimeException("Inkompatible Typen für Addition: " + left + " und " + right);
        }
        else if (expr instanceof SimpleParser.MultiplicateExpressionContext) {
            SimpleParser.MultiplicateExpressionContext multExpr = (SimpleParser.MultiplicateExpressionContext) expr;
            Object left = evaluateExpression(multExpr.expression(0));
            Object right = evaluateExpression(multExpr.expression(1));
            
            if (left == null || right == null) {
                throw new RuntimeException("Null-Werte für Multiplikation/Division nicht erlaubt");
            }
            
            if (!(left instanceof Number && right instanceof Number)) {
                throw new RuntimeException("Multiplikation/Division benötigt Zahlen: " + left + " und " + right);
            }
            
            double l = ((Number) left).doubleValue();
            double r = ((Number) right).doubleValue();
            
            if ("*".equals(multExpr.multiOp().getText())) return l * r;
            if ("/".equals(multExpr.multiOp().getText())) {
                if (r == 0) throw new ArithmeticException("Division durch Null");
                return l / r;
            }
            throw new RuntimeException("Unbekannter Multiplikationsoperator");
        }
        else if (expr instanceof SimpleParser.ParenthesizedExpressionContext) {
            return evaluateExpression(((SimpleParser.ParenthesizedExpressionContext) expr).expression());
        }
        else if (expr instanceof SimpleParser.ObjectCreationExpressionContext) {
            String type = ((SimpleParser.ObjectCreationExpressionContext) expr).IDENTIFIER().getText();
            System.out.println("Objekt erstellt: " + type);
            return "new " + type + "()";
        }
        else if (expr instanceof SimpleParser.UnaryMinusExpressionContext unaryExpr){
            Object val = evaluateExpression(unaryExpr.expression());

            if (val instanceof Number){
                return -((Number) val).doubleValue();
            } else {
                throw new RuntimeException("Unäres Minus nur für Zahlen erlaubt: " + val);
            }
        }
        else if (expr instanceof SimpleParser.LengthAccessExpressionContext lengthExprCtx) {
    
            SimpleParser.LengthAccessExprContext lengthCtx = lengthExprCtx.lengthAccessExpr();

            String varName = lengthCtx.IDENTIFIER().getText();
            
            Object value = variables.get(varName);
            
            if (!(value instanceof String s)) {
                throw new RuntimeException("Length-Zugriff nur für Strings erlaubt, gefunden: " + value.getClass().getSimpleName());
            }
            
            double length = (double) s.length();
            
            System.out.println("LENGTHACCESS: " + varName + ".Length -> " + length);
            return length;
        }
        throw new RuntimeException("Unbekannter Expression-Typ: " + expr.getClass().getSimpleName());
        else if (expr instanceof SimpleParser.ObjectCreationExpressionContext) {
            String type = ((SimpleParser.ObjectCreationExpressionContext) expr).COLLECTION_TYPE().getText();
            
            switch (type) {
                case "LinkedList": return new LinkedList<Object>();
                case "List":       return new ArrayList<Object>();
                case "Set":        return new HashSet<Object>();
                case "Map":        
                case "HashMap":    
                case "Dictionary": return new HashMap<Object, Object>();
                case "Stack":      return new Stack<Object>();
                case "Tuple":      
                    return new Object[0]; // Initialisierung müsste über expressionList erfolgen
                default: return null;
            }
        }
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
    
    // ---File-Methoden (existierende Methoden)---

    //Datei schreiben
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

    //Datei lesen
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

    //Datei löschen
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

    //Ist null Funktion
    private static void processIsNullStmt(SimpleParser.IsNullStmtContext ctx) {
        // Das erste IDENTIFIER ist die Variable für das Ergebnis
        String resultVar = ctx.IDENTIFIER(0).getText();
        
        // Der zu prüfende Wert kann IDENTIFIER oder STRING sein
        String checkVar = null;
        boolean isStringLiteral = false;
        
        // Prüfe ob es ein IDENTIFIER ist
        if (ctx.IDENTIFIER().size() > 1) {
            checkVar = ctx.IDENTIFIER(1).getText();
        } 
        // Prüfe ob es ein STRING ist
        else if (ctx.STRING() != null) {
            checkVar = ctx.STRING().getText();
            // Entferne die Anführungszeichen
            if (checkVar.length() >= 2) {
                checkVar = checkVar.substring(1, checkVar.length() - 1);
            }
            isStringLiteral = true;
        }
        
        if (checkVar == null) {
            throw new RuntimeException("Fehler in IsNull: Weder IDENTIFIER noch STRING gefunden");
        }
        
        System.out.println("Prüfe, ob die Variable '" + checkVar + "' null ist und speichere das Ergebnis in " + resultVar);
        
        boolean isNull;
        
        if (isStringLiteral) {
            // Wenn es ein String-Literal ist, prüfe ob eine Variable mit diesem Namen existiert
            isNull = !variables.containsKey(checkVar) || variables.get(checkVar) == null;
        } else {
            // Wenn es ein Identifier ist, verwende direkt den Namen
            isNull = !variables.containsKey(checkVar) || variables.get(checkVar) == null;
        }
        
        variables.put(resultVar, isNull);
        
        System.out.println("Ergebnis: " + resultVar + " = " + isNull);
    }

    //Datei existiert
    private static void processExistsStmt(SimpleParser.ExistsStmtContext ctx) {
        String varName = ctx.IDENTIFIER(0).getText(); // Verwende das erste IDENTIFIER-Token
        String path = ctx.STRING().getText().replaceAll("^\"|\"$", "");

        System.out.println("Prüfe, ob der Pfad " + path + " existiert und speichere das Ergebnis in " + varName);

        boolean exists = Files.exists(Path.of(path));
        variables.put(varName, exists);

        System.out.println("Ergebnis: " + varName + " = " + exists);
    }

    //Schlafen
    private static void processSleepStmt(SimpleParser.SleepStmtContext ctx) {
        if (ctx.NUMBER() == null) {
            throw new RuntimeException("Fehlender INTEGER-Wert für Sleep.");
        }

        int duration = Integer.parseInt(ctx.NUMBER().getText());

        System.out.println("Schlafe für " + duration + " Millisekunden.");

        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException("Fehler beim Schlafen: " + e.getMessage());
        }

        System.out.println("Schlafen beendet.");
    }

    //Ordner erstellen
    private static void processCreateFolderStmt(SimpleParser.CreateFolderStmtContext ctx) {
        String folderPath = ctx.STRING().getText().replaceAll("^\"|\"$", "");

        System.out.println("Erstelle Ordner: " + folderPath);

        try {
            Files.createDirectories(Path.of(folderPath));
            System.out.println("Ordner erfolgreich erstellt: " + folderPath);
        } catch (IOException e) {
            throw new RuntimeException("Fehler beim Erstellen des Ordners: " + e.getMessage());
        }
    }

    //Ordner löschen
    private static void processDeleteFolderStmt(SimpleParser.DeleteFolderStmtContext ctx) {
        String folderPath = ctx.STRING().getText().replaceAll("^\"|\"$", "");

        System.out.println("Lösche Ordner: " + folderPath);

        try {
            if (!Files.exists(Path.of(folderPath))) {
                throw new RuntimeException("Ordner existiert nicht: " + folderPath);
            }

            Files.delete(Path.of(folderPath));
            System.out.println("Ordner erfolgreich gelöscht: " + folderPath);
        } catch (IOException e) {
            throw new RuntimeException("Fehler beim Löschen des Ordners: " + e.getMessage());
        }
    }

    //Ordner öffnen
    private static void processOpenFileStmt(SimpleParser.OpenFileStmtContext ctx) {
        String filePath = ctx.STRING().getText().replaceAll("^\"|\"$", "");

        System.out.println("Öffne Datei: " + filePath);

        try {
            if (!Files.exists(Path.of(filePath))) {
                throw new RuntimeException("Datei existiert nicht: " + filePath);
            }

            String content = Files.readString(Path.of(filePath));
            System.out.println("Inhalt der Datei " + filePath + ":\n" + content);
        } catch (IOException e) {
            throw new RuntimeException("Fehler beim Öffnen der Datei: " + e.getMessage());
        }
    }


    // ---Mathematische Funktionen---

    private static List<Double> extractNumbers(ParseTree node) {
        List<Double> list = new ArrayList<>();
        
        if (node instanceof TerminalNode) {
            String varName = node.getText();
            if (variables.containsKey(varName)) {
                Object val = variables.get(varName);
                if (val instanceof List) {
                    for (Object item : (List<?>) val) {
                        if (item instanceof Number) {
                            list.add(((Number) item).doubleValue());
                        }
                    }
                } else if (val instanceof Number) {
                    list.add(((Number) val).doubleValue());
                }
            }
            return list;
        } 
        else {
            for (int i = 0; i < node.getChildCount(); i++) {
                ParseTree child = node.getChild(i);
                if (child.getText().equals(",")) continue;
                
                Object res = resolve(child);
                if (res instanceof Number) {
                    list.add(((Number) res).doubleValue());
                }
            }
        }
        return list;
    }

    //Kleinste Zahl einer Liste
    private static void processMinListFunctionStmt(SimpleParser.MinListFunctionStmtContext ctx) {
        String resultVar = ctx.IDENTIFIER(0).getText();
        List<Double> numbers = extractNumbers(ctx.getChild(5));
        double min = Collections.min(numbers);
        updateVariable(resultVar, min);
        System.out.println("MIN: " + resultVar + " = " + min);
    }

    //Absoluter Wert
    private static void processAbsFunctionStmt(SimpleParser.AbsFunctionStmtContext ctx) {
        String resultVar = ctx.IDENTIFIER(0).getText();
        Object val = resolve(ctx.getChild(5)); 

        if (!(val instanceof Number)) {
            throw new RuntimeException("Abs-Funktion benötigt eine Zahl, erhalten: " + val);
        }
        
        double result = Math.abs(((Number) val).doubleValue());
        updateVariable(resultVar, result);
        System.out.println("MATH: Abs(" + val + ") -> " + resultVar + " = " + result);
    }

    //Quadratfunktion (Potenz)
    private static void processSqrtFunctionStmt(SimpleParser.SqrtFunctionStmtContext ctx) {
        String resultVar = ctx.IDENTIFIER(0).getText();
        
        Object baseObj = resolve(ctx.getChild(5));
        Object rootObj = resolve(ctx.getChild(7));

        if (!(baseObj instanceof Number && rootObj instanceof Number)) {
            throw new RuntimeException("Sqrt benötigt zwei Zahlen.");
        }

        double base = ((Number) baseObj).doubleValue();
        double root = ((Number) rootObj).doubleValue();
        
        if (root == 0) throw new RuntimeException("Wurzelexponent darf nicht 0 sein.");

        double result = Math.pow(base, 1.0 / root);
        updateVariable(resultVar, result);
        System.out.println("MATH: Sqrt(" + base + ", " + root + ") -> " + resultVar + " = " + result);
    }

    //Zahl runden
    private static void processRoundFunctionStmt(SimpleParser.RoundFunctionStmtContext ctx) {
        String resultVar = ctx.IDENTIFIER(0).getText();
        
        Object valObj = resolve(ctx.getChild(5));
        Object scaleObj = resolve(ctx.getChild(7));

        if (!(valObj instanceof Number && scaleObj instanceof Number)) {
            throw new RuntimeException("Round benötigt Zahl und Nachkommastellen.");
        }

        double value = ((Number) valObj).doubleValue();
        int scale = ((Number) scaleObj).intValue();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(scale, RoundingMode.HALF_UP);
        double result = bd.doubleValue();

        updateVariable(resultVar, result);
        System.out.println("MATH: Round(" + value + ", " + scale + ") -> " + resultVar + " = " + result);
    }

    //Zufallszahl generieren
    private static void processRandomFunctionStmt(SimpleParser.RandomFunctionStmtContext ctx) {
        String resultVar = ctx.IDENTIFIER(0).getText();
        
        Object minObj = resolve(ctx.getChild(5));
        Object maxObj = resolve(ctx.getChild(7));

        if (!(minObj instanceof Number && maxObj instanceof Number)) {
            throw new RuntimeException("Random benötigt zwei Zahlen für Min und Max.");
        }

        double min = ((Number) minObj).doubleValue();
        double max = ((Number) maxObj).doubleValue();

        if (min >= max) throw new RuntimeException("Min muss kleiner als Max sein.");

        double result = Math.random() * (max - min) + min;
        updateVariable(resultVar, result);
        System.out.println("MATH: Random(" + min + " bis " + max + ") -> " + resultVar + " = " + result);
    }

    //Mittelwert berechnen
    private static void processMeanFunctionStmt(SimpleParser.MeanFunctionStmtContext ctx) {
        String resultVar = ctx.IDENTIFIER(0).getText();
        List<Double> numbers = extractNumbers(ctx.getChild(5));
        double avg = numbers.stream().mapToDouble(d -> d).average().orElse(0.0);
        updateVariable(resultVar, avg);
        System.out.println("MEAN: " + resultVar + " = " + avg);
    }

    //Median berechnen
    private static void processMedianFunctionStmt(SimpleParser.MedianFunctionStmtContext ctx) {
        String resultVar = ctx.IDENTIFIER(0).getText();
        List<Double> numbers = extractNumbers(ctx.getChild(5));
        Collections.sort(numbers);
        double median = (numbers.size() % 2 == 0) 
            ? (numbers.get(numbers.size()/2-1) + numbers.get(numbers.size()/2)) / 2.0 
            : numbers.get(numbers.size()/2);
        updateVariable(resultVar, median);
        System.out.println("MEDIAN: " + resultVar + " = " + median);
    }

    //Größte Zahl finden
    private static void processMaxFunctionStmt(SimpleParser.MaxFunctionStmtContext ctx) {
        String resultVar = ctx.getChild(1).getText();
        List<Double> numbers = extractNumbers(ctx.getChild(5));
        double max = Collections.max(numbers);
        updateVariable(resultVar, max);
        System.out.println("MAX: " + resultVar + " = " + max);
    }

    //Größte Zahl aus Liste finden
    private static void processMaxListFunctionStmt(SimpleParser.MaxFromListStmtContext ctx) {
        String resultVar = ctx.IDENTIFIER(0).getText();
        List<Double> numbers = extractNumbers(ctx.getChild(5));
        double max = Collections.max(numbers);
        updateVariable(resultVar, max);
        System.out.println("MAX (List): " + resultVar + " = " + max);
    }

    // ---String-Funktionen---

    //In Kleinbuchstaben umwandeln
    private static void processToLowerFunctionStmt(SimpleParser.ToLowerFunctionStmtContext ctx) {
    
        String resultVarName = ctx.IDENTIFIER().get(0).getText();
        
        if (ctx.IDENTIFIER().size() < 2) {
            throw new RuntimeException("ToLower benötigt einen Quell-Identifier als Argument.");
        }
        String sourceVarName = ctx.IDENTIFIER().get(1).getText();
        
        if (!variables.containsKey(sourceVarName)) {
            throw new RuntimeException("Quellvariable nicht definiert: " + sourceVarName);
        }
        
        Object sourceObject = variables.get(sourceVarName);
        
        if (!(sourceObject instanceof String sourceString)) {
            throw new RuntimeException("ToLower erfordert einen String-Wert, gefunden: " + sourceObject.getClass().getSimpleName());
        }

        String result = sourceString.toLowerCase();

        trackMemoryBeforeAssignment(resultVarName, result);
        variables.put(resultVarName, result);
        trackMemoryAfterAssignment(resultVarName, result);
        
        System.out.println("TOLOWERFUNCTION: ToLower(" + sourceVarName + ") -> " + resultVarName + " = " + result);
        printMemoryStats();
    }

    //In Großbuchstaben umwandeln
    private static void processToUpperFunctionStmt(SimpleParser.ToUpperFunctionStmtContext ctx){
        String resultVarName = ctx.IDENTIFIER().get(0).getText();

        if (ctx.IDENTIFIER().size() < 2){
            throw new RuntimeException("ToUpper benötigt einen Quell-Identifier als Argument.");
        }

        String sourceVarName = ctx.IDENTIFIER().get(1).getText();

        if (!variables.containsKey(sourceVarName)){
            throw new RuntimeException("Quellvariable nicht definiert: " + sourceVarName);
        }

        Object sourceObject = variables.get(sourceVarName);

        if (!(sourceObject instanceof String sourceString)){
            throw new RuntimeException("ToUpper erfordert einen String-Wert, gefunden: " + sourceObject.getClass().getSimpleName());
        }

        String result = sourceString.toUpperCase();

        trackMemoryBeforeAssignment(resultVarName, result);
        variables.put(resultVarName, result);
        trackMemoryAfterAssignment(resultVarName, result);

        System.out.println("TOUPPERFUNCTION: ToUpper(" + sourceVarName + ") -> " + resultVarName + " = " + result);
        printMemoryStats();
    }

    //Leerzeichen entfernen
    private static void processTrimFunctionStmt(SimpleParser.TrimFunctionStmtContext ctx){
        String resultVarName = ctx.IDENTIFIER().get(0).getText();

        if (ctx.IDENTIFIER().size() < 2){
            throw new RuntimeException("Trim benötigt einen Quell-Identifier als Argument.");
        }

        String sourceVarName = ctx.IDENTIFIER().get(1).getText();

        if (!variables.containsKey(sourceVarName)){
            throw new RuntimeException("Quellvariable nicht definiert: " + sourceVarName);
        }

        Object sourceObject = variables.get(sourceVarName);

        if (!(sourceObject instanceof String sourceString)){
            throw new RuntimeException("Trim erfordert einen String-Wert, gefunden: " + sourceObject.getClass().getSimpleName());
        }

        String result = sourceString.trim();

        trackMemoryBeforeAssignment(resultVarName, result);
        variables.put(resultVarName, result);
        trackMemoryAfterAssignment(resultVarName, result);

        System.out.println("TRIMFUNCTION: Trim(" + sourceVarName + ") -> " + resultVarName + " = " + result);
        printMemoryStats();
    }

    //Leerzeichen am Anfang entfernen
    private static void processTrimStartFunctionStmt(SimpleParser.TrimStartFunctionStmtContext ctx) {
        String resultVarName = ctx.IDENTIFIER().get(0).getText();
        String sourceVarName = ctx.IDENTIFIER().get(1).getText();
        Object sourceObject = variables.get(sourceVarName);
        if (!(sourceObject instanceof String sourceString)) {
            throw new RuntimeException("TrimStart erfordert einen String-Wert.");
        }
        
        // Regex: ^[\s]+ ersetzt Whitespace am Anfang (^) durch Nichts ("")
        String result = sourceString.replaceAll("^[\\s]+", "");

        trackMemoryBeforeAssignment(resultVarName, result);
        variables.put(resultVarName, result);
        trackMemoryAfterAssignment(resultVarName, result);

        System.out.println("TRIMSTARTFUNCTION: TrimStart(" + sourceVarName + ") -> " + resultVarName + " = " + result);
        printMemoryStats();
    }

    //Leerzeichen am Ende entfernen
    private static void processTrimEndFunctionStmt(SimpleParser.TrimEndFunctionStmtContext ctx) {
        String resultVarName = ctx.IDENTIFIER().get(0).getText();
        String sourceVarName = ctx.IDENTIFIER().get(1).getText();
        Object sourceObject = variables.get(sourceVarName);
        if (!(sourceObject instanceof String sourceString)) {
            throw new RuntimeException("TrimEnd erfordert einen String-Wert.");
        }

        // Regex: [\s]+$ ersetzt Whitespace am Ende ($) durch Nichts ("")
        String result = sourceString.replaceAll("[\\s]+$", "");

        trackMemoryBeforeAssignment(resultVarName, result);
        variables.put(resultVarName, result);
        trackMemoryAfterAssignment(resultVarName, result);

        System.out.println("TRIMENDFUNCTION: TrimEnd(" + sourceVarName + ") -> " + resultVarName + " = " + result);
        printMemoryStats();
    }

    //String ersetzen
    private static void processReplaceFunctionStmt(SimpleParser.ReplaceFunctionStmtContext ctx) {
        
        String resultVarName = ctx.IDENTIFIER().get(0).getText();
        
        if (ctx.IDENTIFIER().size() < 2) {
            throw new RuntimeException("Replace benötigt einen Quell-Identifier.");
        }
        String sourceVarName = ctx.IDENTIFIER().get(1).getText();
        
        if (!variables.containsKey(sourceVarName)) {
            throw new RuntimeException("Quellvariable nicht definiert: " + sourceVarName);
        }
        
        Object sourceObject = variables.get(sourceVarName);
        if (!(sourceObject instanceof String sourceString)) {
            throw new RuntimeException("Replace erfordert einen String-Wert als Quelle.");
        }
        
        if (ctx.STRING().size() < 2) {
            throw new RuntimeException("Replace benötigt zwei String-Literale (Alt und Neu).");
        }
        String oldString = ctx.STRING().get(0).getText().replaceAll("^\"|\"$", "");
        
        String newString = ctx.STRING().get(1).getText().replaceAll("^\"|\"$", "");

        String result = sourceString.replace(oldString, newString);

        trackMemoryBeforeAssignment(resultVarName, result);
        variables.put(resultVarName, result);
        trackMemoryAfterAssignment(resultVarName, result);
        
        System.out.println("REPLACEFUNCTION: Replace(" + sourceVarName + ", '" + oldString + "', '" + newString + "') -> " + resultVarName + " = " + result);
        printMemoryStats();
    }

    //String aufteilen
    private static void processSplitFunctionStmt(SimpleParser.SplitFunctionStmtContext ctx) {
    
        String resultVarName = ctx.IDENTIFIER().get(0).getText();
        
        if (ctx.IDENTIFIER().size() < 2) {
            throw new RuntimeException("Split benötigt einen Quell-Identifier.");
        }
        String sourceVarName = ctx.IDENTIFIER().get(1).getText();
        
        if (!variables.containsKey(sourceVarName)) {
            throw new RuntimeException("Quellvariable nicht definiert: " + sourceVarName);
        }
        
        Object sourceObject = variables.get(sourceVarName);
        if (!(sourceObject instanceof String sourceString)) {
            throw new RuntimeException("Split erfordert einen String-Wert als Quelle.");
        }
        
        TerminalNode delimiterNode = ctx.STRING();
        
        if (delimiterNode == null) {
            throw new RuntimeException("Split benötigt ein String-Literal als Trennzeichen.");
        }
        
        String delimiter = delimiterNode.getText().replaceAll("^\"|\"$", "");

        String[] partsArray = sourceString.split(delimiter);
        
        List<String> resultList = Arrays.asList(partsArray);

        trackMemoryBeforeAssignment(resultVarName, resultList);
        variables.put(resultVarName, resultList);
        trackMemoryAfterAssignment(resultVarName, resultList);
        
        System.out.println("SPLITFUNCTION: Split(" + sourceVarName + " durch '" + delimiter + "') -> " + resultVarName + " = " + resultList);
        printMemoryStats();
    }

    //Rechte Zeichen extrahieren
    private static void processRightFunctionStmt(SimpleParser.RightFunctionStmtContext ctx) {
        String resultVarName = ctx.IDENTIFIER(0).getText();
        
        Object sourceObj = resolve(ctx.getChild(5));
        Object lengthObj = resolve(ctx.getChild(7));

        if (!(sourceObj instanceof String sourceString)) {
            throw new RuntimeException("Right-Funktion erfordert einen String als Quelle.");
        }
        if (!(lengthObj instanceof Number)) {
            throw new RuntimeException("Länge für Right-Funktion muss eine Zahl sein.");
        }

        int length = ((Number) lengthObj).intValue();
        int strLen = sourceString.length();

        int actualLength = Math.max(0, Math.min(length, strLen));
        int startIndex = strLen - actualLength;
        
        String result = sourceString.substring(startIndex);

        updateVariable(resultVarName, result);
        
        System.out.println("STRING: Right(" + sourceString + ", " + length + ") -> " + resultVarName + " = " + result);
    }

    //Linke Zeichen extrahieren
    private static void processLeftFunctionStmt(SimpleParser.LeftFunctionStmtContext ctx) {
        
        String resultVarName = ctx.IDENTIFIER().get(0).getText();
                
        if (ctx.IDENTIFIER().size() < 2) {
            throw new RuntimeException("Left benötigt einen Quell-Identifier.");
        }
        String sourceVarName = ctx.IDENTIFIER().get(1).getText();
        
        if (!variables.containsKey(sourceVarName)) {
            throw new RuntimeException("Quellvariable nicht definiert: " + sourceVarName);
        }
        
        Object sourceObject = variables.get(sourceVarName);
        if (!(sourceObject instanceof String sourceString)) {
            throw new RuntimeException("Left erfordert einen String-Wert als Quelle.");
        }
        
        SimpleParser.ExpressionContext lengthExpr = ctx.expression();
        if (lengthExpr == null) {
            throw new RuntimeException("Left benötigt eine Längen-Expression.");
        }
        
        Object lengthValue = evaluateExpression(lengthExpr);
        
        if (!(lengthValue instanceof Double d)) {
            throw new RuntimeException("Länge in Left-Funktion muss eine Zahl sein.");
        }
        
        int length = d.intValue();
        
        if (length < 0) {
            throw new RuntimeException("Länge für Left-Funktion muss >= 0 sein.");
        }

        int actualLength = Math.min(length, sourceString.length());
        String result = sourceString.substring(0, actualLength);

        trackMemoryBeforeAssignment(resultVarName, result);
        variables.put(resultVarName, result);
        trackMemoryAfterAssignment(resultVarName, result);
        
        System.out.println("LEFTFUNCTION: Left(" + sourceVarName + ", " + length + ") -> " + resultVarName + " = " + result);
        printMemoryStats();
    }

    //Linke Zeichen mit Startindex extrahieren
    private static void processLeftRangeFunctionStmt(SimpleParser.LeftRangeFunctionStmtContext ctx) {
        
        String resultVarName = ctx.IDENTIFIER().get(0).getText();
        
        if (ctx.IDENTIFIER().size() < 2) {
            throw new RuntimeException("Left Range benötigt einen Quell-Identifier.");
        }
        String sourceVarName = ctx.IDENTIFIER().get(1).getText();
        
        if (!variables.containsKey(sourceVarName)) {
            throw new RuntimeException("Quellvariable nicht definiert: " + sourceVarName);
        }
        Object sourceObject = variables.get(sourceVarName);
        if (!(sourceObject instanceof String sourceString)) {
            throw new RuntimeException("Left Range erfordert einen String-Wert als Quelle.");
        }
        
        if (ctx.NUMBER().size() < 2) {
            throw new RuntimeException("Left Range benötigt Startindex und Länge.");
        }
        int startIndex = (int) Double.parseDouble(ctx.NUMBER().get(0).getText());
        
        int length = (int) Double.parseDouble(ctx.NUMBER().get(1).getText());

        int stringLength = sourceString.length();
        
        if (startIndex < 0 || startIndex >= stringLength) {
            throw new RuntimeException("Startindex (" + startIndex + ") ist außerhalb des gültigen Bereichs [0, " + (stringLength - 1) + "].");
        }
        if (length < 0) {
            throw new RuntimeException("Länge muss >= 0 sein.");
        }

        int endIndex = Math.min(startIndex + length, stringLength);
        String result = sourceString.substring(startIndex, endIndex);

        trackMemoryBeforeAssignment(resultVarName, result);
        variables.put(resultVarName, result);
        trackMemoryAfterAssignment(resultVarName, result);
        
        System.out.println("LEFTRANGEFUNCTION: Left(" + sourceVarName + ", Start: " + startIndex + ", Länge: " + length + ") -> " + resultVarName + " = " + result);
        printMemoryStats();
    }

    //String verketten
    private static void processConcatFunctionStmt(SimpleParser.ConcatFunctionStmtContext ctx) {
        
        String resultVarName = ctx.IDENTIFIER().get(0).getText();
        
        if (ctx.IDENTIFIER().size() < 3) {
            throw new RuntimeException("Concat benötigt zwei Quell-Identifier.");
        }
        String var1Name = ctx.IDENTIFIER().get(1).getText();
        String var2Name = ctx.IDENTIFIER().get(2).getText();
        
        if (!variables.containsKey(var1Name) || !variables.containsKey(var2Name)) {
            throw new RuntimeException("Quellvariablen für Concat nicht definiert.");
        }
        
        String str1 = variables.get(var1Name).toString();
        String str2 = variables.get(var2Name).toString();
        
        TerminalNode stringNode = ctx.STRING();
        
        if (stringNode == null) {
            System.out.println("WARNUNG: Drittes Argument (Literal) in Concat wurde nicht gefunden. Verwende leeren String.");
            throw new RuntimeException("Concat benötigt ein String-Literal als drittes Argument.");
        }
        
        String literalNodeText = stringNode.getText();
        String literal = literalNodeText.replaceAll("^\"|\"$", "");

        String result = str1 + str2 + literal;

        trackMemoryBeforeAssignment(resultVarName, result);
        variables.put(resultVarName, result);
        trackMemoryAfterAssignment(resultVarName, result);
        
        System.out.println("CONCATFUNCTION: Concat(" + str1 + ", " + str2 + ", '" + literal + "') -> " + resultVarName + " = " + result);
        printMemoryStats();
    }

    //Überprüfen, ob String enthalten ist
    private static void processContainsFunctionStmt(SimpleParser.ContainsFunctionStmtContext ctx) {
        
        String resultVarName = ctx.IDENTIFIER().get(0).getText();
        
        if (ctx.IDENTIFIER().size() < 2) {
            throw new RuntimeException("Contains benötigt einen Quell-Identifier.");
        }
        String sourceVarName = ctx.IDENTIFIER().get(1).getText();
        
        if (!variables.containsKey(sourceVarName)) {
            throw new RuntimeException("Quellvariable nicht definiert: " + sourceVarName);
        }
        
        Object sourceObject = variables.get(sourceVarName);
        if (!(sourceObject instanceof String sourceString)) {
            throw new RuntimeException("Contains erfordert einen String-Wert als Quelle.");
        }
        
        TerminalNode searchNode = ctx.STRING();
        if (searchNode == null) {
            throw new RuntimeException("Contains benötigt ein String-Literal als Suchwert.");
        }
        
        String searchString = searchNode.getText().replaceAll("^\"|\"$", "");

        boolean result = sourceString.contains(searchString);

        trackMemoryBeforeAssignment(resultVarName, result);
        variables.put(resultVarName, result);
        trackMemoryAfterAssignment(resultVarName, result);
        
        System.out.println("CONTAINSFUNCTION: Contains('" + searchString + "' in " + sourceVarName + ") -> " + resultVarName + " = " + result);
        printMemoryStats();
    }

    //if-Statement verarbeiten
    private static void processIfStmt(SimpleParser.IfStmtContext ctx) {
        // 1. Bedingung extrahieren (Annahme: IF '(' expression compareOp expression ')')
        SimpleParser.ExpressionContext leftExpr = ctx.expression(0);
        SimpleParser.CompareOpContext op = ctx.compareOp();
        SimpleParser.ExpressionContext rightExpr = ctx.expression(1);

        // 2. Bedingung auswerten
        boolean conditionMet = false;
        try {
            Object leftVal = evaluateExpression(leftExpr);
            Object rightVal = evaluateExpression(rightExpr);
            String operator = op.getText();

            conditionMet = compareValues(leftVal, operator, rightVal);
        } catch (Exception e) {
            System.out.println("FEHLER in IF-Bedingung: " + e.getMessage());
        }

        if (conditionMet) {
            System.out.println("IF: Bedingung wahr - führe Block aus");
            executeBlockOrLine(ctx, true);
        } else if (ctx.SONST() != null) {
            System.out.println("IF: Bedingung falsch - führe ELSE aus");
            executeBlockOrLine(ctx, false);
        }
    }

    // Hilfsmethode zum Vergleichen
    private static boolean compareValues(Object leftVal, String operator, Object rightVal) {
        if (leftVal instanceof Number && rightVal instanceof Number) {
            double l = ((Number) leftVal).doubleValue();
            double r = ((Number) rightVal).doubleValue();
            switch (operator) {
                case "==": return Math.abs(l - r) < 0.000001;
                case "!=": return Math.abs(l - r) > 0.000001;
                case "<":  return l < r;
                case "<=": return l <= r;
                case ">":  return l > r;
                case ">=": return l >= r;
            }
        }
        if (leftVal instanceof String && rightVal instanceof String) {
            switch (operator) {
                case "==": return leftVal.equals(rightVal);
                case "!=": return !leftVal.equals(rightVal);
            }
        }
        return false;
    }

    // Hilfsmethode um den richtigen Block innerhalb des IF/ELSE zu finden
    private static void executeBlockOrLine(SimpleParser.IfStmtContext ctx, boolean isIfBranch) {
        boolean elseReached = false;
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            
            if (child instanceof TerminalNode && child.getText().equalsIgnoreCase("else")) {
                elseReached = true;
                continue;
            }

            if (isIfBranch && !elseReached) {
                if (child instanceof SimpleParser.LineContext || child instanceof SimpleParser.BlockContext) {
                    processTree(child);
                }
            } 
            else if (!isIfBranch && elseReached) {
                if (child instanceof SimpleParser.LineContext || child instanceof SimpleParser.BlockContext) {
                    processTree(child);
                }
            }
        }
    }

    // Switch-case-Statement
    private static void processSwitchStmt(SimpleParser.SwitchStmtContext ctx) {
        Object switchValue = evaluateExpression(ctx.expression());
        boolean foundMatch = false;

        for (SimpleParser.CaseStmtContext caseCtx : ctx.caseStmt()) {
            Object caseValue = resolve(caseCtx.constant());

            if (compareValues(switchValue, "==", caseValue)) {
                foundMatch = true;
                for (SimpleParser.LineContext line : caseCtx.line()) {
                    processTree(line);
                }
                break; 
            }
        }

        if (!foundMatch && ctx.defaultStmt() != null) {
            for (SimpleParser.LineContext line : ctx.defaultStmt().line()) {
                processTree(line);
            }
        }
    }
}