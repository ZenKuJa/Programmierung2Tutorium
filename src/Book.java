/**
 * Repräsentiert ein Buch als spezifischen Medientyp.
 * Erweitert die abstrakte Klasse Medium.
 */
public class Book extends Medium {
    private String author;
    private int numberOfPages;

    /**
     * Konstruktor für ein neues Buch.
     *
     * @param title Der Titel des Buches.
     * @param isbn Die ISBN des Buches.
     * @param author Der Autor des Buches.
     * @param numberOfPages Die Anzahl der Seiten des Buches.
     * @throws IllegalArgumentException wenn Autor oder Seitenzahl ungültig sind.
     */
    public Book(String title, String isbn, String author, int numberOfPages) {
        super(title, isbn); // Ruft den Konstruktor der Basisklasse auf
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Autor darf nicht leer sein.");
        }
        if (numberOfPages <= 0) {
            throw new IllegalArgumentException("Anzahl der Seiten muss positiv sein.");
        }
        this.author = author;
        this.numberOfPages = numberOfPages;
    }

    /**
     * Gibt den Autor des Buches zurück.
     * @return Der Autor.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Gibt die Anzahl der Seiten des Buches zurück.
     * @return Die Anzahl der Seiten.
     */
    public int getNumberOfPages() {
        return numberOfPages;
    }

    /**
     * Setzt den Autor des Buches.
     * @param author Der neue Autor.
     * @throws IllegalArgumentException wenn der Autor ungültig ist.
     */
    public void setAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Autor darf nicht leer sein.");
        }
        this.author = author;
    }

    /**
     * Setzt die Anzahl der Seiten des Buches.
     * @param numberOfPages Die neue Anzahl der Seiten.
     * @throws IllegalArgumentException wenn die Seitenzahl ungültig ist.
     */
    public void setNumberOfPages(int numberOfPages) {
        if (numberOfPages <= 0) {
            throw new IllegalArgumentException("Anzahl der Seiten muss positiv sein.");
        }
        this.numberOfPages = numberOfPages;
    }

    /**
     * Gibt eine String-Darstellung des Buches zurück.
     * @return Eine formatierte String-Darstellung des Buches.
     */
    @Override
    public String toString() {
        return "Buch - Titel: '" + getTitle() + "', Autor: " + author +
               ", Seiten: " + numberOfPages + ", ISBN: " + getIsbn();
    }
}