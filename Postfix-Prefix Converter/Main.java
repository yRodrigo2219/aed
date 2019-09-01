public class Main{
    public static void main(String[] args) {
        System.out.println("Postfix:\n");

        Postfix postfix = new Postfix();
        System.out.println(postfix.infixToPostfix("a+b*c/d"));
        System.out.println(postfix.postfixToInfix("abc*d/+"));
        System.out.println(postfix.calcPostfix("123*4/+"));
        System.out.println(postfix.postfixToPrefix("abc*d/+"));
        System.out.println(postfix.prefixToPostfix("+a*b/cd"));

        System.out.println("\n\nPrefix:\n");

        Prefix prefix = new Prefix();
        System.out.println(prefix.infixToPrefix("a+b*c/d"));
        System.out.println(prefix.prefixToInfix("+a*b/cd"));
        System.out.println(prefix.calcPrefix("+1*2/34"));
        System.out.println(prefix.postfixToPrefix("abc*d/+"));
        System.out.println(prefix.prefixToPostfix("+a*b/cd"));

        System.out.println("\n\nStack:\n");

        Stack<Integer> s = new Stack<Integer>();
        s.push(1);
        s.push(5);
        s.push(1);
        s.push(1);
        s.push(6);
        System.out.println(s.toString());
        s.pop();
        s.pop();
        s.pop();
        System.out.println(s.toString());
    }
}