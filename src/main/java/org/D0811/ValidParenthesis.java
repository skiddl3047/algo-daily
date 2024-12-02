package org.D0811;

import java.util.Stack;

public class ValidParenthesis {

    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();

        for(char ch:s.toCharArray())
            if(ch == '(')
                stack.push(')');
            else if (ch == '{')
                stack.push('}');
            else if(ch == '[')
                stack.push(']');
            else if(stack.isEmpty() || stack.pop() != ch)
                return false;
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("({[]})"));
        System.out.println(isValid("(){}[]"));
        System.out.println(isValid("})]["));
    }
}
