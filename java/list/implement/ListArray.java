package list.implement;

import list.List;

import java.util.Arrays;

/*
    an array list for java
 */
public class ListArray<T> implements List<T> {
    private Object[] data;
    // actual length
    private int len;
    private int size = 5;

    private int MAXSIZE = 10240;

    public ListArray() {
        data = new Object[size];
    }

    public ListArray(T[] objArr) {
        this.data = objArr;
        this.len = objArr.length;
        if (objArr.length > size) {
            size = objArr.length * 2;
        }
    }


    @Override
    public void add(T element) throws Exception {
        if (len > MAXSIZE) {
            throw new Exception("len out of max size");
        }
        if (len >= size) {
            growCapacity();
        }
        data[len] = element;
        len++;
    }

    @Override
    public void remove(int index) throws Exception {
        if (index < 0 || index >= len) {
            throw new Exception("index out of range");
        }
        for (int a = index; a < len - 1; a++) {
            data[a] = data[a + 1];
        }
        data[len - 1] = null;
        len--;
    }

    @Override
    public void modify(int index, T element) throws Exception {
        if (index < 0 || index >= len) {
            throw new Exception("index out of range");
        }
        data[index] = element;
    }

    @Override
    public ListArray<T> slice(int start, int end) throws Exception {
        if (start < 0 || start > len || end < 0 || end > len || end < start) {
            throw new Exception("parameter out of range");
        }
        int cap = end - start;
        T[] slice = (T[]) new Object[cap];
        System.arraycopy(data, start, slice, 0, cap);
        return new ListArray<>(slice);
    }

    private void growCapacity() {
        int sizeNew = calcCapacity();
        Object[] newData = new Object[sizeNew];
        System.arraycopy(data, 0, newData, 0, data.length);
        this.data = newData;
        this.size = sizeNew;
    }

    /**
     * calculate the expansion size
     *
     * @return
     */
    private int calcCapacity() {
        return size * 2;
    }

    @Override
    public String toString() {
        return "ListArray{" +
                "data=" + Arrays.toString(data) +
                ", len=" + len +
                ", size=" + size +
                ", MAXSIZE=" + MAXSIZE +
                '}';
    }
}