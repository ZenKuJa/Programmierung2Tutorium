package Session2.Exceptions;

public class BasicException {
    public static void checkAge(int age) throws Exception {
        if(age < 18) {
            throw new Exception("You're to young");
        }
    }

    public static void main(String[] args) {
        try {
            checkAge(17);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
