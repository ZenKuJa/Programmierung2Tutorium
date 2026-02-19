package src;

// EXERCISES
public class FinalClassExercises {
    public static void main(String[] args) {

        // ======================================
        // FINALE KLASSEN – GRUNDLAGEN
        // ======================================

        // AUFGABE 1:
        // - Lege eine finale Klasse "Konstante" an.
        // - Attribut:
        //   * PI (double, public static final)
        // - Greife im main darauf zu.
        System.out.println("PI: " + Konstante.PI);


        // AUFGABE 2:
        // - Lege eine finale Klasse "Benutzer" an.
        // - Attribute:
        //   * id (int)
        //   * name (String)
        // - Konstruktor + Getter
        Benutzer b1 = new Benutzer(1, "Max Mustermann");

        System.out.println("Benutzer: " + b1.getId() + " - " + b1.getName());


        // ======================================
        // FINALE METHODEN
        // ======================================

        // AUFGABE 3:
        // - Lege eine Klasse "BasisGeraet" an.
        // - Methode:
        //   * einschalten() (final)
        // - Erstelle eine Unterklasse "Laptop".
        // - Zeige, dass die finale Methode nicht überschrieben werden kann.
        Laptop laptop = new Laptop();

        laptop.einschalten();


        // ======================================
        // FINALE ATTRIBUTE
        // ======================================

        // AUFGABE 4:
        // - Lege eine Klasse "Person" an.
        // - Attribut:
        //   * geburtsdatum (final String)
        // - Wert muss im Konstruktor gesetzt werden.
        Person p = new Person("01.01.2000");

        System.out.println("Geburtsdatum: " + p.getGeburtsdatum());


        // ======================================
        // KOMBINATIONSAUFGABE (etwas schwerer)
        // ======================================

        // Kombi-AUFGABE 5:
        // - Lege eine Klasse "Fahrzeug" an.
        // - Attribut:
        //   * fahrgestellnummer (final String)
        // - Methode:
        //   * zeigeInfo() (final)
        // - Erstelle eine Unterklasse "Motorrad".
        // - Ergänze eigene Attribute + Methoden.
        Motorrad m = new Motorrad("XYZ123", "Yamaha");

        m.zeigeInfo();
        System.out.println("Marke: " + m.getMarke());
    }
}


// ======================================
// KLASSEN
// ======================================