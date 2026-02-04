package src;

// EXERCISES
public class ClassSolutions {
    public static void main(String[] args) {

        // ======================================
        // OBJEKTORIENTIERUNG – GRUNDLAGEN
        // ======================================

        // AUFGABE 1:
        // - Lege eine Klasse "Student" an.
        // - Die Klasse soll folgende Attribute besitzen:
        //   * name (String)
        //   * matrikelnummer (int)
        //   * eingeschrieben (boolean)
        // - Erzeuge ein Objekt und setze Beispielwerte.
        Student student1 = new Student("Donald Trompete", 123456, true);

        System.out.println("Name: " + student1.getName());
        System.out.println("Matrikelnummer: " + student1.getMatrikelnummer());
        System.out.println("Eingeschrieben: " + student1.isEingeschrieben());


        // AUFGABE 2:
        // - Lege eine Klasse "Auto" an.
        // - Attribute:
        //   * marke (String)
        //   * baujahr (int)
        //   * kilometerstand (double)
        // - Erzeuge ein Objekt mit Beispielwerten.
        Auto auto1 = new Auto("Maserati", 2018, 45200.5);

        System.out.println("Auto: " + auto1.getMarke() + ", Baujahr " + auto1.getBaujahr());


        // ======================================
        // KONSTRUKTOREN
        // ======================================

        // AUFGABE 3:
        // - Erweitere die Klasse "Buch".
        // - Attribute:
        //   * titel (String)
        //   * autor (String)
        //   * seitenzahl (int)
        // - Erstelle einen Konstruktor, der alle Werte setzt.
        Buch buch1 = new Buch("Alle Altklausuren", "S. Merk und M. Pfob", 3290);

        System.out.println("Buch: " + buch1.getTitel() + " von " + buch1.getAutor());


        // AUFGABE 4:
        // - Lege eine Klasse "Konto" an.
        // - Attribute:
        //   * inhaber (String)
        //   * kontostand (double)
        // - Erstelle einen Konstruktor.
        Konto konto1 = new Konto("Armer Student", 10.0);

        System.out.println("Kontoinhaber: " + konto1.getInhaber());
        System.out.println("Kontostand: " + konto1.getKontostand() + "€");


        // ======================================
        // METHODEN
        // ======================================

        // AUFGABE 5:
        // - Ergänze die Klasse "Auto" um eine Methode "fahre".
        // - Die Methode erhöht den Kilometerstand um einen übergebenen Wert.
        auto1.fahre(120.5);

        System.out.println("Neuer Kilometerstand: " + auto1.getKilometerstand());


        // AUFGABE 6:
        // - Ergänze die Klasse "Konto" um:
        //   * einzahlen(double betrag)
        //   * abheben(double betrag)
        konto1.einzahlen(200.0);
        konto1.abheben(100.0);

        System.out.println("Aktueller Kontostand: " + konto1.getKontostand() + "€");


        // ======================================
        // GETTER & SETTER
        // ======================================

        // AUFGABE 7:
        // - Setze den Namen des Studenten über einen Setter neu.
        student1.setName("Elon Musik");

        System.out.println("Neuer Name: " + student1.getName());


        // AUFGABE 8:
        // - Ändere den Kilometerstand des Autos über einen Setter.
        auto1.setKilometerstand(50000.0);

        System.out.println("Gesetzter Kilometerstand: " + auto1.getKilometerstand());


        // AUFGABE 9:
        // - Ändere den Kontoinhaber sowie den Kontostand von 'konto1' über einen Setter.
        konto1.setInhaber("Reicher Student");
        konto1.setKontostand(1000000.0);

        System.out.println("Neuer Kontoinhaber: " + konto1.getInhaber());


        // ======================================
        // KOMBINATIONSAUFGABEN (etwas schwerer)
        // ======================================

        // Kombi-AUFGABE 10:
        // - Lege eine Klasse "Rechteck" an.
        // - Attribute (private):
        //   * laenge (double)
        //   * breite (double)
        // - Getter & Setter
        // - Methoden:
        //   * berechneFlaeche()
        //   * berechneUmfang()
        Rechteck r = new Rechteck(5.0, 3.0);

        r.setLaenge(6.0);
        r.setBreite(4.0);

        System.out.println("Fläche: " + r.berechneFlaeche());
        System.out.println("Umfang: " + r.berechneUmfang());


        // Kombi-AUFGABE 11:
        // - Lege eine Klasse "TemperaturMessung" an.
        // - Attribute (private):
        //   * ort (String)
        //   * temperatur (double)
        // - Getter & Setter
        // - Methode:
        //   * istFrost()
        TemperaturMessung t = new TemperaturMessung("Nordpol", -52.5);

        t.setTemperatur(3.0);

        System.out.println("Ort: " + t.getOrt());
        System.out.println("Temperatur: " + t.getTemperatur());
        System.out.println("Frost: " + (t.istFrost() ? "ja" : "nein"));
    }
}


// ======================================
// KLASSEN
// ======================================

class Student {
    private String name;
    private int matrikelnummer;
    private boolean eingeschrieben;

    Student(String name, int matrikelnummer, boolean eingeschrieben) {
        this.name = name;
        this.matrikelnummer = matrikelnummer;
        this.eingeschrieben = eingeschrieben;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    int getMatrikelnummer() {
        return matrikelnummer;
    }

    boolean isEingeschrieben() {
        return eingeschrieben;
    }
}

class Auto {
    private String marke;
    private int baujahr;
    private double kilometerstand;

    Auto(String marke, int baujahr, double kilometerstand) {
        this.marke = marke;
        this.baujahr = baujahr;
        this.kilometerstand = kilometerstand;
    }

    void fahre(double kilometer) {
        kilometerstand += kilometer;
    }

    String getMarke() {
        return marke;
    }

    int getBaujahr() {
        return baujahr;
    }

    double getKilometerstand() {
        return kilometerstand;
    }

    void setKilometerstand(double kilometerstand) {
        this.kilometerstand = kilometerstand;
    }
}

class Buch {
    private String titel;
    private String autor;
    private int seitenzahl;

    Buch(String titel, String autor, int seitenzahl) {
        this.titel = titel;
        this.autor = autor;
        this.seitenzahl = seitenzahl;
    }

    String getTitel() {
        return titel;
    }

    String getAutor() {
        return autor;
    }
}

class Konto {
    private String inhaber;
    private double kontostand;

    Konto(String inhaber, double kontostand) {
        this.inhaber = inhaber;
        this.kontostand = kontostand;
    }

    void einzahlen(double betrag) {
        kontostand += betrag;
    }

    void abheben(double betrag) {
        kontostand -= betrag;
    }

    String getInhaber() {
        return inhaber;
    }

    void setInhaber(String inhaber) {
        this.inhaber = inhaber;
    }

    void setKontostand(double kontostand) {
        this.kontostand = kontostand;
    }

    double getKontostand() {
        return kontostand;
    }
}

class Rechteck {
    private double laenge;
    private double breite;

    Rechteck(double laenge, double breite) {
        this.laenge = laenge;
        this.breite = breite;
    }

    double getLaenge() {
        return laenge;
    }

    void setLaenge(double laenge) {
        this.laenge = laenge;
    }

    double getBreite() {
        return breite;
    }

    void setBreite(double breite) {
        this.breite = breite;
    }

    double berechneFlaeche() {
        return laenge * breite;
    }

    double berechneUmfang() {
        return 2 * (laenge + breite);
    }
}

class TemperaturMessung {
    private String ort;
    private double temperatur;

    TemperaturMessung(String ort, double temperatur) {
        this.ort = ort;
        this.temperatur = temperatur;
    }

    String getOrt() {
        return ort;
    }

    double getTemperatur() {
        return temperatur;
    }

    void setTemperatur(double temperatur) {
        this.temperatur = temperatur;
    }

    boolean istFrost() {
        return temperatur < 0;
    }
}