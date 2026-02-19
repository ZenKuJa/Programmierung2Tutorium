package src;

// EXERCISES
public class EnumSolutions {
    public static void main(String[] args) {

        // ======================================
        // ENUM – GRUNDLAGEN
        // ======================================

        // AUFGABE 1:
        // - Lege ein enum "Wochentag" an.
        // - Werte:
        //   * MONTAG, DIENSTAG, MITTWOCH, DONNERSTAG, FREITAG, SAMSTAG, SONNTAG
        // - Erstelle eine Variable vom Typ Wochentag.
        Wochentag heute = Wochentag.MONTAG;

        System.out.println("Heute ist: " + heute);


        // ======================================
        // ENUM IN IF / SWITCH
        // ======================================

        // AUFGABE 2:
        // - Verwende ein switch-Statement für den Wochentag 'heute'.
        // - Gib aus, ob es ein Werktag oder ein Wochenende ist.
        switch (heute) {
            case MONTAG:
            case DIENSTAG:
            case MITTWOCH:
            case DONNERSTAG:
            case FREITAG:
                System.out.println("Es ist ein Werktag.");
                break;
            case SAMSTAG:
            case SONNTAG:
                System.out.println("Es ist Wochenende.");
        }


        // ======================================
        // ENUM MIT METHODEN
        // ======================================

        // AUFGABE 3:
        // - Erweitere das enum "Ampel".
        // - Werte:
        //   * ROT, GELB, GRUEN
        // - Methode:
        //   * getBedeutung()

        Ampel ampel = Ampel.ROT;
        System.out.println("Ampel: " + ampel);
        System.out.println("Bedeutung: " + ampel.getBedeutung());


        // ======================================
        // ENUM MIT KONSTRUKTOR & ATTRIBUT
        // ======================================

        // AUFGABE 4:
        // - Lege ein enum "Monat" an.
        // - Attribut:
        //   * tage (int)
        // - Konstruktor
        // - Getter
        Monat m = Monat.FEBRUAR;

        System.out.println("Monat: " + m);
        System.out.println("Tage: " + m.getTage());


        // ======================================
        // KOMBINATIONSAUFGABE (etwas schwerer)
        // ======================================

        // Kombi-AUFGABE 5:
        // - Lege ein enum "BestellStatus" an.
        // - Werte:
        //   * OFFEN, BEZAHLT, VERSENDET, STORNIERT
        // - Lege eine Klasse "Bestellung" an.
        // - Attribut:
        //   * status (BestellStatus)
        // - Methode:
        //   * setStatus(...)
        //   * zeigeStatus()

        Bestellung b = new Bestellung();
        b.setStatus(BestellStatus.BEZAHLT);
        b.zeigeStatus();
    }
}


// ======================================
// ENUMS
// ======================================

enum Wochentag {
    MONTAG, DIENSTAG, MITTWOCH, DONNERSTAG, FREITAG, SASTAG, SONNTAG;
}

enum Ampel {
    ROT("Stopp"),
    GELB("Achtung"),
    GRUEN("Fahren");

    private String bedeutung;

    Ampel(String bedeutung) {
        this.bedeutung = bedeutung;
    }

    String getBedeutung() {
        return bedeutung;
    }
}

enum Monat {
    JANUAR(31),
    FEBRUAR(28),
    MAERZ(31),
    APRIL(30);

    private int tage;

    Monat(int tage) {
        this.tage = tage;
    }

    int getTage() {
        return tage;
    }
}

enum BestellStatus {
    OFFEN, BEZAHLT, VERSENDET, STORNIERT
}


// ======================================
// KLASSEN
// ======================================

class Bestellung {
    private BestellStatus status;

    void setStatus(BestellStatus status) {
        this.status = status;
    }

    void zeigeStatus() {
        System.out.println("Aktueller Status: " + status);
    }
}