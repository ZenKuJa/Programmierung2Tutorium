package termin1.Uebungen.src;

public class SearchExercise1 {
    /**
     * Aufgabe 1: Lineare Suche
     * Schreiben Sie eine Java-Methode namens `lineareSuche`, die in einem gegebenen
     * Array von ganzen Zahlen nach einem bestimmten Zielwert sucht. Die Methode soll
     * den Index des ersten Vorkommens des Zielwerts zurückgeben. Wenn der Zielwert
     * nicht im Array vorhanden ist, soll die Methode -1 zurückgeben.
     *
     * Hinweis: Die lineare Suche überprüft jedes Element des Arrays sequenziell,
     * bis der Zielwert gefunden wird oder das Ende des Arrays erreicht ist.
     */
    public static int lineareSuche(int[] arr, int ziel) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ziel) {
                return i; // Zielwert gefunden, gib den Index zurück
            }
        }
        return -1; // Zielwert nicht gefunden
    }

    public static void main(String[] args) {
        int[] zahlen = {2, 7, 1, 9, 4, 6};
        int gesucht = 9;
        int index = lineareSuche(zahlen, gesucht);
        if (index != -1) {
            System.out.println("Der Zielwert " + gesucht + " wurde an Index " + index + " gefunden."); // Ausgabe: Der Zielwert 9 wurde an Index 3 gefunden.
        } else {
            System.out.println("Der Zielwert " + gesucht + " wurde im Array nicht gefunden.");
        }

        gesucht = 3;
        index = lineareSuche(zahlen, gesucht);
        if (index != -1) {
            System.out.println("Der Zielwert " + gesucht + " wurde an Index " + index + " gefunden.");
        } else {
            System.out.println("Der Zielwert " + gesucht + " wurde im Array nicht gefunden."); // Ausgabe: Der Zielwert 3 wurde im Array nicht gefunden.
        }
    }
}
