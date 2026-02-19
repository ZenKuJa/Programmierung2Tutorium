package src;

// EXERCISES
public class AbstractClassSolutions {
    public static void main(String[] args) {

        // ======================================
        // ABSTRAKTE KLASSEN – GRUNDLAGEN
        // ======================================

        // AUFGABE 1:
        // - Lege eine abstrakte Klasse "Tier" an.
        // - Attribute:
        //   * name (String)
        // - Konstruktor zum Setzen des Namens.
        // - Abstrakte Methode:
        //   * macheGeraeusch()
        // - Konkrete Methode:
        //   * schlafe() -> gibt "<name> schläft." aus
        Hund hund1 = new Hund("Bello");

        System.out.println("Name: " + hund1.getName());
        hund1.macheGeraeusch();
        hund1.schlafe();


        // AUFGABE 2:
        // - Erstelle eine Klasse "Katze", die von "Tier" erbt.
        // - Implementiere die Methode "macheGeraeusch()".
        Katze katze1 = new Katze("Minka");

        katze1.macheGeraeusch();
        katze1.schlafe();


        // ======================================
        // ABSTRAKTE METHODEN
        // ======================================

        // AUFGABE 3:
        // - Lege eine abstrakte Klasse "Fahrzeug" an.
        // - Attribute:
        //   * marke (String)
        // - Abstrakte Methode:
        //   * berechneGeschwindigkeit()
        // - Konkrete Methode:
        //   * starteMotor()
        Auto auto = new Auto2("BMW", 180);

        auto.starteMotor();
        System.out.println("Geschwindigkeit: " + auto.berechneGeschwindigkeit() + " km/h");


        // AUFGABE 4:
        // - Erstelle eine Klasse "Fahrrad", die von "Fahrzeug" erbt.
        // - Implementiere "berechneGeschwindigkeit()".
        Fahrrad fahrrad = new Fahrrad("Santa Cruz", 25);

        System.out.println("Fahrrad Geschwindigkeit: " + fahrrad.berechneGeschwindigkeit() + " km/h");


        // ======================================
        // POLYMORPHIE MIT ABSTRAKTEN KLASSEN
        // ======================================

        // AUFGABE 5:
        // - Erstelle ein Array vom Typ "Tier".
        // - Speichere darin ein Objekt vom Typ "Hund" und "Katze".
        // - Rufe jeweils "macheGeraeusch()" auf.
        Tier[] tiere = new Tier[2];
        tiere[0] = new Hund("Rex");
        tiere[1] = new Katze("Luna");

        for (Tier t : tiere) {
            t.macheGeraeusch();
        }


        // ======================================
        // KOMBINATIONSAUFGABE (etwas schwerer)
        // ======================================

        // Kombi-AUFGABE 6:
        // - Lege eine abstrakte Klasse "Mitarbeiter" an.
        // - Attribute:
        //   * name (String)
        // - Abstrakte Methode:
        //   * berechneGehalt()
        // - Konkrete Methode:
        //   * zeigeInfo()
        // - Erstelle zwei Klassen:
        //   * "Festangestellter"
        //   * "Freelancer"
        // - Implementiere jeweils "berechneGehalt()".

        Mitarbeiter m1 = new Festangestellter("Max", 3000);
        Mitarbeiter m2 = new Freelancer("Anna", 50, 120);

        m1.zeigeInfo();
        System.out.println("Gehalt: " + m1.berechneGehalt());

        m2.zeigeInfo();
        System.out.println("Gehalt: " + m2.berechneGehalt());
    }
}


// ======================================
// KLASSEN
// ======================================

abstract class Tier {
    private String name;

    Tier(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    abstract void macheGeraeusch();

    void schlafe() {
        System.out.println(name + " schläft.");
    }
}

class Hund extends Tier {

    Hund(String name) {
        super(name);
    }

    @Override
    void macheGeraeusch() {
        System.out.println(getName() + " sagt: Wuff!");
    }
}

class Katze extends Tier {

    Katze(String name) {
        super(name);
    }

    @Override
    void macheGeraeusch() {
        System.out.println(getName() + " sagt: Miau!");
    }
}

abstract class Fahrzeug {
    private String marke;

    Fahrzeug(String marke) {
        this.marke = marke;
    }

    String getMarke() {
        return marke;
    }

    abstract int berechneGeschwindigkeit();

    void starteMotor() {
        System.out.println("Motor gestartet.");
    }
}

class Auto extends Fahrzeug {
    private int ps;

    Auto2(String marke, int ps) {
        super(marke);
        this.ps = ps;
    }

    @Override
    int berechneGeschwindigkeit() {
        return ps; // stark vereinfacht
    }
}

class Fahrrad extends Fahrzeug {
    private int gang;

    Fahrrad(String marke, int gang) {
        super(marke);
        this.gang = gang;
    }

    @Override
    int berechneGeschwindigkeit() {
        return gang * 5; // vereinfachte Berechnung
    }
}

abstract class Mitarbeiter {
    private String name;

    Mitarbeiter(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    abstract double berechneGehalt();

    void zeigeInfo() {
        System.out.println("Mitarbeiter: " + name);
    }
}

class Festangestellter extends Mitarbeiter {
    private double monatsgehalt;

    Festangestellter(String name, double monatsgehalt) {
        super(name);
        this.monatsgehalt = monatsgehalt;
    }

    @Override
    double berechneGehalt() {
        return monatsgehalt;
    }
}

class Freelancer extends Mitarbeiter {
    private double stundensatz;
    private int stunden;

    Freelancer(String name, double stundensatz, int stunden) {
        super(name);
        this.stundensatz = stundensatz;
        this.stunden = stunden;
    }

    @Override
    double berechneGehalt() {
        return stundensatz * stunden;
    }
}