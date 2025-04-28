---
marp: true
---

<style>
    :root {
        background-image: url("https://upload.wikimedia.org/wikipedia/de/thumb/e/ec/DHBW_Ravensburg.svg/1200px-DHBW_Ravensburg.svg.png");
        background-repeat: no-repeat;
        background-position: right top;
        background-size: 220px;
        background-origin: content-box;
    }
</style>

# Tutorium Programmierung 2
> 28.04.2025

Janens Kurzke und Fabian Bauriedl

---
## Inhalt
1. Organisatorisches
1. Rekursion
1. Suchalgorithmen
1. Sortieralgorithmen

---
## Organisatorisches
> Steffen und Mario behandeln die Themen in unterschiedlicher Reihenfolge

<img src = "..//resources//mentimeter.png" alt = "mentimeter qr-code">

---
## Organisatorisches
Komm in die Gruppe!
<img src = "..//resources//whatsapp.png" alt = "whatsapp groupd qr code">

---
## Rekursion

<img src = "https://blog.penjee.com/wp-content/uploads/2016/05/factorial-code-animation.gif" alt = "recursion">

---
## Suchalgorithmen
> Linear Search

<img src = "https://sushrutkuchik.wordpress.com/wp-content/uploads/2020/05/linear_search.gif?w=438" alt ="Linear Search" height = "250">

---
## Suchalgorithmen
> Linear Search

```Java
public static int search(int array[], int N, int x) {
    for (int i = 0; i < N; i++) {
        if (array[i] == x)
            return i;
    }
    return -1;
}
```
---
## Suchalgorithmen
> Binäre Suche

<img src = "https://sushrutkuchik.wordpress.com/wp-content/uploads/2020/05/bepceumnsg-binary_search_gif.gif" alt ="Binary Search" height = "250">

---
## Suchalgorithmen
> Binäre Suche

```Java
static int binarySearch(int array[], int l, int r, int x){
    while (l <= r) {
        int m = (l + r) / 2;

        if (array[m] == x) {
            return m;
        } else if (array[m] > x) {
            r = m - 1;
        } else {
            l = m + 1;
        }
    }
    return -1;
}
```

---
## Suchalgorithmen
> Interpolationssuche

<img src = "https://upload.wikimedia.org/wikipedia/commons/0/08/Interpolation_sort.gif" alt ="Interpolation Search" height = "250">

---
## Suchalgorithmen
> Interpolationssuche

```Java
public static int interpolationSearch(int array[], int lo, int hi, int x) {
    int pos;

    if (lo <= hi && x >= array[lo] && x <= array[hi]) {
        pos = lo + (((hi - lo) / (array[hi] - array[lo])) * (x - array[lo]));

        if (array[pos] == x) return pos;

        if (array[pos] < x) return interpolationSearch(array, pos + 1, hi, x);

        if (array[pos] > x) return interpolationSearch(array, lo, pos - 1, x);
    }
    return -1;
}
```

---
## Sortieralgorithmen
> Selection Sort

<img src = "https://upload.wikimedia.org/wikipedia/commons/3/3e/Sorting_selection_sort_anim.gif" alt ="selection sort" height = "250">

---
## Sortieralgorithmen
> Selection Sort

```Java
public static void selectionSort(int[] array) {
    int arrayLength = array.length;

    for (int currentPosition = 0; currentPosition < arrayLength - 1; currentPosition++) {
        int minimumIndex = currentPosition;

        for (int index = currentPosition + 1; index < arrayLength; index++) {
            if (array[index] < array[minimumIndex]) {
                minimumIndex = index;
            }
        }

        int temporary = array[minimumIndex];
        array[minimumIndex] = array[currentPosition];
        array[currentPosition] = temporary;
    }
}
```
---
## Sortieralgorithmen
> Bubble Sort

<img src = "https://upload.wikimedia.org/wikipedia/commons/5/54/Sorting_bubblesort_anim.gif?20140912160204" alt ="bubble sort" height = "250">

---
## Sortieralgorithmen
> Bubble Sort

```Java
public static void bubbleSort(int[] array) {
    int arrayLength = array.length;
    
    for (int pass = 0; pass < arrayLength - 1; pass++) {
        for (int index = 0; index < arrayLength - pass - 1; index++) {
            if (array[index] > array[index + 1]) {
                int temporary = array[index];
                array[index] = array[index + 1];
                array[index + 1] = temporary;
            }
        }
    }
}
```
---
## Sortieralgorithmen
> Insertion Sort

<img src = "https://upload.wikimedia.org/wikipedia/commons/2/24/Sorting_insertion_sort_anim.gif" alt ="insertion sort" height = "250">

---
## Sortieralgorithmen
> Insertion Sort

```Java
public static void insertionSort(int[] array) {
    int arrayLength = array.length;

    for (int index = 1; index < arrayLength; index++) {
        int currentValue = array[index];

        int position = index;
        while (position > 0 && array[position - 1] > currentValue) {
            array[position] = array[position - 1];
            position--;
        }
        array[position] = currentValue;
    }
}
```
---
## Sortieralgorithmen
> Quick Sort

<img src = "https://upload.wikimedia.org/wikipedia/commons/6/6a/Sorting_quicksort_anim.gif" alt ="quick sort" height = "250">

---
## Sortieralgorithmen
> Quick Sort

```Java
public static void quickSort(int[] array, int left, int right) {
    if (left < right) {
        int partitionIndex = partition(array, left, right);
        quickSort(array, left, partitionIndex - 1);

        quickSort(array, partitionIndex + 1, right);
    }
}
```
---
## Sortieralgorithmen
> Quick Sort

```Java
private static int partition(int[] array, int left, int right) {
    int pivot = array[right];
    int i = left - 1;
    for (int j = left; j < right; j++) {
        if (array[j] < pivot) {
            i++;
            int temporary = array[i];
            array[i] = array[j];
            array[j] = temporary;
        }
    }
    int temporary = array[i + 1];
    array[i + 1] = array[right];
    array[right] = temporary;
    return i + 1;
}
```

---
## Sortieralgorithmen
> Merge Sort
<img src = "https://upload.wikimedia.org/wikipedia/commons/c/cc/Merge-sort-example-300px.gif" alt ="merge sort" height = "250">

---
## Sortieralgorithmen
> Merge Sort

```Java
public static void mergeSort(int[] array, int left, int right) {
    if (left < right) {
        int middle = (left + right) / 2;
        mergeSort(array, left, middle);

        mergeSort(array, middle + 1, right);
        merge(array, left, middle, right);
    }
}
```

---
## Sortieralgorithmen
> Merge Sort

```Java
private static void merge(int[] array, int left, int middle, int right) {
    int leftArrayLength = middle - left + 1;
    int rightArrayLength = right - middle;

    int[] leftArray = new int[leftArrayLength];
    int[] rightArray = new int[rightArrayLength];

    for (int i = 0; i < leftArrayLength; ++i)
        leftArray[i] = array[left + i];
    for (int j = 0; j < rightArrayLength; ++j)
        rightArray[j] = array[middle + 1 + j];

    int i = 0;
    int j = 0;
    int k = left;

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
    while (i < leftArrayLength) {
        array[k] = leftArray[i];
        i++;
        k++;
    }
    while (j < rightArrayLength) {
        array[k] = rightArray[j];
        j++;
        k++;
    }
}
```

---
## Zeit zum Üben
<img src = "..//resources//github.png" alt = "github repo">
