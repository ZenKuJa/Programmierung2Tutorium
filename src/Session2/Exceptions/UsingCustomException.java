package Session2.Exceptions;

public class UsingCustomException {
    public static void checkAge(int age) throws Exception {
        if(age < 18) {
            throw new ToYoungException("User to young");
        }
    }

    public static void main(String[] args) {
        try {
            checkAge(17);
        } catch (ToYoungException e) {
            System.out.println("User appears to be to young");
        } catch (Exception e) {
            System.out.println("An unknown error occured");
        } finally {
            System.out.println("finished try catch block");
        }
    }
}
