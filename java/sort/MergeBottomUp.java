package sort;

/**
 * 自底向上归并
 * javac -Xlint:unchecked -cp ../otherlib/algs4.jar:. sort/MergeBottomUp.java
 * java -cp ../otherlib/algs4.jar:. sort.MergeTopDown mergbu < ../data/SortString.txt
 */
public class MergeBottomUp extends LocalMergeSort {
    @Override
    void sort(Comparable[] t) {
        temp = new Comparable[t.length];
        for (int size = 1; size < t.length; size = size + size) {
            for (int i = 0; i < t.length; i = i + size + size) {
                merge(t, i, i + size - 1, Math.min(i + size + size - 1, t.length - 1));
            }
        }
    }
}
