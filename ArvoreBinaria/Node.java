public class Node<T>{
    private T data;
    private Node<T> rightNode, leftNode;

    public Node(T data){
        this.data = data;
    }

    public Node(T data, Node<T> r, Node<T> l){
        this.data = data;
        this.rightNode = r;
        this.leftNode = l;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node<T> rightNode) {
        this.rightNode = rightNode;
    }

    public Node<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node<T> leftNode) {
        this.leftNode = leftNode;
    }
    
}