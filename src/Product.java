import java.util.Objects;

/**
 * Repräsentiert ein Produkt mit einer eindeutigen ID, einem Namen und einem Preis.
 * Implementiert Comparable, um Produkte standardmäßig nach ihrer ID zu sortieren.
 */
public class Product implements Comparable<Product> {
    private String id;
    private String name;
    private double price;

    /**
     * Konstruktor für ein neues Produkt.
     *
     * @param id Die eindeutige Produkt-ID.
     * @param name Der Name des Produkts.
     * @param price Der Preis des Produkts.
     * @throws IllegalArgumentException wenn ID, Name oder Preis ungültig sind.
     */
    public Product(String id, String name, double price) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Produkt-ID darf nicht leer sein.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Produktname darf nicht leer sein.");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Produktpreis muss positiv sein.");
        }
        this.id = id;
        this.name = name;
        this.price = price;
    }

    /**
     * Gibt die Produkt-ID zurück.
     * @return Die Produkt-ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Gibt den Produktnamen zurück.
     * @return Der Produktname.
     */
    public String getName() {
        return name;
    }

    /**
     * Gibt den Produktpreis zurück.
     * @return Der Produktpreis.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setzt den Preis des Produkts.
     * @param price Der neue Preis des Produkts.
     * @throws IllegalArgumentException wenn der Preis ungültig ist.
     */
    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Produktpreis muss positiv sein.");
        }
        this.price = price;
    }

    /**
     * Vergleicht dieses Produkt mit dem angegebenen Produkt basierend auf der ID.
     *
     * @param otherProduct Das Produkt, mit dem verglichen werden soll.
     * @return Ein negativer Integer, Null oder ein positiver Integer, wenn dieses Objekt
     * kleiner, gleich oder größer als das angegebene Objekt ist.
     */
    @Override
    public int compareTo(Product otherProduct) {
        return this.id.compareTo(otherProduct.id);
    }

    /**
     * Gibt eine String-Darstellung des Produkts zurück.
     * @return Eine formatierte String-Darstellung des Produkts.
     */
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Preis: " + String.format("%.2f", price) + "€";
    }

    /**
     * Überprüft, ob dieses Produkt gleich einem anderen Objekt ist.
     * Zwei Produkte sind gleich, wenn ihre IDs übereinstimmen.
     *
     * @param o Das Objekt, mit dem verglichen werden soll.
     * @return True, wenn die Objekte gleich sind, sonst false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    /**
     * Gibt den Hash-Code für dieses Produkt zurück.
     * Der Hash-Code basiert auf der Produkt-ID.
     *
     * @return Der Hash-Code des Produkts.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}