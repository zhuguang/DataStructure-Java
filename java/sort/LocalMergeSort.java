package sort;

/**
 * javac -Xlint:unchecked -cp ../otherlib/algs4.jar:. sort/LocalMergeSort.java
 * java -cp ../otherlib/algs4.jar:. sort.LocalMergeSort localmerge < ../data/SortString.txt
 */
public class LocalMergeSort extends SortExample {
    protected Comparable[] temp;

    /**
     * 原地归并
     *
     * @param t
     */
    @Override
    void sort(Comparable[] t) {
        temp = new Comparable[t.length];
        merge(t, 0, t.length / 2, t.length - 1);
    }

    void merge(Comparable[] t, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            temp[i] = t[i];
        }
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k < hi; k++) {
            if (i > mid) {
                t[k] = temp[j++];
            } else if (j > hi) {
                t[k] = temp[i++];
            } else if (less(temp[i], temp[j])) {
                t[k] = temp[i++];
            } else {
                t[k] = temp[j++];
            }
        }
    }
}
