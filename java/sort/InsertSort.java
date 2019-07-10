package sort;

/**
 * 插入排序
 * javac -cp ../otherlib/algs4.jar:. -Xlint:unchecked sort/InsertSort.java
 * java -cp ../otherlib/algs4.jar:. sort.InsertSort < ../data/SortString.txt
 */
public class InsertSort extends SortExample {
    /**
     * 插入排序
     *
     * @param t
     */
    @Override
    void sort(Comparable[] t) {
        for (int a = 1; a < t.length; a++) {
            for (int b = a - 1; b >= 0; b--) {
                if (less(a, b)) {
                    exch(t, a, b);
                }
            }
        }
    }
}
