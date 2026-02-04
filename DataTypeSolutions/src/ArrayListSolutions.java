package src;

import java.util.ArrayList;

// SOLUTIONS
public class ArrayListSolutions {
    public static void main(String[] args) {

        // ======================================
        // ARRAYS – GRUNDLAGEN
        // ======================================

        // AUFGABE 1:
        // - Lege ein int-Array "noten" mit der Größe 5 an.
        // - Speichere die Werte 1, 2, 3, 2, 1 darin.
        int[] noten = {1, 2, 3, 2, 1};

        System.out.println("Note an Position 0: " + noten[0]);


        // AUFGABE 2:
        // - Lege ein String-Array "tage" mit der Größe 7 an.
        // - Speichere die Wochentage Montag bis Sonntag darin.
        String[] tage = {
                "Montag", "Dienstag", "Mittwoch",
                "Donnerstag", "Freitag", "Samstag", "Sonntag"
        };

        System.out.println("Erster Tag: " + tage[0]);
        System.out.println("Letzter Tag: " + tage[6]);


        // AUFGABE 3:
        // - Lege ein double-Array "temperaturen" mit 3 Werten an.
        // - Speichere 12.5, 15.0 und 9.8 darin.
        double[] temperaturen = {12.5, 15.0, 9.8};

        System.out.println("Temperatur mittags: " + temperaturen[1]);


        // AUFGABE 4:
        // - Lege ein boolean-Array "anwesenheit" mit der Größe 4 an.
        // - Setze die Werte auf true, true, false, true.
        boolean[] anwesenheit = {true, true, false, true};

        System.out.println("Anwesenheit Person 3: " + anwesenheit[2]);


        // AUFGABE 5:
        // - Lege ein char-Array "initialen" mit 3 Buchstaben an.
        // - Speichere z.B. 'A', 'B', 'C' darin.
        char[] initialen = {'A', 'B', 'C'};

        System.out.println("Zweites Initial: " + initialen[1]);


        // ======================================
        // ARRAYS – MIT SCHLEIFEN
        // ======================================

        // AUFGABE 6:
        // - Gib alle Werte des Arrays "noten" mit einer for-Schleife aus.
        for (int i = 0; i < noten.length; i++) {
            System.out.println("Note " + i + ": " + noten[i]);
        }


        // AUFGABE 7:
        // - Berechne die Summe aller Werte im Array "noten".
        int summe = 0;
        for (int i = 0; i < noten.length; i++) {
            summe += noten[i];
        }

        System.out.println("Summe der Noten: " + summe);


        // AUFGABE 8:
        // - Finde den höchsten Wert im Array "temperaturen".
        double maxTemperatur = temperaturen[0];
        for (int i = 1; i < temperaturen.length; i++) {
            if (temperaturen[i] > maxTemperatur) {
                maxTemperatur = temperaturen[i];
            }
        }

        System.out.println("Höchste Temperatur: " + maxTemperatur);


        // ======================================
        // ARRAYLIST – GRUNDLAGEN
        // ======================================

        // AUFGABE 9:
        // - Lege eine ArrayList "namen" für Strings an.
        // - Füge drei Namen hinzu.
        ArrayList<String> namen = new ArrayList<>();
        namen.add("Anna");
        namen.add("Ben");
        namen.add("Clara");

        System.out.println("Erster Name: " + namen.get(0));


        // AUFGABE 10:
        // - Lege eine ArrayList "zahlen" für Integer an.
        // - Füge die Zahlen 5, 10 und 15 hinzu.
        ArrayList<Integer> zahlen = new ArrayList<>();
        zahlen.add(5);
        zahlen.add(10);
        zahlen.add(15);

        System.out.println("Anzahl Zahlen: " + zahlen.size());


        // ======================================
        // ARRAYLIST – MIT SCHLEIFEN
        // ======================================

        // AUFGABE 11:
        // - Gib alle Namen aus der ArrayList "namen" mit einer for-Schleife aus.
        for (int i = 0; i < namen.size(); i++) {
            System.out.println("Name " + i + ": " + namen.get(i));
        }


        // AUFGABE 12:
        // - Berechne die Summe aller Werte aus der ArrayList "zahlen".
        int summeZahlen = 0;
        for (int i = 0; i < zahlen.size(); i++) {
            summeZahlen += zahlen.get(i);
        }

        System.out.println("Summe der Zahlen: " + summeZahlen);


        // ======================================
        // KOMBINATIONSAUFGABEN (etwas schwerer)
        // ======================================

        // Kombi-AUFGABE 13:
        // - Lege ein String-Array "kurse" mit 3 Kursnamen an.
        // - Gib alle Kurse nummeriert aus (z.B. "1: Mathe").
        String[] kurse = {"Mathe", "Informatik", "Physik"};

        for (int i = 0; i < kurse.length; i++) {
            System.out.println((i + 1) + ": " + kurse[i]);
        }


        // Kombi-AUFGABE 14:
        // - Lege eine ArrayList "punkte" für Integer an.
        // - Füge mehrere Punktzahlen hinzu.
        // - Berechne den Durchschnitt.
        ArrayList<Integer> punkte = new ArrayList<>();
        punkte.add(10);
        punkte.add(15);
        punkte.add(20);

        int gesamt = 0;
        for (int i = 0; i < punkte.size(); i++) {
            gesamt += punkte.get(i);
        }

        double durchschnitt = (double) gesamt / punkte.size();
        System.out.println("Durchschnitt: " + durchschnitt);
    }
}