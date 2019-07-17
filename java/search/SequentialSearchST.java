package search;

import edu.princeton.cs.algs4.StdOut;

import java.security.Key;

/**
 * 符号表的链表实现
 * 顺序查找
 */
public class SequentialSearchST extends ST<String, Integer> {

    private Node first;
    private int size = 0;

    class Node {
        public Node(String k, Integer v, Node prev, Node next) {
            this.key = k;
            this.value = v;
            this.prev = prev;
            this.next = next;
        }

        String key;
        Integer value;
        Node next;
        Node prev;
    }

    public SequentialSearchST() {

    }

    @Override
    void put(String k, Integer v) {
        for (Node n = first; n != null; n = n.next) {
            if (n.key.equals(k)) {
                n.value = v;
                return;
            }
        }
        Node n = new Node(k, v, null, first);
        if (first != null) {
            first.prev = n;
        }
        first = n;
        size++;
    }

    @Override
    void delete(String k) {
        for (Node n = first; n != null; n = n.next) {
            if (n.key.equals(k)) {
                n.prev.next = n.next;
                n.next.prev = n.prev;
                size--;
            }
        }
    }

    @Override
    Integer get(String k) {
        for (Node n = first; n != null; n = n.next) {
            if (n.key.equals(k)) {
                return n.value;
            }
        }
        return null;
    }

    @Override
    String[] keys() {
        String[] ks = new String[size];
        int idx = 0;
        for (Node x = first; x != null; x = x.next) {
            ks[idx] = x.key;
            idx++;
        }
        return ks;
    }

    public int size() {
        return size;
    }
}
