package sort;

/**
 * 选择排序
 * javac -cp ../otherlib/algs4.jar:. -Xlint:unchecked  sort/SelectSort.java
 * java -cp ../otherlib/algs4.jar:. sort.SelectSort < ../data/SortString.txt
 */
public class SelectSort extends SortExample {

    /**
     * 选择排序
     *
     * @param arr
     */
    @Override
    public void sort(Comparable[] arr) {
        for (int a = 0; a < arr.length; a++) {
            int min = a;
            for (int b = a + 1; b < arr.length; b++) {
                if (less(arr[b], arr[min])) {
                    min = b;
                }
            }
            exch(arr, a, min);
        }
    }
}
