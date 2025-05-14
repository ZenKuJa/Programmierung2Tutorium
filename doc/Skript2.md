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

# Tutorium Programmierung 2
> 15.05.2025

Janens Kurzke und Fabian Bauriedl

---
## Inhalt

1. Exceptions
1. Generics
1. Datenstrukturen
1. Big-O-Notation
1. Git

---
### Exceptions
* Fehler die während der Laufzeit auftreten
* Dienen zur Kommunikation
* Manuelles auslösen über throw
* Abfangen über catch
* Exceptions sind Klassen/ Objekte
---
### Exceptions werfen

```Java
public static void checkAge(int age) throws Exception {
    if(age < 18) {
        throw new Exception("You're to young");
    }
}
```

---
### Eigene Exceptions

```Java
public class CustomExceptions extends Exception{
    CustomExceptions(String message){
        super(message);
        System.out.println("I am a custom exception");
    }
}
```

---
### Exceptions fangen

```Java
public static void main(String[] args) {
    try {
        checkAge(17);
    } catch (ToYoungException e) {
        System.out.println("User appears to be to young");
    } catch (Exception e) {
        System.out.println("An unknown error occured");
    } finally {
        System.out.println("finished try catch block");
    }
}
```

---
### Generics
* Generische Klassen und Interfaces
* Bezieht sich auf Parameter/ Argumente
* Funktionalität unabhängig von Typen implementieren

---
### Generics Anwendung

*  Verwendung des komplexen Datentypes

```Java
public static void main(String[] args) {
    ArrayList<String> names = new ArrayList<>();
    names.add("Christian");
    names.add("Sabine");
    int len = names.size();
    names.remove(0);
}
```

---
### Generics Implementierung

```Java
public class Paar<T, U> {
    private final T firstElement;
    private final U secondElement;

    public Paar(T firstElement, U secondElement){
        this.firstElement = firstElement;
        this.secondElement = secondElement;
    }

    @Override
    public String toString(){
        return firstElement + " and " + secondElement;
    }
}
```

---
### Optionals
* Java Klasse
* Vermeidung von Nullpointer Exceptions
* Zugriff auf Werte über umwege

---
### Optionals Anwendung I

```Java
Optional<String> name = Optional.of("Lindner");
if (name.isPresent()){
    System.out.println("there is a name");
}
```

---
### Optionals Anwendung II

```Java
String userInput = null;
Optional<String> userName = Optional.ofNullable(userInput);

userName.ifPresentOrElse(
    (value) -> System.out.println(value),
    () -> System.out.println("there is no name"));
```

---
## Datenstrukturen
1. Stack
1. Queue
1. List
1. Tree
1. HashMap

---
### Stack
* Stapel von Elementen
* Neue Elemente werden oben angefuegt
* Zugriff nur von oben moeglich
* Neueste Elemente zuerst --> Last in First Out
* z.B. Undo/ Redo, Browserverlauf

---
### Stack Operationen
|Return|Method|Description|
|---|---|---|
|boolean|empty()|check ob stack leer ist|
|E|peek()|gibt oberstes Objekt und behält es|
|E|pop()|gibt oberstes Objekt und entfernt es|
|E|push(E item)|fügt Objekt oben an|
|int| search(Object o)| sucht Objekt und gibt Position zurück|

---
### Stack
<img src="https://media.geeksforgeeks.org/wp-content/cdn-uploads/20230726165552/Stack-Data-Structure.png" alt ="Stack Visual Description">

---
### Queue
* Stapel von Elementen
* Neue Elemente werden unten angefuegt
* Zugriff nur von oben moeglich
* Älteste Elemente zuerst --> First in First Out
* z.B. Datenübertragung, Warteschlangen, Schedular (Betriebssysteme)

---
### Queue Operationen
|Return|Method|Description|
|---|---|---|
|boolean|add(E e)|fügt Objekt ein wenn möglich, true bei Erfolg, Exception bei Misserfolg|
|E|element()|gibt oberstes Objekt und behält es|
|boolean|offer()|fügt Objekt ein wenn möglich|
|E|peek()|gibt oberstes Objekt und behält es, oder null wenn leer|
|E|peek()|gibt oberstes Objekt und entfernt es, oder null wenn leer|
|E| remove()|gibt oberstes Objekt und entfernt es|

---
### Queue
<img src="https://media.geeksforgeeks.org/wp-content/cdn-uploads/20230726165642/Queue-Data-structure1.png" alt = "Queue Visual Description">

---
### List

---
### Tree

---
### Map

---
### HashMap

---
## Big-O-Notation

---
## Git
