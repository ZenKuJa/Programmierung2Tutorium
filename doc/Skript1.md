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
1. Themen Besprechung
1. Algorithmen
1. Suchalgorithmen
1. Rekursion
1. Sortieralgorithmen

---
## Themen
> Steffen und Mario behandeln die Themen in unterschiedlicher Reihenfolge

---
## Themen
> Steffen und Mario behandeln die Themen in unterschiedlicher Reihenfolge


| Option 1 | Option 2 | Option 3 |
|---|---|---|
|Steffen|Mario|Eure Wuensche|

---
## Themen
> Steffen und Mario behandeln die Themen in unterschiedlicher Reihenfolge

<img src = "..//ressources//mentimeter.png" alt = "mentimeter qr-code">


---
## Algorithmen

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
## Rekursion

<img src = "https://blog.penjee.com/wp-content/uploads/2016/05/factorial-code-animation.gif" alt = "recursion">

---
## Sortieralgorithmen
> Selection Sort

<img src = "https://upload.wikimedia.org/wikipedia/commons/3/3e/Sorting_selection_sort_anim.gif" alt ="selection sort" height = "250">

---
## Sortieralgorithmen
> Selection Sort

```Java

```
---
## Sortieralgorithmen
> Bubble Sort

<img src = "https://upload.wikimedia.org/wikipedia/commons/5/54/Sorting_bubblesort_anim.gif?20140912160204" alt ="bubble sort" height = "250">

---
## Sortieralgorithmen
> Bubble Sort

```Java

```
---
## Sortieralgorithmen
> Insertion Sort

<img src = "https://upload.wikimedia.org/wikipedia/commons/2/24/Sorting_insertion_sort_anim.gif" alt ="insertion sort" height = "250">

---
## Sortieralgorithmen
> Insertion Sort

```Java

```
---
## Sortieralgorithmen
> Quick Sort

<img src = "https://upload.wikimedia.org/wikipedia/commons/6/6a/Sorting_quicksort_anim.gif" alt ="quick sort" height = "250">

---
## Sortieralgorithmen
> Quick Sort

```Java

```
---
## Sortieralgorithmen
> Merge Sort
<img src = "https://upload.wikimedia.org/wikipedia/commons/6/6d/Funnel_sorting_algorithm_with_merging.gif" alt ="merge sort" height = "250">

---
## Sortieralgorithmen
> Merge Sort

```Java

```

---
## Zeit zum Üben
<img src = "..//ressources//github.png" alt = "github repo">
