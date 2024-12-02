package org.D0906;

import java.util.Arrays;
import java.util.List;

public class GoatLatin {

    public String toGoatLatin(String sentence) {
        List<Character> vowels = Arrays.asList('a','e','i','o','u');

        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        for(String word:words){
            if(vowels.contains(word.charAt(0))){
                sb.append(word).append("ma ");
            }else{
                sb.append(word.substring(1));
                sb.append(word.charAt(0)).append("ma");
            }

        }
        return sb.toString();
    }
}
