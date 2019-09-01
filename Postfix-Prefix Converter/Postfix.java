public class Postfix extends Expression{

    public String infixToPostfix(String expression){
        String result = "";
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < expression.length(); i++){
            if(Character.isLetterOrDigit(expression.charAt(i))){
                result += expression.charAt(i);
            }else{
                if(expression.charAt(i) == '('){
                    stack.push(expression.charAt(i));
                }else if(expression.charAt(i) == ')'){
                    while(!stack.isEmpty() && stack.getTop() != '(')
                        result += stack.pop();

                    stack.pop();
                }else{
                    while(!stack.isEmpty() && operatorPrecedance(expression.charAt(i)) <= operatorPrecedance(stack.getTop()==null?' ':stack.getTop()))
                        result += stack.pop();
                    stack.push(expression.charAt(i));
                }
            }
        }
        while(!stack.isEmpty())
            result += stack.pop();

        return result;
    }

    public String postfixToInfix(String expression){
        String result = "";
        Stack<String> stack = new Stack<String>();

        for(int i = 0; i < expression.length(); i++){
            if(Character.isLetterOrDigit(expression.charAt(i))){
                stack.push(expression.charAt(i)+"");
            }else{
                String out1 = stack.pop();
                String out2 = stack.pop();
                stack.push("(" + out2 + expression.charAt(i) + out1 + ")");
            }
        }
        result = stack.pop();
        return result;
    }

    public double calcPostfix(String expression){
        double result;
        Stack<Double> stack = new Stack<Double>();

        for(int i = 0; i < expression.length(); i++){
            if(Character.isDigit(expression.charAt(i))){
                stack.push(Integer.parseInt(expression.charAt(i)+"")-0.0);
            }else{
                double val1 = stack.pop();
                double val2 = stack.pop();

                switch(expression.charAt(i)){
                    case '+': 
                        stack.push(val2+val1); 
                        break; 
                    case '-': 
                        stack.push(val2- val1); 
                        break; 
                    case '/': 
                        stack.push(val2/val1); 
                        break; 
                    case '*': 
                        stack.push(val2*val1); 
                        break; 
                    case '^':
                        stack.push(Math.pow(val2, val1));
                        break;
                }
            }
        }

        result = stack.pop();
        return result;
    }

    public String postfixToPrefix(String expression){
        Prefix pre = new Prefix();

        String infix = this.postfixToInfix(expression);

        return pre.infixToPrefix(infix);
    }

    public String prefixToPostfix(String expression){
        Prefix pre = new Prefix();

        String infix = pre.prefixToInfix(expression);
        
        return this.infixToPostfix(infix);
    }
}