package list;

public interface List<T> {
    List<T> add(T data) throws Exception;

    int remove(int index);

    List<T> modify(int index, T data);

    List<T> slice(int start, int end);
}
