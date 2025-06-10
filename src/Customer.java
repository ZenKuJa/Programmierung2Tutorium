import java.util.Objects;

/**
 * Repräsentiert einen Kunden mit ID, Namen und Postleitzahl.
 * Implementiert Comparable, um Kunden nach ihrer ID zu sortieren.
 */
public class Customer implements Comparable<Customer> {
    private String id;
    private String name;
    private String postalCode; // Postleitzahl

    /**
     * Konstruktor für einen neuen Kunden.
     *
     * @param id Der eindeutige Kunden-ID.
     * @param name Der Name des Kunden.
     * @param postalCode Die Postleitzahl des Kunden.
     * @throws IllegalArgumentException wenn ID, Name oder Postleitzahl ungültig sind.
     */
    public Customer(String id, String name, String postalCode) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Kunden-ID darf nicht leer sein.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Kundenname darf nicht leer sein.");
        }
        if (postalCode == null || postalCode.trim().isEmpty()) {
            throw new IllegalArgumentException("Postleitzahl darf nicht leer sein.");
        }
        this.id = id;
        this.name = name;
        this.postalCode = postalCode;
    }

    /**
     * Gibt die Kunden-ID zurück.
     * @return Die Kunden-ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Gibt den Namen des Kunden zurück.
     * @return Der Kundenname.
     */
    public String getName() {
        return name;
    }

    /**
     * Gibt die Postleitzahl des Kunden zurück.
     * @return Die Postleitzahl.
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Vergleicht dieses Kundenobjekt mit dem angegebenen Objekt basierend auf der ID.
     * Ermöglicht die natürliche Sortierung von Kunden.
     *
     * @param otherCustomer Der Kunde, mit dem verglichen werden soll.
     * @return Ein negativer Integer, Null oder ein positiver Integer, wenn dieses Objekt
     * kleiner, gleich oder größer als das angegebene Objekt ist.
     */
    @Override
    public int compareTo(Customer otherCustomer) {
        return this.id.compareTo(otherCustomer.id);
    }

    /**
     * Überprüft, ob dieses Kundenobjekt gleich einem anderen Objekt ist.
     * Zwei Kunden sind gleich, wenn ihre IDs übereinstimmen.
     *
     * @param o Das Objekt, mit dem verglichen werden soll.
     * @return True, wenn die Objekte gleich sind, sonst false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id);
    }

    /**
     * Gibt den Hash-Code für dieses Kundenobjekt zurück.
     * Der Hash-Code basiert auf der Kunden-ID.
     *
     * @return Der Hash-Code des Kundenobjekts.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Gibt eine String-Darstellung des Kunden zurück.
     * @return Eine formatierte String-Darstellung des Kunden.
     */
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", PLZ: " + postalCode;
    }
}