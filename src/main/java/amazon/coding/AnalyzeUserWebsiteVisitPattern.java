package amazon.coding;

import java.util.*;

public class AnalyzeUserWebsiteVisitPattern {

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, ArrayList<Visit>> map = new HashMap<>();
        for(int i=0; i<username.length; ++i)
            map.computeIfAbsent(username[i], l -> new ArrayList<>()).add(new Visit(website[i], timestamp[i]));

        sort(map);
        Map<String,HashSet<String>> sequences = generateSequences(map);
        List<String> threeSequenceAsArray = pickMaxSequenceAndReformat(sequences);
        return threeSequenceAsArray;
    }
    private List<String> pickMaxSequenceAndReformat(Map<String,HashSet<String>> sequences){
        String maxSequence = "";
        int max =0;
        for(String sequence : sequences.keySet()){
            int totalUsers = sequences.get(sequence).size();
            if(totalUsers > max ){
                max = totalUsers;
                maxSequence=sequence;
            }
            else if(totalUsers == max){
                if(sequence.compareTo(maxSequence) < 0){
                    maxSequence = sequence;
                }
            }
        }
        List<String> threeSequenceAsArray = new ArrayList<>();
        String [] splitSequence = maxSequence.split(" ");
        for(String s : splitSequence){
            threeSequenceAsArray.add(s);
        }
        return threeSequenceAsArray;
    }
    private Map<String, HashSet<String>> generateSequences(Map<String,ArrayList<Visit>> map){
        Map<String, HashSet<String>> sequences = new HashMap<>();
        for(String user : map.keySet()){
            ArrayList<Visit> current = map.get(user);
            for(int i=0; i< current.size()-2; i++){
                for(int j=i+1;j< current.size()-1; j++){
                    for(int k=j+1 ;k<current.size(); k++){
                        String threeSequence = current.get(i).site +" "+ current.get(j).site +" "+current.get(k).site;
                        sequences.computeIfAbsent(threeSequence, l -> new HashSet<>()).add(user);
                    }
                }
            }
        }
        return sequences;
    }
    public void sort(Map<String, ArrayList<Visit>> map){
        for(String user : map.keySet()){
            ArrayList<Visit> visits = map.get(user);
            Collections.sort(visits);
        }
    }

    public static void main(String[] args) {
        String[] username = new String[] {"joe","joe","joe","james","james","james","james","mary","mary","mary"};
        int[] timestamp = new int[] {1,2,3,4,5,6,7,8,9,10};
        String[] website = new String[] {"home","about","career","home","cart","maps","home","home","about","career"};

        System.out.println(new AnalyzeUserWebsiteVisitPattern().mostVisitedPattern(username, timestamp, website));
    }
}
class Visit implements Comparable <Visit>{
    String site;
    int time;
    public Visit(String site, int time){
        this.site=site;
        this.time=time;
    }
    public int compareTo(Visit v){
        if(v.time==this.time){
            return 0;
        }
        else{
            return this.time > v.time ? 1 : -1;
        }
    }
}
