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

# Tutorium Programmierung 4

> 26.05.2025

Jannes Kurzke und Fabian Bauriedl

---

## Inhalt

1. Lambda Ausrücke
1. Streams

---

## Lambda Ausdrücke

* Anonyme Funktionen, nur über Referenz ansprechbar
* Nehmen Parameter entgegen
* Verarbeiten Paramenter
* Können Wert zurückgeben

---

## Lambda Ausdrücke

1. parameter -> expression
1. (parameter1, parameter2) -> expression
1. (parameter1, parameter2) -> { code block }

---

## Lambda Ausdrücke

* **Expressions** 
    * können keine Variablen anlegen
    * return keyword kann weggelassen werden
    * können keine komplexen Operationen verwendne (if, for, ...)
* **Code Blöcke**
    * können Variablen anlegen und verwalten
    * return keyword ist nötig für returns
    * Verwendugn komplexer Operationen möglich

---

## Lambda Beispiel

```java
public static void main(String[] args) {
    LinkedList<Integer> numbers = new LinkedList<Integer>();
    for (int i = 0; i < 10; i++) {
        numbers.add(i);
    }
}
```

> Wie würdet ihr nun alle werte der Liste ausgeben lassen?

---

## Lambda Beispiel

```java
public static void main(String[] args) {
    LinkedList<Integer> numbers = new LinkedList<Integer>();
    for (int i = 0; i < 10; i++) {
        numbers.add(i);
    }

    for (Integer number : numbers) {
        System.out.println(number);
    }
}
```

---

## Lambda Beispiel

```java
public static void main(String[] args) {
    LinkedList<Integer> numbers = new LinkedList<Integer>();
    for (int i = 0; i < 10; i++) {
        numbers.add(i);
    }

    numbers.forEach((number) -> System.out.println(number));
}
```
### Lambda Ausdruck


```java
(number) -> System.out.println(number)
```

---

### Lambda Ausdrücke

> Besteht die Lambda funktion nur aus einem Methodenaufruf, kann sie kürzer gefasst werden

* <Klasse der Methode> :: <Methode>
```java
System.out::println
```

---

### Lambda Ausdrücke

```java
public static void main(String[] args) {
    LinkedList<Integer> numbers = new LinkedList<Integer>();
    for (int i = 0; i < 10; i++) {
        numbers.add(i);
    }

    numbers.forEach(System.out::println);
}
```

---

## Vorteile von Lambdas

1. Lesbarer Code
1. Unterstützung von Funktionaler Programmierung
1. Paralele Verarbeitung mit Streams
1. Einführung neuer APIs und Bibliotheken

---

## Javas Stream API

* Ermöglicht das Arbeiten mit Strömen
* Verarbeitung von verketteten Elementen
* Intermediäre und Terminale Operationen
* Elemente werden nicht verändert
* Verarbeitung bei Bedarf

---

## Erzeugen von Streams

```java
public static void main(String[] args) {
    // Felder
    int[] array = {4, 8, 15, 16, 23, 42};
    IntStream integerStream = Arrays.stream(array);

    // Datensammlung
    List<Integer> list = List.of(4, 8, 15, 16, 23, 42);
    Stream<Integer> integerStream2 = list.stream();     

    // Einzelobjekte
    Stream<Integer> integerStream3 = Stream.of(4, 8, 15, 16, 23, 42);
}
```

---

## Spezifische Streams

* **IntStreams**, **DoubleStreams** und **LongStreams**
* Methoden zur verarbeitung der primitiven Datentypen

```java
public static void main(String[] args) {
    int[] array = {4, 8, 15, 16, 23, 42};
    IntStream integerStream = Arrays.stream(array);
    int sum = integerStream.sum();
}
```
---
# Intermediäre Operationen 1/3

|Operation|Methode|Schnittstellen-Methode|
|---|---|---|
|Filtern|Stream<T> filter(predicate: Predicate<T>)|boolean test(t: T)
|Abbilden|Stream<T> map(mapper: Function<T, R>)|R apply(t: T)
|Abbilden|DoubleStream mapToDouble(mapper: ToDoubleFunction<T, R>)|double applyAsDouble(value: T)
|Abbilden|IntStream mapToInt(mapper: ToIntFunction<T, R>)|int applyAsInt(vaue: T)

---
# Intermediäre Operationen 2/3

|Operation|Methode|Schnittstellen-Methode|
|---|---|---|
|Abbilden|LongStream mapToLong(mapper: ToLongFunction<T, R>)|long applyAsLong(value: T)
|Spähen|Stream<T> peek(consumer: Consumer<T>)|void accept(t: T)
|Sortieren|Stream<T> sorted(comparator: Comparator<T>)|int compare(o1: T, o2: T)

---
# Intermediäre Operationen 3/3

|Operation|Methode|Schnittstellen-Methode|
|---|---|---|
|Unterscheiden|Stream<T> distinct()|-
|Begrenzen|Stream<T> limit(maxSize: long)|-
|Überspringen|Stream<T> skip(n: long)|-

---
## Terminale Operationen 1/2

|Operation|Methode|Schnittstellen-Methode|
|---|---|---|
|Finden|Optional<T> findAny()|-
|Finden|Optional<T> findFirst()|-
|Prüfen|boolean allMatch(predicate: Predicate<T>)|boolean test(t: T)
|Prüfen|boolean anyMatch(predicate: Predicate<T>)|boolean test(t: T)
|Prüfen|boolean noneMatch(predicate: Predicate<T>)|boolean test(t: T)

---
## Terminale Operationen 2/2
|Operation|Methode|Schnittstellen-Methode|
|---|---|---|
|Aggregieren|Optional<T> min(comparator: Comparator<T>)|int compare(o1: T, o2: T)
|Aggregieren|Optional<T> max(comparator: Comparator<T>)|int compare(o1: T, o2: T)
|Aggregieren|long count()|-
|Sammeln|R collect(collector: Collector<T, A, R>)|-
|Ausführen|void forEach(action: Consumer<T>)|void accept(t: T)

---
## Stream Beispiel
```java
public static void main(String[] args) {

    Stream.of(4, 8, 15, 16, 23, 42).filter(
        i -> {
            System.out.println(i + ": filter 1");
            return i % 2 == 0;
        }
    )
    .filter(
        i -> {
            System.out.println(i + ": filter 2");
            return i > 15;
        }
    )
    .forEach(
        i -> System.out.println(i + ": forEach")
    );
}
```

---
## Streams ohne Bedarfsauswertung

```console
4: filter 1
8: filter 1
15: filter 1
16: filter 1
23: filter 1
42: filter 1
4: filter 2
8: filter 2
16: filter 2
42: filter 2
16: forEach
42: forEach
```

---
## Streams mit Bedarfsauswertung
```console
4: filter 1
4: filter 2
8: filter 1
8: filter 2
15: filter 1
16: filter 1
16: filter 2
16: forEach
23: filter 1
42: filter 1
42: filter 2
42: forEach
```

---
## Unendliche Streams
* Java ermöglicht das erstellen von unendlichen Strömen
* Stream.iterate()
* Stream.generate()

---
## Unendliche Streams Beispiel
```java
public static void main(String[] args) {

    //Stream<T> iterate(seed: T, f: UnaryOperator<T>)
    Stream.iterate(0, i -> ++i)
        .limit(100)
        .forEach(System.out::println);

    //Stream<T> iterate(seed: T, hasNext: Predicat <T>, next: UnaryOperator<T>)
    Stream.iterate(0, i -> i < 100, i -> ++i)
        .forEach(System.out::println);

    //Stream<T> generate(s: Supplier<T>)
    Stream.generate(() -> new Random()
        .nextInt(100))
        .limit(100)
        .forEach(System.out::println);
}
```