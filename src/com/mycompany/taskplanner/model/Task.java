package com.mycompany.taskplanner.model;

import java.util.Objects;

/**
 * Repräsentiert eine einzelne Aufgabe im Aufgabenplaner.
 * Aufgaben haben einen Titel, eine Priorität und können optional sein.
 * Implementiert Comparable für die Sortierung, primär nach Priorität.
 */
public class Task implements Comparable<Task> {
    private String title;
    private Priority priority;
    private boolean isOptional; // Gibt an, ob die Aufgabe optional ist

    /**
     * Konstruktor für eine neue Aufgabe.
     *
     * @param title Der Titel der Aufgabe.
     * @param priority Die Priorität der Aufgabe (HIGH, MEDIUM, LOW).
     * @param isOptional True, wenn die Aufgabe optional ist, sonst false.
     * @throws IllegalArgumentException wenn der Titel ungültig ist.
     */
    public Task(String title, Priority priority, boolean isOptional) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Aufgabentitel darf nicht leer sein.");
        }
        this.title = title;
        this.priority = Objects.requireNonNull(priority, "Priorität darf nicht null sein.");
        this.isOptional = isOptional;
    }

    /**
     * Gibt den Titel der Aufgabe zurück.
     * @return Der Titel der Aufgabe.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gibt die Priorität der Aufgabe zurück.
     * @return Die Priorität der Aufgabe.
     */
    public Priority getPriority() {
        return priority;
    }

    /**
     * Überprüft, ob die Aufgabe optional ist.
     * @return True, wenn die Aufgabe optional ist, sonst false.
     */
    public boolean isOptional() {
        return isOptional;
    }

    /**
     * Setzt den optionalen Status der Aufgabe.
     * @param optional Der neue optionale Status.
     */
    public void setOptional(boolean optional) {
        isOptional = optional;
    }

    /**
     * Setzt die Priorität der Aufgabe.
     * @param priority Die neue Priorität.
     * @throws IllegalArgumentException wenn die Priorität null ist.
     */
    public void setPriority(Priority priority) {
        this.priority = Objects.requireNonNull(priority, "Priorität darf nicht null sein.");
    }

    /**
     * Vergleicht diese Aufgabe mit einer anderen Aufgabe.
     * Aufgaben werden zuerst nach Priorität (höhere Priorität zuerst),
     * dann alphabetisch nach Titel verglichen.
     * Dies ermöglicht die Verwendung in einer PriorityQueue.
     *
     * @param otherTask Die andere Aufgabe, mit der verglichen werden soll.
     * @return Ein negativer Integer, Null oder ein positiver Integer, wenn diese Aufgabe
     * kleiner, gleich oder größer als die angegebene Aufgabe ist.
     */
    @Override
    public int compareTo(Task otherTask) {
        // Priorität zuerst: Niedrigere Ordinalzahl bedeutet höhere Priorität
        int priorityComparison = this.priority.compareTo(otherTask.priority);
        if (priorityComparison != 0) {
            return priorityComparison;
        }
        // Wenn Prioritäten gleich sind, nach Titel sortieren
        return this.title.compareToIgnoreCase(otherTask.title);
    }

    /**
     * Überprüft, ob diese Aufgabe gleich einem anderen Objekt ist.
     * Zwei Aufgaben sind gleich, wenn ihre Titel übereinstimmen.
     *
     * @param o Das Objekt, mit dem verglichen werden soll.
     * @return True, wenn die Objekte gleich sind, sonst false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(title.toLowerCase(), task.title.toLowerCase()); // Case-insensitive Titelvergleich
    }

    /**
     * Gibt den Hash-Code für diese Aufgabe zurück.
     * Der Hash-Code basiert auf dem Titel der Aufgabe (case-insensitive).
     *
     * @return Der Hash-Code der Aufgabe.
     */
    @Override
    public int hashCode() {
        return Objects.hash(title.toLowerCase());
    }

    /**
     * Gibt eine String-Darstellung der Aufgabe zurück.
     * @return Eine formatierte String-Darstellung der Aufgabe.
     */
    @Override
    public String toString() {
        String optionalStatus = isOptional ? " (Optional)" : "";
        return "Aufgabe: '" + title + "', Priorität: " + priority + optionalStatus;
    }
}