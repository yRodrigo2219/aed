import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<T extends Comparable<? super T>>{
    private Node<T> root;

    public void prePrintI(){
        Stack<Node<T>> stack = new Stack<>();

        if(this.root != null){
            stack.add(this.root);
            while(!stack.isEmpty()){
                Node<T> temp = stack.pop();

                System.out.print(temp.getData() + " ");

                if(temp.getRightNode() != null){
                    stack.add(temp.getRightNode());
                }

                if(temp.getLeftNode() != null){
                    stack.add(temp.getLeftNode());
                }     
            }
        }
        System.out.println();
    }

    public void posPrintI(){
        Stack<Node<T>> stack = new Stack<>();

        if(this.root != null){
            Stack<T> printS = new Stack<>();
            
            stack.add(this.root);
            while(!stack.isEmpty()){
                printS.add(stack.peek().getData());
                Node<T> temp = stack.pop();

                if(temp.getLeftNode() != null){
                    stack.add(temp.getLeftNode());
                }     

                if(temp.getRightNode() != null){
                    stack.add(temp.getRightNode());
                }
            }
            while(!printS.isEmpty()){
                System.out.print(printS.pop() + " ");
            }
        }
        System.out.println();
    }

    public void inPrintI(){
        if(this.root != null){
            Stack<Node<T>> stack = new Stack<>();
            boolean end = false;

            Node<T> ptr = this.root;
            do{
                while(ptr != null){
                    stack.add(ptr);
                    ptr = ptr.getLeftNode();
                }

                if(!stack.isEmpty()){
                    ptr = stack.peek();
                    System.out.print(stack.pop().getData() + " ");
                    ptr = ptr.getRightNode();
                }else{
                    end = true;
                }
            }while(!end);
        }
        System.out.println();
    }

    private String recursivePathing(Node<T> node, T data, String path){
        if(node == null){
            return "No inexistente";
        }else if(data.compareTo(node.getData()) == 0){
            return path;
        }else{
            if(data.compareTo(node.getData()) < 0){ // data < node
                return recursivePathing(node.getLeftNode(), data, path+"0");
            }else{ // data >= node
                return recursivePathing(node.getRightNode(), data, path+"1");
            }
        }
    }

    public String path(T data){
        if(this.root == null){
            return "Arvore vaiza";
        }else{
            return recursivePathing(this.root, data, "");
        }
    }

    public void insert(T data){
        if(root == null){
            this.root = new Node<>(data);
        }else{
            recursiveInsertion(this.root, data);
        }
    }

    private void recursiveInsertion(Node<T> node, T data){
        if(data.compareTo(node.getData()) < 0){ // data < node
            if(node.getLeftNode() == null){
                Node<T> newNode = new Node<>(data);
                node.setLeftNode(newNode);
            }else{
                recursiveInsertion(node.getLeftNode(), data);
            }
        }else{ // data >= node
            if(node.getRightNode() == null){
                Node<T> newNode = new Node<>(data);
                node.setRightNode(newNode);
            }else{
                recursiveInsertion(node.getRightNode(), data);
            }
        }
    }

    private Node<T> recursiveSearch(Node<T> node, T data){
        if(data.compareTo(node.getData()) == 0 || node == null){
            return node;
        }else{
            if(data.compareTo(node.getData()) < 0){ // data < node
                return recursiveSearch(node.getLeftNode(), data);
            }else{ // data >= node
                return recursiveSearch(node.getRightNode(), data);
            }
        }
    }

    public Node<T> search(T data){
        if(this.root == data){
            return this.root;
        }else{
            return recursiveSearch(this.root, data);
        }
    }

    private boolean recursiveIsInTree(Node<T> node, T data){
        if(node == null){
            return false;
        }

        if(data.compareTo(node.getData()) == 0){
            return true;
        }else{
            if(data.compareTo(node.getData()) < 0){ // data < node
                return recursiveIsInTree(node.getLeftNode(), data);
            }else{
                return recursiveIsInTree(node.getRightNode(), data);
            }
        }
    }

    public boolean isInTree(T data){
        if(this.root == data){
            return true;
        }else{
            return recursiveIsInTree(this.root, data);
        }
    }

    public void prePrint(Node<T>... node){
        if(node.length == 0){
            System.out.print(this.root.getData() + " ");
            if(this.root.getLeftNode() != null){
                prePrint(this.root.getLeftNode());
            }
            if(this.root.getRightNode() !=  null){
                prePrint(this.root.getRightNode());
            }
        }else{
            System.out.print(node[0].getData() + " ");
            if(node[0].getLeftNode() != null){
                prePrint(node[0].getLeftNode());
            }
            if(node[0].getRightNode() !=  null){
                prePrint(node[0].getRightNode());
            }
        }
    }

    public void inPrint(Node<T>... node){
        if(node.length == 0){
            if(this.root.getLeftNode() != null){
                inPrint(this.root.getLeftNode());
            }
            System.out.print(this.root.getData() + " ");
            if(this.root.getRightNode() !=  null){
                inPrint(this.root.getRightNode());
            }
        }else{
            if(node[0].getLeftNode() != null){
                inPrint(node[0].getLeftNode());
            }
            System.out.print(node[0].getData() + " ");
            if(node[0].getRightNode() !=  null){
                inPrint(node[0].getRightNode());
            }
        }
    }

    public void posPrint(Node<T>... node){
        if(node.length == 0){
            if(this.root.getLeftNode() != null){
                posPrint(this.root.getLeftNode());
            }
            if(this.root.getRightNode() !=  null){
                posPrint(this.root.getRightNode());
            }
            System.out.print(this.root.getData() + " ");
        }else{
            if(node[0].getLeftNode() != null){
                posPrint(node[0].getLeftNode());
            }
            if(node[0].getRightNode() !=  null){
                posPrint(node[0].getRightNode());
            }
            System.out.print(node[0].getData() + " ");
        }
    }

    public void bfPrint(){
        Queue<Node<T>> queue = new LinkedList<>();

        if(this.root != null){
            queue.add(this.root);
            while(!queue.isEmpty()){
                Node<T> temp = queue.poll();

                System.out.print(temp.getData() + " ");

                if(temp.getLeftNode() != null){
                    queue.add(temp.getLeftNode());
                }

                if(temp.getRightNode() != null){
                    queue.add(temp.getRightNode());
                }
            }
        }
        System.out.println();
    }

    private boolean isLeaf(Node<T> node){
        if(node.getLeftNode() == null && node.getRightNode() == null){
            return true;
        }else{
            return false;
        }
    }

    private Node<T> removeLeaf(Node<T> node){
        if(node == this.root){
            this.root = null;
            return node;
        }

        Node<T> father = this.root;
        while(father.getLeftNode() != node && father.getRightNode() != node){
            if(father.getData().compareTo(node.getData()) < 0){
                father = father.getLeftNode();
            }else{ // >=
                father = father.getRightNode();
            }
        }

        if(father.getLeftNode() == node){
            father.setLeftNode(null);
        }else{
            father.setRightNode(null);
        }

        return node;
    }

    private Node<T> recursiveRemotion(Node<T> node){
        if(isLeaf(node)){
            return removeLeaf(node);
        }else{
            if(node.getRightNode() != null){
                Node<T> temp = node.getRightNode();
                while(temp.getLeftNode() != null){
                    temp = temp.getLeftNode();
                }

                node.setData(temp.getData());
                return recursiveRemotion(temp);
            }else{
                Node<T> temp = node.getLeftNode();
                while(temp.getRightNode() != null){
                    temp = temp.getRightNode();
                }

                node.setData(temp.getData());
                return recursiveRemotion(temp);
            }
        }
    }

    public Node<T> remove(T data){
        if(this.root == null){
            return null;
        }else{
            Node<T> node = search(data);

            return recursiveRemotion(node);
        }
    }
}