package org.D0811;

import java.util.Stack;

public class ValidParenthesis {

    /*
    // if you find '(' add ')' to stack
    // if you find '[' add ']' to stack
    // if you find '{' add '}' to stack
    // else if stack is empty or stack pop operation returns char not equals to ch then return false
    // after the loop return stack.isEmpty()
     */
    /*
    Time complexity : O(n) because we simply traverse the given string one character at a time and
    push and pop operations on a stack take O(1) time.

Space complexity : O(n) as we push all opening brackets onto the stack and in the worst case,
we will end up pushing all the brackets onto the stack. e.g. ((((((((((.
     */

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
