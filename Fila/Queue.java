public class Queue<T> implements IQueue<T>{
    private class Element<T>{
        private T data;
        private Element<T> next;

        public Element(T data) {
			this.data = data;
		}

		public T getData() {
			return data;
        }
        
		public Element<T> getNext() {
			return next;
        }
        
		public void setNext(Element<T> next) {
			this.next = next;
		}
        
    }

    private Element<T> head, tail;

    @Override
    public void add(T newData){
        Element<T> newElement = new Element<T>(newData);

        if(isEmpty()){
            this.head = newElement;
        }else{
            this.tail.setNext(newElement);
        }
        this.tail = newElement;
    }

    @Override
    public T peek(){
        return this.head.getData();
    }

    @Override
    public T poll(){
        if(isEmpty()){
            return null;
        }

        Element<T> tempElement = this.head;
        this.head = tempElement.getNext();
        return tempElement.getData();
    }

    @Override
    public boolean isEmpty(){
        if(this.head == null){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        String str = "Head -> [ ";

        for(Element<T> ptr = this.head; ptr != null; ptr = ptr.getNext()){
            str += ptr.getData() + (ptr.getNext()!=null ? ", ":" ] -> Tail");
        }

        if(isEmpty()){
            return "Head -> [ ] -> Tail";
        }

        return str;
    }
}