import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Kommandozeilen-Anwendung zur Verwaltung der Bibliotheksbestände.
 * Bietet Funktionen zum Hinzufügen, Auflisten, Speichern und Laden von Medien.
 */
public class CliApp {
    // Instanz der Bibliothek, die verschiedene Medientypen verwalten kann.
    private Library<Medium> library;
    private Scanner scanner;
    private static final String DATA_FILE = "library_data.ser"; // Dateiname für die Speicherung

    /**
     * Konstruktor für die CliApp.
     * Initialisiert die Bibliothek und lädt bestehende Daten.
     */
    public CliApp() {
        library = new Library<>(DATA_FILE);
        scanner = new Scanner(System.in);
        // Versucht, die Bibliotheksdaten beim Start zu laden
        try {
            library.loadLibrary();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Fehler beim Laden der Bibliotheksdaten: " + e.getMessage());
            System.out.println("Startet mit leerem Bibliotheksbestand.");
        }
    }

    /**
     * Startet die Hauptschleife der Anwendung und verarbeitet Benutzereingaben.
     */
    public void run() {
        int choice;
        do {
            printMenu();
            try {
                System.out.print("Wählen Sie eine Option: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Konsumiere den Zeilenumbruch
                
                switch (choice) {
                    case 1:
                        addBook();
                        break;
                    case 2:
                        addMagazine();
                        break;
                    case 3:
                        listAllMedia();
                        break;
                    case 4:
                        removeMedium();
                        break;
                    case 5:
                        saveLibraryData();
                        break;
                    case 6:
                        loadLibraryData();
                        break;
                    case 0:
                        System.out.println("Anwendung wird beendet. Bibliotheksdaten werden gespeichert...");
                        saveLibraryData(); // Speichert die Daten beim Beenden
                        break;
                    default:
                        System.out.println("Ungültige Option. Bitte versuchen Sie es erneut.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl ein.");
                scanner.nextLine(); // Konsumiere die fehlerhafte Eingabe
                choice = -1; // Setze choice auf einen ungültigen Wert, um das Menü neu anzuzeigen
            } catch (IllegalArgumentException e) {
                System.out.println("Fehler: " + e.getMessage());
                choice = -1;
            }
            System.out.println(); // Leerzeile für bessere Lesbarkeit
        } while (choice != 0);
        scanner.close();
    }

    /**
     * Zeigt das Hauptmenü der Anwendung an.
     */
    private void printMenu() {
        System.out.println("--- Bibliotheksverwaltung ---");
        System.out.println("1. Buch hinzufügen");
        System.out.println("2. Zeitschrift hinzufügen");
        System.out.println("3. Alle Medien auflisten");
        System.out.println("4. Medium entfernen (nach ISBN)");
        System.out.println("5. Bibliotheksdaten speichern");
        System.out.println("6. Bibliotheksdaten laden");
        System.out.println("0. Beenden");
        System.out.println("-----------------------------");
    }

    /**
     * Ermöglicht das Hinzufügen eines neuen Buches zur Bibliothek.
     */
    private void addBook() {
        System.out.println("\n--- Buch hinzufügen ---");
        System.out.print("Titel: ");
        String title = scanner.nextLine();
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Autor: ");
        String author = scanner.nextLine();
        System.out.print("Anzahl Seiten: ");
        int pages = scanner.nextInt();
        scanner.nextLine(); 

        try {
            Book book = new Book(title, isbn, author, pages);
            if (library.addMedium(book)) {
                System.out.println("Buch erfolgreich hinzugefügt.");
            } else {
                System.out.println("Fehler: Ein Medium mit dieser ISBN existiert bereits.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Fehler beim Hinzufügen des Buches: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Ungültige Eingabe für Anzahl Seiten. Bitte geben Sie eine Zahl ein.");
            scanner.nextLine(); 
        }
    }

    /**
     * Ermöglicht das Hinzufügen einer neuen Zeitschrift zur Bibliothek.
     */
    private void addMagazine() {
        System.out.println("\n--- Zeitschrift hinzufügen ---");
        System.out.print("Titel: ");
        String title = scanner.nextLine();
        System.out.print("ISBN (oder ISSN): ");
        String isbn = scanner.nextLine();
        System.out.print("Ausgabennummer: ");
        int issue = scanner.nextInt();
        System.out.print("Erscheinungsjahr: ");
        int year = scanner.nextInt();
        scanner.nextLine(); 

        try {
            Magazine magazine = new Magazine(title, isbn, issue, year);
            if (library.addMedium(magazine)) {
                System.out.println("Zeitschrift erfolgreich hinzugefügt.");
            } else {
                System.out.println("Fehler: Ein Medium mit dieser ISBN existiert bereits.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Fehler beim Hinzufügen der Zeitschrift: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Ungültige Eingabe für Ausgabennummer oder Erscheinungsjahr. Bitte geben Sie Zahlen ein.");
            scanner.nextLine(); 
        }
    }

    /**
     * Listet alle im System vorhandenen Medien auf.
     */
    private void listAllMedia() {
        System.out.println("\n--- Aktueller Medienbestand ---");
        List<Medium> allMedia = library.getAllMedia();
        if (allMedia.isEmpty()) {
            System.out.println("Der Bibliotheksbestand ist leer.");
        } else {
            allMedia.forEach(System.out::println);
        }
    }

    /**
     * Entfernt ein Medium aus der Bibliothek anhand seiner ISBN.
     */
    private void removeMedium() {
        System.out.println("\n--- Medium entfernen ---");
        System.out.print("Geben Sie die ISBN des zu entfernenden Mediums ein: ");
        String isbn = scanner.nextLine();

        if (library.removeMedium(isbn)) {
            System.out.println("Medium mit ISBN '" + isbn + "' erfolgreich entfernt.");
        } else {
            System.out.println("Fehler: Medium mit ISBN '" + isbn + "' nicht gefunden.");
        }
    }

    /**
     * Speichert den aktuellen Bibliotheksbestand in der konfigurierten Datei.
     */
    private void saveLibraryData() {
        try {
            library.saveLibrary();
        } catch (IOException e) {
            System.err.println("Fehler beim Speichern der Daten: " + e.getMessage());
        }
    }

    /**
     * Lädt den Bibliotheksbestand aus der konfigurierten Datei.
     */
    private void loadLibraryData() {
        try {
            library.loadLibrary();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Fehler beim Laden der Daten: " + e.getMessage());
            System.out.println("Bibliotheksdaten konnten nicht geladen werden.");
        }
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