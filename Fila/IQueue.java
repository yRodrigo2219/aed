public interface IQueue<T>{
    public void add(T newData);
    public T peek();
    public T poll();
    public boolean isEmpty();
}