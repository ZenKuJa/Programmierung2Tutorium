package src;

// EXERCISES
public class InterfaceExercises {
    public static void main(String[] args) {

        // ======================================
        // INTERFACE – GRUNDLAGEN
        // ======================================

        // AUFGABE 1:
        // - Lege ein Interface "Fahrbar" an.
        // - Methode:
        //   * fahren()
        // - Erstelle eine Klasse "Auto", die das Interface implementiert.
        Auto auto = new Auto("BMW");

        auto.fahren();


        // ======================================
        // MEHRERE INTERFACES
        // ======================================

        // AUFGABE 2:
        // - Lege ein Interface "Schwimmbar" an.
        // - Methode:
        //   * schwimmen()
        // - Erstelle eine Klasse "AmphibienFahrzeug".
        // - Implementiere sowohl "Fahrbar" als auch "Schwimmbar".
        AmphibienFahrzeug a = new AmphibienFahrzeug();

        a.fahren();
        a.schwimmen();


        // ======================================
        // POLYMORPHIE MIT INTERFACES
        // ======================================

        // AUFGABE 3:
        // - Erstelle ein Array vom Typ "Fahrbar".
        // - Speichere verschiedene Objekte darin.
        Fahrbar[] fahrzeuge = new Fahrbar[2];
        fahrzeuge[0] = new Auto("Audi");
        fahrzeuge[1] = new AmphibienFahrzeug();

        for (Fahrbar f : fahrzeuge) {
            f.fahren();
        }


        // ======================================
        // DEFAULT-METHODEN
        // ======================================

        // AUFGABE 4:
        // - Erweitere ein Interface "Geraet".
        // - Methode:
        //   * einschalten()
        // - Default-Methode:
        //   * info()
        // - Erstelle eine Klasse "Smartphone".
        Smartphone s = new Smartphone();

        s.einschalten();
        s.info();


        // ======================================
        // KOMBINATIONSAUFGABE (etwas schwerer)
        // ======================================

        // Kombi-AUFGABE 5:
        // - Lege ein Interface "Zahlbar" an.
        // - Methode:
        //   * zahle(double betrag)
        // - Implementiere:
        //   * Kreditkarte
        //   * PayPal
        // - Erstelle eine Methode:
        //   * fuehreZahlungAus(Zahlbar zahlungsmittel)

        ZahlungService service = new ZahlungService();

        service.fuehreZahlungAus(new Kreditkarte("1234-5678"), 100.0);
        service.fuehreZahlungAus(new PayPal("max@mail.de"), 49.99);
    }
}