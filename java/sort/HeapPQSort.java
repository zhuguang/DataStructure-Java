package sort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Transaction;

/**
 * 堆排序
 * javac -Xlint:unchecked -cp ../otherlib/algs4.jar:. sort/HeapPQSort.java
 * java -cp ../otherlib/algs4.jar:. sort.HeapPQSort heapsort < ../data/SortString.txt
 */
public class HeapPQSort extends PQAPI<Transaction> {

    public HeapPQSort() {
        super();
    }

    public HeapPQSort(int size) {
        super(size);
    }

    @Override
    void insert(Transaction item) {
        arr[++N] = item;
        swim(N);
    }

    @Override
    Transaction max() {
        if (isEmpty()) {
            return null;
        }
        return arr[1];
    }

    @Override
    Transaction delMax() {
        Transaction max = arr[1];
        exch(arr, 1, N--);//注意这里的 N--
        arr[N + 1] = null;
        sink(1);
        return max;
    }

    @Override
    Transaction delMin() {
        return null;
    }

    /**
     * 二叉堆上浮
     *
     * @param idx
     */
    protected void swim(int idx) {
        while (idx > 1 && less(arr[idx / 2], arr[idx])) {
            exch(arr, idx, idx);
            idx = idx / 2;
        }
    }

    /**
     * 二叉堆下沉
     *
     * @param idx
     */
    protected void sink(int idx) {
        while (idx * 2 <= size()) {
            int child = idx * 2;
            if (child < size() && less(arr[child], arr[child + 1])) {
                child++;
            }
//            如果父节点不比子节点小，说明已经有序，不继续下沉
            if (!less(arr[idx], arr[child])) {
                break;
            }
            exch(arr, idx, child);
            idx = child;
        }
    }

    /**
     * 堆排序
     *
     * @param data
     */
    @Override
    void sort(Comparable[] data) {
        int N = data.length - 1;//数组多了一个 data[0]，所以 N = length -1
        for (int idx = N / 2; idx >= 1; idx--) {
            sink(data, N, idx);
        }
        show(data, 1, N + 1);
        while (N > 1) {
            exch(data, 1, N--);
            sink(data, N, 1);
        }
    }

    /**
     * 对数组 arr 从 idx 到 N 组成的堆上浮
     *
     * @param arr 数组
     * @param N   下界
     * @param idx 顶点
     */
    private void swim(Comparable[] arr, int N, int idx) {

    }

    /**
     * 对数组 arr 从 idx 到 N 组成的堆下沉
     *
     * @param arr
     * @param N
     * @param idx
     */
    private void sink(Comparable[] arr, int N, int idx) {
        while (idx * 2 <= N) {
            int j = idx * 2;
            if (j < N && less(arr[j], arr[j + 1])) {
                j++;
            }
            if (!less(arr[idx], arr[j])) {
                break;
            }
            exch(arr, idx, j);
            idx = j;
        }
    }
}
