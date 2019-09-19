public interface ICursor<T>{
    public T get();
    public void addBefore(T data);
    public void addAfter(T data);
    public void remove();
}