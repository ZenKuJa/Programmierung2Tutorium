package termin1.Uebungen.src;

public class RecursionUebung2 {

    /**
     * Aufgabe 2: Fibonacci-Folge
     * Schreiben Sie eine rekursive Java-Methode namens `fibonacci`, die das n-te
     * Element der Fibonacci-Folge berechnet.
     *
     * Hinweis: Die Fibonacci-Folge beginnt mit 0 und 1, und jedes nachfolgende
     * Element ist die Summe der beiden vorhergehenden. Die Folge beginnt also so:
     * 0, 1, 1, 2, 3, 5, 8, 13, ...
     */
    public static int fibonacci(int n) {

    }

    public static void main(String[] args) {
        int index = 7;
        int ergebnis = fibonacci(index);
        System.out.println("Das " + index + "-te Element der Fibonacci-Folge ist: " + ergebnis);
    }
}
