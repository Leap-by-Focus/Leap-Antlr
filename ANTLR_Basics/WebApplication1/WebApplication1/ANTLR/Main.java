import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.nio.file.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filename = (args.length > 0) ? args[0] : "test.simple";

        try {
            System.out.println("---Lese Datei: " + filename + " ---");
            String input = Files.readString(Path.of(filename));

            if (input.isBlank()) {
                System.out.println("---Die Datei ist leer. Bitte Testinput in " + filename + " legen.---");
                return;
            }

            // ANTLR: Lexer -> TokenStream -> Parser -> ParseTree
            CharStream charStream = CharStreams.fromString(input);
            SimpleLexer lexer = new SimpleLexer(charStream);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            SimpleParser parser = new SimpleParser(tokens);

            // Fehlerlistener entfernen/ersetzen, falls später notwendig
            parser.removeErrorListeners();
            parser.addErrorListener(new DiagnosticErrorListener());

            // entry point der Grammatik
            ParseTree tree = parser.program();

            System.out.println("---Parse Tree---");
            System.out.println(tree.toStringTree(parser));

            // Visitor oder Listener muss ich hier aufrufen
            // SimpleBaseVisitor<?> visitor = new SimpleBaseVisitor<>();
            // visitor.visit(tree);

            System.out.println("---Interpreter/Parser beendet---");

        } catch (IOException e) {
            System.err.println("---Fehler beim Lesen der Datei: " + e.getMessage() + " ---");
        } catch (RuntimeException e) {
            System.err.println("---Laufzeitfehler: " + e.getMessage() + " ---");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
