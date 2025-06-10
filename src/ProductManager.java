import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.InputMismatchException;

/**
 * Verwaltet eine Sammlung von Produkten.
 * Ermöglicht das Hinzufügen, Abrufen, Aktualisieren und Sortieren von Produkten.
 */
public class ProductManager {
    // Verwendet eine HashMap für schnellen Zugriff auf Produkte mittels ihrer ID.
    private Map<String, Product> products;

    /**
     * Konstruktor für den ProductManager. Initialisiert die Produkt-Map.
     */
    public ProductManager() {
        this.products = new HashMap<>();
    }

    /**
     * Fügt ein Produkt zum Manager hinzu.
     * Wenn ein Produkt mit der gleichen ID bereits existiert, wird es nicht hinzugefügt.
     *
     * @param product Das hinzuzufügende Produkt.
     * @return True, wenn das Produkt erfolgreich hinzugefügt wurde, false sonst (ID bereits vorhanden).
     */
    public boolean addProduct(Product product) {
        if (products.containsKey(product.getId())) {
            return false; // Produkt mit dieser ID existiert bereits
        }
        products.put(product.getId(), product);
        return true;
    }

    /**
     * Ruft ein Produkt anhand seiner ID ab.
     *
     * @param id Die ID des abzurufenden Produkts.
     * @return Das Produkt, falls gefunden, sonst null.
     */
    public Product getProduct(String id) {
        return products.get(id);
    }

    /**
     * Aktualisiert den Preis eines bestehenden Produkts.
     *
     * @param id Der ID des zu aktualisierenden Produkts.
     * @param newPrice Der neue Preis für das Produkt.
     * @return True, wenn der Preis erfolgreich aktualisiert wurde, false wenn das Produkt nicht gefunden wurde.
     * @throws IllegalArgumentException wenn der neue Preis ungültig ist.
     */
    public boolean updateProductPrice(String id, double newPrice) {
        Product product = products.get(id);
        if (product != null) {
            product.setPrice(newPrice); // setPrice() hat bereits eine Validierung für den Preis
            return true;
        }
        return false; // Produkt nicht gefunden
    }

    /**
     * Gibt eine Liste aller Produkte zurück.
     *
     * @return Eine Liste aller im Manager vorhandenen Produkte.
     */
    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    /**
     * Gibt eine Liste von Produkten zurück, sortiert nach dem angegebenen Comparator.
     * Lambda-Ausdrücke können hier für flexible Sortierlogiken verwendet werden.
     *
     * @param comparator Der Comparator, der die Sortierlogik definiert.
     * @return Eine sortierte Liste von Produkten.
     */
    public List<Product> getSortedProducts(Comparator<Product> comparator) {
        List<Product> sortedProducts = new ArrayList<>(products.values());
        Collections.sort(sortedProducts, comparator);
        return sortedProducts;
    }
}