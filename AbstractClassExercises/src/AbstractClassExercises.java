package src;

// EXERCISES
public class AbstractClassExercises {
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
