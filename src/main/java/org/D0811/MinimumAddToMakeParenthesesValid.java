package org.D0811;

public class MinimumAddToMakeParenthesesValid {

    public static int minAddToMakeValid(String s) {

        int balance = 0;
        int unBalanced = 0;
        for (char c: s.toCharArray()){
            if (c == '(') balance++;
            else if (balance == 0 && c == ')') unBalanced++;
            else balance--;
        }
        return balance + unBalanced;
    }

    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("(())"));
        System.out.println(minAddToMakeValid("))(("));
        System.out.println(minAddToMakeValid("(()"));
    }
}
