package org.test;

import java.util.Arrays;
import java.util.Comparator;

public class MultiDimensionalArrayTest {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int[] interval : intervals){
            System.out.println(interval[0]);
            System.out.println(interval[1]);
        }
    }
}
