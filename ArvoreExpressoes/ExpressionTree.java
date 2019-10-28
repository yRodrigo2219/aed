import java.util.Stack; 

public class ExpressionTree{
    private Node root;

    public ExpressionTree(String postExp){
        Stack<Node> stack = new Stack();
    
        char[] pExp = postExp.toCharArray();

        for(int i = 0; i < pExp.length; i++){
            if(!isOperator(pExp[i])){
                stack.push(new Node(pExp[i]));
            }else{
                Node node1 = stack.pop();
                Node node2 = stack.pop();

                stack.push(new Node(pExp[i], node2, node1));
            }
        }

        this.root = stack.pop();
    }

    public void prefix(){
        System.out.print("Prefix: ");
        Stack<Node> stack = new Stack<>();

        if(this.root != null){
            stack.add(this.root);
            while(!stack.isEmpty()){
                Node temp = stack.pop();

                System.out.print(temp.getData());

                if(temp.getRight() != null){
                    stack.add(new Node(')'));
                    stack.add(temp.getRight());
                    System.out.print('(');
                }

                if(temp.getLeft() != null){
                    stack.add(temp.getLeft());
                }
            }
        }
        System.out.println();
    }

    public void postfix(){
        System.out.print("Postfix: ");
        Stack<Node> stack = new Stack<>();

        if(this.root != null){
            Stack printS = new Stack<>();
            
            stack.add(this.root);
            while(!stack.isEmpty()){
                printS.add(stack.peek().getData());
                Node temp = stack.pop();

                if(temp.getLeft() != null){
                    stack.add(temp.getLeft());
                }     

                if(temp.getRight() != null){
                    stack.add(temp.getRight());
                }
            }
            while(!printS.isEmpty()){
                System.out.print(printS.pop());
            }
        }
        System.out.println();
    }

    public void infix(){
        System.out.print("Infix: ");
        if(this.root != null){
            Stack<Node> stack = new Stack<>();
            boolean end = false;

            Node ptr = this.root;
            do{
                while(ptr != null){
                    if(ptr.getLeft() != null)
                        stack.push(new Node(')'));

                    stack.add(ptr);
                    ptr = ptr.getLeft();
                    
                    if(ptr != null)
                        System.out.print('(');
                }

                if(!stack.isEmpty()){
                    ptr = stack.peek();
                    System.out.print(stack.pop().getData());
                    ptr = ptr.getRight();
                }else{
                    end = true;
                }
            }while(!end);
        }
        System.out.println();
    }

    public boolean isOperator(char c) { 
        if (c == '+' || c == '–' || c == '*'
            || c == '/' || c == '^'){
                return true; 
        }
        return false; 
    }
}