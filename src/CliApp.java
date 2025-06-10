import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Kommandozeilen-Anwendung zur Demonstration des EventLoggers.
 * Ermöglicht das Protokollieren von Nachrichten und simuliert Fehler.
 */
public class CliApp {
    // Der Dateiname für die Protokolldatei.
    private static final String LOG_FILE_PATH = "application.log";
    private Scanner scanner;

    /**
     * Konstruktor für die CliApp.
     * Initialisiert den Scanner.
     */
    public CliApp() {
        scanner = new Scanner(System.in);
    }

    /**
     * Startet die Hauptschleife der Anwendung und verarbeitet Benutzereingaben.
     */
    public void run() {
        int choice;
        // Nutzt try-with-resources, um sicherzustellen, dass der Logger immer geschlossen wird.
        try (EventLogger logger = new EventLogger(LOG_FILE_PATH)) {
            System.out.println("Event-Logger initialisiert. Protokolle werden in '" + LOG_FILE_PATH + "' geschrieben.");
            do {
                printMenu();
                try {
                    System.out.print("Wählen Sie eine Option: ");
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Konsumiere den Zeilenumbruch

                    switch (choice) {
                        case 1:
                            logSimpleMessage(logger);
                            break;
                        case 2:
                            logComplexObject(logger);
                            break;
                        case 3:
                            simulateError(logger);
                            break;
                        case 0:
                            System.out.println("Anwendung wird beendet.");
                            break;
                        default:
                            System.out.println("Ungültige Option. Bitte versuchen Sie es erneut.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl ein.");
                    scanner.nextLine(); // Konsumiere die fehlerhafte Eingabe
                    choice = -1; // Setze choice auf einen ungültigen Wert, um das Menü neu anzuzeigen
                } catch (LogException e) {
                    System.err.println("Ein Logger-Fehler ist aufgetreten: " + e.getMessage());
                    if (e.getCause() != null) {
                        System.err.println("Ursache: " + e.getCause().getMessage());
                    }
                    choice = -1; // Bei kritischen Fehlern ggf. beenden oder neu initialisieren
                }
                System.out.println(); // Leerzeile für bessere Lesbarkeit
            } while (choice != 0);
        } catch (LogException e) {
            System.err.println("Kritischer Fehler beim Starten oder Schließen des Loggers: " + e.getMessage());
            if (e.getCause() != null) {
                System.err.println("Ursache: " + e.getCause().getMessage());
            }
        } finally {
            scanner.close(); // Scanner am Ende schließen
        }
    }

    /**
     * Zeigt das Hauptmenü der Anwendung an.
     */
    private void printMenu() {
        System.out.println("--- Event-Logger Demo ---");
        System.out.println("1. Einfache Nachricht protokollieren");
        System.out.println("2. Komplexes Objekt protokollieren");
        System.out.println("3. Fehler simulieren (wirft eine Exception)");
        System.out.println("0. Beenden");
        System.out.println("-------------------------");
    }

    /**
     * Protokolliert eine vom Benutzer eingegebene Nachricht.
     *
     * @param logger Die Instanz des EventLoggers.
     * @throws LogException Wenn der Logger einen Fehler meldet.
     */
    private void logSimpleMessage(EventLogger logger) throws LogException {
        System.out.print("Geben Sie eine Nachricht ein, die protokolliert werden soll: ");
        String message = scanner.nextLine();
        logger.logEvent(message);
        System.out.println("Nachricht erfolgreich protokolliert.");
    }

    /**
     * Protokolliert ein Beispielobjekt (hier ein String-Array).
     *
     * @param logger Die Instanz des EventLoggers.
     * @throws LogException Wenn der Logger einen Fehler meldet.
     */
    private void logComplexObject(EventLogger logger) throws LogException {
        // Beispiel für ein komplexes Objekt
        String[] data = {"User: John Doe", "Action: Login", "Status: Success"};
        System.out.println("Protokolliere ein komplexes Objekt (String-Array).");
        logger.logObject(data);
        System.out.println("Objekt erfolgreich protokolliert.");
    }

    /**
     * Simuliert einen Fehler, indem versucht wird, eine Null-Nachricht zu protokollieren.
     * Dies kann vom Logger intern geprüft werden.
     * Hier könnte man auch bewusst eine andere Exception werfen, um den Fluss zu testen.
     *
     * @param logger Die Instanz des EventLoggers.
     * @throws LogException Wenn der Logger einen Fehler meldet.
     */
    private void simulateError(EventLogger logger) throws LogException {
        System.out.println("Simuliere eine Fehlerbedingung...");
        // Versuch, eine Null-Nachricht zu protokollieren, um die Null-Prüfung und Optional zu demonstrieren
        logger.logEvent(null);
        System.out.println("Fehler-Simulation ausgeführt (Null-Nachricht versucht zu protokollieren).");
    }

    /**
     * Die Hauptmethode, die die Anwendung startet.
     * @param args Kommandozeilenargumente (werden hier nicht verwendet).
     */
    public static void main(String[] args) {
        CliApp app = new CliApp();
        app.run();
    }
}