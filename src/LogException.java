/**
 * Eine benutzerdefinierte Ausnahme, die geworfen wird, wenn ein Fehler beim
 * Protokollieren von Ereignissen oder bei der Initialisierung des Loggers auftritt.
 */
public class LogException extends Exception {

    /**
     * Konstruktor für eine LogException mit einer Fehlermeldung.
     *
     * @param message Die detaillierte Fehlermeldung.
     */
    public LogException(String message) {
        super(message);
    }

    /**
     * Konstruktor für eine LogException mit einer Fehlermeldung und einer Ursache.
     *
     * @param message Die detaillierte Fehlermeldung.
     * @param cause   Die Ursache der Ausnahme (z.B. eine IOException).
     */
    public LogException(String message, Throwable cause) {
        super(message, cause);
    }
}