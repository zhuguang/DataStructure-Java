package sort;

public class SortAuxFunc {
    /**
     * 比较 a 和 b，如果 a 小于 b，返回 true
     *
     * @param a
     * @param b
     * @return
     */
    public boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    /**
     * 交换 arr数组中 a 和 b 坐标的元素
     *
     * @param arr
     * @param a
     * @param b
     */
    public void exch(Comparable[] arr, int a, int b) {
        Comparable temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * 输出数组，用来验证结果
     *
     * @param arr
     */
    public void show(Comparable[] arr, int start, int end) {
        StringBuilder b = new StringBuilder("数组 => \n");
        for (int a = start; a < end; a++) {
            b.append(arr[a].toString()).append(" ");
        }
        System.out.println(b.toString());
    }

    public void show(Comparable[] arr) {
        show(arr, 0, arr.length);
    }
}
