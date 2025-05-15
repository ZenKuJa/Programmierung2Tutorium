package Session2.Set;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<Integer>();
        Set<Integer> otherNumders = new HashSet<Integer>();

        for (int i = 0; i < 10; i++) {
            numbers.add(i);
            //[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
            otherNumders.add(i*2);
            //[0, 16, 2, 18, 4, 6, 8, 10, 12, 14]
        }
        numbers.size(); 
        //10
        otherNumders.addAll(numbers);
        //[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 16, 18]
        otherNumders.retainAll(numbers);
        //[0, 2, 4, 6, 8]
        otherNumders.removeAll(numbers);
        //[16, 18, 10, 12, 14]
    }
}
