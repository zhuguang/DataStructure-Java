package sort;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSort extends SortExample {

    void sort(Comparable[] data) {
//        StdRandom.shuffle(data);
        sort(data, 0, data.length - 1);
    }

    void sort(Comparable[] data, int l, int h) {
        if (l >= h) {
            return;
        }
        int mid = partition(data, l, h);
//        System.out.println("mid:" + mid);
        sort(data, l, mid - 1);
        sort(data, mid + 1, h);
    }

    /**
     * 这里i,j自增如果用i++,j--会比较麻烦，用++i,--j能简洁很多
     *
     * @param data
     * @param l
     * @param h
     * @return
     */
    int partition(Comparable[] data, int l, int h) {
//        System.out.println("l:" + l + ", h:" + h);
        int i = l;
        int j = h + 1;
        while (true) {
            while (less(data[++i], data[l])) {
                if (i >= h) {
                    break;
                }
            }
//            System.out.println("i:" + i);
            while (less(data[l], data[--j])) {
                if (j <= l) {
                    break;
                }
            }
//            System.out.println("j:" + j);
            if (i >= j) {
                exch(data, l, j);
                break;
            }
            exch(data, i, j);
        }
        return j;
    }

}
