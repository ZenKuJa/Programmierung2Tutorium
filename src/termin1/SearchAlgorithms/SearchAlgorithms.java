package termin1.SearchAlgorithms;

public class SearchAlgorithms {

    // LINEAR SEARCH
        // Array does not have to be sorted
    static int linearSearch(int[] array, int number)
    {
        // loop over the array
        for (int i = 0; i < array.length; i++) {
            // if the number is found, return the index
            if (array[i] == number)
                return i;
        }

        // return -1 if the element is not found
        return -1;
    }

    // BINARY SEARCH
        // Array must be sorted before tarting Binary Search
    static int binarySearch(int[] array, int left, int right, int number)
    {
        while (left <= right) {
            // find the index of the middle element
            int middleIndex = (left + right) / 2;

            // If the middleIndex is the number, return its index
            if (array[middleIndex] == number) {
                return middleIndex;

                // If element is smaller than the mid element, then
                // it can only be present in left subarray
                // so we decrease our right pointer to middleIndex - 1
                // so we only search in the left side of the sub-array
            } else if (array[middleIndex] > number) {
                right = middleIndex - 1;

                // Else the element can only be present
                // in right subarray
                // so we increase our left pointer to middleIndex + 1
                // so we only search in the right side of the sub-array
            } else {
                left = middleIndex + 1;
            }
        }

        // No Element Found
        return -1;
    }


    // INTERPOLATION SEARCH
        // array must be sorted before
    public static int interpolationSearch(int[] array, int low,
                                          int high, int number)
    {
        // src/termin1/Uebungen/src/SortUebungen1.java src/termin1/Uebungen/src/SortUebungen2.java src/termin1/Uebungen/src/SortUebungen3.java
        if (low <= high && number >= array[low] && number <= array[high]) {

            // Interpolation tries to guess the position of the element
            // based on its value and the first and last array values
            // Works best if the elements are uniformly distributed
            int position = low
                    + (((high - low) / (array[high] - array[low]))
                    * (number - array[low]));

            // If guess is correct and element found return its index
            if (array[position] == number) return position;

            // If number is larger than the guess, number is in the right sub array
            if (array[position] < number)
                // Recurse function call
                // new left boundary is the guessed position + 1
                // repeats the same procedure with smaller and smaller sub arrays
                // until number is found
                return interpolationSearch(array, position + 1, high, number);

            // Same here: Recurse function call
            // new right boundary is the guessed position - 1
            if (array[position] > number) return interpolationSearch(array, low, position - 1, number);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = { 3, 4, 1, 7, 5, 11, 8 };
        int number = 4;

        // LINEAR SEARCH
        int indexLinear = linearSearch(array, number);

        if (indexLinear == -1)
            System.out.println("Element is not present in the array");
        else
            System.out.println("Element '" + number + "' found at index: " + indexLinear + " using linear search");

        // BINARY SEARCH

        int[] arraySorted = { 1, 3, 4, 5, 7, 8, 11 };
        int indexBinary = binarySearch(arraySorted, 0, arraySorted.length - 1, number);

        if (indexBinary == -1)
            System.out.println("Element is not present in the array");
        else
            System.out.println("Element '" + number + "' found at index: " + indexBinary + " using binary search");

        // INTERPOLATION SEARCH
        int indexInterpolation = interpolationSearch(arraySorted, 0, arraySorted.length - 1, number);

        if (indexBinary == -1)
            System.out.println("Element is not present in the array");
        else
            System.out.println("Element '" + number + "' found at index: " + indexInterpolation + " using interpolation search");
    }
}