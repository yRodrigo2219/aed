public class Main{
    public static void main(String[] args) {
        ListaClassificadaArray<Integer> lsa = new ListaClassificadaArray<Integer>(10);

        for(int i = 0; i < 5; i++){
            lsa.add(i);
        }
        System.out.println(lsa.toString());
        for(int i = 0; i < 5; i++){
            if(i%2==0){
                lsa.getPosition(i).addAfter(1);
            }else{
                lsa.getPosition(i).addBefore(2);
            }
        }
        System.out.println(lsa.toString());
        for(int i = 0; i < 10; i++){
            lsa.removeL(i);
        }
        System.out.println(lsa.toString());

        ListaClassificadaArray<Integer> ls = new ListaClassificadaArray<Integer>(10);

        for(int i = 0; i < 5; i++){
            ls.add(i);
        }
        System.out.println(ls.toString());
        for(int i = 0; i < 5; i++){
            if(i%2==0){
                ls.getPosition(i).addAfter(1);
            }else{
                ls.getPosition(i).addBefore(2);
            }
        }
        System.out.println(ls.toString());
        for(int i = 0; i < 10; i++){
            ls.removeL(i);
        }
        System.out.println(ls.toString());
    }
}