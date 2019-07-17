package search;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public abstract class ST<Key extends Comparable<Key>, Value> {
    public ST() {

    }

    abstract void put(Key k, Value v);

    abstract void delete(Key k);

    abstract Value get(Key k);

    abstract Key[] keys();

    public static void main(String[] args) {
        ST<String, Integer> st;
        st = new SequentialSearchST();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String s : st.keys()) {
            StdOut.println(s + " " + st.get(s));
        }
    }
}
