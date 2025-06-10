import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Kommandozeilen-Anwendung zur Demonstration der Produktverwaltung.
 * Ermöglicht das Hinzufügen, Anzeigen und Sortieren von Produkten.
 */
public class CliApp {
    private ProductManager productManager;
    private Scanner scanner;

    /**
     * Konstruktor für die CliApp.
     * Initialisiert den ProductManager und den Scanner.
     */
    public CliApp() {
        productManager = new ProductManager();
        scanner = new Scanner(System.in);
    }

    /**
     * Zeigt das Hauptmenü an und verarbeitet Benutzereingaben.
     */
    public void run() {
        int choice;
        do {
            printMenu();
            try {
                System.out.print("Wählen Sie eine Option: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Konsumiere den Rest der Zeile
                
                switch (choice) {
                    case 1:
                        addProduct();
                        break;
                    case 2:
                        listAllProducts();
                        break;
                    case 3:
                        listProductsSortedByName();
                        break;
                    case 4:
                        listProductsSortedByPrice();
                        break;
                    case 5:
                        updateProductPrice();
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
     * Zeigt die Menüoptionen an.
     */
    private void printMenu() {
        System.out.println("--- Produktverwaltung ---");
        System.out.println("1. Produkt hinzufügen");
        System.out.println("2. Alle Produkte auflisten (nach ID sortiert)");
        System.out.println("3. Produkte nach Name sortiert auflisten");
        System.out.println("4. Produkte nach Preis sortiert auflisten");
        System.out.println("5. Produktpreis aktualisieren");
        System.out.println("0. Beenden");
        System.out.println("-------------------------");
    }

    /**
     * Ermöglicht dem Benutzer, ein neues Produkt hinzuzufügen.
     * Fragt nach ID, Name und Preis des Produkts.
     */
    private void addProduct() {
        System.out.println("\n--- Produkt hinzufügen ---");
        System.out.print("Geben Sie die Produkt-ID ein: ");
        String id = scanner.nextLine();
        System.out.print("Geben Sie den Produktnamen ein: ");
        String name = scanner.nextLine();
        System.out.print("Geben Sie den Produktpreis ein: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Konsumiere den Rest der Zeile

        try {
            Product newProduct = new Product(id, name, price);
            if (productManager.addProduct(newProduct)) {
                System.out.println("Produkt '" + name + "' erfolgreich hinzugefügt.");
            } else {
                System.out.println("Fehler: Produkt mit ID '" + id + "' existiert bereits.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Fehler beim Hinzufügen des Produkts: " + e.getMessage());
        }
    }

    /**
     * Listet alle Produkte auf, standardmäßig sortiert nach ihrer ID (Comparable).
     */
    private void listAllProducts() {
        System.out.println("\n--- Alle Produkte (sortiert nach ID) ---");
        List<Product> products = productManager.getAllProducts();
        Collections.sort(products); // Nutzt die natürliche Ordnung (Comparable)
        if (products.isEmpty()) {
            System.out.println("Keine Produkte vorhanden.");
        } else {
            products.forEach(System.out::println);
        }
    }

    /**
     * Listet Produkte auf, sortiert nach ihrem Namen.
     * Verwendet einen Lambda-Ausdruck für den Comparator.
     */
    private void listProductsSortedByName() {
        System.out.println("\n--- Produkte sortiert nach Name ---");
        // Sortieren der Produkte nach Namen mithilfe eines Lambda-Ausdrucks für den Comparator
        List<Product> sortedProducts = productManager.getSortedProducts(
            (p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName())
        );
        if (sortedProducts.isEmpty()) {
            System.out.println("Keine Produkte vorhanden.");
        } else {
            sortedProducts.forEach(System.out::println);
        }
    }

    /**
     * Listet Produkte auf, sortiert nach ihrem Preis.
     * Verwendet einen Lambda-Ausdruck für den Comparator.
     */
    private void listProductsSortedByPrice() {
        System.out.println("\n--- Produkte sortiert nach Preis ---");
        // Sortieren der Produkte nach Preis mithilfe eines Lambda-Ausdrucks für den Comparator
        List<Product> sortedProducts = productManager.getSortedProducts(
            Comparator.comparingDouble(Product::getPrice)
        );
        if (sortedProducts.isEmpty()) {
            System.out.println("Keine Produkte vorhanden.");
        } else {
            sortedProducts.forEach(System.out::println);
        }
    }

    /**
     * Ermöglicht dem Benutzer, den Preis eines bestehenden Produkts zu aktualisieren.
     */
    private void updateProductPrice() {
        System.out.println("\n--- Produktpreis aktualisieren ---");
        System.out.print("Geben Sie die ID des Produkts ein, dessen Preis aktualisiert werden soll: ");
        String id = scanner.nextLine();
        System.out.print("Geben Sie den neuen Preis ein: ");
        double newPrice = scanner.nextDouble();
        scanner.nextLine(); // Konsumiere den Rest der Zeile

        try {
            if (productManager.updateProductPrice(id, newPrice)) {
                System.out.println("Preis für Produkt mit ID '" + id + "' erfolgreich auf " + String.format("%.2f", newPrice) + "€ aktualisiert.");
            } else {
                System.out.println("Fehler: Produkt mit ID '" + id + "' nicht gefunden.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Fehler beim Aktualisieren des Preises: " + e.getMessage());
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