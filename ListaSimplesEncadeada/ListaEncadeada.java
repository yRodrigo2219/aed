public class ListaEncadeada<T>{
    private final class Element<T>{
        private T data;
        private Element<T> next;

        public Element(T data, Element<T> next){
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Element<T> getNext() {
            return next;
        }

        public void setNext(Element<T> next) {
            this.next = next;
        }
    }

    private Element<T> head;
    private Element<T> tail;

    public Element<T> getHead(){
        return this.head;
    }

    public Element<T> getTail(){
        return this.tail;
    }
    
    public boolean estaVazia(){
        return (this.head == null);
    }

    public void fazVazia(){
        this.head = null;
        this.tail = null;
    }

    public void inserirInicio(T data){
        Element<T> novo = new Element<>(data, this.head);

        if(this.head == null){
            this.tail = novo;
        }

        this.head = novo;
    }

    public void inserirFinal(T data){
        Element<T> novo = new Element<>(data, null);

        if(this.tail == null){
            this.head = novo;
        }else{
            this.tail.setNext(novo);
        }

        this.tail = novo;
    }

    public void removerInicio(){
        this.head = this.head.getNext();
    }

    public void atribuir(ListaEncadeada<T> lista2){
        if(this != lista2){
            this.fazVazia();
            for(Element<T> ptr = lista2.getHead(); ptr != null; ptr = ptr.getNext()){
                inserirFinal(ptr.getData());
            }
        }
    }

    public void extrair(T i){
        Element<T> ptr = this.head;
        Element<T> prevPtr = null;

        while(ptr != null && ptr.getData() != i){
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

    public Element<T> retornaElemento(T conteudo){
        Element<T> ptr = this.head;

        while (ptr != null && ptr.getData() != conteudo){
            ptr = ptr.getNext();
        }

        return ptr;
    }

    public void inserirAntes(T oQue, T deQuem){
        Element<T> ptr = retornaElemento(deQuem);
        Element<T> novo = new Element<>(oQue, ptr);
        Element<T> prevPtr = this.head;

        if (ptr == this.head){
            this.head = novo;
            return;
        }

        for(;prevPtr != null && prevPtr.getNext() != ptr; prevPtr = prevPtr.getNext()){}
        prevPtr.setNext(novo);
    }

    public void inserirDepois(T oQue, T deQuem){
        Element<T> ptr = retornaElemento(deQuem);
        Element<T> novo = new Element<>(oQue, ptr.getNext());

        ptr.setNext(novo);

        if(ptr == this.tail){
            this.tail = novo;
        }
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