---
marp: true
---

<style>
    :root {
        background-image: url("https://upload.wikimedia.org/wikipedia/de/thumb/e/ec/DHBW_Ravensburg.svg/1200px-DHBW_Ravensburg.svg.png");
        background-repeat: no-repeat;
        background-position: right top;
        background-size: 220px;
        background-origin: content-box;
    }

    img {
        height: 300px;
    }
</style>

# Tutorium Programmierung 1
> 12.02.2026

Jannes Kurzke und Fabian Bauriedl

---
## Inhalt
1. Java API (Wrapper, Datum, IO)
1. Final Modifier
1. Enumeration
1. Klassen Diagramme
1. Vererbung
1. Protected Modifier
1. Polymorphie
1. Abstract & Final Modifier
1. Interface
1. Komparator

---
## Wrapper Klassen
* Wir kennen **Primitive** Datentypen und **Komplexe** Datentypen
* Komplexe Datentypen bringen fortgeschrittene Funktionen mit sich

---
### Numerische Wrapper Klassen

```java
public static void main(String[] args) {
    // Numerische Wrapper funktionieren mit Integer, Long und Double
    int intResult;
    String binResult;

    intResult = Integer.parseInt("1");           // --> 1

    intResult = Integer.compare(1, 2);           // --> -1
    intResult = Integer.compare(2, 2);           // --> 0
    intResult = Integer.compare(2, 1);           // --> 1

    intResult = Integer.min(2, 1);               // --> 1
    intResult = Integer.max(2, 1);               // --> 2
    intResult = Integer.sum(2, 1);               // --> 3

    binResult = Integer.toBinaryString(69);      // --> "1000101"
}
```

---
### Character Wrapper
```java
public static void main(String[] args) {
    //Char Wrapper

    boolean boolResult;

    boolResult = Character.isDigit('1');        // --> True
    boolResult = Character.isLetter('A');       // --> True
    boolResult = Character.isWhitespace(' ');   // --> True
    boolResult = Character.isUpperCase('A');    // --> True
    boolResult = Character.isLowerCase('a');    // --> True
}
```

---
### Boolean Wrapper

```java
public static void main(String[] args) {
    boolean boolResult;

    boolResult = Boolean.parseBoolean("TrUe");     // --> true (ignoriert Groß-/Kleinschreibung)
    boolResult = Boolean.logicalXor(true, false);  // --> true
    boolResult = Boolean.logicalAnd(true, true);   // --> true
}
```

---
## Datums Objekte

---
### Datums Objekte
```java
public static void main(String[] args) {
    LocalDateTime now = LocalDateTime.now();

    System.out.println(now.getYear());          // --> 2026
    System.out.println(now.getMonth());         // --> FEBRUARY
    System.out.println(now.getMonthValue());    // --> 2
    System.out.println(now.getDayOfMonth());    // --> 18

    System.out.println(now.plusWeeks(2));
            // --> 2026-03-04T22:52:18.034961767
    System.out.println(now.minusHours(5));
            // --> 2026-02-18T17:53:21.239400596
    System.out.println(now.withHour(12).withMinute(0));
            // --> 2026-02-18T12:00:19.056285733
}
```

---
### Datums Objekte
```java
public static void main(String[] args) {
    LocalDate today = LocalDate.now();
    LocalDate examDate = LocalDate.of(2026, 3, 10);

    long daysUntilExam;
    daysUntilExam = ChronoUnit.DAYS.between(today, examDate);       //--> 20

    boolean isLeap = today.isLeapYear();
    boolean isBefore = today.isBefore(examDate);
    DayOfWeek dayOfWeek = today.getDayOfWeek();                     // -> WEDNESDAY
    String dayString = today.getDayOfWeek().toString();             // -> WEDNESDAY
    int daysInMonth = today.lengthOfMonth();                        // --> 28
}
```

---
## Dateien Lesen
* Wir kennen bereits den **Scanner** --> Nutzereingabe über die Konsole
* Scanner kann nun ebenso verwendet werden, um Dateien zu lesen
* Bei der Arbeit mit Dateien muss auf korrekte Fehler Behandlung geachtet werden
* Verwendung von **Try-Ressource** Blöcken wird empfohlen

---
### Dateien Lesen

```java
public static void main(String[] args) {
    File file = new File("HelloWorld.txt");

    try (Scanner sc = new Scanner(file)) {
        while (sc.hasNextLine()) {
            String currentLine = sc.nextLine();
            System.out.println(currentLine);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
```

> Dateien Speichern wird mit dem **FileWriter** erledigt --> nicht im ersten Semester

---
## Final Modifier
* Anwendbar auf: Klassen, Methoden, Attribute, Variablen
* Zuweisung eines Wertes erfolgt **final**
    * Das bedeutet er lässt sich nicht mehr verändern
* Finale Attribute müssen im Konstruktur gesetzt oder direkt initialisiert werden

---
### Final Modifier
```java
public class Car {
    final int wheelCount = 4;
    final String make;
    final String model;

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }
}

```

---
## Enumerations
* Feste Gruppe von bekannten Konstanten
* Sehr komfortable und schnelle Art mehrere, ähnliche Objekte anzulegen
* Können Attribute, Funktionen und Konstruktor verwenden
    > Konstruktur ist hier **private**
* **Best Practice:** Namen der Enum-Objekte in Caps-Lock und Singluar


---
### Enumerations - **Car**-Klasse Upgrade
```java
public class Car {
    final int wheelCount = 4;
    final String make;
    final String model;
    final EngineEnum engine;

    public Car(String make, String model, EngineEnum engine) {
        this.make = make;
        this.model = model;
        this.engine = engine;
    }
}
```

---
### Enumerations
```java
public enum EngineEnum {
    Diesel,
    Petrol,
    Electric,
    Hydrogen;
}
```

```java
public static void main(String[] args) {
    Car Id3 = new Car("VW", "ID.3", EngineEnum.Electric);

    System.out.println(Id3.engine);     // --> Electric
}
```

---
### Enumerations - Upgrade
```java
public enum EngineEnum {
    Diesel(0.1),
    Petrol(0.2),
    Electric(1.0),
    Hydrogen(0.9);

    private double ecoRating;

    private EngineEnum(double ecoRating){
        this.ecoRating = ecoRating;
    }

    public double getEcoRating(){
        return this.ecoRating;
    }
}
```

---
### Enumerations - Upgrade
```java
public static void main(String[] args) {
    Car Id3 = new Car("VW", "ID.3", EngineEnum.ELECTRIC);
    Car P911 = new Car("Porsche", "9/11", EngineEnum.PETROL);

    System.out.println(Id3.engine);                         // --> ELECTRIC
    System.out.println(Id3.engine.getEcoRating());          // --> 1.0
    System.out.println(P911.engine);                        // --> PETROL
    System.out.println(P911.engine.getEcoRating());         // --> 0.2
}
```

---
## Unified Modelling Language
* Standardisierte grafische Sprache
* Modellierung und Spezifikation von Software
* Visualisierung, Konstruktion und Dokumentation von Software-Architektur
* Unabhängig von der verwendeten Programmiersprache
* Strukturdiagramme z.B. Klassendaigramme
* Verhaltensdiagramme z.B. Sequenzdiagramme

---
### UML- Tooling

|Draw.io|Eclipse-Papyrus|Plant-UML|
|---|---|---|
|![Draw.IO](https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/Diagrams.net_Logo.svg/960px-Diagrams.net_Logo.svg.png)|![Eclipse-Papyrus](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRyh_m9Z6aFV_bg2-NKf877mN9sLeKF5Hyp1A&s)|![Plant-UML](https://www.svgrepo.com/show/373977/plantuml.svg)|
|Einfache Browser Anwendung|Profi Werkzeug mit Projekt Imports und Exports|UML-As-Code Lösung|

---
## Klassendiagramme
* Verwendet den UML Standard
* Grafische modellierung von Klassen und deren Beziehung
* Empfiehlt sich beim Entwurf der Software-Architektur
     * **bevor** man Code schreibt

---
### Klassendaigramme - UML Syntax

| UML Syntax / Symbol | Bedeutung | Beispiel |
|---|---|---|
| **+** | public | `+ name: String` |
| **-** | private | `- alter: int` |
| **#** | protected | `# id: int` |
| **name: T** | Attribut | `- gehalt: double` |
| **name(p: Typ): Typ**| Methode| `+ getGehalt(bonus: int): double` |


---
### Klassendaigramme - UML Syntax
| UML Syntax / Symbol | Bedeutung | Beispiel |
|---|---|---|
| **Unterstrichen** | static | <ins>`- MAX_SPEED: int`</ins> |
| **Kursiv** | abstract | *`+ berechnePreis(): double`* |
| **<<interface>>** | Interface | `<<interface>> Runnable` |
| **<<enumeration>>** | Enumeration | `<<enumeration>> Engine` |
| **Leere Raute** | Aggregation | `Parkplatz` ◇── `Auto` |
| **Gefüllte Raute** | Komposition | `Auto` ♦── `Motor` |
| **Durchgezogene Linie, leerer Pfeil** | Vererbung | `PKW` ──▷ `Fahrzeug` |
| **Gestrichelte Linie, leerer Pfeil** | Implementierung | `Auto` ╌╌▷ `Fahrbar` |

---
### Klassendiagramme - Beispiel
![Example UML Class-Diagramm](/doc/resources/UmlExample.png)

---
## Vererbung
* Wiederverwendung von Attributen und Funktionen
* Vererbung über **extends** Kezyword im Klassen-Kopf
* Spiegelt eine **ist-ein** Beziehung wieder --> ein **Auto** ist ein **Fahrzeug**
* Die **Sub-Klasse** (Child) erbt von der **Super-Klasse** (Parent)
* Java erlaubt nur Einfach-Vererbung --> nur eine Super-Klasse
* Konstruktoren werden nicht verebt --> Aufruf über **super** Keyword
> **Ziel:** Hohes Maß an Generalisierung erhalten --> Code Recycling

---
### Vererbung - Modelling

![Inheritance UML Modell](/doc/resources/UmlExample-2.png)

---
### Vererbung - Code 
> Super Klasse
```java
public class Vehicle {
    final double topSpeed;

    public Vehicle(double topSpeed){
        this.topSpeed = topSpeed;
    }
}
```

---
### Vererbung - Code 
> Sub-Klasse
```java
public class Car extends Vehicle {
    int wheelCount = 4;
    String make;
    String model;
    EngineEnum engine;

    public Car(String make, String model, EngineEnum engine, double topSpeed) {
        super(topSpeed);
        this.make = make;
        this.model = model;
        this.engine = engine;
    }
}
```
* **Car** verfügt nun über alle Eigenschaften und Funktionen der **Vehicle** Klasse

---
### Vererbung - Code 
> Verwendung
```java
public static void main(String[] args) {
    Car Id3 = new Car("VW", "ID.3", EngineEnum.ELECTRIC, 150);
    
    System.out.println(Id3.engine);                         // --> ELECTRIC
    System.out.println(Id3.engine.getEcoRating());          // --> 1.0
    System.out.println(Id3.topSpeed);                       // --> 150.0
}
```
* Die **topSpeed** Eigenschaft auf **Vehicle** kann nun von **Car** verwendet und gesetzt werden

---
## Protected Modifier

---
## Polymorphie
* Objekt kann als Instanz seiner Klasse oder einer seiner Superklassen 
behandelt werden
* Wichtig: Trennung zwischen **Referenztyp**  und **Objekttyp**
* Variable vom Typ Super-Klasse kann Objekte der Sub-Klasse speichern
* **Upcast:** Umwandlung in die Superklasse
    * **Explizit**/Manuell oder  **Implizit**/ Automatisch möglich
* **Downcast:** Rückumwandlung in die Subklasse
    * Erfolgt immer **Explizit**
    * Downcast eines falschen Objekts führt zu Fehler
* **instanceof:** Prüfung ob Objekt einen bestimmten Typ hat

---
### Polymorphie - Code
```java
public static void main(String[] args) {
    Car Id3 = new Car("VW", "ID.3", EngineEnum.ELECTRIC, 150);
    
    System.out.println(Id3.engine);                         // --> ELECTRIC

    Vehicle vehicle = (Vehicle) Id3;        // <-- upcast (explizit)
    Vehicle vehicle2 = Id3;                 // <-- upcast (implizit)
    System.out.println(vehicle.engine);                     // --> FEHLER

    Car car = (Car) vehicle;                // <-- downcast (explizit)
    System.out.println(car.engine);                         // --> ELECTRIC

    Boolean resultBool;
    resultBool = Id3 instanceof Vehicle;                    // --> true
}
```

---
## Abstract Modifier

---
## Final Modifier

---
## Interface

---
## Komparator

---
## Arrays
* Speichert mehrere Datenobjekte des selben Typs
* Fest definierte Anzahl an Datenobjekten

---
### Array - Deklaration
* Datentyp der zu speichernden Elemente + []
> Eckige Klammern [Länge]

```java
public static void main(String[] args) {
    int[] int_array = new int[6];
}
```

---
### Array - Initialisierung
* Datentyp der zu speichernden Elemente + []
> Geschweifte Klammern {Werte}

```java
public static void main(String[] args) {
    int[] int_array = {1,2,3,4,5,6};
}
```

---
### Array - Zugriff
* Mit eckigen Klammern
* Index beginnend bei 0!

```java
public static void main(String[] args) {
    int[] int_array = {1,2,3,4,5,6};
    int num_1 = int_array[0];
    int num_2 = int_array[5];

    System.out.println(num_1);
    // --> 1
    System.out.println(num_2);
    // --> 6
}
```

---
### Array - Zuweisung / Speichern
* Angabe des Index in eckigen Klammern
* Zuweisung mit Zuweisungsoperator '='

```java
public static void main(String[] args) {
    int[] int_array = {1,2,3,4,5,6};

    System.out.println(int_array[3]);
    // --> 4

    int_array[3] = 9;
    System.out.println(int_array[3]);
    // --> 9
}
```

---
### Array - Länge

```java
public static void main(String[] args) {
    int[] int_array = {1,2,3,4,5,6};

    System.out.println(int_array.length);
    // --> 6
}
```

---
### Array - Werte Anhängen 1/2
* Problem: Arrays haben feste Größe
* Lösung: Neues Array mit neuer Größe erstellen

```java
    public static void main(String[] args) {
        int[] int_array = {1,2,3,4,5,6};

        int[] int_array_long = new int[int_array.length + 1];

        for (int i = 0; i < int_array.length; i++) {
            int_array_long[i] = int_array[i];
        }

        int_array_long[6] = 7;

        for (int i : int_array_long) System.out.print(i + " ");
        // --> 1 2 3 4 5 6 7
    }
```

---
### Array - Werte Anhängen 2/2

```java
public static void main(String[] args) {
    int[] int_array = {1,2,3,4,5,6};

    int[] int_array_long = addToArray(int_array, 7);

    for (int i : int_array_long) System.out.print(i + " ");
    // --> 1 2 3 4 5 6 7
}

public static int[] addToArray(int[] array, int newElement){
    int[] returnArray = new int[array.length + 1];

    for (int i = 0; i < array.length; i++) {
        returnArray[i] = array[i];
    }

    returnArray[returnArray.length - 1] = newElement;

    return returnArray;
}
```

---
## ArrayList - Das besserer Array
* Bessere Verison des Standard Arrays
* Kommt mit vielen nützlichen Funktionen
* Benötigt mehr Speicherplatz

```java
public static void main(String[] args) {
    ArrayList<Integer> int_list = new ArrayList<>();
    System.out.println(int_list);
    // --> []

    int_list.add(1);
    int_list.add(2);
    int_list.add(3);

    System.out.println(int_list);
    // --> [1, 2, 3]
}
```

---
### ArrayList - Länge
* Länge einer ArrayList ist dynamisch --> muss berechnet werden
* Zugriff auf Länge über Funktion '.size()', **nicht** über Attribut '.length'

```java
public static void main(String[] args) {
    ArrayList<Integer> int_list = new ArrayList<>();
    System.out.println(int_list).size();
    // --> 0

    int_list.add(1);
    int_list.add(2);
    int_list.add(3);

    System.out.println(int_list.size());
    // --> 3
}
```

---
## Hilfsklassen - Math
* Standard Operatoren mit '+ - * /'
* Fortgeschrittenere Operatoren mit Funktionen von Math

```java
public static void main(String[] args) {
    double num_1 = -5;
    double num_2 = 5;
    double num_3 = 10;
    double result;

    result = Math.abs(num_1);
    System.out.println(result);         // --> 5.0

    result = Math.sqrt(num_2);
    System.out.println(result);         // --> 2.23606797749979

    result = Math.pow(num_2, num_3);
    System.out.println(result);         // --> 9765625.0
```

---
## Hilfsklassen - Random
* Zufällige Erzeugung von Ganzzahlen und Gleitkommazahlen

```java
public static void main(String[] args) {
    Random random = new Random();
    int rnd_num ;

    // Zahlen von 0 bis 99 --> 100 als exklusive Grenze
    rnd_num = random.nextInt(100);
    System.out.println(rnd_num);

    // Trick um Zahlen von 1 bis 100 zu erhalten
    rnd_num = random.nextInt(100);
    System.out.println(rnd_num+1);

    double rnd_double = random.nextDouble(100);
    System.out.println(rnd_double);
}
```

---
## Hilfsklassen - Scanner
* Scanner wird verwendet um Eingaben in der Konsole zu ermöglichen

```java
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Wie lautet dein Name?");
    String benutzerEingabe = sc.nextLine();

    System.out.println("Hallo " + benutzerEingabe + ", schön dich kennen zu lernen.");
    System.out.println("Wie alt bist du?");

    int alter = sc.nextInt();
    System.out.println("Du bist also " + alter + " Jahre alt");
}
```

---
## Objektorientierung
* Gängiges und leicht verständliches Programmier Paradigma
* Abbildung realer Gegenstände in digitale Objekte
* Objekte verfügen über spezifische Eigenschaften und Funktionen

> Beispiel __Auto__
Eigenschaften: Farbe, Leistung, Sitze, Türen, etc.
Funktioen: beschleunigen, bremsen, schließen, öffnen, etc.

---
### Objektorientierung - Auto Implementierung 1/4

```java
public class auto {
    String farbe;
    int leistungInPS;
    boolean isOpen;
    double aktuelleGeschwindigkeit;
    double maxGeschwindigkeit;

    public Auto(String farbe, int leistungInPS, double maxGeschwindigkeit){
        ...
    }

    public boolean beschleunigen(double extraSpeed){
        ...
    }

    public boolean bremsen(double lowerSpeed){
        ...
    }

    public boolean schließen(){
        ...
    }

    public boolean öffnen(){
        ...
    }
}
```

---
### Objektorientierung - Auto Implementierung 2/4

```java
public class auto {
    String farbe;
    int leistungInPS;
    boolean isOpen;
    double aktuelleGeschwindigkeit;
    double maxGeschwindigkeit;

    public Auto(String farbe, int leistungInPS, double maxGeschwindigkeit){
        this.farbe = farbe;
        this.leistungInPS = leistungInPS;
        this.maxGeschwindigkeit = maxGeschwindigkeit;
        this.aktuelleGeschwindigkeit = 0;
        this.isOpen = false;
    }

    ...
}
```


---
### Objektorientierung - Auto Implementierung 3/4

```java
public class auto {
    String farbe;
    int leistungInPS;
    boolean isOpen;
    double aktuelleGeschwindigkeit;
    double maxGeschwindigkeit;

    ...

    public boolean beschleunigen(double extraSpeed){
        if (this.aktuelleGeschwindigkeit + extraSpeed <= maxGeschwindigkeit) {
            this.aktuelleGeschwindigkeit += extraSpeed;
            return true;
        }
        return false;s
    }

    public boolean bremsen(double lowerSpeed){
        if (this.aktuelleGeschwindigkeit - lowerSpeed >=0) {
            this.aktuelleGeschwindigkeit -= lowerSpeed;
            return true;
        }
        return false;
    }

    ...
}
```


---
### Objektorientierung - Auto Implementierung 4/4

```java
public class auto {
    String farbe;
    int leistungInPS;
    boolean isOpen;
    double aktuelleGeschwindigkeit;
    double maxGeschwindigkeit;

    ...

    public boolean schließen(){
        if (this.isOpen) {
            this.isOpen = false;
            return true;
        }
        return false;
    }

    public boolean öffnen(){
        if (!this.isOpen) {
            this.isOpen = true;
            return true;
        }
        return false;
    }
}
```

---
### Objektorientierung - Auto Verwendung

```java
public class main {
    public static void main(String[] args) {
        Auto auto1 = new Auto("grün", 100, 130);

        System.out.println("Beschleunige um 100km/h");
        System.out.println("Erfolg: " + auto1.beschleunigen(100));
        System.out.println("Aktuelle Geschwindigkeit: " + auto1.aktuelleGeschwindigkeit);

        // Beschleunige um 100km/h
        // Erfolg: true
        // Aktuelle Geschwindigkeit: 100.0
    }
}
```

---
## Access Modifier
* Standard: jede Variable, jede Methode, jede Klasse kann von überall verwendet werden
* Access Modifier limitieren den Zugriff auf Variablen, Methoden und Klassen
> Wir kennen: public und private

---
### Access Modifier - Public
* Zugriff kann direkt und von überall erfolgen

```java
public class Mensch {
    public String name;
    public int alter;
    ...
}
```
```java
public class main {
    public static void main(String[] args) {
        Mensch thomas = new Mensch("Thomas", 21);

        System.out.println(thomas.name);
        System.out.println(thomas.alter);
    }
}
```

---
### Access Modifier - Private
* Zugriff nur innerhalb des Objektes möglich
* Variablen Abfrage über Getter/ Setter

<table>
<tr>
<td>

```java
public class Mensch {
    private String name;
    private int alter;

    public Mensch(String name, int alter){
        this.name = name;
        this.alter = alter;
    }

    public String getName(){
        return this.name;
    }

    public int getAlter(){
        return this.alter;
    }
}
```

</td>
<td>

```java
public class main {
    public static void main(String[] args) {
        Mensch thomas = new Mensch("Thomas", 21);

        System.out.println(thomas.getName());
        System.out.println(thomas.getAlter());
    }
}
```

</td>
</tr>
</table>

---
## Method Overloading
* Definition der gleichen Methode **aber** mit unterschiedlichen Argumenten
* Java ist clever und wählt die Implementierung, welcher den gegebenen Argumenten entspricht

<table>
<tr>
<td>

```java
public class Calculator {
    public int addNums(int num1, int num2){
        System.out.println("double integer implementation");
        return num1 + num2;
    }

    public int addNums(int num1, int num2, int num3){
        System.out.println("tripple integer implementation");
        return num1 + num2 + num3;
    }

    public double addNums(double num1, double num2){
        System.out.println("double implementation");
        return num1 + num2;
    }
}
```

</td>
<td>

```java
public class main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println(calc.addNums(1, 1));
        // double integer implementation
        // 2

        System.out.println(calc.addNums(1, 1, 1));
        // tripple integer implementation
        // 3

        System.out.println(calc.addNums(1.0, 1.0));
        // double implementation
        // 2.0
    }
}

```

</td>
</tr>
</table>

---
## Constructor
* Anleitung wie man die Instanz einer Klasse baut
* Definition als Methode ohne Return-Typ

```java
public class Mensch {
    private String name;
    private int alter;

    public Mensch(String name, int alter){
        this.name = name;
        this.alter = alter;
    }
}
```

---
### Constructor - Overloading

```java
public class Mensch {
    public String name;
    public int alter;

    public Mensch(String name, int alter){
        this.name = name;
        this.alter = alter;
    }

    public Mensch (String name){
        this.name = name;
        this.alter = 20;
    }

    public Mensch(int alter){
        this.name = "John Doe";
        this.alter = alter;
    }

    public Mensch(){
        this.name = "John Doe";
        this.alter = 20;
    }
}
```

---
### Constructor - Overloading Best Practice

```java
public class Mensch {
    public String name;
    public int alter;

    public Mensch(String name, int alter){
        this.name = name;
        this.alter = alter;
    }

    public Mensch (String name){
        this(name, 20);
    }

    public Mensch(int alter){
        this("John Doe", alter);
    }

    public Mensch(){
        this("John Doe", 20);
    }
}
```

---
## Static Modifier
* Unveränderliche Variable
* In allen Instanzen einer Klasse gleich

```java
public class Auto {
    private boolean isOpen = false;
    private double aktuelleGeschwindigkeit = 0;
    private double maxGeschwindigkeit;
    
    private static int anzahlRäder = 4;     // <-- Static Modifier

    public Auto(double maxGeschwindigkeit){
        this.maxGeschwindigkeit = maxGeschwindigkeit;

        this.anzahlRäder = 6;               // --> fehler
    }
    ...
}
```

---
## Übungen

> git fetch
git checkout <branch_name>

* Array & ArrayList: semester1/array-list
* ⁠Klassen: semester1/classes
* ⁠Access modifier: semester1/access-modifier
* ⁠Methoden Überladung: semester1/method-overloading