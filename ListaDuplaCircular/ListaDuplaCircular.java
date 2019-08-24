public class ListaDuplaCircular{
    private class Element{
        private Element prev, next;
        private int data;

        public Element(Element prev, Element next, int data) {
			this.prev = prev;
			this.next = next;
			this.data = data;
        }

        public Element(int data) {
            this.data = data;
        }

        public Element getPrev() {
            return prev;
        }

        public void setPrev(Element prev) {
            this.prev = prev;
        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

    }

    private Element tail;

    public boolean isEmpty(){
        if(this.tail == null){
            return true;
        }
        return false;
    }

    public Element getFirstElement(){
        if(!isEmpty()){
            return this.tail.getNext();
        }
        return null;
    }

    public Element getLastElement(){
        if(!isEmpty()){
            return this.tail;
        }
        return null;
    }

    public void addToBegin(int data){
        if(!isEmpty()){
            Element firstElement = getFirstElement();
            Element newElement = new Element(firstElement.getPrev(), firstElement, data);
            firstElement.setPrev(newElement);
            this.tail.setNext(newElement);
        }else{
            Element newElement = new Element(data);
            this.tail = newElement;
            newElement.setNext(this.tail);
            newElement.setPrev(this.tail);
        }
        System.out.println("Elemento adicionado!");
        System.out.println("Nova lista: " + this.toString());
    }

    public void addToEnd(int data){
        if(!isEmpty()){
            Element lastElement = getLastElement();
            Element newElement = new Element(lastElement, lastElement.getNext(), data);
            lastElement.getNext().setPrev(newElement);
            lastElement.setNext(newElement);
            this.tail = newElement;
        }else{
            Element newElement = new Element(data);
            this.tail = newElement;
            newElement.setNext(this.tail);
            newElement.setPrev(this.tail);
        }
        System.out.println("Elemento adicionado!");
        System.out.println("Nova lista: " + this.toString());
    }

    public Element searchElement(int refData){
        if(!isEmpty()){
            Element ptr = getFirstElement();
            for(; ptr.getData() != refData && ptr != getLastElement(); ptr = ptr.getNext()){
            }
            if(ptr.getData() == refData){
                return ptr;
            }
        }
        return null;
    }

    public void addAfter(int refData, int data){
        Element refElement = searchElement(refData);
        if(refElement != null){
            Element newElement = new Element(refElement, refElement.getNext(), data);
            refElement.setNext(newElement);

            if(refElement == this.tail){
                this.tail = newElement;
            }
        }else{
            System.out.println("Elemento inexistente");
        }
        System.out.println("Elemento adicionado!");
        System.out.println("Nova lista: " + this.toString());
    }

    public void addBefore(int refData, int data){
        Element refElement = searchElement(refData);
        if(refElement != null){
            Element newElement = new Element(refElement.getPrev(), refElement, data);
            refElement.getPrev().setNext(newElement);
            refElement.setPrev(newElement);
        }else{
            System.out.println("Elemento inexistente");
        }
        System.out.println("Elemento adicionado!");
        System.out.println("Nova lista: " + this.toString());
    }

    public void clearList(){
        this.tail = null;
    }

    public void assign(ListaDuplaCircular list){
        if(this != list){
            clearList();
            for(Element ptr = list.getFirstElement(); ptr != list.getLastElement(); ptr = ptr.getNext()){
                addToEnd(ptr.getData());
            }
            addToEnd(list.getLastElement().getData());
        }
        System.out.println("Lista atribuida!");
        System.out.println("Nova lista: " + this.toString());
    }

    public void remove(int refData){
        Element refElement = searchElement(refData);

        if(refElement != null){
            refElement.getPrev().setNext(refElement.getNext());
            refElement.getNext().setPrev(refElement.getPrev());

            System.out.println("Elemento removido com sucesso!");
            System.out.println("Nova lista: " + this.toString());
        }else{
            System.out.println("Elemento não existente");
            System.out.println("Sua lista é: " + this.toString());
        }
    }

    @Override
    public String toString(){
        String str = "[ ";
        for(Element ptr = getFirstElement(); ptr != getLastElement(); ptr = ptr.getNext()){
            str += ptr.getData() + ", ";
        }
        str += getLastElement().getData() + " ]";
        return str;
    }
}