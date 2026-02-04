package src;

import java.util.ArrayList;

// SOLUTIONS
public class ArrayListExercises {
    public static void main(String[] args) {

        // ======================================
        // ARRAYS – GRUNDLAGEN
        // ======================================

        // AUFGABE 1:
        // - Lege ein int-Array "noten" mit der Größe 5 an.
        // - Speichere die Werte 1, 2, 3, 2, 1 darin.

        System.out.println("Note an Position 0: " + noten[0]);


        // AUFGABE 2:
        // - Lege ein String-Array "tage" mit der Größe 7 an.
        // - Speichere die Wochentage Montag bis Sonntag darin.

        System.out.println("Erster Tag: " + tage[0]);
        System.out.println("Letzter Tag: " + tage[6]);


        // AUFGABE 3:
        // - Lege ein double-Array "temperaturen" mit 3 Werten an.
        // - Speichere 12.5, 15.0 und 9.8 darin.

        System.out.println("Temperatur mittags: " + temperaturen[1]);


        // AUFGABE 4:
        // - Lege ein boolean-Array "anwesenheit" mit der Größe 4 an.
        // - Setze die Werte auf true, true, false, true.

        System.out.println("Anwesenheit Person 3: " + anwesenheit[2]);


        // AUFGABE 5:
        // - Lege ein char-Array "initialen" mit 3 Buchstaben an.
        // - Speichere z.B. 'A', 'B', 'C' darin.

        System.out.println("Zweites Initial: " + initialen[1]);


        // ======================================
        // ARRAYS – MIT SCHLEIFEN
        // ======================================

        // AUFGABE 6:
        // - Gib alle Werte des Arrays "noten" mit einer for-Schleife aus.


        // AUFGABE 7:
        // - Berechne die Summe aller Werte im Array "noten".

        System.out.println("Summe der Noten: " + summe);


        // AUFGABE 8:
        // - Finde den höchsten Wert im Array "temperaturen".

        System.out.println("Höchste Temperatur: " + maxTemperatur);


        // ======================================
        // ARRAYLIST – GRUNDLAGEN
        // ======================================

        // AUFGABE 9:
        // - Lege eine ArrayList "namen" für Strings an.
        // - Füge drei Namen hinzu.

        System.out.println("Erster Name: " + namen.get(0));


        // AUFGABE 10:
        // - Lege eine ArrayList "zahlen" für Integer an.
        // - Füge die Zahlen 5, 10 und 15 hinzu.

        System.out.println("Anzahl Zahlen: " + zahlen.size());


        // ======================================
        // ARRAYLIST – MIT SCHLEIFEN
        // ======================================

        // AUFGABE 11:
        // - Gib alle Namen aus der ArrayList "namen" mit einer for oder for-each Schleife aus.


        // AUFGABE 12:
        // - Berechne die Summe aller Werte aus der ArrayList "zahlen".

        System.out.println("Summe der Zahlen: " + summeZahlen);


        // ======================================
        // KOMBINATIONSAUFGABEN (etwas schwerer)
        // ======================================

        // Kombi-AUFGABE 13:
        // - Lege ein String-Array "kurse" mit 3 Kursnamen an.
        // - Gib alle Kurse nummeriert aus (z.B. "1: Mathe").


        // Kombi-AUFGABE 14:
        // - Lege eine ArrayList "punkte" für Integer an.
        // - Füge mehrere Punktzahlen hinzu.
        // - Berechne den Durchschnitt.
    }
}