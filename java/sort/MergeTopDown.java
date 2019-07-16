package sort;

/**
 * 自顶向下归并排序
 * <p>
 * javac -Xlint:unchecked -cp ../otherlib/algs4.jar:. sort/MergeTopDown.java\
 * <p>
 * java -cp ../otherlib/algs4.jar:. sort.MergeTopDown mergetd < ../data/SortString.txt
 */
public class MergeTopDown extends LocalMergeSort {
    @Override
    void sort(Comparable[] t) {
        temp = new Comparable[t.length];
        sort(t, 0, t.length - 1);
    }

    void sort(Comparable[] t, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(t, lo, mid);
        sort(t, mid + 1, hi);
        merge(t, lo, mid, hi);
    }
}
