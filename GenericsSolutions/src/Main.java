public class Main {
    public static void main(String[] args) {

        // EXERCISE 1:
        printArray(new Integer[]{1, 2, 3});
        printArray(new String[]{"A", "B", "C"});

        // EXERCISE 2:
        Pair<String, Integer> studentAge = new Pair<>("Alice", 21);
        studentAge.printPair();

        Pair<Double, Boolean> data = new Pair<>(99.5, true);
        data.printPair();

        // EXERCISE 3:
        System.out.println(compareValues(10, 10));        // true
        System.out.println(compareValues(5.5, 7.5));        // false
        System.out.println(compareValues("abc", "abc"));  // true
    }

    // EXERCISE 1:
    // Create a generic method called printArray that accepts an array of any type

    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }

    // EXERCISE 2:
    // Create a generic class Pair with two type parameters T and U


    // EXERCISE 3:
    // Create a generic method compareValues that checks if two values are equal

    public static <T extends Comparable<T>> boolean compareValues(T a, T b) {
        return a.compareTo(b) == 0;
    }
}
