package org.D0826;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeTwoIntervalListsWithTwoArrays {

    // written in meta interview on Dec5th
    public List<int[]> unionIntervals(List<int[]> ip1, List<int[]> ip2){
        List<int[]> res = new ArrayList<>();

        res.addAll(ip1);
        res.addAll(ip2);
        res.sort(Comparator.comparingInt( a -> a[0]));

        int[] currentInterval = res.getFirst();

        List<int[]> result = new ArrayList<>();
        result.add(currentInterval);

        for(int[] interval : res){
            int endTime = currentInterval[1];

            if(interval[0] <= endTime){
                currentInterval[1] = Math.max(currentInterval[1], interval[1]);
            }else{
                currentInterval = interval;
                res.add(interval);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        List<int[]> list1 = new ArrayList<>();
        list1.add(new int[]{1, 5});
        list1.add(new int[]{10, 14});
        list1.add(new int[]{16, 18});

        List<int[]> list2 = new ArrayList<>();
        list2.add(new int[]{2, 6});
        list2.add(new int[]{8, 10});
        list2.add(new int[]{11, 20});
        //new MergeTwoIntervalListsWithTwoArrays().unionIntervals(list1, list2);
        System.out.println(Arrays.deepToString(new List[]{new MergeTwoIntervalListsWithTwoArrays().unionIntervalsOptimal(list1, list2)}));

        list1 = new ArrayList<>();
        list1.add(new int[]{1, 3});
        list1.add(new int[]{5, 7});
        list1.add(new int[]{10, 18});

        list2 = new ArrayList<>();
        list2.add(new int[]{2, 5});
        list2.add(new int[]{7, 10});
        List<int[]> result = new MergeTwoIntervalListsWithTwoArrays().unionIntervalsOptimal(list1, list2);
        for (int[] num : result)
            System.out.println(num[0]+" "+num[1]);


    }


    public List<int[]> unionIntervalsOptimal(List<int[]> A, List<int[]> B){
        int i = 0, j = 0;
        List<int[]> res = new ArrayList<>();
        while(i < A.size() || j < B.size()) {
            int[] curr;
            if (i == A.size()) {
                curr = B.get(j);
                j++;
            } else if (j == B.size()) {
                curr = A.get(i);
                i++;
            } else if (A.get(i)[0] < B.get(j)[0]) {
                curr = A.get(i);
                i++;
            } else {
                curr = B.get(j);
                j++;
            }
            // Merge with the last interval if overlapping
            if (!res.isEmpty() && res.getLast()[1] >= curr[0]) {
                res.getLast()[1] = Math.max(res.getLast()[1], curr[1]);
            } else {
                res.add(curr);
            }
        }
        return res;
    }

}
