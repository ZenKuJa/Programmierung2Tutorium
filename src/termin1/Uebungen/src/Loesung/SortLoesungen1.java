package termin1.Uebungen.src;

import java.util.Arrays;

public class SortLoesungen1 {
    
    /**
     * Aufgabe 1: Bubble Sort
     * Schreiben Sie eine Java-Methode namens `bubbleSort`, die ein gegebenes Array
     * von ganzen Zahlen mithilfe des Bubble-Sort-Algorithmus aufsteigend sortiert.
     *
     * Hinweis: Bubble Sort funktioniert, indem es wiederholt benachbarte Elemente
     * vergleicht und sie vertauscht, wenn sie in der falschen Reihenfolge sind.
     * Größere Elemente "blubbern" dadurch langsam ans Ende des Arrays.
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Vertausche arr[j] und arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // Wenn im inneren Durchlauf keine Vertauschungen stattgefunden haben,
            // ist das Array bereits sortiert.
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] zahlen = {5, 1, 4, 2, 8};
        System.out.println("Unsortiertes Array: " + Arrays.toString(zahlen)); // Ausgabe: Unsortiertes Array: [5, 1, 4, 2, 8]
        bubbleSort(zahlen);
        System.out.println("Sortiertes Array: " + Arrays.toString(zahlen));   // Ausgabe: Sortiertes Array: [1, 2, 4, 5, 8]

        int[] zahlen2 = {10, 5, 8, 20, 1, 7};
        System.out.println("Unsortiertes Array: " + Arrays.toString(zahlen2)); // Ausgabe: Unsortiertes Array: [10, 5, 8, 20, 1, 7]
        bubbleSort(zahlen2);
        System.out.println("Sortiertes Array: " + Arrays.toString(zahlen2));  // Ausgabe: Sortiertes Array: [1, 5, 7, 8, 10, 20]
    }
}
