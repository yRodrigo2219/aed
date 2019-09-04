public class Deque<T> implements IDeQue<T>{
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

    public void addFirst(T newData){
        Element<T> newElement = new Element<T>(newData);

        if(isEmpty()){
            this.tail = newElement;
        }else{
            newElement.setNext(this.head);
        }
        this.head = newElement;
    }

    public void addLast(T newData){
        Element<T> newElement = new Element<T>(newData);

        if(isEmpty()){
            this.head = newElement;
        }else{
            this.tail.setNext(newElement);
        }
        this.tail = newElement;
    }

    public T removeFirst(){
        Element<T> tempElement = this.head;

        this.head = this.head.getNext();

        if(isEmpty())
            return null;

        return tempElement.getData();
    }

    public T removeLast(){
        Element<T> tempElement = this.head;
        Element<T> prevElement = null;

        if(isEmpty())
            return null;
        
        for(; tempElement != this.tail; tempElement = tempElement.getNext()){
            prevElement = tempElement;
        }

        this.tail = prevElement;
        this.tail.setNext(null);
        return tempElement.getData();
    }

    public T peekFirst(){
        return this.head.getData();
    }

    public T peekLast(){
        return this.tail.getData();
    }

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

        return str;
    }
}