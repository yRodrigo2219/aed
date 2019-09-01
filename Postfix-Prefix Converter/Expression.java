public abstract class Expression{
    protected char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    protected char[] operators = {'+', '-', '/', '*', '(', ')', '^'};
    protected char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    protected boolean isOperator(char chr){
        for(int j = 0; j < operators.length; j++){
            if(chr == operators[j])
                return true;
        }
        return false;
    }

    protected int operatorPrecedance(char chr){
        switch(chr){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
}