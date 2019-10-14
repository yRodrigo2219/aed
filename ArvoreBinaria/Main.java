public class Main{
    public static void main(String[] args) {
        BinaryTree<Integer> b = new BinaryTree<>();

        b.insert(6);
        b.insert(4);
        b.insert(8);
        b.insert(5);
        b.insert(2);
        b.insert(7);
        b.insert(9);
        b.insert(10);

        b.bfPrint();
        
        System.out.println(b.path(7));

        b.remove(6);
        b.bfPrint();

        System.out.println(b.path(7));

        System.out.println("PrePrint:");

        b.prePrint();
        System.out.println();
        b.prePrintI();

        System.out.println("PosPrint:");

        b.posPrint();
        System.out.println();
        b.posPrintI();

        System.out.println("InPrint:");

        b.inPrint();
        System.out.println();
        b.inPrintI();
    }
}