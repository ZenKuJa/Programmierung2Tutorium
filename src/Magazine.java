/**
 * Repräsentiert eine Zeitschrift als spezifischen Medientyp.
 * Erweitert die abstrakte Klasse Medium.
 */
public class Magazine extends Medium {
    private int issueNumber;
    private int publicationYear;

    /**
     * Konstruktor für eine neue Zeitschrift.
     *
     * @param title Der Titel der Zeitschrift.
     * @param isbn Die ISBN der Zeitschrift (kann auch eine ISSN sein, wird hier aber als ISBN behandelt).
     * @param issueNumber Die Ausgabennummer der Zeitschrift.
     * @param publicationYear Das Erscheinungsjahr der Zeitschrift.
     * @throws IllegalArgumentException wenn Ausgabennummer oder Erscheinungsjahr ungültig sind.
     */
    public Magazine(String title, String isbn, int issueNumber, int publicationYear) {
        super(title, isbn); // Ruft den Konstruktor der Basisklasse auf
        if (issueNumber <= 0) {
            throw new IllegalArgumentException("Ausgabennummer muss positiv sein.");
        }
        if (publicationYear <= 0) {
            throw new IllegalArgumentException("Erscheinungsjahr muss positiv sein.");
        }
        this.issueNumber = issueNumber;
        this.publicationYear = publicationYear;
    }

    /**
     * Gibt die Ausgabennummer der Zeitschrift zurück.
     * @return Die Ausgabennummer.
     */
    public int getIssueNumber() {
        return issueNumber;
    }

    /**
     * Gibt das Erscheinungsjahr der Zeitschrift zurück.
     * @return Das Erscheinungsjahr.
     */
    public int getPublicationYear() {
        return publicationYear;
    }

    /**
     * Setzt die Ausgabennummer der Zeitschrift.
     * @param issueNumber Die neue Ausgabennummer.
     * @throws IllegalArgumentException wenn die Ausgabennummer ungültig ist.
     */
    public void setIssueNumber(int issueNumber) {
        if (issueNumber <= 0) {
            throw new IllegalArgumentException("Ausgabennummer muss positiv sein.");
        }
        this.issueNumber = issueNumber;
    }

    /**
     * Setzt das Erscheinungsjahr der Zeitschrift.
     * @param publicationYear Das neue Erscheinungsjahr.
     * @throws IllegalArgumentException wenn das Erscheinungsjahr ungültig ist.
     */
    public void setPublicationYear(int publicationYear) {
        if (publicationYear <= 0) {
            throw new IllegalArgumentException("Erscheinungsjahr muss positiv sein.");
        }
        this.publicationYear = publicationYear;
    }

    /**
     * Gibt eine String-Darstellung der Zeitschrift zurück.
     * @return Eine formatierte String-Darstellung der Zeitschrift.
     */
    @Override
    public String toString() {
        return "Zeitschrift - Titel: '" + getTitle() + "', Ausgabe: " + issueNumber +
               ", Jahr: " + publicationYear + ", ISBN: " + getIsbn();
    }
}