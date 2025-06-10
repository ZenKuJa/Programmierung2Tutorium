import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Verwaltet eine Liste von Kunden und bietet Such- und Filterfunktionen.
 * Nutzt Listen, Suchalgorithmen und Streams für effiziente Operationen.
 */
public class CustomerManager {
    // Liste zur Speicherung der Kundendaten.
    private List<Customer> customers;

    /**
     * Konstruktor für den CustomerManager.
     * Initialisiert die Liste der Kunden.
     */
    public CustomerManager() {
        this.customers = new ArrayList<>();
    }

    /**
     * Fügt einen Kunden zur Liste hinzu.
     * Stellt sicher, dass keine Kunden mit doppelten IDs hinzugefügt werden.
     *
     * @param customer Der hinzuzufügende Kunde.
     * @return True, wenn der Kunde erfolgreich hinzugefügt wurde, false sonst (ID bereits vorhanden).
     */
    public boolean addCustomer(Customer customer) {
        // Überprüft, ob ein Kunde mit derselben ID bereits existiert.
        if (customers.contains(customer)) {
            return false;
        }
        return customers.add(customer);
    }

    /**
     * Gibt eine unveränderliche Liste aller Kunden zurück.
     *
     * @return Eine Liste aller Kunden.
     */
    public List<Customer> getAllCustomers() {
        // Eine neue ArrayList zurückgeben, um die interne Liste vor externen Änderungen zu schützen.
        return new ArrayList<>(customers);
    }

    /**
     * Sucht einen Kunden anhand seiner ID mithilfe einer Linearen Suche.
     * Diese Methode ist O(n), d.h. sie ist für kleine Listen akzeptabel,
     * aber bei großen Listen kann sie ineffizient sein.
     *
     * @param customerId Die ID des gesuchten Kunden.
     * @return Der gefundene Kunde, oder null, wenn kein Kunde mit dieser ID existiert.
     */
    public Customer linearSearchById(String customerId) {
        for (Customer customer : customers) {
            if (customer.getId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }

    /**
     * Sucht einen Kunden anhand seiner ID mithilfe einer Binären Suche.
     * Voraussetzung: Die Liste der Kunden muss nach ID sortiert sein.
     * Diese Methode ist O(log n), d.h. sehr effizient für große, sortierte Listen.
     *
     * @param customerId Die ID des gesuchten Kunden.
     * @return Der gefundene Kunde, oder null, wenn kein Kunde mit dieser ID existiert.
     */
    public Customer binarySearchById(String customerId) {
        // Zuerst sicherstellen, dass die Liste nach ID sortiert ist.
        // In einer echten Anwendung würde man die Liste entweder persistent sortiert halten
        // oder diese Sortierung nur einmalig bei Bedarf durchführen, um Performance zu sparen.
        List<Customer> sortedCustomers = new ArrayList<>(customers); // Kopie erstellen, um Original nicht zu ändern
        Collections.sort(sortedCustomers); // Sortiert nach der natürlichen Ordnung (ID)

        int low = 0;
        int high = sortedCustomers.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            Customer midCustomer = sortedCustomers.get(mid);
            int cmp = customerId.compareTo(midCustomer.getId());

            if (cmp == 0) {
                return midCustomer; // Kunde gefunden
            } else if (cmp < 0) {
                high = mid - 1; // Suche in der linken Hälfte
            } else {
                low = mid + 1; // Suche in der rechten Hälfte
            }
        }
        return null; // Kunde nicht gefunden
    }

    /**
     * Filtert Kunden nach einem Teil des Namens (Case-Insensitive).
     * Nutzt Java Streams für eine moderne und flexible Filterung.
     *
     * @param nameQuery Der Suchbegriff für den Namen.
     * @return Eine Liste von Kunden, deren Namen den Suchbegriff enthalten.
     */
    public List<Customer> filterCustomersByName(String nameQuery) {
        if (nameQuery == null || nameQuery.trim().isEmpty()) {
            return new ArrayList<>(); // Leere Liste zurückgeben, wenn der Suchbegriff leer ist
        }
        String lowerCaseQuery = nameQuery.toLowerCase();
        return customers.stream()
                        .filter(customer -> customer.getName().toLowerCase().contains(lowerCaseQuery))
                        .collect(Collectors.toList());
    }

    /**
     * Filtert Kunden nach einer exakten Postleitzahl.
     * Nutzt Java Streams.
     *
     * @param postalCode Die gesuchte Postleitzahl.
     * @return Eine Liste von Kunden mit der angegebenen Postleitzahl.
     */
    public List<Customer> filterCustomersByPostalCode(String postalCode) {
        if (postalCode == null || postalCode.trim().isEmpty()) {
            return new ArrayList<>();
        }
        return customers.stream()
                        .filter(customer -> customer.getPostalCode().equals(postalCode))
                        .collect(Collectors.toList());
    }

    /**
     * Sortiert die Kundenliste nach dem Namen.
     *
     * @return Eine neue Liste mit den nach Namen sortierten Kunden.
     */
    public List<Customer> sortCustomersByName() {
        return customers.stream()
                        .sorted(Comparator.comparing(Customer::getName))
                        .collect(Collectors.toList());
    }

    /**
     * Sortiert die Kundenliste nach der Postleitzahl.
     *
     * @return Eine neue Liste mit den nach Postleitzahl sortierten Kunden.
     */
    public List<Customer> sortCustomersByPostalCode() {
        return customers.stream()
                        .sorted(Comparator.comparing(Customer::getPostalCode))
                        .collect(Collectors.toList());
    }
}