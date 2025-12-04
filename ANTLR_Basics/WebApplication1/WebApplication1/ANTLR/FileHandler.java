import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private List<String> managedFiles = new ArrayList<>();
    
    public void WriteFile(String fileName) {
        try {
            // Entferne die Anführungszeichen vom Dateinamen
            String cleanFileName = fileName.replaceAll("^\"|\"$", "");
            Files.writeString(Path.of(cleanFileName), "Inhalt der Datei");
            managedFiles.add(cleanFileName);
            System.out.println("Datei erstellt: " + cleanFileName);
        } catch (IOException e) {
            throw new RuntimeException("Fehler beim Schreiben der Datei: " + e.getMessage());
        }
    }
    
    @Override
    public String toString() {
        if (managedFiles.isEmpty()) {
            return "FileHandler{keine Dateien}";
        } else {
            return "FileHandler{verwalteteDateien=" + managedFiles + "}";
        }
    }
}