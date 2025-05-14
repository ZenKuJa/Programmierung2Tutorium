package src;

public class ExerciseRecursion1 {
    /** 
     * Aufgabe 1: Fakultät
     * Schreiben Sie eine rekursive Java-Methode namens `fakultaet`, die die Fakultät
     * einer gegebenen nicht-negativen ganzen Zahl `n` berechnet.
     *
     * Hinweis: Die Fakultät von `n` (geschrieben als n!) ist das Produkt aller
     * positiven ganzen Zahlen kleiner oder gleich `n`. Zum Beispiel ist 5! = 5 * 4 * 3 * 2 * 1 = 120.
     * Die Fakultät von 0 ist per Definition 1.
     */
    public static long fakultaet(int n) {
        
    }

    public static void main(String[] args) {
        int zahl = 5;
        long ergebnis = fakultaet(zahl);
        System.out.println("Die Fakultät von " + zahl + " ist: " + ergebnis);
    }
}
