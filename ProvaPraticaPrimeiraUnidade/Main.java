public class Main{
    public static void main(String[] args) {
        // Demonstração da questão 1
        System.out.println("Questao1:\n");
        ListaClassificada<Integer> l = new ListaClassificada<>();
    
        for(int i = 1; i <= 10; i++){
            l.add(i);
        }

        System.out.println(l);

        // Metodo adicionado na linha 105 da ListaClassificada.java
        l = l.invert();

        System.out.println(l);


        // Questão 2
        System.out.println("\nQuestao2:\n");

        ParenthesisChecker p = new ParenthesisChecker();

        System.out.print("Letra A - ");
        p.checkSequence("(((()))())"); // letra A

        System.out.print("Letra B - ");
        p.checkSequence("((())"); // letra B

        System.out.print("Letra C - ");
        p.checkSequence("(("); // letra C

        System.out.print("Letra D - ");
        p.checkSequence("()"); // letra D

        System.out.print("\nBonus: ");
        p.checkSequence("(((a)))");
    }
}