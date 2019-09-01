public class Prefix extends Expression{
    public String infixToPrefix(String expression){
        String result = "";

        for(int i = expression.length()-1; i>=0 ; i--){
            if(expression.charAt(i) == '('){
                result += ')';
            }else if(expression.charAt(i) == ')'){
                result += '(';
            }else{
                result += expression.charAt(i);
            }
        }

        Postfix pos = new Postfix();

        String prefix = pos.infixToPostfix(result);
        result = "";

        for(int i = prefix.length()-1; i >= 0 ; i--){
            result += prefix.charAt(i);
        }

        return result;
    }

    public String prefixToInfix(String expression){
        Stack<String> stack = new Stack<String>();

        for(int i = expression.length()-1; i >= 0 ; i--){
            if(isOperator(expression.charAt(i))){
                String oper1 = stack.pop();
                String oper2 = stack.pop();

                String temp = "(" + oper1 + expression.charAt(i) + oper2 + ")";

                stack.push(temp);
            }else{
                stack.push(expression.charAt(i) + "");
            }
        }

        return stack.pop();
    }

    public double calcPrefix(String expression){
        Stack<Double> stack = new Stack<Double>();

        for(int i = expression.length()-1; i >= 0 ; i--){
            if(Character.isDigit(expression.charAt(i))){
                stack.push(Integer.parseInt(expression.charAt(i)+"")-0.0);
            }else{
                double val1 = stack.pop();
                double val2 = stack.pop();

                switch(expression.charAt(i)){
                    case '+': 
                        stack.push(val1+val2); 
                        break; 
                    case '-': 
                        stack.push(val1- val2); 
                        break; 
                    case '/': 
                        stack.push(val1/val2); 
                        break; 
                    case '*': 
                        stack.push(val1*val2); 
                        break; 
                    case '^':
                        stack.push(Math.pow(val1, val2));
                        break;
                }
            }
        }

        return stack.pop();
    }

    public String postfixToPrefix(String expression){
        Postfix pos = new Postfix();

        String infix = pos.postfixToInfix(expression);

        return this.infixToPrefix(infix);
    }

    public String prefixToPostfix(String expression){
        Postfix pos = new Postfix();

        String infix = this.prefixToInfix(expression);
        
        return pos.infixToPostfix(infix);
    }
}