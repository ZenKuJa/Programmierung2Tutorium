package src;

// EXERCISES
public class MethodOverloadingExercises {
    public static void main(String[] args) {

        // ======================================
        // METHOD OVERLOADING – GRUNDLAGEN
        // ======================================

        // AUFGABE 1:
        // - Lege eine Methode "addiere" an.
        // - Überlade sie, sodass sie entweder zwei Integer oder zwei doubles addieren kann:
        System.out.println("Summe int: " + Rechner.addiere(3, 4));
        System.out.println("Summe double: " + Rechner.addiere(2.5, 1.5));


        // AUFGABE 2:
        // - Überlade die Methode "begruesse".
        // - Wird ein Name angegeben, erfolgt eine direkte Begrüssung
        // - Wird keiner angegeben, erfolgt eine Standard Begrüssung
        Begruesser.begruesse();
        Begruesser.begruesse("Donald Trompete");


        // ======================================
        // METHOD OVERLOADING – UNTERSCHIEDE
        // ======================================

        // AUFGABE 3:
        // - Überlade die Methode "drucke", damit sie das folgende in der Konsole ausgeben kann:
        //   * String
        //   * int
        //   * double
        Drucker.drucke("Hallo Welt");
        Drucker.drucke(42);
        Drucker.drucke(3.14);


        // AUFGABE 4:
        // - Überlade die Methode "berechne", sodass sie entweder 2 oder 3 Zahlen zusammenrechnen kann.
        System.out.println("Summe (2 Werte): " + Rechner.berechne(2, 3));
        System.out.println("Summe (3 Werte): " + Rechner.berechne(2, 3, 4));


        // ======================================
        // METHOD OVERLOADING – KONSTRUKTOREN
        // ======================================

        // AUFGABE 5:
        // - Überlade den Konstruktor der Klasse "Student".
        //   * Entweder nur der Name
        //   * Oder Name + Matrikelnummer
        Student s1 = new Student("Anna");
        Student s2 = new Student("Ben", 987654);

        System.out.println("Student 1: " + s1.getName() + ", Matrikel: " + s1.getMatrikelnummer());
        System.out.println("Student 2: " + s2.getName() + ", Matrikel: " + s2.getMatrikelnummer());


        // ======================================
        // KOMBINATIONSAUFGABEN (etwas schwerer)
        // ======================================

        // Kombi-AUFGABE 6:
        // - Überlade die Methode "flaeche":
        //   * double radius                -> Kreis
        //   * double laenge, double breite -> Rechteck
        System.out.println("Kreisfläche: " + Geometrie.flaeche(3.0));
        System.out.println("Rechteckfläche: " + Geometrie.flaeche(4.0, 5.0));


        // Kombi-AUFGABE 7:
        // - Überlade die Methode "info".
        //   * String text
        //   * String text, int zahl
        //   * String text, char bewertung (amerikanisch: 'A' bis 'F')
        // Bonus: Überprüfe jeweils, ob valide Argumente übergeben wurden
        Info.info("Punkte");
        Info.info("Punkte", 10);
        Info.info("Punkte", 9.5);
    }
}


// ======================================
// KLASSEN
// ======================================