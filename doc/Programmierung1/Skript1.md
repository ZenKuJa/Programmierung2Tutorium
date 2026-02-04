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





<!--
---
## Array
* Speicherung mehrere Variablen des gleichen Datentyps
* Speichert eine fest definierte Anzahl an Variablen


---
## Schleifen

---
## Rekursion

<img src = "https://blog.penjee.com/wp-content/uploads/2016/05/factorial-code-animation.gif" alt = "recursion">

---
## Suchalgorithmen
> Linear Search

<img src = "https://sushrutkuchik.wordpress.com/wp-content/uploads/2020/05/linear_search.gif?w=438" alt ="Linear Search" height = "250">

---
## Suchalgorithmen
> Linear Search

```Java
public static int search(int array[], int N, int x) {
    for (int i = 0; i < N; i++) {
        if (array[i] == x)
            return i;
    }
    return -1;
}
```
---
## Suchalgorithmen
> Binäre Suche

<img src = "https://sushrutkuchik.wordpress.com/wp-content/uploads/2020/05/bepceumnsg-binary_search_gif.gif" alt ="Binary Search" height = "250">

---
## Suchalgorithmen
> Binäre Suche

```Java
static int binarySearch(int array[], int l, int r, int x){
    while (l <= r) {
        int m = (l + r) / 2;

        if (array[m] == x) {
            return m;
        } else if (array[m] > x) {
            r = m - 1;
        } else {
            l = m + 1;
        }
    }
    return -1;
}
```

---
## Suchalgorithmen
> Interpolationssuche

<img src = "https://upload.wikimedia.org/wikipedia/commons/0/08/Interpolation_sort.gif" alt ="Interpolation Search" height = "250">

---
## Suchalgorithmen
> Interpolationssuche

```Java
public static int interpolationSearch(int array[], int lo, int hi, int x) {
    int pos;

    if (lo <= hi && x >= array[lo] && x <= array[hi]) {
        pos = lo + (((hi - lo) / (array[hi] - array[lo])) * (x - array[lo]));

        if (array[pos] == x) return pos;

        if (array[pos] < x) return interpolationSearch(array, pos + 1, hi, x);

        if (array[pos] > x) return interpolationSearch(array, lo, pos - 1, x);
    }
    return -1;
}
```

---
## Sortieralgorithmen
> Selection Sort

<img src = "https://upload.wikimedia.org/wikipedia/commons/3/3e/Sorting_selection_sort_anim.gif" alt ="selection sort" height = "250">

---
## Sortieralgorithmen
> Selection Sort

```Java
public static void selectionSort(int[] array) {
    int arrayLength = array.length;

    for (int currentPosition = 0; currentPosition < arrayLength - 1; currentPosition++) {
        int minimumIndex = currentPosition;

        for (int index = currentPosition + 1; index < arrayLength; index++) {
            if (array[index] < array[minimumIndex]) {
                minimumIndex = index;
            }
        }

        int temporary = array[minimumIndex];
        array[minimumIndex] = array[currentPosition];
        array[currentPosition] = temporary;
    }
}
```
---
## Sortieralgorithmen
> Bubble Sort

<img src = "https://upload.wikimedia.org/wikipedia/commons/5/54/Sorting_bubblesort_anim.gif?20140912160204" alt ="bubble sort" height = "250">

---
## Sortieralgorithmen
> Bubble Sort

```Java
public static void bubbleSort(int[] array) {
    int arrayLength = array.length;
    
    for (int pass = 0; pass < arrayLength - 1; pass++) {
        for (int index = 0; index < arrayLength - pass - 1; index++) {
            if (array[index] > array[index + 1]) {
                int temporary = array[index];
                array[index] = array[index + 1];
                array[index + 1] = temporary;
            }
        }
    }
}
```
---
## Sortieralgorithmen
> Insertion Sort

<img src = "https://upload.wikimedia.org/wikipedia/commons/2/24/Sorting_insertion_sort_anim.gif" alt ="insertion sort" height = "250">

---
## Sortieralgorithmen
> Insertion Sort

```Java
public static void insertionSort(int[] array) {
    int arrayLength = array.length;

    for (int index = 1; index < arrayLength; index++) {
        int currentValue = array[index];

        int position = index;
        while (position > 0 && array[position - 1] > currentValue) {
            array[position] = array[position - 1];
            position--;
        }
        array[position] = currentValue;
    }
}
```
---
## Sortieralgorithmen
> Quick Sort

<img src = "https://upload.wikimedia.org/wikipedia/commons/6/6a/Sorting_quicksort_anim.gif" alt ="quick sort" height = "250">

---
## Sortieralgorithmen
> Quick Sort

```Java
public static void quickSort(int[] array, int left, int right) {
    if (left < right) {
        int partitionIndex = partition(array, left, right);
        quickSort(array, left, partitionIndex - 1);

        quickSort(array, partitionIndex + 1, right);
    }
}
```
---
## Sortieralgorithmen
> Quick Sort

```Java
private static int partition(int[] array, int left, int right) {
    int pivot = array[right];
    int i = left - 1;
    for (int j = left; j < right; j++) {
        if (array[j] < pivot) {
            i++;
            int temporary = array[i];
            array[i] = array[j];
            array[j] = temporary;
        }
    }
    int temporary = array[i + 1];
    array[i + 1] = array[right];
    array[right] = temporary;
    return i + 1;
}
```

---
## Sortieralgorithmen
> Merge Sort
<img src = "https://upload.wikimedia.org/wikipedia/commons/c/cc/Merge-sort-example-300px.gif" alt ="merge sort" height = "250">

---
## Sortieralgorithmen
> Merge Sort

```Java
public static void mergeSort(int[] array, int left, int right) {
    if (left < right) {
        int middle = (left + right) / 2;
        mergeSort(array, left, middle);

        mergeSort(array, middle + 1, right);
        merge(array, left, middle, right);
    }
}
```

---
## Sortieralgorithmen
> Merge Sort

```Java
private static void merge(int[] array, int left, int middle, int right) {
    int leftArrayLength = middle - left + 1;
    int rightArrayLength = right - middle;

    int[] leftArray = new int[leftArrayLength];
    int[] rightArray = new int[rightArrayLength];

    for (int i = 0; i < leftArrayLength; ++i)
        leftArray[i] = array[left + i];
    for (int j = 0; j < rightArrayLength; ++j)
        rightArray[j] = array[middle + 1 + j];

    int i = 0;
    int j = 0;
    int k = left;

    while (i < leftArrayLength && j < rightArrayLength) {
        if (leftArray[i] <= rightArray[j]) {
            array[k] = leftArray[i];
            i++;
        } else {
            array[k] = rightArray[j];
            j++;
        }
        k++;
    }
    while (i < leftArrayLength) {
        array[k] = leftArray[i];
        i++;
        k++;
    }
    while (j < rightArrayLength) {
        array[k] = rightArray[j];
        j++;
        k++;
    }
}
```
-->
---
## Zeit zum Üben
<img src = "..//resources//github.png" alt = "github repo">
