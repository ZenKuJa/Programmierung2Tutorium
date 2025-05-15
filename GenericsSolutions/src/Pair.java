// Generic class for EXERCISE 2
public class Pair<T, U> {
    private T key;
    private U value;

    public Pair(T key, U value) {
        this.key = key;
        this.value = value;
    }

    public void printPair() {
        System.out.println("Key: " + key + ", Value: " + value);
    }
}
