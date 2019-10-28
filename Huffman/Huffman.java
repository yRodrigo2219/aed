import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Stack;

class HuffmanComparator implements Comparator<HuffmanNode> { 
    public int compare(HuffmanNode node1, HuffmanNode node2){
        return node1.getData() - node2.getData();
    }
}

public class Huffman{
    private PriorityQueue<HuffmanNode> queue;
    private HuffmanNode root;

    public Huffman(char[] c, int[] f){
        if(c.length != f.length){
            System.err.println("Entrada invalida!");
            return;
        }

        this.queue = new PriorityQueue<HuffmanNode>(c.length, new HuffmanComparator());

        for(int i = 0; i < c.length; i++){
            HuffmanNode newNode = new HuffmanNode(f[i], c[i]);
            this.queue.add(newNode);
        }

        while(this.queue.size() > 1){
            HuffmanNode temp1 = this.queue.peek();
            this.queue.poll();

            HuffmanNode temp2 = this.queue.peek();
            this.queue.poll();

            int data = temp1.getData() + temp2.getData();
            char chr = '-';
            HuffmanNode freq = new HuffmanNode(data, chr, temp1, temp2);

            this.root = freq;
            this.queue.add(freq);
        }
    }

    @Override
    public String toString(){
        String str = "";

        Stack<HuffmanNode> stack = new Stack<>();

        if(this.root != null){
            stack.add(this.root);
            while(!stack.isEmpty()){
                HuffmanNode temp = stack.pop();

                str += temp.getChr()+":"+temp.getData() + " ";

                if(temp.getRight() != null){
                    stack.add(temp.getRight());
                }

                if(temp.getLeft() != null){
                    stack.add(temp.getLeft());
                }     
            }
        }

        System.out.print("Preprint: ");
        return str;
    }
}
