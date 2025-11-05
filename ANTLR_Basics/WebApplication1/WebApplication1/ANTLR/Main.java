import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.nio.file.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // Datei test.simple lesen
            System.out.println("Versuche, die Datei test.simple zu lesen...");
            String input = Files.readString(Path.of("test.simple"));

            if (input.isBlank()) {
                System.out.println("Die Datei test.simple ist leer. Bitte füge gültige Inhalte hinzu.");
                return;
            }

            System.out.println("Datei-Inhalt erfolgreich gelesen: " + input);

            // Lexer und TokenStream erstellen
            System.out.println("Erstelle Lexer...");
            SimpleLexer lexer = new SimpleLexer(CharStreams.fromString(input));
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            // Parser erstellen
            System.out.println("Erstelle Parser...");
            SimpleParser parser = new SimpleParser(tokens);
            
            // Error-Listener für bessere Fehlermeldungen
            parser.removeErrorListeners();
            parser.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, 
                                      int line, int charPositionInLine, String msg, RecognitionException e) {
                    System.err.println("Syntax Fehler in Zeile " + line + ":" + charPositionInLine + " " + msg);
                }
            });

            ParseTree tree = parser.program();

            // Debugging: Parse-Baum
            System.out.println("Parse-Baum erstellt erfolgreich");

            // Interpreter ausführen
            System.out.println("Starte Interpreter...");
            SimpleInterpreter interpreter = new SimpleInterpreter();
            interpreter.visit(tree);

            System.out.println("Interpreter beendet");

        } catch (IOException e) {
            System.err.println("Fehler beim Lesen der Datei: " + e.getMessage());
        } catch (RuntimeException e) {
            System.err.println("Laufzeitfehler: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}