package termin1.Uebungen.src;

import java.util.Arrays;

public class SortLoesungen2 {
    
    /**
     * Aufgabe 2: Insertion Sort
     * Schreiben Sie eine Java-Methode namens `insertionSort`, die ein gegebenes Array
     * von ganzen Zahlen mithilfe des Insertion-Sort-Algorithmus aufsteigend sortiert.
     *
     * Hinweis: Insertion Sort funktioniert, indem es das Array schrittweise aufbaut.
     * Es nimmt ein Element nach dem anderen und fügt es an der richtigen Position
     * im bereits sortierten Teil des Arrays ein.
     */
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Bewege Elemente von arr[0..i-1], die größer als key sind,
               um eine Position nach vorne von ihrer aktuellen Position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] zahlen = {5, 1, 4, 2, 8};
        System.out.println("Unsortiertes Array: " + Arrays.toString(zahlen)); // Ausgabe: Unsortiertes Array: [5, 1, 4, 2, 8]
        insertionSort(zahlen);
        System.out.println("Sortiertes Array: " + Arrays.toString(zahlen));   // Ausgabe: Sortiertes Array: [1, 2, 4, 5, 8]

        int[] zahlen2 = {10, 5, 8, 20, 1, 7};
        System.out.println("Unsortiertes Array: " + Arrays.toString(zahlen2)); // Ausgabe: Unsortiertes Array: [10, 5, 8, 20, 1, 7]
        insertionSort(zahlen2);
        System.out.println("Sortiertes Array: " + Arrays.toString(zahlen2));  // Ausgabe: Sortiertes Array: [1, 5, 7, 8, 10, 20]
    }
}
