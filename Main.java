public class Main{
    // Tamanho do array gerado
    private static int SIZE = 100000;

    private static int[] genOrderedVector(){
        int[] arr = new int[SIZE];
        for(int i = 0; i < SIZE; i++){
            arr[i] = i;
        }
        return arr;
    }

    private static int[] genHardShuffledVector(){
        int[] arr = genOrderedVector();

        for(int i = 0; i < SIZE; i++){
            int x = (int) Math.floor(Math.random() * SIZE);
            int temp = arr[i];
            arr[i] = arr[x];
            arr[x] = temp;
        }

        return arr;
    }

    private static int[] genSoftShuffledVector(){
        int[] arr = genOrderedVector();

        for(int i = 0; i < SIZE/3; i++){
            int x = (int) Math.floor(Math.random() * SIZE);
            int temp = arr[i];
            arr[i] = arr[x];
            arr[x] = temp;
        }

        return arr;
    }

    private static int[] genVectorWithLowRepetition(){
        int[] arr = new int[SIZE];

        for(int i = 0; i < SIZE; i++){
            arr[i] = (int) Math.floor(Math.random() * SIZE);
        }

        return arr;
    }

    private static int[] genVectorWithHighRepetition(){
        int[] arr = new int[SIZE];

        for(int i = 0; i < SIZE; i++){
            arr[i] = (int) Math.floor(Math.random() * SIZE/5);
        }

        return arr;
    }

    private static void print(int[] arr){
        System.out.print("[ ");

        for(int i = 0; i < SIZE; i++){
            System.out.print(arr[i] + (i+1==SIZE?" ]":", "));
        }

        System.out.println();
    }

    private static void heapify(int arr[], int length, int i){
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i +2;

        if(left < length && arr[left] > arr[largest])
            largest = left;

        if(right < length && arr[right] > arr[largest])
            largest = right;

        if(largest != i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, length, largest);
        }
    }

    private static void heapSort(int arr[]){
        int length = arr.length;
        for(int i = length/2 - 1; i >= 0; i--)
            heapify(arr, length, i);

        for(int i = length-1; i >= 0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void main(String[] args){
        long start, time;

        // Embaralhados, sem repetição
        int[] softShuff = genSoftShuffledVector();
        int[] hardShuff = genHardShuffledVector();

        // Com repetição
        int[] softRep = genVectorWithLowRepetition();
        int[] hardRep = genVectorWithHighRepetition();

        // Pouco embaralhado, sem repetição
        System.out.println("Pouco embaralhado: ");
        //print(softShuff);
        start = System.currentTimeMillis();
        heapSort(softShuff);
        time = (System.currentTimeMillis() - start);
        //print(softShuff);
        System.out.println("Tempo: " + time + " ms\n");

        // Muito embaralhado, sem repetição
        System.out.println("Muito embaralhado: ");
        //print(hardShuff);
        start = System.currentTimeMillis();
        heapSort(hardShuff);
        time = (System.currentTimeMillis() - start);
        //print(hardShuff);
        System.out.println("Tempo: " + time + " ms\n");

        // Pouca repetição
        System.out.println("Pouca repetição: ");
        //print(softRep);
        start = System.currentTimeMillis();
        heapSort(softRep);
        time = (System.currentTimeMillis() - start);
        //print(softRep);
        System.out.println("Tempo: " + time + " ms\n");

        // Muita repetição
        System.out.println("Muita repetição: ");
        //print(hardRep);
        start = System.currentTimeMillis();
        heapSort(hardRep);
        time = (System.currentTimeMillis() - start);
        //print(hardRep);
        System.out.println("Tempo: " + time + " ms");
    }
}
