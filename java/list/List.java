package list;

public interface List<T> {
    void add(T data) throws Exception;

    void remove(int index) throws Exception ;

    void modify (int index, T data) throws Exception ;

    List<T> slice(int start, int end) throws Exception ;
}
