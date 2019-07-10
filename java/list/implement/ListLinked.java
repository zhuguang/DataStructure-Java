package list.implement;

import list.List;

public class ListLinked<T> implements List<T> {

    private Node<T> firstNode;

    public ListLinked() {
        this.firstNode = new Node<>(null, null, null);
    }

    private static class Node<T> {
        Node(Node<T> prev, T data, Node<T> next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }

        T data;
        Node<T> prev;
        Node<T> next;
    }

    @Override
    public void add(T data) throws Exception {
        Node<T> current = firstNode;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node<>(current, data, null);
    }

    @Override
    public void remove(int index) throws Exception {
        if (index < 0) {
            return;
        }
        if (index == 0) {
            firstNode = firstNode.next;
            return;
        }
        int count = 0;
        for (Node current = firstNode; current != null; current = current.next) {
            if (count == index - 1) {
                if (current.next == null) {
                    return;
                }
                current.next = current.next.next;
                return;
            }
            if (current.next == null) {
                return;
            }
            count++;
        }
    }

    //    ||prev|next|| -> ||prev|next|| -> ||prev|next||
    private void unlink(Node<T> node) {
        Node<T> prev = node.prev;
        Node<T> next = node.next;
        next.prev = prev;
        prev.next = next;
        node.next = next.next;
    }

    @Override
    public void modify(int index, Object data) throws Exception {
        int count = 0;
       /* for (Node current = firstNode; ; current = current.next) {
            if ()
        }*/

    }

    @Override
    public List slice(int start, int end) throws Exception {
        return null;
    }
}
