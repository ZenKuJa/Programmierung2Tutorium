package src;

// AUFGABE 1: Hello
@FunctionalInterface
interface HelloSolution {
    void execute();
}

// AUFGABE 2
@FunctionalInterface
interface PrintNameSolution {
    void print(String name);
}

// AUFGABE 3
@FunctionalInterface
interface WordLengthSolution {
    int getLength(String word);
}

// AUFGABE 4
@FunctionalInterface
interface PrintPersonAgeSolution {
    void print(String name, int age);
}

// AUFGABE 5
@FunctionalInterface
interface AddSolution {
    int calculate(int a, int b);
}

// AUFGABE 6
@FunctionalInterface
interface RandomNumberSolution {
    double generate();
}

// AUFGABE 7
@FunctionalInterface
interface IsShortWordSolution {
    boolean check(String word);
}
