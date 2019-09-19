public interface IListaClassificada<T>{
    public ICursor<T> get();
    public ICursor<T> getPosition(T data);
    public boolean isMember(T data);
    public void add(T data);
    public void removeL(T data);
    public T search(T data);
}