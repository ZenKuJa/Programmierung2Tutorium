import java.util.LinkedList;

public class Lambda1 {
    public static void main(String[] args) {
        LinkedList<Integer> numbers = new LinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }

        for (Integer number : numbers) {
            System.out.println(number);
        }
        System.out.println("~~~~~~~~~~~");
        numbers.forEach((number) -> System.out.println(number));

        System.out.println("~~~~~~~~~~~");
        numbers.forEach(System.out::println);

    }
}