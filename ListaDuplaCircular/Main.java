public class Main{
    public static void main(String[] args) {
        ListaDuplaCircular list = new ListaDuplaCircular();
        ListaDuplaCircular list0 = new ListaDuplaCircular();

        System.out.println("Lista: ");
        list.addToEnd(1);
        list.addToEnd(2);
        list.addToEnd(3);
        list.addToBegin(4);
        list.addToEnd(5);
        list.addAfter(5, 4);
        list.addToBegin(8);
        list.addToEnd(7);
        list.addBefore(8, 1);
        list.addToBegin(8);

        System.out.println("\n\nLista0: ");
        list0.addToBegin(5);
        list0.addToBegin(5);
        list0.addToBegin(5);
        list0.addToBegin(5);
        list0.addToBegin(5);
        list0.addToBegin(5);

        list.assign(list0);

        System.out.println("\n\nLista: ");
        list.remove(5);
        list.remove(5);
        list.remove(5);
        list.remove(5);
        list.remove(5);

        list.addToBegin(8);
        list.addToEnd(7);
        list.addBefore(8, 1);
        list.addToBegin(8);
    }
}