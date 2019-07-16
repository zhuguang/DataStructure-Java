package sort;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Transaction;

/**
 * 优先队列
 */
public abstract class PQAPI<Key extends Comparable<Key>> extends SortExample {

    protected Key[] arr;

    private int size = 10;

    protected int N = 0;

    public PQAPI() {
        arr = (Key[]) new Comparable[size];
    }

    public PQAPI(int size) {
        arr = (Key[]) new Comparable[size];
    }

    public PQAPI(Key[] param) {
        arr = param;
    }

    /**
     * 加入一个元素
     *
     * @param item
     */
    abstract void insert(Key item);

    /**
     * 最大元素
     *
     * @return
     */
    abstract Key max();

    /**
     * 删除并返回最大元素
     *
     * @return
     */
    abstract Key delMax();

    abstract Key delMin();

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return N < 1;
    }

   /* public static void main(String[] args) {
        int size = Integer.parseInt(args[0]);
        PQAPI<Transaction> pq = new HeapPQSort(size);
        while (StdIn.hasNextLine()) {
            String line = StdIn.readLine();
            pq.insert(new Transaction(line));
            if (pq.size() > size) {
                pq.delMin();
            }
        }
        Stack<Transaction> stack = new Stack<>();
        while (pq.size() > 0) {
            stack.push(pq.delMin());
        }
        for (Transaction t : stack) {
            StdOut.println(t);
        }
    }*/
}
