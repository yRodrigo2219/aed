public class Main{
    public static void main(String[] args) {
        ExpressionTree e = new ExpressionTree("ab/cd–e*+");
        e.infix();
        e.prefix();
        e.postfix();
    }
}