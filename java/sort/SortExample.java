package sort;

import edu.princeton.cs.algs4.In;
import performance.StopWatch;

import java.util.Arrays;
import java.util.Scanner;

public abstract class SortExample extends SortAuxFunc {
    /**
     * 需要实现的排序算法
     *
     * @param data
     */
    abstract void sort(Comparable[] data);

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
        String func = args[0];
        int[] input = new In().readAllInts();
        Integer[] ints = new Integer[input.length];
        for (int idx = 0; idx < input.length; idx++) {
            ints[idx] = input[idx];
        }
        SortExample sort = new SelectSort();
        StopWatch watch = new StopWatch();
        sort.show(ints);
        if ("selection".equals(func)) {
            sort = new SelectSort();
        }
        if ("insertion".equals(func)) {
            sort = new SelectSort();
        }
        if ("localmerge".equals(func)) {
            sort = new LocalMergeSort();
        }
        if ("mergetd".equals(func)) {
            sort = new MergeTopDown();
        }
        if ("Mergebu".equals(func)) {
            sort = new MergeBottomUp();
        }
        if ("quicksort".equals(func)) {
            sort = new QuickSort();
        }
        if ("heapsort".equals(func)) {
            sort = new HeapPQSort();
            // 堆排序是从 1 到 N，对数组提前做个调整
            Integer[] temp = new Integer[input.length + 1];
            for (int idx = 0; idx < input.length; idx++) {
                temp[idx + 1] = input[idx];
            }
            ints = temp;
            sort.sort(ints);
            sort.show(ints, 1, ints.length);
        } else {
            sort.sort(ints);
            sort.show(ints);
        }
        System.out.println("elapsed: " + watch.elapsedMillisTime());
    }
}
