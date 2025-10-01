import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Lese eine Datei ein
        CharStream input = CharStreams.fromFileName("test.simple");

        // Lexer und Parser erzeugen
        SimpleLexer lexer = new SimpleLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SimpleParser parser = new SimpleParser(tokens);

        // Parse starten
        ParseTree tree = parser.program();

        // Interpreter ausführen
        SimpleInterpreter visitor = new SimpleInterpreter();
        visitor.visit(tree);
    }
}
