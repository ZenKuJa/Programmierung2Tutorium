package Session2.Exceptions;

public class ToYoungException extends Exception{
    ToYoungException(String message){
        super(message);
        System.out.println("I am a custom exception");
    }
}
