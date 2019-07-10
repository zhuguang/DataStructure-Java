package sort;

import edu.princeton.cs.algs4.In;
import performance.StopWatch;

import java.util.Arrays;
import java.util.Scanner;

public abstract class SortExample {
    /**
     * 需要实现的排序算法
     *
     * @param t
     */
    abstract void sort(Comparable[] t);

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
    public void show(Comparable[] arr) {
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
    public boolean isSorted(Comparable[] arr) {
        for (int a = 0; a < arr.length - 1; a++) {
            if (less(arr[a + 1], arr[a])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SelectSort sort = new SelectSort();
        int[] input = new In().readAllInts();
        Integer[] ints = new Integer[input.length];
        for (int idx = 0; idx < input.length; idx++) {
            ints[idx] = input[idx];
        }
//        Integer[] ints = new Integer[]{5, 3, 6, 1, 2, 6, 8, 9, 3, 4, 6, 1, 4, 2, 3};
        StopWatch watch = new StopWatch();
        sort.show(ints);
        sort.sort(ints);
        sort.show(ints);
        System.out.println("elapsed: " + watch.elapsedMillisTime());
    }
}
