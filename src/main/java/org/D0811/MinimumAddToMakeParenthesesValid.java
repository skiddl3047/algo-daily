package org.D0811;
/*
A parentheses string is valid if and only if:

It is the empty string,
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.

For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
Return the minimum number of moves required to make s valid.

Example 1:
Input: s = "())"
Output: 1

Example 2:
Input: s = "((("
Output: 3


Constraints:

1 <= s.length <= 1000
s[i] is either '(' or ')'.

 */
public class MinimumAddToMakeParenthesesValid {

    //Step - 1 Declare 2 variables balanced & unbalanced
    //Step - 2 Iterate through the String char array and
    //Step - 2.1 Increment balanced if you find '('
    //Step - 2.2 Increment unbalanced if balanced == 0 & ')'
    //Step - 2.3 Decrement balanced (else statement which is nothing but ')')
    // Return balanced + unbalanced
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
