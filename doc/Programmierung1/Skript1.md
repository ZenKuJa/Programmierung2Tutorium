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
</style>

# Tutorium Programmierung 1
> 21.01.2026

Jannes Kurzke und Fabian Bauriedl

---
## Inhalt
1. Git Basics
1. Datentypen
1. Operatoren
1. Methoden
1. Array und ArrayList
1. Kontrollstrukturen + Ternary Operator
1. Schleifen

---
## Organisatorisches
> Steffen und Mario behandeln die Themen in unterschiedlicher Reihenfolge

---
## Organisatorisches
Komm in die Gruppe!
<img src = "..//resources//whatsapp1.png" alt = "whatsapp groupd qr code">

---
## Git Basics
<img src = "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.20i.com%2Fblog%2Fwp-content%2Fuploads%2F2022%2F08%2Fgit-blog-header.png&f=1&nofb=1&ipt=37271629cf8cc015af36d6c0bd667234949c8a65234a980ba224316731fc7b56" alt = "Git Basics">

---
### Git Basics - Branches
<img src = "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.softwaretestingo.com%2Fwp-content%2Fuploads%2F2022%2F07%2FDifferent-Git-Branch.png&f=1&nofb=1&ipt=c5f9cfbcd17a6fe532661bfce11605804c531e8a0ef812f4843d556283ad054d" alt = "Git Branches">

---
### Git Basics - Staging
<img src = "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fgit-scm.com%2Fimages%2Fabout%2Findex1%402x.png&f=1&nofb=1&ipt=7939c67fe099b91267690043d51b1683e524d8687a9228607d7737cb5c15f730" alt = "Git Staging">

---
### Git Basics - Commands

|Befehl|Beispiel|
|---|---|
|git clone|git clone https://github.com/Kona418/ProgrammierungTutorium.git|
|git add <>|git add ReadMe.md|
|git commit -m""|git commit -m"Updated Repo name in ReadMe"|
|git push||
|git pull||
|git branch||
|git checkout| git checkout exercise/strings|

---
## Datentypen
* Bestimmung wie Daten gespeichert und gelesen werden
* Planbarkeit von Speicherbedarf
* Integrierte Limitierung des Wertebereichs
> Unterscheidung zwischen primitiven und komplexen Datentypen

---
### Datentypen - Wahrheitswerte

|Datentyp|Größe|Wertebereich|
|---|---|---|
|boolean|1 Bit|true, false|

---
### Datentypen - Ganzzahlen

|Datentyp|Größe|Wertebereich|
|---|---|---|
|byte|1 Byte|-128 bis +127|
|short|2 Byte|-32.768 bis +32.767|
|int|4 Byte|-2.1 Mrd bis +2.1 Mrd|
|long|8 Byte|-9.2 Trill bis + 9.2 Trill|

---
### Datentypen - Gleitkommazahlen

|Datentyp|Größe|Wertebereich|
|---|---|---|
|float|4 Byte|-3,4\*10^38 bis 3,4\*10^38|
|double|8 Byte|-1,7\*10^308 bis 1,7\*10^308|

---
### Datentypen - Zeichen

|Datentyp|Größe|Wertebereich|
|---|---|---|
|char|2 Byte|\u0000 bis \uFFFF|
|String|variable Größe|jedes einzelne Zeichen wie bei char|

---
## Datenobjekte/ Variablen
* Variablen werden als Zwischenspeicher für Werte verwendet
* Variablen haben einen festen Datentyp
* Deklaration legt eine Variable an und reserviert Speicherplatz
* Initialisierung befüllt den reservierten Speicherplatz mit einem Wert

---
### Datenobjekte/ Variablen - Anlegen
```Java
public static void main(String[] args) {

    // Deklaration der Variable "name"
    String name;

    // Initialisierung der Variable "name" mit dem Wert "Thorsten"
    name = "Thorsten";

    // Deklaration und Initialisierung der Variable "alter" mit dem Wert "19"
    int alter = 19;
}
```
---
## Operatoren
* Berechnungen bzw. Umwandlung der in den Variablen gespeicherten Werte
* Verschiedene Operationen je nach Datentyp erlaubt
* Verschiedene Ergebnisse bei gleicher Operation je nach Datentyp

---
### Addition, Subtraktion, Multiplikation

```Java
public static void main(String[] args) {

    int numA = 10;
    int numB = 5;
    int result;

    result = numA + numB;
    System.out.println(result);
    // 15

    result = numA - numB;
    System.out.println(result);
    // 5

    result = numA * numB;
    System.out.println(result);
    // 50
}
```

---
### Division

```Java
public static void main(String[] args) {

    int numAInt = 10;
    int numBInt = 4;
    int resultInt;

    resultInt = numAInt / numBInt;
    System.out.println(resultInt);
    // 2

    double numADouble = 10;
    double numBDouble = 4;
    double resultDouble;

    resultDouble = numADouble / numBDouble;
    System.out.println(resultDouble);
    //2.5
}
```

---
### String Addition
```Java
public static void main(String[] args) {

    String text1 = "Hello ";
    String text2 = "World!";

    System.out.println(text1 + text2);
    // Hello World!
}
```

---
### Vergleichsoperatoren

```java
public static void main(String[] args) {

    int numA = 10;
    int numB = 5;
    boolean result;

    result = numA > numB;
    System.out.println(result);
    // true

    result = numA < numB;
    System.out.println(result);
    // false

    result = numA == numB;
    System.out.println(result);
    // false

    result = numA != numB;
    System.out.println(result);
    // true
}
```

---
### Boolische Operatoren

```java
public static void main(String[] args) {

    boolean boolA = true;
    boolean boolB = false;
    boolean result;

    result = boolA && boolA;
    System.out.println(result);
    // true

    result = boolB || boolB;
    System.out.println(result);
    // false

    result = boolA || boolB;
    System.out.println(result);
    // true

    result = !boolA;
    System.out.println(result);
    // false
}
```

---
### Konvertierung von Variablentypen
```Java
public static void main(String[] args) {
    
    int numA = 10;
    System.out.println(numA);
    // 10

    double numB;
    numB = (double) numA;
    System.out.println(numB);
    // 10.0
}
```

---
## Methoden

* Main-Methode ist der Einstiegspunkt in das Programm
* Code-Abschnitte die mehrfach verwendbar sind
* Java kommt mit vielen nützlichen Standard Methoden
* Methoden lassen sich selbst definieren

---
### Hilfsmethoden komplexer Datentypen
```java
public static void main(String[] args) {
    
    String name = "Thorsten";
    char firstLetter;

    firstLetter = name.charAt(0);
    System.out.println(firstLetter);
    // "T"
}
```

---
### Hilfsmethoden komplexer Datentypen
```java
public static void main(String[] args) {
    
    String userInput = "19";
    System.out.println(userInput * 2);
    // **error**

    int age;
    age = Integer.parseInt(userInput);
    System.out.println(age * 2);
    // 38
}
```

---
### Methoden - Aufbau

|Bestandteil|Inhalt|
|---|---|
|Rückgabetyp|void, int, String, double, ...|
|Bezeichner|Name der Methode|
|Parameter|Eingabevariablen|
|Methodenrumpf|Auszuführender Code|

---
### Methoden Beispiel Addition

```java
public static void main(String[] args) {

    int result;
    result = intAdder(10, 5);
    System.out.println(result);
    // 15
}

public static int intAdder(int numA, int numB){

    int internalResult = numA + numB;
    return internalResult;
}
```
---
### Methoden Beispiel Alter Check

```java
public static void main(String[] args) {

    boolean result;
    result = ageCheck(19);
    System.out.println(result);
    // true

    result = ageCheck(15);
    System.out.println(result);
    // false
}

public static boolean ageCheck(int age){

    boolean isAdult = age >= 18;
    return isAdult;
}
```
---
## Kontrollstrukturen
* Ausführung bestimmter Code-Abschnitte bei Erfüllung einer Bedingung
* Angbae eines alternativen Code-Abschnitts wenn Bedingung nicht erfüllt ist
* Vielseitiges Werkezug zum Erreichen eines komplexen Programm-Ablaufs

---
### Aufbau von If-Anweisungen
* if Schlüsselwort
* Bedingung
* Code Block

```java
public static void main(String[] args) {
    int age = 19;
    if (age >= 18) {
        System.out.println("Come in");
    }
}
```

---
### Aufbau von If-Else-Anweisungen
* if Schlüsselwort
* Bedingung
* Erfolg Code Block
* Misserfolg Code Block

```java
public static void main(String[] args) {
    int age = 19;
    if (age >= 18) {
        System.out.println("Come in");
    } else {
        System.out.println("Adults only!");
    }
}
```

---
### If-Else-Ketten

```java
public static void main(String[] args) {
    
    int age = 18;
    if (age > 18) {
        System.out.println("Come in");

    } else if (age == 18){
        System.out.println("You're just old enough");

    }
    else {
        System.out.println("Adults only!");
    }
}
```
---
### Switch-Case
* Ähnlich zu If-Else Anweisungen
* Entscheidung basiert hier auf dem Wert einer Variable
* Kann je nach Anwendung und Programmiersprache schneller sein als If-Else

### Switch Aufbau
* Switch Schlüsselwort
* Variable die geprüft wird
* Case Schlüsselwort mit Wert
* Code Block
* Break Schlüsselwort
* Code Block

---
### Switch-Case Beispiel
```java
public static void main(String[] args) {
    char gender = 'j';
    switch (gender) {
        case 'm':
            System.out.println("männlich");
            break;
        case 'w':
            System.out.println("weiblich");
            break;
        case 'd':
            System.out.println("divers");
            break;
        default:
            System.out.println("nur \"m|w|d\" zugelassen");
            break;
    }
}
```

---
### Ternary Operator
* Kurzform der If-Else Anweisung

```java
public static void main(String[] args) {

    int numA = 10;
    int numB = 5;
    String result;

    if (numA > numB) {
        result = "greater";
    } else {
        result = "less";
    }

    result = numA > numB ? "greater" : "less";
    System.out.println(result);
    // greater
}
```
---

## Übungen (Stand 21.01.2026)
**Vorbereitung:**
* In VSCode/IntelliJ Terminal öffnen
* Repository klonen:
* 'git clone https://github.com/Kona418/ProgrammierungTutorium.git'
* 'cd ProgrammierungTutorium'
* Alternativ: Menüpunkt 'Neues Projekt aus Versionskontrolle' aufrufen und Repository Link einfügen

---


**Verfügbare Themen:**
* 'datatypes'
* 'methoden'
* 'kontrollstrukturen'

**Übungen öffnen:**
* nacheinander im Terminal ausführen (Thema aus Liste für THEMA einsetzen):
* 'git stash'
* 'git checkout semester1/THEMA'
* Im Ordner THEMAExercises sind die Aufgaben, in THEMASolutions die Lösungen
* Die Kommentare im Code beschreiben, was zu tun ist!

---
## Zeit zum Üben
<img src = "..//resources//github.png" alt = "github repo">
