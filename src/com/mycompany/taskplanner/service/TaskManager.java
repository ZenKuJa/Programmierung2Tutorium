package com.mycompany.taskplanner.service;

import com.mycompany.taskplanner.model.Task;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Verwaltet Aufgaben in einem Aufgabenplaner.
 * Nutzt eine PriorityQueue, um Aufgaben basierend auf ihrer Priorität zu verwalten.
 * Bietet Methoden zum Hinzufügen, Abrufen und Suchen von Aufgaben.
 */
public class TaskManager {
    // PriorityQueue sortiert Aufgaben basierend auf ihrer natürlichen Ordnung (compareTo-Methode in Task).
    private PriorityQueue<Task> tasks;

    /**
     * Konstruktor für den TaskManager.
     * Initialisiert die PriorityQueue.
     */
    public TaskManager() {
        this.tasks = new PriorityQueue<>();
    }

    /**
     * Fügt eine neue Aufgabe zum Planer hinzu.
     * Wenn eine Aufgabe mit demselben Titel bereits existiert, wird sie nicht hinzugefügt.
     *
     * @param task Die hinzuzufügende Aufgabe.
     * @return True, wenn die Aufgabe erfolgreich hinzugefügt wurde, false sonst (Titel bereits vorhanden).
     */
    public boolean addTask(Task task) {
        // Prüfen, ob bereits eine Aufgabe mit dem gleichen Titel existiert.
        // Das Iterieren über die PriorityQueue ist nicht optimal für diese Prüfung,
        // da sie keine effiziente 'contains' basierend auf equals() garantiert.
        // Für häufige "contains" Prüfungen würde man zusätzlich eine HashMap nutzen.
        // Für diese Aufgabe ist dies jedoch ausreichend.
        if (tasks.stream().anyMatch(t -> t.getTitle().equalsIgnoreCase(task.getTitle()))) {
            return false; // Aufgabe mit diesem Titel existiert bereits
        }
        return tasks.offer(task); // Fügt die Aufgabe der PriorityQueue hinzu
    }

    /**
     * Ruft die Aufgabe mit der höchsten Priorität ab und entfernt sie aus dem Planer.
     *
     * @return Ein Optional, das die Aufgabe mit der höchsten Priorität enthält,
     * oder ein leeres Optional, wenn keine Aufgaben vorhanden sind.
     */
    public Optional<Task> getNextTask() {
        // poll() gibt null zurück, wenn die Queue leer ist, was perfekt zu Optional passt.
        return Optional.ofNullable(tasks.poll());
    }

    /**
     * Sucht eine Aufgabe anhand ihres Titels.
     *
     * @param title Der Titel der gesuchten Aufgabe.
     * @return Ein Optional, das die gefundene Aufgabe enthält, oder ein leeres Optional,
     * wenn keine Aufgabe mit dem angegebenen Titel gefunden wurde.
     */
    public Optional<Task> findTaskByTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            return Optional.empty(); // Leeres Optional für ungültigen Suchtitel
        }
        // Durchsuchen der Queue nach der Aufgabe.
        return tasks.stream()
                    .filter(task -> task.getTitle().equalsIgnoreCase(title))
                    .findFirst();
    }

    /**
     * Gibt eine Liste aller Aufgaben im Planer zurück, sortiert nach Priorität.
     * Die Aufgaben bleiben in der PriorityQueue erhalten.
     *
     * @return Eine Liste aller Aufgaben.
     */
    public List<Task> getAllTasks() {
        // Erstellt eine neue ArrayList aus der PriorityQueue und sortiert sie.
        // Achtung: toList() ohne collect(Collectors.toList()) ist ab Java 16 verfügbar.
        // Für ältere Java-Versionen: .collect(Collectors.toList()) verwenden.
        return tasks.stream()
                    .sorted() // Nutzt die compareTo-Methode der Task-Klasse
                    .collect(Collectors.toList());
    }

    /**
     * Überprüft, ob der Aufgabenplaner leer ist.
     * @return True, wenn keine Aufgaben vorhanden sind, sonst false.
     */
    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    /**
     * Gibt die Anzahl der Aufgaben im Planer zurück.
     * @return Die Anzahl der Aufgaben.
     */
    public int size() {
        return tasks.size();
    }
}