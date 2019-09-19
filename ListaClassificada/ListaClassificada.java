public class ListaClassificada<T> implements IListaClassificada<T>{
    public class Cursor<A> implements ICursor<A>{
        private Element<A> cursor;

        public A get(){
            return cursor.getData();
        }

        public void addBefore(A data){
            Element<A> ptr = this.cursor;
            Element<A> novo = new Element(data, ptr);
            Element<A> prevPtr = (ListaClassificada<T>.Element<A>) head;
    
            if (ptr == head){
                head = (ListaClassificada<T>.Element<T>) novo;
                return;
            }
    
            for(;prevPtr != null && prevPtr.getNext() != ptr; prevPtr = prevPtr.getNext()){}
            prevPtr.setNext(novo);
        }

        public void addAfter(A data){
            Element<A> ptr = this.cursor;
            Element<A> novo = new Element(data, ptr.getNext());

            ptr.setNext(novo);

            if(ptr == tail){
                tail = (ListaClassificada<T>.Element<T>) novo;
            }
        }

        public void remove(){
            Element<A> ptr = (ListaClassificada<T>.Element<A>) head;
            Element<A> prevPtr = null;

            while(ptr != null && ptr != this.cursor){
                prevPtr = ptr;
                ptr = ptr.getNext();
            }

            if(ptr == null){
                System.out.println("Nulo");
                return;
            }

            if(ptr == head){
                head = (ListaClassificada<T>.Element<T>) ptr.getNext();
            }else if(ptr == tail){
                tail = (ListaClassificada<T>.Element<T>) prevPtr;
                prevPtr.setNext(null);
            }else{
                prevPtr.setNext(ptr.getNext());
            }
        }

        public void setCursor(Element<A> num){
            this.cursor = num;
        }

    }
    private final class Element<S>{
        private S data;
        private Element<S> next;

        public Element(S data, Element<S> next){
            this.data = data;
            this.next = next;
        }

        public S getData() {
            return data;
        }

        public void setData(S data) {
            this.data = data;
        }

        public Element<S> getNext() {
            return next;
        }

        public void setNext(Element<S> next) {
            this.next = next;
        }
    }

    private Element<T> head;
    private Element<T> tail;
    private Cursor<T> cursor;


    public ICursor<T> get(){
        return this.cursor;
    }

    public ICursor<T> getPosition(T data){
        Element<T> ptr = this.head;
        for(; ptr.getData() != data && ptr != null; ptr = ptr.getNext()){
        }
        this.cursor.setCursor(ptr);
        return this.cursor;
    }

    public boolean isMember(T data){
        Element<T> ptr = this.head;
        for(; ptr.getData() != data && ptr != null; ptr = ptr.getNext()){
        }
        if(ptr == null){
            return false;
        }else{
            return true;
        }
    }

    public void add(T data){
        Element<T> novo = new Element<T>(data, null);

        if(this.tail == null){
            this.head = novo;
        }else{
            this.tail.setNext(novo);
        }

        this.tail = novo;
    }

    public void removeL(T data){
        Element<T> ptr = this.head;
        Element<T> prevPtr = null;

        while(ptr != null && ptr.getData() != data){
            prevPtr = ptr;
            ptr = ptr.getNext();
        }

        if(ptr == null){
            System.out.println("Nulo");
            return;
        }

        if(ptr == this.head){
            this.head = ptr.getNext();
        }else if(ptr == this.tail){
            this.tail = prevPtr;
            prevPtr.setNext(null);
        }else{
            prevPtr.setNext(ptr.getNext());
        }
    }

    public T search(T data){
        Element<T> ptr = this.head;

        while (ptr != null && ptr.getData() != data){
            ptr = ptr.getNext();
        }

        return ptr.getData();
    }

    @Override
    public String toString(){
        String str = "[ ";
        for(Element<T> ptr = this.head; ptr != null; ptr = ptr.getNext()){
            str += ptr.getData() + (ptr.getNext() != null ? ", " : "");
        }
        str += " ]";
        return str;
    }
}