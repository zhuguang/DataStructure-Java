package sort;

import performance.StopWatch;

import java.util.Scanner;

public abstract class SortExample<T> {
    /**
     * 需要实现的排序算法
     *
     * @param t
     */
    abstract void sort(Comparable<T>[] t);

    /**
     * 比较 a 和 b，如果 a 小于 b，返回 true
     *
     * @param a
     * @param b
     * @return
     */
    public boolean less(Comparable<T> a, T b) {
        return a.compareTo(b) < 0;
    }

    /**
     * 交换 arr数组中 a 和 b 坐标的元素
     *
     * @param arr
     * @param a
     * @param b
     */
    public void exch(Comparable<T>[] arr, int a, int b) {
        Comparable<T> temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * 输出数组，用来验证结果
     *
     * @param arr
     */
    public void show(Comparable<T>[] arr) {
        StringBuilder b = new StringBuilder("数组 => \n");
        for (int a = 0; a < arr.length; a++) {
            b.append(arr[a].toString()).append(" ");
        }
        System.out.println(b.toString());
    }

    /**
     * 验证数组是否正确排序
     *
     * @param arr
     * @return
     */
    public boolean isSorted(Comparable<T>[] arr) {
        for (int a = 0; a < arr.length - 1; a++) {
            if (less(arr[a + 1], (T) arr[a])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        StopWatch watch = new StopWatch();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("elapsed: " + watch.elapsedMillisTime());
    }
}
