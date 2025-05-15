// Main.java
public class Main {
    public static void main(String[] args) {
        try {
            // Exercise 1: Basic Exception
            validateAge(16);

            // Exercise 2: Using custom exception
            validatePassword("123");

            // Exercise 3: Multiple custom exceptions
            processTransaction(-100, "CHF");
        } catch (InvalidAgeException e) {
            System.out.println("Age Error: " + e.getMessage());
        } catch (InvalidPasswordException e) {
            System.out.println("Username Error: " + e.getMessage());
        } catch (InvalidTransactionException e) {
            System.out.println("Transaction Error: " + e.getMessage());
        }
    }

    // Exercise 1: Throws built-in Exception
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            // Throws custom exception
            throw new InvalidAgeException("User must be 18 or older.");
        }
        System.out.println("Age is valid.");
    }

    // Exercise 2: Throws the InvalidPasswordException, if password length is below 5
    public static void validatePassword(String password) throws InvalidPasswordException {
        if (password.length() < 5) {
            throw new InvalidPasswordException("Password must be at least 5 characters long.");
        }
        System.out.println("Password is set to: " + password);
    }

    // Exercise 3: Throws custom exception with different rules
    public static void processTransaction(double amount, String currency) throws InvalidTransactionException {
        if (amount <= 0) {
            throw new InvalidTransactionException("Transaction amount must be positive.");
        }
        if (!currency.equals("USD") && !currency.equals("EUR")) {
            throw new InvalidTransactionException("Unsupported currency: " + currency);
        }
        System.out.println("Transaction processed: " + amount + " " + currency);
    }
}
