import java.util.*;
import java.util.stream.*;  

public class StreamIntermediate {

    public static void main(String[] args) {

        List<String> namen = Arrays.asList("Anna", "Bob", "Alex", "Ben", "Anna", "Clara");

        // 1. Filtern (filter)
        System.out.println("Filter: Namen mit A am Anfang");
        namen.stream()
                .filter(name -> name.startsWith("A")) // Predicate<T>
                .forEach(System.out::println);

        // 2. Abbilden (map)
        System.out.println("\nMap: Namen in Großbuchstaben");
        namen.stream()
                .map(String::toUpperCase) // Function<T, R>
                .forEach(System.out::println);

        // 3. Abbilden auf Double (mapToDouble)
        System.out.println("\nMapToDouble: Länge der Namen als double");
        namen.stream()
                .mapToDouble(name -> (double) name.length()) // ToDoubleFunction<T>
                .forEach(System.out::println);

        // 4. Abbilden auf Int (mapToInt)
        System.out.println("\nMapToInt: Länge der Namen als int");
        namen.stream()
                .mapToInt(String::length) // ToIntFunction<T>
                .forEach(System.out::println);

        // 5. Abbilden auf Long (mapToLong)
        System.out.println("\nMapToLong: Länge der Namen als long");
        namen.stream()
                .mapToLong(name -> (long) name.length()) // ToLongFunction<T>
                .forEach(System.out::println);

        // 6. Spähen (peek)
        System.out.println("\nPeek: Seiteneffekt (Debug-Ausgabe vor toUpperCase)");
        List<String> result = namen.stream()
                .peek(name -> System.out.println("Original: " + name)) // Consumer<T>
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Result: " + result);

        // 7. Sortieren (sorted mit Comparator)
        System.out.println("\nSorted: Nach Länge der Namen sortiert");
        namen.stream()
                .sorted(Comparator.comparingInt(String::length)) // Comparator<T>
                .forEach(System.out::println);

        // 8. Unterscheiden (distinct)
        System.out.println("\nDistinct: Duplikate entfernen");
        namen.stream()
                .distinct()
                .forEach(System.out::println);

        // 9. Begrenzen (limit)
        System.out.println("\nLimit: Nur die ersten 3 Namen");
        namen.stream()
                .limit(3)
                .forEach(System.out::println);

        // 10. Überspringen (skip)
        System.out.println("\nSkip: Erste 2 Namen überspringen");
        namen.stream()
                .skip(2)
                .forEach(System.out::println);
    }
}
