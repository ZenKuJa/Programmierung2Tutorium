package termin1.Uebungen.src;

public class SearchUebung1 {
    /**
     * Aufgabe 1: Lineare Suche
     * Schreiben Sie eine Java-Methode namens `lineareSuche`, die in einem gegebenen
     * Array von ganzen Zahlen nach einem bestimmten Zielwert sucht. Die Methode soll
     * den Index des ersten Vorkommens des Zielwerts zurückgeben. Wenn der Zielwert
     * nicht im Array vorhanden ist, soll die Methode -1 zurückgeben.
     */
    public static int lineareSuche(int[] arr, int ziel) {

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
    }
}
