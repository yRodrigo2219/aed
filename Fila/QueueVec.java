public class QueueVec<T> implements IQueue<T>{
    private int head = 0;
    private int tail = 0;
    private int length;
    private int size = 0;
    private T[] arr;

    public QueueVec(int length){
        this.length = length;
        this.arr = (T[]) new Object[length];
    }

    public void add(T newData){
        if(isEmpty()){
            this.arr[0] = newData;
            this.size++;
        }else{
            if(this.tail+1 == this.length){
                System.out.println("Array cheio");
            }else{
                this.arr[this.tail+1] = newData;
                this.tail++;
                this.size++;
            }
        }
    }

    public T peek(){
        if(isEmpty())
            return null;

        return this.arr[this.head];
    }

    public T poll(){
        if(isEmpty()){
            return null;
        }
        
        T[] tempArr = (T[]) new Object[this.length];
        T tempElem = this.arr[this.head];

        for(int i = 0; i < this.size-1; i++){
            tempArr[i] = this.arr[i+1];
        }
        
        this.arr = tempArr;
        this.size--;

        return tempElem;
    }

    public boolean isEmpty(){
        if(this.size == 0){
            return true;
        }

        return false;
    }

    @Override
    public String toString(){
        String str = "Head -> [ ";

        if(isEmpty())
            return "Head -> [ ] -> Tail";

        for(int i = 0; i < this.size; i++){
            str += this.arr[i] + (i+1==this.size?" ] -> Tail":", ");
        }

        return str;
    }

}