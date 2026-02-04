package src;

// EXERCISES


// ----------------------------------------------------------------------------
// ---- Spickzettel: ----------------------------------------------------------
// ---- private -> Zugriff nur innerhalb der Klasse -----------------------
// ---- public  -> Zugriff von überall im Programm ------------------------
// ---- static  -> Gehört zur Klasse, nicht zum initialisierten Objekt ----
// ---- final   -> Nach Initialisierung nicht mehr veränderbar ------------
// ----------------------------------------------------------------------------

public class AccessModifierExercises {
    public static void main(String[] args) {

        // ======================================
        // PUBLIC & PRIVATE
        // ======================================

        // AUFGABE 1:
        // - Lege eine Klasse "Person" an.
        // - Erstelle private Attribute:
        //   * name
        //   * alter
        // - Erstelle public Getter für beide Attribute.
        // - Erzeuge ein Objekt und gib die Werte aus.
        Person p1 = new Person("Angela", 22);

        System.out.println("Name: " + p1.getName());
        System.out.println("Alter: " + p1.getAlter());


        // AUFGABE 2:
        // - Erkläre, warum das folgende nicht erlaubt ist:
        // p1.name = "Lisa";   // NICHT ERLAUBT

        // Greife auf das 'name' Attribut zu, sodass es korrekt ausgegeben wird und gib diesen aus



        // ======================================
        // STATIC
        // ======================================

        // AUFGABE 3:
        // - Ergänze die Klasse "Rechner".
        // - Lege eine static Methode "addiere" an,
        //   die zwei Zahlen addiert.
        int summe = Rechner.addiere(5, 7);

        System.out.println("Summe: " + summe);


        // ======================================
        // FINAL
        // ======================================

        // AUFGABE 4:
        // - Lege eine Klasse "Konstanten" an.
        // - Definiere:
        //   * PI als public static final double
        System.out.println("PI: " + Konstanten.PI);


        // AUFGABE 5:
        // - Lege in der Klasse "Spieler" ein final Attribut "id" an.
        // - Die ID darf nach dem Konstruktor nicht mehr geändert werden.
        Spieler s1 = new Spieler(101);

        System.out.println("Spieler-ID: " + s1.getId());


        // ======================================
        // KOMBINATIONSAUFGABEN (etwas schwerer)
        // ======================================

        // Kombi-AUFGABE 6:
        // - Lege eine Klasse "Bankkonto" an.
        // - Attribute:
        //   * kontonummer (private final int)
        //   * kontostand (private double)
        // - Getter für beide Attribute.
        // - Setter nur für kontostand.
        Bankkonto konto = new Bankkonto(555123, 1000.0);

        konto.setKontostand(1200.0);

        System.out.println("Kontonummer: " + konto.getKontonummer());
        System.out.println("Kontostand: " + konto.getKontostand() + "€");


        // Kombi-AUFGABE 7:
        // - Lege eine Klasse "Universitaet" an.
        // - static Attribut "name".
        // - private Konstruktor (Objekte sollen nicht erzeugt werden).
        // - public static Getter für den Namen.
        System.out.println("Uni: " + Universitaet.getName());
    }
}


// ======================================
// KLASSEN
// ======================================

class Person {
    private String name;
    private int alter;

    Person(String name, int alter) {
        this.name = name;
        this.alter = alter;
    }

    public String getName() {
        return name;
    }

    public int getAlter() {
        return alter;
    }
}

class Rechner {
    static int addiere(int a, int b) {
        return a + b;
    }
}

class Konstanten {
    public static final double PI = 3.14159265359;
}

class Spieler {
    private final int id;

    Spieler(int id) {
        this.id = id;
    }

    int getId() {
        return id;
    }
}

class Bankkonto {
    private final int kontonummer;
    private double kontostand;

    Bankkonto(int kontonummer, double kontostand) {
        this.kontonummer = kontonummer;
        this.kontostand = kontostand;
    }

    int getKontonummer() {
        return kontonummer;
    }

    double getKontostand() {
        return kontostand;
    }

    void setKontostand(double kontostand) {
        this.kontostand = kontostand;
    }
}

class Universitaet {
    private static final String name = "Technische Hochschule Musterstadt";

    private Universitaet() {
        // verhindert Objekterstellung
    }

    static String getName() {
        return name;
    }
}