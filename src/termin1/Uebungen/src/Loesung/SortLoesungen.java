package termin1.Uebungen.src;

import java.util.Arrays;

public class SortUebungen3 {
    /**
     * Aufgabe 3: Quick Sort
     * Schreiben Sie eine rekursive Java-Methode namens `quickSort`, die ein gegebenes
     * Array von ganzen Zahlen mithilfe des Quick-Sort-Algorithmus aufsteigend sortiert.
     *
     * Hinweis: Quick Sort ist ein Divide-and-Conquer-Algorithmus. Er wählt ein
     * "Pivot"-Element aus dem Array aus und partitioniert die anderen Elemente in
     * zwei Sub-Arrays, entsprechend kleiner oder größer als das Pivot. Die Sub-Arrays
     * werden dann rekursiv sortiert.
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Finde den Pivot-Index, arr[p] ist nun an der richtigen Position
            int p = partition(arr, low, high);

            // Sortiere Elemente vor und nach dem Pivot rekursiv
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // Index des kleineren Elements
        for (int j = low; j < high; j++) {
            // Wenn das aktuelle Element kleiner oder gleich dem Pivot ist
            if (arr[j] <= pivot) {
                i++;

                // Vertausche arr[i] und arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Vertausche arr[i+1] und arr[high] (Pivot an die richtige Position)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Überladene Methode für den einfachen Aufruf
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] zahlen = {5, 1, 4, 2, 8};
        System.out.println("Unsortiertes Array: " + Arrays.toString(zahlen)); // Ausgabe: Unsortiertes Array: [5, 1, 4, 2, 8]
        quickSort(zahlen);
        System.out.println("Sortiertes Array: " + Arrays.toString(zahlen));   // Ausgabe: Sortiertes Array: [1, 2, 4, 5, 8]

        int[] zahlen2 = {10, 5, 8, 20, 1, 7};
        System.out.println("Unsortiertes Array: " + Arrays.toString(zahlen2)); // Ausgabe: Unsortiertes Array: [10, 5, 8, 20, 1, 7]
        quickSort(zahlen2);
        System.out.println("Sortiertes Array: " + Arrays.toString(zahlen2));  // Ausgabe: Sortiertes Array: [1, 5, 7, 8, 10, 20]
    }
}
