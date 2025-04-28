package termin1.Uebungen.src.Loesung;

public class RecursionLoesung1 {
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
            if (n < 0) {
                throw new IllegalArgumentException("Die Fakultät ist für negative Zahlen nicht definiert.");
            }
            if (n == 0) {
                return 1;
            } else {
                return n * fakultaet(n - 1);
            }
        }
    
        public static void main(String[] args) {
            int zahl = 5;
            long ergebnis = fakultaet(zahl);
            System.out.println("Die Fakultät von " + zahl + " ist: " + ergebnis);
        }
}
