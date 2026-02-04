package src;

// EXERCISES
public class ClassExercises {
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
        Auto auto1 = new Auto("BMW", 2018, 45200.5);

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
        Buch buch1 = new Buch("Java leicht gemacht", "A. Schmidt", 320);

        System.out.println("Buch: " + buch1.getTitel() + " von " + buch1.getAutor());


        // AUFGABE 4:
        // - Lege eine Klasse "Konto" an.
        // - Attribute:
        //   * inhaber (String)
        //   * kontostand (double)
        // - Erstelle einen Konstruktor.
        Konto konto1 = new Konto("Lisa Meyer", 1500.0);

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
        student1.setName("Laura Schmidt");

        System.out.println("Neuer Name: " + student1.getName());


        // AUFGABE 8:
        // - Ändere den Kilometerstand des Autos über einen Setter.
        auto1.setKilometerstand(50000.0);

        System.out.println("Gesetzter Kilometerstand: " + auto1.getKilometerstand());


        // AUFGABE 9:
        // - Ändere den Kontoinhaber über einen Setter.
        konto1.setInhaber("Tom Fischer");

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
        TemperaturMessung t = new TemperaturMessung("Berlin", -2.5);

        t.setTemperatur(3.0);

        System.out.println("Ort: " + t.getOrt());
        System.out.println("Temperatur: " + t.getTemperatur());
        System.out.println("Frost: " + (t.istFrost() ? "ja" : "nein"));
    }
}


// ======================================
// KLASSEN
// ======================================