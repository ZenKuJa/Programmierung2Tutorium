import java.io.Serializable; // Notwendig für die Dateiserialisierung

/**
 * Abstrakte Basisklasse für alle Medientypen in der Bibliothek.
 * Implementiert Serializable, um Objekte in Dateien speichern zu können.
 */
public abstract class Medium implements Serializable {
    private String title;
    private String isbn; // Eindeutige Identifikationsnummer

    /**
     * Konstruktor für ein neues Medium.
     *
     * @param title Der Titel des Mediums.
     * @param isbn Die ISBN des Mediums.
     * @throws IllegalArgumentException wenn Titel oder ISBN ungültig sind.
     */
    public Medium(String title, String isbn) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Titel darf nicht leer sein.");
        }
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("ISBN darf nicht leer sein.");
        }
        this.title = title;
        this.isbn = isbn;
    }

    /**
     * Gibt den Titel des Mediums zurück.
     * @return Der Titel.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gibt die ISBN des Mediums zurück.
     * @return Die ISBN.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Setzt den Titel des Mediums.
     * @param title Der neue Titel.
     * @throws IllegalArgumentException wenn der Titel ungültig ist.
     */
    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Titel darf nicht leer sein.");
        }
        this.title = title;
    }

    /**
     * Abstrakte Methode zur Darstellung des Mediums als String.
     * Muss von den konkreten Medientypen implementiert werden.
     * @return Eine String-Darstellung des Mediums.
     */
    @Override
    public abstract String toString();

    /**
     * Überschreibt die equals-Methode, um Medien anhand ihrer ISBN zu vergleichen.
     *
     * @param obj Das Objekt, mit dem verglichen werden soll.
     * @return True, wenn die Objekte gleich sind, sonst false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Medium medium = (Medium) obj;
        return isbn.equals(medium.isbn);
    }

    /**
     * Überschreibt die hashCode-Methode, um den Hash-Code basierend auf der ISBN zu generieren.
     * @return Der Hash-Code des Mediums.
     */
    @Override
    public int hashCode() {
        return isbn.hashCode();
    }
}