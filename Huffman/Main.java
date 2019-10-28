public class Main{
    public static void main(String[] args) {
        char[] c = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] f = { 5, 9, 12, 13, 16, 45 }; 
        Huffman h = new Huffman(c, f);
        
        System.out.println(h);
    }
}