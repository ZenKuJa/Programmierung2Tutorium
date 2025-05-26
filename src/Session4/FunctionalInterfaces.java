import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfaces {

    public static void main(String[] args) {
        Consumer<String> printer = text -> System.out.println("Text: " + text);
        printer.accept("Hello World");

        BiConsumer<String, Integer> biPrinter = (name, age) -> System.out.println("Name: " + name + " age: " + age);
        biPrinter.accept("Thorsten", 137);

        Predicate<Integer> ageCheck = age -> age > 18;
        System.out.println(ageCheck.test(14));
        System.out.println(ageCheck.test(22));

        Function<String, Integer> lengthGetter = s -> s.length();
        System.out.println(lengthGetter.apply("HelloWorld"));
    }   
}