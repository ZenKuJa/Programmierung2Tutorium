import java.util.Random;
import java.util.stream.Stream;

public class UnendlicheStreams {
   public static void main(String[] args) {
      Stream.iterate(0, i -> ++i).limit(100).forEach(System.out::println);
      Stream.iterate(0, i -> i < 100, i -> ++i).forEach(System.out::println);
      Stream.generate(() -> new Random().nextInt(100)).limit(100).forEach(System.out::println);
   }
}
