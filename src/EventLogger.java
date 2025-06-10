import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional; // Für die Vermeidung von NullPointerExceptions

/**
 * Ein Event-Logger, der Systemereignisse in eine Datei schreibt.
 * Unterstützt das Protokollieren von einfachen Nachrichten und Objekten.
 * Nutzt BufferedWriter für effizientes Schreiben und behandelt Dateifehler.
 */
public class EventLogger implements AutoCloseable { // AutoCloseable für try-with-resources
    private final String logFilePath;
    private BufferedWriter writer;
    // Definiert ein Datum-Uhrzeit-Format für die Protokolleinträge
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Konstruktor für den EventLogger.
     * Initialisiert den BufferedWriter für die angegebene Protokolldatei.
     *
     * @param logFilePath Der Pfad zur Protokolldatei.
     * @throws LogException Wenn der Logger nicht initialisiert werden kann (z.B. Dateizugriffsfehler).
     */
    public EventLogger(String logFilePath) throws LogException {
        if (logFilePath == null || logFilePath.trim().isEmpty()) {
            throw new LogException("Protokolldateipfad darf nicht leer sein.");
        }
        this.logFilePath = logFilePath;
        try {
            // FileWriter mit 'true' für den Append-Modus, d.h. neue Einträge werden angehängt.
            // BufferedWriter für verbesserte Performance durch Puffern der Daten.
            this.writer = new BufferedWriter(new FileWriter(logFilePath, true));
            logEvent("Logger initialisiert."); // Protokolliert die Initialisierung
        } catch (IOException e) {
            throw new LogException("Fehler beim Initialisieren des Loggers für Pfad: " + logFilePath, e);
        }
    }

    /**
     * Protokolliert eine einfache Textnachricht als Ereignis.
     *
     * @param message Die zu protokollierende Nachricht.
     * @throws LogException Wenn ein Fehler beim Schreiben in die Protokolldatei auftritt.
     */
    public void logEvent(String message) throws LogException {
        // Sicherstellen, dass die Nachricht nicht null ist, Optional hilft hier, um elegante Prüfungen durchzuführen.
        Optional<String> optionalMessage = Optional.ofNullable(message);
        String logEntry = String.format("[%s] %s%n",
                LocalDateTime.now().format(FORMATTER),
                optionalMessage.orElse("NULL-Nachricht")); // Fallback für null-Nachrichten

        try {
            writer.write(logEntry);
            writer.flush(); // Leert den Puffer, um sicherzustellen, dass Daten geschrieben werden.
        } catch (IOException e) {
            // Werfe eine spezifische LogException, um den Fehler zu kennzeichnen.
            throw new LogException("Fehler beim Schreiben der Protokollnachricht: " + message, e);
        }
    }

    /**
     * Protokolliert ein komplexeres Objekt. Das Objekt wird mit seiner toString()-Methode
     * in einen String umgewandelt.
     *
     * @param object Das zu protokollierende Objekt.
     * @throws LogException Wenn ein Fehler beim Schreiben in die Protokolldatei auftritt.
     */
    public void logObject(Object object) throws LogException {
        // Optional.ofNullable() wird verwendet, um Null-Objekte sicher zu behandeln.
        // Falls das Objekt null ist, wird ein leerer String verwendet, um NPEs zu vermeiden.
        String objectString = Optional.ofNullable(object)
                                    .map(Object::toString) // Ruft toString() auf, falls nicht null
                                    .orElse("NULL-Objekt"); // Fallback für null-Objekte
        logEvent("Objekt-Protokoll: " + objectString);
    }

    /**
     * Schließt den Writer und gibt Ressourcen frei.
     * Diese Methode wird automatisch aufgerufen, wenn EventLogger in einem try-with-resources Block verwendet wird.
     *
     * @throws LogException Wenn ein Fehler beim Schließen des Writers auftritt.
     */
    @Override
    public void close() throws LogException {
        if (writer != null) {
            try {
                writer.close();
                System.out.println("Logger erfolgreich geschlossen.");
            } catch (IOException e) {
                throw new LogException("Fehler beim Schließen des Loggers.", e);
            }
        }
    }
}