package termin1.SortAlgorithms.src;

import java.util.Arrays;


class SortingAlgorithms {

    // SELECTION SORT
    public static void selectionSort(int[] array) {
        int arrayLength = array.length;

        // loop over each value of the array
        for (int currentPosition = 0; currentPosition < arrayLength - 1; currentPosition++) {
            int minimumIndex = currentPosition;

            // Find the smallest element in the unsorted portion by looping over the remaining array
            // unsorted partition = part of the array that comes after currentIndex
            for (int index = currentPosition + 1; index < arrayLength; index++) {
                if (array[index] < array[minimumIndex]) {
                    // if a value lower than the one at currentIndex is found
                    // set minimumIndex to index of lower value
                    minimumIndex = index;
                }
            }

            // Swap the found new minimum element with the currentIndex element
            // by temporary storing minimum element in a new variable
            // and swapping the elements then
            int temporary = array[minimumIndex];
            array[minimumIndex] = array[currentPosition];
            array[currentPosition] = temporary;
        }
    }

    // BUBBLE SORT
    public static void bubbleSort(int[] array) {
        int arrayLength = array.length;

        // has n passes over the complete array (minus the sorted parts)
        // In each pass the greatest, then second greatest, third greatest etc elements is found

        // Outer loop to control the number of passes
        for (int pass = 0; pass < arrayLength - 1; pass++) {
            // Inner loop for each pass
            for (int index = 0; index < arrayLength - pass - 1; index++) {
                // Each element at index is compared to element at next index
                // and swapped if it is greater
                // high values at the beginning of the array are pushed to the end
                // lower values stay where they are
                if (array[index] > array[index + 1]) {
                    int temporary = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = temporary;
                }
            }
            // After each pass, the next largest element is set to its correct position
        }
    }


    // INSERTION SORT
    public static void insertionSort(int[] array) {
        int arrayLength = array.length;

        // Start from the second element (index 1)
        for (int index = 1; index < arrayLength; index++) {
            // currentValue is the element we want to place at the correct position in the sorted part
            int currentValue = array[index];

            // compare it with the element before currentValue
            int position = index;

            // Second loop:
            // Shift elements of the sorted part of the array that are greater than currentValue
            // one position to the right to make room for currentValue
            while (position > 0 && array[position - 1] > currentValue) {
                array[position] = array[position - 1]; // Move the larger element one position to the right
                // Move position index to the previous position
                // where correct placed currentValue will be inserted
                position--;
            }

            // Place currentValue at its correct position so that elements before it are sorted
            array[position] = currentValue;
        }
    }


    // QUICK SORT
    public static void quickSort(int[] array, int left, int right) {
        // Only proceed if there are at least two elements to sort
        if (left < right) {
            // Partition the array: place one element ('pivot element') in its correct position
            // All elements smaller than pivot are moved to its left
            // All elements greater are moved to its right
            int partitionIndex = partition(array, left, right);

            // Recursively apply quicksort to the left partition (elements before pivot)
            quickSort(array, left, partitionIndex - 1);

            // Recursively apply quicksort to the right partition (elements after pivot)
            quickSort(array, partitionIndex + 1, right);
        }
    }

    // Quick sort partition function
        // moves
    private static int partition(int[] array, int left, int right) {
        // Choose the last element as the pivot (convenience)
        int pivot = array[right];

        // i is the index of the smaller element
        // it starts one position before the 'left' index
        // initially setting i to -1 (aso left is 0 at the beginning)
        int i = left - 1;

        // j goes from left to right-1 (one before pivot)
        for (int j = left; j < right; j++) {
            // If current element is smaller than pivot
            if (array[j] < pivot) {
                i++; // Move i to the right, to make room for a smaller element

                // Swap array[i] and array[j] (smaller element)
                // so that smaller elements stay on the left
                int temporary = array[i];
                array[i] = array[j];
                array[j] = temporary;
            }
        }

        // After the loop, place the pivot after the last smaller element
        // So that pivot is at its correct sorted position
        // and all smaller values are on the left side, greater values on the right
        int temporary = array[i + 1];
        array[i + 1] = array[right];
        array[right] = temporary;

        // Return the index where the pivot is placed
        return i + 1;
    }


    // MERGE SORT
    public static void mergeSort(int[] array, int left, int right) {
        // Check if there are at least two elements to sort in array
        if (left < right) {
            // Find the middle index to divide the array into two halves
            int middle = (left + right) / 2;

            // Recursively sort the first half
            // Each recursive call runs itself again until there is only one element in first half
            // then starts with the recursive returns and continues to recurse calls of second half
            mergeSort(array, left, middle);

            // Recursively sort the second half
            mergeSort(array, middle + 1, right);

            // Merge the two sorted halves
            // Is only called when array is split in all recursive parts
                // means: Array is split in many recursive sub-parts
                    // containing a left and a right value
            // merge function then recursively merges the small parts into greater parts
            // until the whole array is sorted
            merge(array, left, middle, right);
        }
    }

    private static void merge(int[] array, int left, int middle, int right) {
        // Find lengths of the two subarrays to be merged
        // in first call this will just be one value per subarray
        int leftArrayLength = middle - left + 1;
        int rightArrayLength = right - middle;

        // Create temporary arrays to hold the elements of the two halves
        int[] leftArray = new int[leftArrayLength];
        int[] rightArray = new int[rightArrayLength];

        // Copy the data into the temporary arrays
        for (int i = 0; i < leftArrayLength; ++i)
            leftArray[i] = array[left + i];
        for (int j = 0; j < rightArrayLength; ++j)
            rightArray[j] = array[middle + 1 + j];

        // Initial indexes of first and second subarrays
        int i = 0;
        int j = 0;

        // Initial index of the merged subarray
        int k = left;

        // Compare elements from leftArray and rightArray
        // and copy the smaller one into the original array
        while (i < leftArrayLength && j < rightArrayLength) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements from leftArray
        // (RightArray is already copied if exhausted)
        while (i < leftArrayLength) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy any remaining elements from rightArray
        while (j < rightArrayLength) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }


    public static void main(String[] args) {
        int[] array = {64, 25, 12, 22, 11};

        selectionSort(array);
        System.out.println("Selection Sort Result: " + Arrays.toString(array));

        bubbleSort(array);
        System.out.println("Bubble Sort Result: " + Arrays.toString(array));

        insertionSort(array);
        System.out.println("Insertion Sort Result: " + Arrays.toString(array));

        quickSort(array, 0, array.length - 1);
        System.out.println("Quick Sort Result: " + Arrays.toString(array));

        mergeSort(array, 0, array.length - 1);
        System.out.println("Merge Sort Result: " + Arrays.toString(array));
    }
}
