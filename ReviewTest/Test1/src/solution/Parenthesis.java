package solution;

import java.util.Stack;

public class Parenthesis {
    public boolean chkParenthesis(String A, int n){
        if(n%2 == 1){
            return false;
        }
        Stack<Character> stringStack = new Stack<>();
        for (char cString : A.toCharArray()) {
            if (cString == '('){
                stringStack.push(cString);
            }else if(cString == ')'){
                stringStack.pop();
            }else {
                return false;
            }
        }
        return stringStack.isEmpty();
    }

    public static void main(String[] args) {
        Parenthesis p = new Parenthesis();
        String A = "()(()((()()())";
        System.out.println(p.chkParenthesis(A, 14));
    }
}
