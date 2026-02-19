package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// EXERCISES
public class ComparatorExercises {
    public static void main(String[] args) {

        // ======================================
        // COMPARATOR – GRUNDLAGEN
        // ======================================

        // AUFGABE 1:
        // - Lege eine Klasse "Student" an.
        // - Attribute:
        //   * name (String)
        //   * note (double)
        // - Konstruktor + Getter
        // - Erstelle eine Liste mit mehreren Studenten.

        List<Student> studenten = new ArrayList<>();
        studenten.add(new Student("Max", 2.3));
        studenten.add(new Student("Anna", 1.7));
        studenten.add(new Student("Tom", 3.0));

        System.out.println("Unsortiert:");
        for (Student s : studenten) {
            System.out.println(s.getName() + " - " + s.getNote());
        }


        // ======================================
        // SORTIEREN MIT COMPARATOR
        // ======================================

        // AUFGABE 2:
        // - Erstelle einen Comparator, der nach Note sortiert.
        // - Sortiere die Liste.

        Collections.sort(studenten, new NoteComparator());

        System.out.println("\nSortiert nach Note:");
        for (Student s : studenten) {
            System.out.println(s.getName() + " - " + s.getNote());
        }


        // ======================================
        // MEHRERE SORTIERKRITERIEN
        // ======================================

        // AUFGABE 3:
        // - Erstelle einen zweiten Comparator:
        //   * Sortierung nach Name (alphabetisch)
        Collections.sort(studenten, new NameComparator());

        System.out.println("\nSortiert nach Name:");
        for (Student s : studenten) {
            System.out.println(s.getName() + " - " + s.getNote());
        }



        // ======================================
        // KOMBINATIONSAUFGABE (etwas schwerer)
        // ======================================

        // Kombi-AUFGABE 5:
        // - Lege eine Klasse "Produkt" an.
        // - Attribute:
        //   * name (String)
        //   * preis (double)
        // - Erstelle eine Liste von Produkten.
        // - Sortiere:
        //   1. Nach Preis
        //   2. Bei gleichem Preis nach Name

        List<Produkt> produkte = new ArrayList<>();
        produkte.add(new Produkt("Laptop", 999.99));
        produkte.add(new Produkt("Maus", 19.99));
        produkte.add(new Produkt("Tastatur", 19.99));

        Collections.sort(produkte, new ProduktComparator());

        System.out.println("\nProdukte sortiert:");
        for (Produkt p : produkte) {
            System.out.println(p.getName() + " - " + p.getPreis());
        }
    }
}


// ======================================
// KLASSEN
// ======================================
