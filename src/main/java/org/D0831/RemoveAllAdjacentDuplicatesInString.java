package org.D0831;

import java.util.Stack;

/*
You are given a string s consisting of lowercase English letters.
A duplicate removal consists of choosing two adjacent and equal letters and removing them.

We repeatedly make duplicate removals on s until we no longer can.
Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.



Example 1:

Input: s = "abbaca"
Output: "ca"
Explanation:
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".

Example 2:
Input: s = "azxxzy"
Output: "ay"

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
 */
public class RemoveAllAdjacentDuplicatesInString {

    /*
    Time complexity : O(N), where N is a string length.
    Space complexity : O(N−D) where D is a total length for all duplicates.
     */
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for(char character : S.toCharArray()) {
            if (sbLength != 0 && character == sb.charAt(sbLength - 1)){
                sb.deleteCharAt(sbLength - 1);
                sbLength--;
            }
            else {
                sb.append(character);
                sbLength++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new RemoveAllAdjacentDuplicatesInString().removeDuplicates("abbaca"));
        System.out.println(new RemoveAllAdjacentDuplicatesInString().removeDuplicates("azxxzy"));
    }
    /*
    Time complexity : O(N), where N is a string length.
    Space complexity : O(N−D) where D is a total length for all duplicates.
     */

    public String removeDuplicatesUsingStack(String s) {
        Stack<Character> stack=new Stack<>();
        stack.push(s.charAt(0));

        for(char ch:s.toCharArray()){
            if(!stack.isEmpty() && ch==stack.peek())
                stack.pop();
            else
                stack.push(ch);
        }
        StringBuilder sb=new StringBuilder();
        for(char a:stack){
            sb.append(a);
        }

        return sb.toString() ;
    }
}
