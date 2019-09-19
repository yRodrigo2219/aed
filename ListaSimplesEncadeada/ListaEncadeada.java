public class ListaEncadeada{
    private final class Element{
        private int data;
        private Element next;

        public Element(int data, Element next){
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }
    }

    private Element head;
    private Element tail;

    public ListaEncadeada(){
        this.head = null;
        this.tail = null;
    }

    public Element getHead(){
        return this.head;
    }

    public Element getTail(){
        return this.tail;
    }

    public void fazVazia(){
        this.head = null;
        this.tail = null;
    }

    public void inserirInicio(int data){
        Element novo = new Element(data, this.head);

        if(this.head == null){
            this.tail = novo;
        }

        this.head = novo;
    }

    public void inserirFinal(int data){
        Element novo = new Element(data, null);

        if(this.tail == null){
            this.head = novo;
        }else{
            this.tail.setNext(novo);
        }

        this.tail = novo;
    }

    public void atribuir(ListaEncadeada lista2){
        if(this != lista2){
            this.fazVazia();
            for(Element ptr = lista2.getHead(); ptr != null; ptr = ptr.getNext()){
                inserirFinal(ptr.getData());
            }
        }
    }

    public void extrair(int i){
        Element ptr = this.head;
        Element prevPtr = null;

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

    public Element retornaElemento(int conteudo){
        Element ptr = this.head;

        while (ptr != null && ptr.getData() != conteudo){
            ptr = ptr.getNext();
        }

        return ptr;
    }

    public void inserirAntes(int oQue, int deQuem){
        Element ptr = retornaElemento(deQuem);
        Element novo = new Element(oQue, ptr);
        Element prevPtr = this.head;

        if (ptr == this.head){
            this.head = novo;
            return;
        }

        for(;prevPtr != null && prevPtr.getNext() != ptr; prevPtr = prevPtr.getNext()){}
        prevPtr.setNext(novo);
    }

    public void inserirDepois(int oQue, int deQuem){
        Element ptr = retornaElemento(deQuem);
        Element novo = new Element(oQue, ptr.getNext());

        ptr.setNext(novo);

        if(ptr == this.tail){
            this.tail = novo;
        }
    }

    @Override
    public String toString(){
        String str = "[ ";
        for(Element ptr = this.head; ptr != null; ptr = ptr.getNext()){
            str += ptr.getData() + (ptr.getNext() != null ? ", " : "");
        }
        str += " ]";
        return str;
    }
}