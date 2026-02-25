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
> 25.02.2026

Jannes Kurzke und Fabian Bauriedl

---
## Inhalt

1. Exceptions
1. Übungen

---
## Exceptions
* Fehler die während der Laufzeit auftreten
* Dienen zur Kommunikation zwischen Entwickler und Verwender
* Manuelles auslösen über **throw**
* Exceptions sind Klassen/ Objekte
---
### Exceptions - auslösen

```Java
public static void checkAge(int age) throws Exception {
    if(age < 18) {
        throw new Exception("You're to young");
    }
}
```

---
### Exceptions - selbst erstellen

```Java
public class CustomExceptions extends Exception{
    CustomExceptions(String message){
        super(message);
        System.out.println("I am a custom exception");
    }
}
```
> Erbt von der Basis-Klasse **Exception**

---
### Exceptions - abfangen 1/3

```Java
public static void main(String[] args) {
    try {
        checkAge(17);
    } catch (ToYoungException e) {
        System.out.println("User appears to be to young");
    }
}
```

---
### Exceptions - abfangen 2/3

```Java
public static void main(String[] args) {
    try {
        checkAge(17);
    } catch (ToYoungException e) {
        System.out.println("User appears to be to young");
    } catch (Exception e) {
        System.out.println("An unknown error occured");
    }
}
```

---
### Exceptions - abfangen 3/3

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
## Ressourcen
* Objekte, die nach Nutzung freigegeben werden **müssen**
    * z.B. Dateien, Datenbankverbindungen, Streams, Scanner
* Nicht freigeben der Ressource führt zu Speicher leak
* Ressourcen mit **.close()** Methode schließen
* Try-with-Ressource - Ressource muss **AutoCloseable** Interface implementieren

---
### Ressource - manuell schließen

```java
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);                // <-- Scanner ist hier Ressource

    System.out.print("Wie lautet dein Name? ");
    String userName = sc.nextLine();
    System.out.println("Hallo " + userName + ", schön dich kennen zu lernen!");

    sc.close();                                         // <-- Ressource wird manuell geschlossen
}
```

---
### Ressource - Try-with-Ressource 1/3
```java
public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) { // <--  Scanner ist hier Ressource
                                                //      Scanner wird bei verlassen des try-Blocks geschlossen
        System.out.print("Wie lautet dein Name? ");
        String userName = sc.nextLine();
        System.out.println("Hallo " + userName + ", schön dich kennen zu lernen!");

    } catch (Exception e) {
        e.printStackTrace();
    }
}
```

---
### Ressource - Try-with-Ressource 2/3
```java
public static void main(String[] args) {
    try {
        Scanner sc = new Scanner(System.in);    // <--  Scanner ist hier Ressource

        System.out.print("Wie alt bist du? ");
        int userAge = sc.nextInt();             // <-- Exception wenn kein int
        System.out.println("Du bist als " + userAge + " Jahre alt.");

        sc.close();                             // <-- Scanner wird manuell geschlossen
    } catch (Exception e) {
        System.out.println("User age was probably not a String-object");
                                                // <-- Scanner ist noch offen
    }
}
```

---
### Ressource - Try-with-Ressource 3/3
```java
public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)){      // <--  Scanner ist hier Ressource

        System.out.print("Wie alt bist du? ");
        int userAge = sc.nextInt();                 // <-- Exception wenn kein int
        System.out.println("Du bist als " + userAge + " Jahre alt.");

    } catch (Exception e) {                         // <-- Scanner wird bei verlassen des try-blocks geschlossen
        System.out.println("User age was probably not a String-object");
    }
}
```
---
# Zeit für Übungen!