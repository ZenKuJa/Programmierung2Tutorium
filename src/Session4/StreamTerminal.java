import java.util.*;
import java.util.stream.*;

public class StreamTerminal {

    public static void main(String[] args) {

        List<String> namen = Arrays.asList("Anna", "Bob", "Alex", "Ben", "Anna", "Clara");

        // 1. findAny
        System.out.println("findAny: Beliebiges Element");
        Optional<String> anyName = namen.stream()
                .findAny(); // beliebiges Element
        anyName.ifPresent(System.out::println);

        // 2. findFirst
        System.out.println("\nfindFirst: Erstes Element");
        Optional<String> firstName = namen.stream()
                .findFirst(); // erstes Element
        firstName.ifPresent(System.out::println);

        // 3. allMatch
        System.out.println("\nallMatch: Alle Namen haben Länge > 2?");
        boolean alleLangGenug = namen.stream()
                .allMatch(name -> name.length() > 2); // Predicate<T>
        System.out.println(alleLangGenug);

        // 4. anyMatch
        System.out.println("\nanyMatch: Gibt es Namen, die mit B beginnen?");
        boolean jemandMitB = namen.stream()
                .anyMatch(name -> name.startsWith("B")); // Predicate<T>
        System.out.println(jemandMitB);

        // 5. noneMatch
        System.out.println("\nnoneMatch: Kein Name länger als 10?");
        boolean keinerZuLang = namen.stream()
                .noneMatch(name -> name.length() > 10); // Predicate<T>
        System.out.println(keinerZuLang);

        // 6. min
        System.out.println("\nmin: Kürzester Name");
        Optional<String> kuerzesterName = namen.stream()
                .min(Comparator.comparingInt(String::length)); // Comparator<T>
        kuerzesterName.ifPresent(System.out::println);

        // 7. max
        System.out.println("\nmax: Längster Name");
        Optional<String> laengsterName = namen.stream()
                .max(Comparator.comparingInt(String::length)); // Comparator<T>
        laengsterName.ifPresent(System.out::println);

        // 8. count
        System.out.println("\ncount: Anzahl der Namen");
        long anzahl = namen.stream()
                .count();
        System.out.println(anzahl);

        // 9. collect
        System.out.println("\ncollect: Namen zu Liste sammeln (ohne Duplikate)");
        List<String> einzigartigeNamen = namen.stream()
                .distinct()
                .collect(Collectors.toList()); // Collector<T, A, R>
        System.out.println(einzigartigeNamen);

        // 10. forEach
        System.out.println("\nforEach: Jeden Namen ausgeben");
        namen.stream()
                .forEach(name -> System.out.println("Name: " + name)); // Consumer<T>
    }
}
