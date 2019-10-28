public class HuffmanNode{
    private int data; 
    private char chr;
  
    private HuffmanNode left; 
    private HuffmanNode right;

    public HuffmanNode(int data, char chr) {
        this.data = data;
        this.chr = chr;
    }

    public HuffmanNode(int data, char chr, HuffmanNode left, HuffmanNode right) {
        this.data = data;
        this.chr = chr;
        this.left = left;
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public char getChr() {
        return chr;
    }

    public void setChr(char chr) {
        this.chr = chr;
    }

    public HuffmanNode getLeft() {
        return left;
    }

    public void setLeft(HuffmanNode left) {
        this.left = left;
    }

    public HuffmanNode getRight() {
        return right;
    }

    public void setRight(HuffmanNode right) {
        this.right = right;
    }

}