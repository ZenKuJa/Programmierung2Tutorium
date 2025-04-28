package termin1.Uebungen.src.Loesung;

public class RecursionLoesung2 {

    /**
     * Aufgabe 2: Fibonacci-Folge
     * Schreiben Sie eine rekursive Java-Methode namens `fibonacci`, die das n-te
     * Element der Fibonacci-Folge berechnet.
     *
     * Hinweis: Die Fibonacci-Folge beginnt mit 0 und 1, und jedes nachfolgende
     * Element ist die Summe der beiden vorhergehenden. Die Folge beginnt also so:
     * 0, 1, 1, 2, 3, 5, 8, 13, ...
     *
     * Rekursionsbasis: Was sind die ersten beiden Elemente der Folge, die Sie direkt zurückgeben können?
     * Rekursiver Schritt: Wie können Sie das n-te Fibonacci-Element mithilfe der vorherigen Elemente berechnen?
     */
    public static int fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Der Index der Fibonacci-Folge muss nicht-negativ sein.");
        }
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        int index = 7;
        int ergebnis = fibonacci(index);
        System.out.println("Das " + index + "-te Element der Fibonacci-Folge ist: " + ergebnis);
    }
}
