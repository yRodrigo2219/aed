import java.util.Random;

public class Hashing{
    private ListaEncadeada<String>[] hashTable;
    private int[] weights = new int[5];
    private int conf = 0;
    private int cont = 0;

    public Hashing(int len){
        this.hashTable = new ListaEncadeada[len];

        createWeights();
        
        for(int i = 0; i < len; i++){
            this.hashTable[i] = new ListaEncadeada<String>();
        }
    }

    private void createWeights(){
        // 56 105 0 258 828 15%
        this.weights[0] = 56;
        this.weights[1] = 105;
        this.weights[2] = 0; // caractere "/"
        this.weights[3] = 258;
        this.weights[4] = 828;
    }

    public void add(String date){
        this.cont++;
        if(!this.hashTable[hash(date)].estaVazia())
            this.conf++;

        this.hashTable[hash(date)].inserirFinal(date);
    }

    public void remove(String date){
        // Já que dado e key são a mesma coisa, removendo qualquer um é o certo
        this.hashTable[hash(date)].removerInicio();
    }

    public ListaEncadeada<String> search(String date){
        return this.hashTable[hash(date)];
    }

    private int hash(String key){
        int hashTemp = 0;

        for(int i = 0; i < key.length(); i++){
            hashTemp += this.weights[i]*((int) key.charAt(i)-48);
        }

        int hashIndex = hashTemp % this.hashTable.length;

        return hashIndex;
    }

    @Override
    public String toString(){
        String str = "[ \n";
        int s = this.hashTable.length;

        for(int i = 0; i < s; i++){
            if(!this.hashTable[i].estaVazia()){
                str += this.hashTable[i] + "\n";
            }
        }

        return str + " ] \n Conflitos: " + ((this.conf+0.0)/this.cont * 100) + " %";
    }
}