public class Recustion {
    static int findSum(int n) {
        // Base case 
        if (n == 1) 
            return 1; 
        
        // Recursive case 
        return n + findSum(n - 1);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(findSum(n));
    }
}
