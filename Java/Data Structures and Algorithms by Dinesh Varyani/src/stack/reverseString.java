package stack;

import java.lang.invoke.StringConcatException;
import java.util.Stack;

public class reverseString {
    private String reverse(String s){
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(char ch : chars){
            stack.push(ch);
        }

        for(int i = 0; i < chars.length; i++){
            chars[i] = stack.pop();
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        String str = "ABCD";
        reverseString rs = new reverseString();
        System.out.println(rs.reverse(str));
    }
}
