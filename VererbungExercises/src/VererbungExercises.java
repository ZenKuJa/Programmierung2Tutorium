package src;

// EXERCISES
public class VererbungExercises {
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
