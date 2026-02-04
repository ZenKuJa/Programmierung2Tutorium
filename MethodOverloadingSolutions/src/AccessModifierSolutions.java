package src;

// EXERCISES
public class MethodOverloadingSolutions {
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

class Rechner {

    static int addiere(int a, int b) {
        return a + b;
    }

    static double addiere(double a, double b) {
        return a + b;
    }

    static int berechne(int a, int b) {
        return a + b;
    }

    static int berechne(int a, int b, int c) {
        return a + b + c;
    }
}

class Begruesser {

    static void begruesse() {
        System.out.println("Hallo!");
    }

    static void begruesse(String name) {
        System.out.println("Hallo " + name + "!");
    }
}

class Drucker {

    static void drucke(String text) {
        System.out.println("Text: " + text);
    }

    static void drucke(int zahl) {
        System.out.println("Zahl (int): " + zahl);
    }

    static void drucke(double zahl) {
        System.out.println("Zahl (double): " + zahl);
    }
}

class Student {
    private String name;
    private int matrikelnummer;

    Student(String name) {
        this.name = name;
        this.matrikelnummer = 0;
    }

    Student(String name, int matrikelnummer) {
        this.name = name;
        this.matrikelnummer = matrikelnummer;
    }

    String getName() {
        return name;
    }

    int getMatrikelnummer() {
        return matrikelnummer;
    }
}

class Geometrie {

    static double flaeche(double radius) {
        return Math.PI * radius * radius;
    }

    static double flaeche(double laenge, double breite) {
        return laenge * breite;
    }
}

class Info {

    static void info(String text) {
        System.out.println(text);
    }

    static void info(String text, int zahl) {
        System.out.println(text + ": " + zahl);
    }

    static void info(String text, double zahl) {
        System.out.println(text + ": " + zahl);
    }
}