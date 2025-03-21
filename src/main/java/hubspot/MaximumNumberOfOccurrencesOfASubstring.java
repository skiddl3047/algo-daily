package hubspot;

import java.util.HashMap;

public class MaximumNumberOfOccurrencesOfASubstring {

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        HashMap<String,Integer> map=new HashMap<>();
        int res=0;
        int[] ch=new int[128];
        int l=0, r=0, letter=0;
        while(r<s.length()){
            if(ch[s.charAt(r++)]++==0)
                letter++;
            while(letter>maxLetters || (r-l)>minSize){
                if(ch[s.charAt(l++)]--==1) letter--;
            }
            if((r-l)==minSize){
                String sb=s.substring(l, r);
                map.put(sb, map.getOrDefault(sb,0)+1);
                res=Math.max(res, map.get(sb));
            }
        }
        return res;
    }
}
