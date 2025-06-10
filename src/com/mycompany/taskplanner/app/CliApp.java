package com.mycompany.taskplanner.app;

import com.mycompany.taskplanner.model.Priority;
import com.mycompany.taskplanner.model.Task;
import com.mycompany.taskplanner.service.TaskManager;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Kommandozeilen-Anwendung für den Aufgabenplaner.
 * Ermöglicht das Hinzufügen, Anzeigen und Abrufen von Aufgaben.
 */
public class CliApp {
    private TaskManager taskManager;
    private Scanner scanner;

    /**
     * Konstruktor für die CliApp.
     * Initialisiert den TaskManager und den Scanner.
     */
    public CliApp() {
        taskManager = new TaskManager();
        scanner = new Scanner(System.in);
        System.out.println("Aufgabenplaner gestartet.");
    }

    /**
     * Startet die Hauptschleife der Anwendung und verarbeitet Benutzereingaben.
     */
    public void run() {
        int choice;
        do {
            printMenu();
            try {
                System.out.print("Wählen Sie eine Option: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Konsumiere den Zeilenumbruch

                switch (choice) {
                    case 1:
                        addTask();
                        break;
                    case 2:
                        getNextTask();
                        break;
                    case 3:
                        listAllTasks();
                        break;
                    case 4:
                        findTask();
                        break;
                    case 0:
                        System.out.println("Anwendung wird beendet. Auf Wiedersehen!");
                        break;
                    default:
                        System.out.println("Ungültige Option. Bitte versuchen Sie es erneut.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl ein.");
                scanner.nextLine(); // Konsumiere die fehlerhafte Eingabe
                choice = -1; // Setze choice auf einen ungültigen Wert, um das Menü neu anzuzeigen
            } catch (IllegalArgumentException e) {
                System.out.println("Fehler: " + e.getMessage());
                choice = -1;
            }
            System.out.println(); // Leerzeile für bessere Lesbarkeit
        } while (choice != 0);
        scanner.close();
    }

    /**
     * Zeigt das Hauptmenü der Anwendung an.
     */
    private void printMenu() {
        System.out.println("--- Aufgabenplaner ---");
        System.out.println("1. Aufgabe hinzufügen");
        System.out.println("2. Nächste Aufgabe abrufen (höchste Priorität)");
        System.out.println("3. Alle Aufgaben auflisten");
        System.out.println("4. Aufgabe nach Titel suchen");
        System.out.println("0. Beenden");
        System.out.println("----------------------");
    }

    /**
     * Ermöglicht dem Benutzer, eine neue Aufgabe hinzuzufügen.
     */
    private void addTask() {
        System.out.println("\n--- Aufgabe hinzufügen ---");
        System.out.print("Titel der Aufgabe: ");
        String title = scanner.nextLine();

        Priority priority = null;
        boolean validPriority = false;
        while (!validPriority) {
            System.out.print("Priorität (HIGH, MEDIUM, LOW): ");
            String priorityStr = scanner.nextLine().toUpperCase();
            try {
                priority = Priority.valueOf(priorityStr);
                validPriority = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Ungültige Priorität. Bitte wählen Sie HIGH, MEDIUM oder LOW.");
            }
        }

        System.out.print("Ist die Aufgabe optional? (ja/nein): ");
        String optionalStr = scanner.nextLine().toLowerCase();
        boolean isOptional = optionalStr.equals("ja");

        try {
            Task newTask = new Task(title, priority, isOptional);
            if (taskManager.addTask(newTask)) {
                System.out.println("Aufgabe '" + title + "' erfolgreich hinzugefügt.");
            } else {
                System.out.println("Fehler: Eine Aufgabe mit dem Titel '" + title + "' existiert bereits.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Fehler beim Hinzufügen der Aufgabe: " + e.getMessage());
        }
    }

    /**
     * Ruft die Aufgabe mit der höchsten Priorität ab und entfernt sie.
     * Nutzt Optional, um sicherzustellen, dass keine NullPointerExceptions auftreten.
     */
    private void getNextTask() {
        System.out.println("\n--- Nächste Aufgabe abrufen ---");
        // Optional wird hier verwendet, um sicher zu sein, ob eine Aufgabe vorhanden ist.
        Optional<Task> nextTask = taskManager.getNextTask();

        if (nextTask.isPresent()) {
            System.out.println("Nächste Aufgabe (erledigt): " + nextTask.get());
        } else {
            System.out.println("Keine Aufgaben im Planer.");
        }
    }

    /**
     * Listet alle Aufgaben im Planer auf, sortiert nach Priorität.
     */
    private void listAllTasks() {
        System.out.println("\n--- Alle Aufgaben ---");
        List<Task> allTasks = taskManager.getAllTasks();
        if (allTasks.isEmpty()) {
            System.out.println("Der Aufgabenplaner ist leer.");
        } else {
            allTasks.forEach(System.out::println);
        }
    }

    /**
     * Sucht eine Aufgabe anhand ihres Titels.
     * Nutzt Optional, um das Suchergebnis sicher abzubilden.
     */
    private void findTask() {
        System.out.println("\n--- Aufgabe suchen ---");
        System.out.print("Geben Sie den Titel der gesuchten Aufgabe ein: ");
        String title = scanner.nextLine();

        // Optional wird verwendet, um das mögliche Nicht-Existieren der Aufgabe darzustellen.
        Optional<Task> foundTask = taskManager.findTaskByTitle(title);

        if (foundTask.isPresent()) {
            System.out.println("Aufgabe gefunden: " + foundTask.get());
        } else {
            System.out.println("Aufgabe mit dem Titel '" + title + "' nicht gefunden.");
        }
    }

    /**
     * Die Hauptmethode, die die Anwendung startet.
     * @param args Kommandozeilenargumente (werden hier nicht verwendet).
     */
    public static void main(String[] args) {
        CliApp app = new CliApp();
        app.run();
    }
}