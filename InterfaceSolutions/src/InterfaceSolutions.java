package src;

// EXERCISES
public class InterfaceSolutions {
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


// ======================================
// INTERFACES
// ======================================

interface Fahrbar {
    void fahren();
}

interface Schwimmbar {
    void schwimmen();
}

interface Geraet {
    void einschalten();

    default void info() {
        System.out.println("Standard-Geräteinformation.");
    }
}

interface Zahlbar {
    void zahle(double betrag);
}


// ======================================
// KLASSEN
// ======================================

class Auto implements Fahrbar {

    private String marke;

    Auto(String marke) {
        this.marke = marke;
    }

    @Override
    public void fahren() {
        System.out.println("Das Auto " + marke + " fährt.");
    }
}

class AmphibienFahrzeug implements Fahrbar, Schwimmbar {

    @Override
    public void fahren() {
        System.out.println("Amphibienfahrzeug fährt.");
    }

    @Override
    public void schwimmen() {
        System.out.println("Amphibienfahrzeug schwimmt.");
    }
}

class Smartphone implements Geraet {

    @Override
    public void einschalten() {
        System.out.println("Smartphone wird eingeschaltet.");
    }
}

class Kreditkarte implements Zahlbar {

    private String kartennummer;

    Kreditkarte(String kartennummer) {
        this.kartennummer = kartennummer;
    }

    @Override
    public void zahle(double betrag) {
        System.out.println("Zahlung mit Kreditkarte (" + kartennummer + "): " + betrag + "€");
    }
}

class PayPal implements Zahlbar {

    private String email;

    PayPal(String email) {
        this.email = email;
    }

    @Override
    public void zahle(double betrag) {
        System.out.println("Zahlung mit PayPal (" + email + "): " + betrag + "€");
    }
}

class ZahlungService {

    void fuehreZahlungAus(Zahlbar zahlungsmittel, double betrag) {
        zahlungsmittel.zahle(betrag);
    }
}