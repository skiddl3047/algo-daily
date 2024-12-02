package org.D0905;

/*
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".



Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strings) {

        StringBuilder result = new StringBuilder();
        for(int i=0; i< strings[0].length(); i++){
            boolean exitFromLoop = true;
            char ch = strings[0].charAt(i);
            for(int j = 1; j < strings.length; j++ ){
                if (i > strings[j].length() - 1 || strings[j].charAt(i) != ch) {
                    exitFromLoop = false;
                    break;
                }
            }
            if(!exitFromLoop){
                break;
            }else{
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
}
