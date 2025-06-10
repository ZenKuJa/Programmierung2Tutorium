import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Kommandozeilen-Anwendung zur Demonstration der Kundensuche und -filterung.
 */
public class CliApp {
    private CustomerManager customerManager;
    private Scanner scanner;

    /**
     * Konstruktor für die CliApp.
     * Initialisiert den CustomerManager und befüllt ihn mit Beispieldaten.
     */
    public CliApp() {
        customerManager = new CustomerManager();
        scanner = new Scanner(System.in);
        // Hinzufügen von Beispieldaten
        customerManager.addCustomer(new Customer("C001", "Alice Wonderland", "12345"));
        customerManager.addCustomer(new Customer("C005", "Bob The Builder", "54321"));
        customerManager.addCustomer(new Customer("C003", "Charlie Chaplin", "98765"));
        customerManager.addCustomer(new Customer("C002", "David Copperfield", "12345"));
        customerManager.addCustomer(new Customer("C004", "Eve Adams", "11223"));
        customerManager.addCustomer(new Customer("C006", "Frankenstein", "54321"));
        System.out.println("Beispieldaten geladen.");
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
                        searchCustomerLinear();
                        break;
                    case 2:
                        searchCustomerBinary();
                        break;
                    case 3:
                        filterCustomersByName();
                        break;
                    case 4:
                        filterCustomersByPostalCode();
                        break;
                    case 5:
                        listAllCustomers();
                        break;
                    case 6:
                        sortAndListCustomersByName();
                        break;
                    case 7:
                        sortAndListCustomersByPostalCode();
                        break;
                    case 0:
                        System.out.println("Anwendung wird beendet. Auf Wiedersehen!");
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
        System.out.println("--- Kundendaten-Manager ---");
        System.out.println("1. Kunde nach ID suchen (Lineare Suche)");
        System.out.println("2. Kunde nach ID suchen (Binäre Suche)");
        System.out.println("3. Kunden nach Namen filtern");
        System.out.println("4. Kunden nach Postleitzahl filtern");
        System.out.println("5. Alle Kunden auflisten");
        System.out.println("6. Kunden nach Namen sortiert auflisten");
        System.out.println("7. Kunden nach Postleitzahl sortiert auflisten");
        System.out.println("0. Beenden");
        System.out.println("---------------------------");
    }

    /**
     * Führt eine lineare Suche nach einem Kunden anhand seiner ID durch.
     */
    private void searchCustomerLinear() {
        System.out.print("Geben Sie die Kunden-ID für die lineare Suche ein: ");
        String id = scanner.nextLine();
        Customer foundCustomer = customerManager.linearSearchById(id);
        if (foundCustomer != null) {
            System.out.println("Kunde gefunden: " + foundCustomer);
        } else {
            System.out.println("Kunde mit ID '" + id + "' nicht gefunden.");
        }
    }

    /**
     * Führt eine binäre Suche nach einem Kunden anhand seiner ID durch.
     * Hinweis: Für die binäre Suche muss die Liste sortiert sein.
     */
    private void searchCustomerBinary() {
        System.out.print("Geben Sie die Kunden-ID für die binäre Suche ein: ");
        String id = scanner.nextLine();
        Customer foundCustomer = customerManager.binarySearchById(id);
        if (foundCustomer != null) {
            System.out.println("Kunde gefunden (Binäre Suche): " + foundCustomer);
        } else {
            System.out.println("Kunde mit ID '" + id + "' nicht gefunden.");
        }
    }

    /**
     * Filtert und zeigt Kunden basierend auf einem eingegebenen Namensteil.
     */
    private void filterCustomersByName() {
        System.out.print("Geben Sie den Namen oder einen Teil des Namens ein, um Kunden zu filtern: ");
        String nameQuery = scanner.nextLine();
        List<Customer> filteredCustomers = customerManager.filterCustomersByName(nameQuery);
        displayCustomers(filteredCustomers, "nach Name gefiltert");
    }

    /**
     * Filtert und zeigt Kunden basierend auf einer eingegebenen Postleitzahl.
     */
    private void filterCustomersByPostalCode() {
        System.out.print("Geben Sie die Postleitzahl ein, um Kunden zu filtern: ");
        String postalCode = scanner.nextLine();
        List<Customer> filteredCustomers = customerManager.filterCustomersByPostalCode(postalCode);
        displayCustomers(filteredCustomers, "nach Postleitzahl gefiltert");
    }

    /**
     * Listet alle Kunden auf.
     */
    private void listAllCustomers() {
        System.out.println("\n--- Alle Kunden ---");
        displayCustomers(customerManager.getAllCustomers(), "alle");
    }

    /**
     * Listet Kunden sortiert nach Namen auf.
     */
    private void sortAndListCustomersByName() {
        System.out.println("\n--- Kunden nach Namen sortiert ---");
        displayCustomers(customerManager.sortCustomersByName(), "nach Namen sortiert");
    }

    /**
     * Listet Kunden sortiert nach Postleitzahl auf.
     */
    private void sortAndListCustomersByPostalCode() {
        System.out.println("\n--- Kunden nach Postleitzahl sortiert ---");
        displayCustomers(customerManager.sortCustomersByPostalCode(), "nach Postleitzahl sortiert");
    }

    /**
     * Hilfsmethode zum Anzeigen einer Liste von Kunden.
     *
     * @param customersToDisplay Die Liste der anzuzeigenden Kunden.
     * @param description Eine Beschreibung, was angezeigt wird (z.B. "alle", "nach Name gefiltert").
     */
    private void displayCustomers(List<Customer> customersToDisplay, String description) {
        if (customersToDisplay.isEmpty()) {
            System.out.println("Keine Kunden " + description + " gefunden.");
        } else {
            customersToDisplay.forEach(System.out::println);
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