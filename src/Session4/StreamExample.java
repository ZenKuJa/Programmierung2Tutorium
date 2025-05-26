import java.util.stream.Stream;

public class StreamExample {
   public static void main(String[] args) {
    Stream.of(4, 8, 15, 16, 23, 42).filter(i -> {
         System.out.println(i + ": filter 1");
         return i % 2 == 0;
      }).filter(i -> {
         System.out.println(i + ": filter 2");
         return i > 15;
      }).forEach(i -> System.out.println(i + ": forEach"));
   }
}
