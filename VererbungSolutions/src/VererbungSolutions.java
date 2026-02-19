package src;

// EXERCISES
public class VererbungSolutions {
    public static void main(String[] args) {

        // ======================================
        // VERERBUNG – GRUNDLAGEN
        // ======================================

        // AUFGABE 1:
        // - Lege eine Klasse "Person" an.
        // - Attribute:
        //   * name (String)
        //   * alter (int)
        // - Konstruktor + Getter
        // - Erstelle eine Unterklasse "Student".
        // - Zusätzliches Attribut:
        //   * matrikelnummer (int)
        Student s1 = new Student("Max Mustermann", 21, 123456);

        System.out.println("Name: " + s1.getName());
        System.out.println("Alter: " + s1.getAlter());
        System.out.println("Matrikelnummer: " + s1.getMatrikelnummer());


        // ======================================
        // SUPER & KONSTRUKTOREN
        // ======================================

        // AUFGABE 2:
        // - Lege eine Klasse "Fahrzeug" an.
        // - Attribut:
        //   * marke (String)
        // - Konstruktor
        // - Erstelle eine Unterklasse "Auto".
        // - Zusätzlich:
        //   * tueren (int)
        Auto auto = new Auto("Audi", 4);

        System.out.println("Marke: " + auto.getMarke());
        System.out.println("Türen: " + auto.getTueren());


        // ======================================
        // METHODENÜBERSCHREIBUNG (OVERRIDING)
        // ======================================

        // AUFGABE 3:
        // - Lege eine Klasse "Tier" an.
        // - Methode:
        //   * macheGeraeusch()
        // - Erstelle Unterklassen:
        //   * Hund
        //   * Katze
        // - Überschreibe jeweils die Methode.
        Tier t1 = new Hund("Bello");
        Tier t2 = new Katze("Minka");

        t1.macheGeraeusch();
        t2.macheGeraeusch();


        // ======================================
        // POLYMORPHIE
        // ======================================

        // AUFGABE 4:
        // - Erstelle ein Array vom Typ "Tier".
        // - Speichere verschiedene Unterklassen darin.
        // - Rufe "macheGeraeusch()" auf.
        Tier[] tiere = new Tier[2];
        tiere[0] = new Hund("Rex");
        tiere[1] = new Katze("Luna");

        for (Tier tier : tiere) {
            tier.macheGeraeusch();
        }


        // ======================================
        // KOMBINATIONSAUFGABE (etwas schwerer)
        // ======================================

        // Kombi-AUFGABE 5:
        // - Lege eine Klasse "Mitarbeiter" an.
        // - Attribute:
        //   * name (String)
        //   * grundgehalt (double)
        // - Methode:
        //   * berechneGehalt()
        // - Erstelle zwei Unterklassen:
        //   * "Manager" (Bonus zusätzlich)
        //   * "Azubi" (festes kleines Gehalt)
        Mitarbeiter m1 = new Manager("Herr Schmidt", 4000, 1000);
        Mitarbeiter m2 = new Azubi("Lisa", 900);

        System.out.println(m1.getName() + " Gehalt: " + m1.berechneGehalt());
        System.out.println(m2.getName() + " Gehalt: " + m2.berechneGehalt());
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

    String getName() {
        return name;
    }

    int getAlter() {
        return alter;
    }
}

class Student extends Person {
    private int matrikelnummer;

    Student(String name, int alter, int matrikelnummer) {
        super(name, alter);
        this.matrikelnummer = matrikelnummer;
    }

    int getMatrikelnummer() {
        return matrikelnummer;
    }
}

class Fahrzeug {
    private String marke;

    Fahrzeug(String marke) {
        this.marke = marke;
    }

    String getMarke() {
        return marke;
    }
}

class Auto extends Fahrzeug {
    private int tueren;

    Auto(String marke, int tueren) {
        super(marke);
        this.tueren = tueren;
    }

    int getTueren() {
        return tueren;
    }
}

class Tier {
    protected String name;

    Tier(String name) {
        this.name = name;
    }

    void macheGeraeusch() {
        System.out.println("Tier macht ein Geräusch.");
    }
}

class Hund extends Tier {

    Hund(String name) {
        super(name);
    }

    @Override
    void macheGeraeusch() {
        System.out.println(name + " sagt: Wuff!");
    }
}

class Katze extends Tier {

    Katze(String name) {
        super(name);
    }

    @Override
    void macheGeraeusch() {
        System.out.println(name + " sagt: Miau!");
    }
}

class Mitarbeiter {
    private String name;
    protected double grundgehalt;

    Mitarbeiter(String name, double grundgehalt) {
        this.name = name;
        this.grundgehalt = grundgehalt;
    }

    String getName() {
        return name;
    }

    double berechneGehalt() {
        return grundgehalt;
    }
}

class Manager extends Mitarbeiter {
    private double bonus;

    Manager(String name, double grundgehalt, double bonus) {
        super(name, grundgehalt);
        this.bonus = bonus;
    }

    @Override
    double berechneGehalt() {
        return grundgehalt + bonus;
    }
}

class Azubi extends Mitarbeiter {

    Azubi(String name, double grundgehalt) {
        super(name, grundgehalt);
    }

    @Override
    double berechneGehalt() {
        return grundgehalt;
    }
}