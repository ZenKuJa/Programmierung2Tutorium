package src;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

public class MainSolution {
    public static void main(String[] args) {

        List<StudentSolution> students = List.of(
                new StudentSolution("Anna", 22, "female", 1.3, "Computer Science"),
                new StudentSolution("Ben", 24, "male", 2.0, "Mathematics"),
                new StudentSolution("Carla", 21, "female", 2.5, "Physics"),
                new StudentSolution("David", 23, "male", 1.7, "Engineering"),
                new StudentSolution("Ella", 20, "female", 1.0, "Computer Science"),
                new StudentSolution("Finn", 25, "male", 3.2, "History"),
                new StudentSolution("Greta", 22, "female", 1.9, "Biology")
        );

        // Aufgabe 1: Alle Studierenden ausgeben.
        // Schreibe eine Stream-Operation, die alle Studierenden in der Konsole ausgibt.
        students.forEach(System.out::println);

        // Aufgabe 2: Nur weibliche Studierende filtern.
        // Filtere die Liste so, dass nur weibliche Studierende ausgegeben werden.
        students.stream()
                .filter(s -> s.getGender().equals("female"))
                .forEach(System.out::println);

        // Aufgabe 3: Studierende mit Note < 2.0 anzeigen.
        // Zeige alle Studierenden mit einer Note besser als 2.0 an.
        students.stream()
                .filter(s -> s.getGrade() < 2.0)
                .forEach(System.out::println);

        // Aufgabe 4: Nur Namen der Studierenden extrahieren (map).
        // Verwende map, um eine Liste mit allen Namen der Studierenden zu erzeugen.
        students.stream()
                .map(StudentSolution::getName)
                .forEach(System.out::println);

        // Aufgabe 5: Anzahl aller Studierenden zählen.
        // Gib die Gesamtzahl der Studierenden zurück.
        long count = students.stream().count();
        System.out.println("Anzahl: " + count);

        // Aufgabe 6: Alphabetisch nach Name sortieren.
        // Sortiere die Studierenden nach Namen in alphabetischer Reihenfolge.
        students.stream()
                .sorted(Comparator.comparing(StudentSolution::getName))
                .forEach(System.out::println);

        // Aufgabe 7: Erste 3 Studierende ausgeben (limit).
        // Gib nur die ersten drei Studierenden der Liste aus.
        students.stream().limit(3).forEach(System.out::println);

        // Aufgabe 8: Gibt es Studierende mit Note 1.0? (anyMatch).
        // Prüfe, ob mindestens ein Studierender die Note 1.0 hat.
        boolean hasTop = students.stream().anyMatch(s -> s.getGrade() == 1.0);
        System.out.println("Hat Note 1.0: " + hasTop);

        // Aufgabe 9: Sind alle Studierenden älter als 18? (allMatch).
        // Prüfe, ob alle Studierenden älter als 18 Jahre sind.
        boolean allAdults = students.stream().allMatch(s -> s.getAge() > 18);
        System.out.println("Alle über 18: " + allAdults);

        // Aufgabe 10: Kein Studierender mit Note > 4.0? (noneMatch).
        // Überprüfe, ob kein Studierender eine schlechtere Note als 4.0 hat.
        boolean noneBad = students.stream().noneMatch(s -> s.getGrade() > 4.0);
        System.out.println("Niemand > 4.0: " + noneBad);

        // Aufgabe 11: Durchschnittsnote aller Studierenden berechnen.
        // Berechne die Durchschnittsnote aller Studierenden.
        double avg = students.stream().mapToDouble(StudentSolution::getGrade).average().orElse(0);
        System.out.println("Durchschnitt: " + avg);

        // Aufgabe 12: Studierenden mit bester Note finden (min).
        // Finde den Studierenden mit der besten (niedrigsten) Note.
        students.stream()
                .min(Comparator.comparing(StudentSolution::getGrade))
                .ifPresent(System.out::println);

        // Aufgabe 13: Studierenden mit schlechtester Note finden (max).
        // Finde den Studierenden mit der schlechtesten (höchsten) Note.
        students.stream()
                .max(Comparator.comparing(StudentSolution::getGrade))
                .ifPresent(System.out::println);

        // Aufgabe 14: Studierende nach Studienfach gruppieren.
        // Gruppiere die Studierenden nach ihrem Studienfach.
        Map<String, List<StudentSolution>> byMajor = students.stream().collect(groupingBy(StudentSolution::getMajor));
        System.out.println(byMajor);

        // Aufgabe 15: Anzahl pro Studienfach zählen.
        // Zähle, wie viele Studierende es pro Studienfach gibt.
        Map<String, Long> majorCount = students.stream().collect(groupingBy(StudentSolution::getMajor, counting()));
        System.out.println(majorCount);

        // Aufgabe 16: Alle Namen zu einer Zeichenkette (joining).
        // Erstelle eine einzige Zeichenkette mit allen Namen, getrennt durch Kommas.
        String names = students.stream().map(StudentSolution::getName).collect(joining(", "));
        System.out.println(names);

        // Aufgabe 17: Nach Alter sortieren, aber rückwärts.
        // Sortiere die Studierenden absteigend nach Alter.
        students.stream()
                .sorted(Comparator.comparing(StudentSolution::getAge).reversed())
                .forEach(System.out::println);

        // Aufgabe 18: "Computer Science"-Studierende -> Namen sammeln.
        // Sammle die Namen aller Studierenden im Fach "Computer Science".
        List<String> csNames = students.stream()
                .filter(s -> s.getMajor().equals("Computer Science"))
                .map(StudentSolution::getName)
                .collect(toList());
        System.out.println(csNames);

        // Aufgabe 19: Weibliche Studierende alphabetisch sortieren.
        // Sortiere alle weiblichen Studierenden alphabetisch nach Name.
        students.stream()
                .filter(s -> s.getGender().equals("female"))
                .sorted(Comparator.comparing(StudentSolution::getName))
                .forEach(System.out::println);

        // Aufgabe 20: Noten aufrunden und ausgeben.
        // Runde alle Noten auf ganze Zahlen und gib sie aus.
        students.stream()
                .map(s -> (int) Math.round(s.getGrade()))
                .forEach(System.out::println);

        // Aufgabe 21: Bester Schnitt pro Studiengang.
        // Finde für jedes Studienfach den Studierenden mit der besten Note.
        Map<String, Optional<StudentSolution>> bestPerMajor = students.stream()
                .collect(groupingBy(StudentSolution::getMajor, minBy(Comparator.comparing(StudentSolution::getGrade))));
        System.out.println(bestPerMajor);

        // Aufgabe 22: Durchschnittsnote pro Studiengang.
        // Berechne die Durchschnittsnote für jedes Studienfach.
        Map<String, Double> avgPerMajor = students.stream()
                .collect(groupingBy(StudentSolution::getMajor, averagingDouble(StudentSolution::getGrade)));
        System.out.println(avgPerMajor);

        // Aufgabe 23: Studierende nach Geschlecht gruppieren.
        // Gruppiere die Studierenden nach Geschlecht und zähle sie.
        Map<String, Long> genderCount = students.stream()
                .collect(groupingBy(StudentSolution::getGender, counting()));
        System.out.println(genderCount);

        // Aufgabe 24: Ältester pro Studienfach.
        // Finde den ältesten Studierenden in jedem Studienfach.
        Map<String, Optional<StudentSolution>> oldestPerMajor = students.stream()
                .collect(groupingBy(StudentSolution::getMajor, maxBy(Comparator.comparing(StudentSolution::getAge))));
        System.out.println(oldestPerMajor);

        // Aufgabe 25: Zweitbeste Note ermitteln.
        // Ermittle die zweitbeste (zweitniedrigste) Note unter allen Studierenden.
        students.stream()
                .map(StudentSolution::getGrade)
                .sorted()
                .skip(1)
                .findFirst()
                .ifPresent(System.out::println);

        // Aufgabe 26: Männliche mit Note < 2.0, sortiert.
        // Gib alle männlichen Studierenden mit Note < 2.0 sortiert nach Note aus.
        students.stream()
                .filter(s -> s.getGender().equals("male") && s.getGrade() < 2.0)
                .sorted(Comparator.comparing(StudentSolution::getGrade))
                .forEach(System.out::println);

        // Aufgabe 27: Durchschnittsalter für Note < 2.0.
        // Berechne das Durchschnittsalter aller Studierenden mit einer Note < 2.0.
        double avgAge = students.stream()
                .filter(s -> s.getGrade() < 2.0)
                .mapToInt(StudentSolution::getAge)
                .average().orElse(0);
        System.out.println("Durchschnittsalter: " + avgAge);

        // Aufgabe 28: Map<Name, Note>.
        // Sammle die Studierenden in einer Map, wobei der Name der Schlüssel ist und die Note der Wert.
        Map<String, Double> nameGradeMap = students.stream()
                .collect(toMap(StudentSolution::getName, StudentSolution::getGrade));
        System.out.println(nameGradeMap);

        // Aufgabe 29: In zwei Listen: unter/über Durchschnitt.
        // Teile die Studierenden in zwei Gruppen: unter und über dem Durchschnitt.
        double avgAll = students.stream().mapToDouble(StudentSolution::getGrade).average().orElse(0);
        Map<Boolean, List<StudentSolution>> partitioned = students.stream()
                .collect(partitioningBy(s -> s.getGrade() < avgAll));
        System.out.println("Unter Durchschnitt: " + partitioned.get(true));
        System.out.println("Über Durchschnitt: " + partitioned.get(false));

        // Aufgabe 30: Top 3 Noten extrahieren.
        // Extrahiere die drei besten Noten (kleinsten Werte) und speichere sie in einer Liste.
        List<Double> top3Grades = students.stream()
                .map(StudentSolution::getGrade)
                .sorted()
                .limit(3)
                .collect(toList());
        System.out.println("Top 3 Noten: " + top3Grades);
    }
}

