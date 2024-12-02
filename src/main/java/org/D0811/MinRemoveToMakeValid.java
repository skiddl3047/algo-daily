package org.D0811;

import java.util.Stack;

public class MinRemoveToMakeValid {

    public static String minRemoveToMakeValid(String s) {
        var chars = s.toCharArray();
        var stack = new Stack<Integer>();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else if (chars[i] == ')') {
                if (stack.empty()) {
                    chars[i] = ' ';
                } else {
                    stack.pop();
                }
            }
        }

        for (var index : stack.reversed()) {
            chars[index] = ' ';
        }

        var stringBuilder = new StringBuilder();

        for (var character : chars) {
            if (character != ' ') {
                stringBuilder.append(character);
            }
        }
        return stringBuilder.toString();
    }

    public static String minRemoveToMakeValidOptimal(String s) {

        // Pass 1: Remove all invalid ")"
        StringBuilder sb = new StringBuilder();
        int openSeen = 0;
        int balance = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                openSeen++;
                balance++;
            } if (ch == ')') {
                if (balance == 0) continue;
                balance--;
            }
            sb.append(ch);
        }
        //System.out.println("input: "+s+" sb: "+sb);
        // Pass 2: Remove the rightmost "("
        StringBuilder result = new StringBuilder();
        int openToKeep = openSeen - balance;
        for (char ch: sb.toString().toCharArray()) {
            if (ch == '(') {
                openToKeep--;
                /*
                 Stopping Condition: When openToKeep is zero, we’ve kept all the required (.
                 Changing the condition to <= 0 would mean skipping an additional valid ( when openToKeep reaches zero, making the balance incorrect.
                 */
                if (openToKeep < 0) continue;
            }
            result.append(ch);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(MinRemoveToMakeValid.minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(MinRemoveToMakeValid.minRemoveToMakeValid("a)b(c)d"));
        System.out.println(MinRemoveToMakeValid.minRemoveToMakeValid("))(("));
        System.out.println(MinRemoveToMakeValid.minRemoveToMakeValid("(ab)(cd)"));

        System.out.println("Optimal\n");
        System.out.println(MinRemoveToMakeValid.minRemoveToMakeValidOptimal("lee(t(c)o)de)"));
        System.out.println(MinRemoveToMakeValid.minRemoveToMakeValidOptimal("a)b(c)d"));
        System.out.println(MinRemoveToMakeValid.minRemoveToMakeValidOptimal("))(("));
        System.out.println(MinRemoveToMakeValid.minRemoveToMakeValidOptimal("(ab)(cd)"));
    }
}
