public class Stack<T>{
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

    private Element<T> top;

    public boolean isEmpty(){
        if(this.top == null){
            return true;
        }
        return false;
    }

    public void push(T data){
        Element<T> newElement = new Element<T>(data);
        if(!isEmpty()){
            newElement.setNext(this.top);
        }
        this.top = newElement;
    }

    public T pop(){
        T data = this.top.getData();
        if(!isEmpty()){
            this.top = this.top.getNext();
        }
        return data;
    }

    public T getTop(){
        if(isEmpty())
            return null;
        return this.top.getData();
    }

    @Override
    public String toString(){
        String str = "Top -> [ ";

        for(Element<T> ptr = this.top; ptr != null; ptr = ptr.getNext()){
            str += ptr.getData() + (ptr.getNext()!=null ? ", ":" ]");
        }

        return str;
    }
}