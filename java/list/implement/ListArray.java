package list.implement;

import list.List;

/*
    an array list for java
 */
public class ListArray<T> implements List<T> {
    private Object[] data;
    private int len;

    private int MAXSIZE = 1024;

    public ListArray() {

    }


    @Override
    public List<T> add(T data) throws Exception {
        if (len > 1024) {
            throw  new Exception("len out of max size");
        }

        return null;
    }

    @Override
    public int remove(int index) {
        return 0;
    }

    @Override
    public List<T> modify(int index, T data) {
        return null;
    }

    @Override
    public List<T> slice(int start, int end) {
        return null;
    }
}
