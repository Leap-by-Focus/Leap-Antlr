import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.nio.file.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // Lese die Datei test.simple
            System.out.println("Versuche, die Datei test.simple zu lesen...");
            String input = Files.readString(Path.of("C:/Users/shram/Documents/GitHub/Leap-Antlr/ANTLR_Basics/WebApplication1/WebApplication1/ANTLR/test.simple"));
            System.out.println("Datei-Inhalt erfolgreich gelesen: " + input);

            // Lexer und TokenStream erstellen
            System.out.println("Erstelle Lexer...");
            SimpleLexer lexer = new SimpleLexer(CharStreams.fromString(input));
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            // Debugging: Zeige alle Tokens
            System.out.println("Tokens:");
            tokens.fill();
            for (Token token : tokens.getTokens()) {
                System.out.println(token.toString());
            }

            // Parser erstellen
            System.out.println("Erstelle Parser...");
            SimpleParser parser = new SimpleParser(tokens);
            ParseTree tree = parser.program(); // Starte mit der Regel 'program'

            // Debugging: Zeige den Parse-Baum
            System.out.println("Parse-Baum:");
            System.out.println(tree.toStringTree(parser));

            // Interpreter ausführen
            System.out.println("Starte Interpreter...");
            SimpleInterpreter interpreter = new SimpleInterpreter();
            interpreter.visit(tree);

        } catch (IOException e) {
            System.err.println("Fehler beim Lesen der Datei: " + e.getMessage());
        } catch (RuntimeException e) {
            System.err.println("Laufzeitfehler: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace(); // Zeigt den Fehler-Stacktrace
        }
    }
}