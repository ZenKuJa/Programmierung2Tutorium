import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional; // Für die optionale Rückgabe bei der Suche

/**
 * Verwaltet den Bestand an Medien in der Bibliothek.
 * Nutzt Generics für die Speicherung verschiedener Medientypen.
 * Ermöglicht das Speichern und Laden des Bestands aus einer Datei.
 */
public class Library<T extends Medium> { // T ist ein Typparameter, der auf Medium beschränkt ist
    // Verwendet eine ArrayList, um die Medienobjekte im Arbeitsspeicher zu speichern.
    private List<T> mediaList;
    private final String filename; // Dateiname für die Persistenz

    /**
     * Konstruktor für die Bibliothek.
     *
     * @param filename Der Dateiname, unter dem die Bibliotheksdaten gespeichert/geladen werden.
     */
    public Library(String filename) {
        this.mediaList = new ArrayList<>();
        this.filename = filename;
    }

    /**
     * Fügt ein Medium zur Bibliothek hinzu.
     * Es wird überprüft, ob ein Medium mit derselben ISBN bereits existiert.
     *
     * @param medium Das hinzuzufügende Medium.
     * @return True, wenn das Medium erfolgreich hinzugefügt wurde, false sonst (ISBN bereits vorhanden).
     */
    public boolean addMedium(T medium) {
        // Überprüft, ob bereits ein Medium mit dieser ISBN existiert
        if (mediaList.stream().anyMatch(m -> m.getIsbn().equals(medium.getIsbn()))) {
            return false; // Medium mit dieser ISBN existiert bereits
        }
        return mediaList.add(medium);
    }

    /**
     * Entfernt ein Medium anhand seiner ISBN aus der Bibliothek.
     *
     * @param isbn Die ISBN des zu entfernenden Mediums.
     * @return True, wenn das Medium gefunden und entfernt wurde, false sonst.
     */
    public boolean removeMedium(String isbn) {
        return mediaList.removeIf(medium -> medium.getIsbn().equals(isbn));
    }

    /**
     * Sucht ein Medium anhand seiner ISBN.
     *
     * @param isbn Die ISBN des zu suchenden Mediums.
     * @return Ein Optional, das das Medium enthält, falls gefunden, ansonsten ein leeres Optional.
     */
    public Optional<T> findMediumByIsbn(String isbn) {
        return mediaList.stream()
                        .filter(medium -> medium.getIsbn().equals(isbn))
                        .findFirst();
    }

    /**
     * Gibt eine unveränderliche Liste aller Medien in der Bibliothek zurück.
     *
     * @return Eine Liste aller Medien.
     */
    public List<T> getAllMedia() {
        // Eine neue ArrayList zurückgeben, um die interne Liste vor externen Änderungen zu schützen.
        return new ArrayList<>(mediaList);
    }

    /**
     * Speichert den aktuellen Bibliotheksbestand in einer Datei.
     * Verwendet ObjectOutputStream für die Serialisierung.
     *
     * @throws IOException Wenn ein Fehler beim Schreiben der Datei auftritt.
     */
    public void saveLibrary() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(mediaList);
            System.out.println("Bibliotheksbestand erfolgreich in '" + filename + "' gespeichert.");
        }
    }

    /**
     * Lädt den Bibliotheksbestand aus einer Datei.
     * Verwendet ObjectInputStream für die Deserialisierung.
     *
     * @throws IOException Wenn ein Fehler beim Lesen der Datei auftritt.
     * @throws ClassNotFoundException Wenn die Klasse eines geladenen Objekts nicht gefunden wird.
     */
    @SuppressWarnings("unchecked") // Unterdrückt die Warnung für ungeprüfte Typumwandlung
    public void loadLibrary() throws IOException, ClassNotFoundException {
        File file = new File(filename);
        if (!file.exists() || file.length() == 0) {
            System.out.println("Keine vorhandene Bibliotheksdatei gefunden oder Datei ist leer. Starte mit leerem Bestand.");
            mediaList = new ArrayList<>(); // Starte mit einer leeren Liste
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            // Wir wissen, dass wir eine Liste von Objekten vom Typ T (extends Medium) speichern.
            // Daher ist diese ungeprüfte Umwandlung sicher.
            mediaList = (List<T>) ois.readObject();
            System.out.println("Bibliotheksbestand erfolgreich aus '" + filename + "' geladen.");
        } catch (FileNotFoundException e) {
            System.out.println("Bibliotheksdatei '" + filename + "' nicht gefunden. Starte mit leerem Bestand.");
            mediaList = new ArrayList<>(); // Starte mit einer leeren Liste
        }
    }
}