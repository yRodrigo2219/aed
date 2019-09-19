public class ListaClassificadaArray<T> implements IListaClassificada<T>{
    public class Cursor<A> implements ICursor<A>{
        private int cursor = -1;

        public A get(){
            return (A) arr[this.cursor];
        }

        public void remove(){
            if(this.cursor <= 0 || this.cursor >= count || this.cursor >= size){
                System.out.println("Cursor apontando para o nada");
            }else{
                int i = this.cursor;
                for(; i < count; i++){
                    arr[i] = arr[i+1];
                }
                arr[i] = null;
                count--;
            }
        }

        public void addBefore(A data){
            if(this.cursor <= 0 || this.cursor >= count || this.cursor >= size){
                System.out.println("Cursor apontando para o nada");
            }else{
                for(int i = count; i > this.cursor; i--){
                    arr[i] = arr[i-1];
                }
                arr[this.cursor] = (T) data;
                count++;
            }
        }

        public void addAfter(A data){
            if(this.cursor <= 0 || this.cursor >= count || this.cursor >= size){
                System.out.println("Cursor apontando para o nada");
            }else{
                int posIns = this.cursor+1;
                for(int i = count; i > posIns; i--){
                    arr[i] = arr[i-1];
                }
                arr[posIns] = (T) data;
                count++;
            }
        }

        public void setCursor(int num){
            this.cursor = num;
        }
    }
    private Cursor<T> cursor;
    private T[] arr;
    private int count, size;

    public ListaClassificadaArray(int len){
        this.arr = (T[]) new Object[len];
        this.size = len;
        this.count = 0;
    }

    public Cursor<T> get(){
        return this.cursor;
    }

    public boolean isMember(T data){
        for(int i = 0; i < this.count; i++){
            if(data == this.arr[i]){
                return true;
            }
        }
        return false;
    }

    public Cursor<T> getPosition(T data){
        for(int i = 0; i < this.count; i++){
            if(data == this.arr[i]){
                this.cursor.setCursor(i);
                return this.cursor;
            }
        }
        this.cursor.setCursor(-1);
        
        return this.cursor;
    }

    public void add(T data){
        if(this.count >= this.size){
            System.out.println("Lista cheia");
        }else{
            this.arr[this.count] = data;
            count++;
        }
    }

    public void removeL(T data){
        if(this.count == 0){
            System.out.println("Lista vazia");
        }else{
            int i = 0;
            for(; i < this.count && this.arr[i] != data; i++){}
            if(i == this.count){
                System.out.println("Argumento invalido");
            }else{
                for(; i < this.count-1; i++){
                    this.arr[i]= this.arr[i+1];
                }
                this.arr[i] = null;
                this.count--;
            }
        }
    }

    public T search(T data){
        for(int i = 0; i < this.count; i++){
            if(this.arr[i] == data){
                return this.arr[i];
            }
        }
        return null;
    }

    @Override
    public String toString(){
        String str = "";
        for(int i = 0; i < this.count; i++){
            str += this.arr[i] + ", ";
        }
        return str;
    }
}