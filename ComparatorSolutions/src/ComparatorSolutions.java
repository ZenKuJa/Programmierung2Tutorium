package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// EXERCISES
public class ComparatorSolutions {
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
        // LAMBDA-COMPARATOR
        // ======================================

        // AUFGABE 4:
        // - Sortiere die Liste mit einem Lambda-Ausdruck
        //   (z.B. Note absteigend)

        Collections.sort(studenten,
                (s1, s2) -> Double.compare(s2.getNote(), s1.getNote())
        );

        System.out.println("\nSortiert nach Note (absteigend):");
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

class Student {
    private String name;
    private double note;

    Student(String name, double note) {
        this.name = name;
        this.note = note;
    }

    String getName() {
        return name;
    }

    double getNote() {
        return note;
    }
}

class NoteComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return Double.compare(s1.getNote(), s2.getNote());
    }
}

class NameComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }
}

class Produkt {
    private String name;
    private double preis;

    Produkt(String name, double preis) {
        this.name = name;
        this.preis = preis;
    }

    String getName() {
        return name;
    }

    double getPreis() {
        return preis;
    }
}

class ProduktComparator implements Comparator<Produkt> {

    @Override
    public int compare(Produkt p1, Produkt p2) {

        int preisVergleich = Double.compare(p1.getPreis(), p2.getPreis());

        if (preisVergleich != 0) {
            return preisVergleich;
        }

        return p1.getName().compareTo(p2.getName());
    }
}