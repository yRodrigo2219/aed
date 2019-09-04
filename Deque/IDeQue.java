public interface IDeQue<T>{
    public void addFirst(T newData);
    public void addLast(T newData);
    public T removeFirst();
    public T removeLast();
    public T peekFirst();
    public T peekLast();
    public boolean isEmpty();
}