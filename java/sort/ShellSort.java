package sort;

/**
 * 希尔排序
 */
public class ShellSort extends SortExample {
    /**
     * 希尔排序
     *
     * @param t
     */
    @Override
    void sort(Comparable[] t) {
        int h = 0;
        while (h < t.length / 3) {
            h = h * 3 + 1;
        }
        for (int i = h; i < t.length; i++) {
            for (int j = i - h; j >= 0 && less(t[i], t[j]); j = j - h) {
                exch(t, i, j);
            }
        }
    }
}
