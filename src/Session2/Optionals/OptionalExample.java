package Session2.Optionals;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Optional<String> name = Optional.ofNullable("Lindner");
        if (name.isPresent()){
            System.out.println("there is a name");
        }

        String userInput = null;
        Optional<String> userName = Optional.ofNullable(userInput);

        userName.ifPresentOrElse(
            (value) -> System.out.println(value),
            () -> System.out.println("there is no name"));
    }
}
