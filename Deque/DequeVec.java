public class DequeVec<T> implements IDeQue<T>{
    private int head = 0;
    private int tail = 0;
    private int size = 0;
    private int length;
    private T[] arr;

    public DequeVec(int length){
        this.length = length;
        arr = (T[]) new Object[length];
    }

    public void addFirst(T newData){
        if(isEmpty()){
            this.arr[0] = newData;
            this.size++;
            this.tail = 0;
        }else{
            if(this.tail+1 == this.length){
                System.out.println("Array cheio");
            }else{
                T[] tempArr = (T[]) new Object[this.length];
                tempArr[0] = newData;

                this.size++;

                for(int i = 1; i < this.size; i++){
                    tempArr[i] = this.arr[i-1];
                }

                this.arr = tempArr;
                this.tail++;
            }
        }
    }

    public void addLast(T newData){
        if(isEmpty()){
            this.arr[0] = newData;
            this.size++;
            this.tail = 0;
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

    public T removeFirst(){
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
        this.tail--;

        return tempElem;
    }

    public T removeLast(){
        if(isEmpty()){
            return null;
        }

        T[] tempArr = (T[]) new Object[this.length];
        T tempElem = this.arr[this.tail];

        for(int i = 0; i < this.size-1; i++){
            tempArr[i] = this.arr[i];
        }

        this.arr = tempArr;
        this.size--;
        this.tail--;

        return tempElem;
    }

    public T peekFirst(){
        if(isEmpty())
            return null;

        return this.arr[this.head];
    }

    public T peekLast(){
        if(isEmpty())
            return null;

        return this.arr[this.tail];
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