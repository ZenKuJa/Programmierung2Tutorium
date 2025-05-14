package Session1.Recursion;

public class Recustion {
    static int faculty(int n) {
        // Base case 
        if (n == 1) 
            return 1; 
        
        // Recursive case 
        return n * faculty(n - 1);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(faculty(n));
    }
}
