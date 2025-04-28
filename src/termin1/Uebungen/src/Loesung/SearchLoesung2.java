package termin1.Uebungen.src;

import java.util.Arrays;

public class SearchExercise2 {
    
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
     *
     * Rekursionsbasis: Was sind die Abbruchbedingungen für die Rekursion?
     * Rekursiver Schritt: Wie wird der Suchraum in jedem Schritt verkleinert?
     */
    public static int binaereSuche(int[] arr, int ziel, int links, int rechts) {
        if (links > rechts) {
            return -1; // Zielwert nicht gefunden
        }

        int mitte = links + (rechts - links) / 2; // Verhindert Überlauf bei großen Indizes

        if (arr[mitte] == ziel) {
            return mitte; // Zielwert gefunden
        } else if (arr[mitte] < ziel) {
            return binaereSuche(arr, ziel, mitte + 1, rechts); // Suche im rechten Teil
        } else {
            return binaereSuche(arr, ziel, links, mitte - 1); // Suche im linken Teil
        }
    }

    // Überladene Methode für den einfachen Aufruf
    public static int binaereSuche(int[] arr, int ziel) {
        Arrays.sort(arr); // Stellen Sie sicher, dass das Array sortiert ist
        return binaereSuche(arr, ziel, 0, arr.length - 1);
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

        gesucht = 3;
        index = binaereSuche(zahlen, gesucht);
        if (index != -1) {
            System.out.println("Der Zielwert " + gesucht + " wurde an Index " + index + " gefunden.");
        } else {
            System.out.println("Der Zielwert " + gesucht + " wurde im Array nicht gefunden."); // Ausgabe: Der Zielwert 3 wurde im Array nicht gefunden.
        }
    }
}
