public class ParenthesisChecker{
    public boolean checkSequence(String sequence){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < sequence.length(); i++){
            if(sequence.charAt(i) != '(' && sequence.charAt(i) != ')'){
                System.err.println("Caractere invalido!");
                return false;
            }else{
                if(stack.isEmpty()){
                    stack.push(sequence.charAt(i));
                }else{
                    if(stack.getTop() == '('){
                        if(sequence.charAt(i) == '('){
                            stack.push(sequence.charAt(i));
                        }else{
                            stack.pop();
                        }
                    }else{ // se for ')'
                        if (sequence.charAt(i) == ')') {
                            stack.push(sequence.charAt(i));
                        } else {
                            stack.pop();
                        }
                    }
                }
            }
        }

        if(!stack.isEmpty()){
            System.out.println("Sequencia invalida");
            return false;
        }

        System.out.println("Sequencia valida");
        return true;
    }
}