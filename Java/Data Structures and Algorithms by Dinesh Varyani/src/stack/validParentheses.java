package stack;

import java.util.Stack;

public class validParentheses {

    private boolean checkParentheses(String s){
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '('){
                stack.push(')');
            }else if(ch == '{'){
                stack.push('}');
            }else if(ch == '['){
                stack.push(']');
            }else if(stack.peek() == ch){
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String[] test = { "{()}", "{]", "{()" };
        validParentheses vp = new validParentheses();
        for(String s : test){
            System.out.println(vp.checkParentheses(s));
        }
    }
}
