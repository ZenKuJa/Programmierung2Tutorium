package termin1.Uebungen.src;

public class RecursionUebung3 {

    /**
     * Aufgabe 3: Palindrom-Prüfung
     * Schreiben Sie eine rekursive Java-Methode namens `istPalindrom`, die überprüft,
     * ob eine gegebene Zeichenkette ein Palindrom ist oder nicht. Ein Palindrom ist
     * eine Zeichenkette, die vorwärts und rückwärts gelesen gleich ist (z.B. "racecar", "level").
     *
     * Hinweis: Achten Sie darauf, Groß- und Kleinschreibung zu ignorieren und eventuelle
     * Leerzeichen oder Satzzeichen zu entfernen, bevor Sie die Palindrom-Prüfung durchführen
     * (optional, aber macht die Aufgabe interessanter). Konzentrieren Sie sich aber zunächst
     * auf die reine Rekursion der Zeichenkette selbst.
     */
    public static boolean istPalindrom(String text) {

    }

    public static void main(String[] args) {
        String wort1 = "racecar";
        String wort2 = "hello";
        System.out.println("\"" + wort1 + "\" ist ein Palindrom: " + istPalindrom(wort1));
        System.out.println("\"" + wort2 + "\" ist ein Palindrom: " + istPalindrom(wort2));
    }
}
