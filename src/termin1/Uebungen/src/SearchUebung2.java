package termin1.Uebungen.src;

import java.util.Arrays;

public class SearchUebung2 {
    
    /**
     * Aufgabe 2: Binäre Suche
     * Schreiben Sie eine rekursive Java-Methode namens `binaereSuche`, die in einem
     * **sortierten** Array von ganzen Zahlen nach einem bestimmten Zielwert sucht.
     * Die Methode soll den Index des Zielwerts zurückgeben, wenn er gefunden wird,
     * und -1, wenn er nicht vorhanden ist.
     *
     * Hinweis: Die binäre Suche funktioniert nur auf sortierten Arrays. Sie vergleicht
     * den Zielwert mit dem mittleren Element des Arrays. Abhängig vom Ergebnis wird
     * die Suche im linken oder rechten Teil des Arrays fortgesetzt.
     */
    public static int binaereSuche(int[] arr, int ziel, int links, int rechts) {

    }

    // Überladene Methode für den einfachen Aufruf
    public static int binaereSuche(int[] arr, int ziel) {

    }

    public static void main(String[] args) {
        int[] zahlen = {2, 7, 1, 9, 4, 6};
        Arrays.sort(zahlen); // Sortiere das Array vor der binären Suche
        int gesucht = 6;
        int index = binaereSuche(zahlen, gesucht);
        if (index != -1) {
            System.out.println("Der Zielwert " + gesucht + " wurde an Index " + index + " gefunden."); // Ausgabe: Der Zielwert 6 wurde an Index 3 gefunden.
        } else {
            System.out.println("Der Zielwert " + gesucht + " wurde im Array nicht gefunden.");
        }
    }
}
