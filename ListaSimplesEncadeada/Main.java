public class Main{
    public static void main(String[] args) {
        ListaEncadeada<Integer> lista1 = new ListaEncadeada<>();
        ListaEncadeada<Integer> lista2 = new ListaEncadeada<>();

        for(int i = 0; i <= 20; i++){
            lista1.inserirFinal(20-i);
            lista2.inserirFinal(i);
        }

        System.out.println("Lista 1: " + lista1);
        System.out.println("Lista 2: " + lista2);

        try{
            // insere o 5 depois do 5
            lista2.inserirDepois(5, 5);
            lista2.inserirDepois(5, 5);

            // insere o 3 antes do 1
            lista2.inserirAntes(3, 1);

            // extrai dois 5s da lista
            lista2.extrair(5);
            lista2.extrair(5);

            // atribui a lista2 a lista1
            lista1.atribuir(lista2);

            System.out.println("Lista 1: " + lista1);
            System.out.println("Lista 2: " + lista2);
        }catch(Exception e){
            System.out.println("" + e.getMessage());
        }
      }
}
