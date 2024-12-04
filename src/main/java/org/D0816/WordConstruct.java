package org.D0816;

import java.util.Arrays;
import java.util.List;

public class WordConstruct {

    public static boolean canConstruct(String target, List<String> wordBank){
        boolean[] dp = new boolean[target.length() + 1];
        dp[0] = true;
        for(int i=0; i< target.length(); i++){
            if(dp[i]){
                for(String word: wordBank){
                    // if the word matches the characters starting at position i
                    // target.substring(i, i+word.length()).equals(word)
                    if(target.startsWith(word, i)){
                        dp[i+word.length()] = true;
                        System.out.println("word : "+word+" i : "+i+" dp : "+ Arrays.toString(dp));
                    }
                }
            }
        }

        return dp[target.length()];
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("abcdef", List.of("ab","bc","cd","ef")));
        System.out.println(canConstruct("abcdef", List.of("ab","bcd","ef")));
        System.out.println(canConstruct("skateboard", List.of("bo","rd","ate","t","ska","sk","boar")));
        System.out.println(canConstruct("sidpan", List.of("n","pa","si","d")));

    }
}
