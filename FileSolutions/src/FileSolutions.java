package src;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileSolutions {

    // Exercise 1 (Easy)
    // Create a new text file called "data.txt" and write "Hello, Data Science!" into it.
    public static void createFile() throws IOException {
        FileWriter writer = new FileWriter("data.txt");
        writer.write("Hello, Data Science!");
        writer.close();
    }

    // Exercise 2 (Easy)
    // Read the contents of "data.txt" and print them to the console.
    public static void readFile() throws IOException {
        FileReader reader = new FileReader("data.txt");
        int character;
        while ((character = reader.read()) != -1) {
            System.out.print((char) character);
        }
        reader.close();
    }

    // Exercise 3 (Medium)
    // List all .txt files in the current directory.
    public static void listTextFiles() {
        File dir = new File(".");
        File[] files = dir.listFiles((d, name) -> name.endsWith(".txt"));
        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        }
    }

    // Exercise 4 (Medium)
    // Count the number of lines in a file using java.nio.file.Files.
    public static void countLines(String fileName) throws IOException {
        Path path = Path.of(fileName);
        long lineCount = Files.lines(path).count();
        System.out.println("Number of lines: " + lineCount);
    }

    // Exercise 5 (Medium)
    // Copy the contents of "data.txt" to "copy.txt" using java.nio.file.Files.
    public static void copyFile() throws IOException {
        Path source = Path.of("data.txt");
        Path target = Path.of("copy.txt");
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
    }

    // Exercise 6 (Hard)
        // Given the file "people.txt" with comma-separated values like "Alice,24" create Person objects
        // and store them in a list. Print people older than 21.
        // The Person class is found in Person.java
    public static void filterPeople() throws IOException {
        List<String> lines = Files.readAllLines(Path.of("people.txt"));
        List<PersonSolution> people = new ArrayList<>();

        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length == 2) {
                String name = parts[0];
                int age = Integer.parseInt(parts[1]);
                people.add(new PersonSolution(name, age));
            }
        }

        for (PersonSolution p : people) {
            if (p.getAge() > 21) {
                System.out.println(p);
            }
        }
    }

    // Exercise 7 (Hard)
    // Analyze a file of numbers (one per line) and output basic statistics:
    // mean, min, max. Use java.nio.file.Files to read the file.
    public static void analyzeNumbers(String fileName) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(fileName));
        List<Double> numbers = new ArrayList<>();

        for (String line : lines) {
            numbers.add(Double.parseDouble(line));
        }

        double sum = 0;
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;

        for (double num : numbers) {
            sum += num;
            if (num < min) min = num;
            if (num > max) max = num;
        }

        double mean = sum / numbers.size();

        System.out.println("Mean: " + mean);
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
    }

    public static void main(String[] args) throws IOException {
        // UNCOMMENT ANY METHOD TO TEST IT:

        // createFile();
        // readFile();
        // listTextFiles();
        // countLines("data.txt");
        // copyFile();
        // filterPeople();
        // analyzeNumbers("numbers.txt");
    }
}
