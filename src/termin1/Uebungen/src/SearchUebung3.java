package termin1.Uebungen.src;

import java.util.Arrays;

public class SearchUebung3 {
     /**
     * Aufgabe 3: Interpolationssuche
     * Schreiben Sie eine Java-Methode namens `interpolationsSuche`, die in einem
     * **sortierten** Array von ganzen Zahlen nach einem bestimmten Zielwert sucht.
     * Die Methode soll den Index des Zielwerts zurückgeben, wenn er gefunden wird,
     * und -1, wenn er nicht vorhanden ist.
     *
     * Hinweis: Die Interpolationssuche ist eine Verbesserung der binären Suche für
     * gleichmäßig verteilte Daten. Anstatt immer die Mitte zu wählen, schätzt sie die
     * Position des Zielwerts basierend auf seinem Wert im Vergleich zu den Randwerten
     * des aktuellen Suchbereichs.
     *
     * Formel zur Schätzung der Position:
     * pos = links + ((ziel - arr[links]) * (rechts - links)) / (arr[rechts] - arr[links])
     */
    public static int interpolationsSuche(int[] arr, int ziel, int links, int rechts) {

    }

    // Überladene Methode für den einfachen Aufruf
    public static int interpolationsSuche(int[] arr, int ziel) {
        
    }

    public static void main(String[] args) {
        int[] zahlen = {2, 4, 6, 8, 10, 12}; // Gleichmäßig verteilte Daten
        int gesucht = 10;
        int index = interpolationsSuche(zahlen, gesucht);
        if (index != -1) {
            System.out.println("Der Zielwert " + gesucht + " wurde an Index " + index + " gefunden."); // Ausgabe: Der Zielwert 10 wurde an Index 4 gefunden.
        } else {
            System.out.println("Der Zielwert " + gesucht + " wurde im Array nicht gefunden.");
        }
    }
}
