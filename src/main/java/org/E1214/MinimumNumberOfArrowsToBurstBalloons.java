package org.E1214;

import java.util.Arrays;

public class MinimumNumberOfArrowsToBurstBalloons {

    /*
       1   2   3   4   5   6   7   8   9   10  11  12
<--+---+---+---+---+---+---+---+---+---+---+---+-->
 0 *-----------------------------------*
         1 *-----------------------*
             2 *---------------------------*
                     3 *---*
                     4 *-----------*
                              5 *--------------*
                                 6 *-----------*
     */
    //https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/comments/2306972
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        // sort by x_end
        Arrays.sort(points, (o1, o2) -> {
            // We can't simply use the o1[1] - o2[1] trick, as this will cause an
            // integer overflow for very large or small values.
            /*
                if (o1[1] == o2[1]) return 0;
                if (o1[1] < o2[1]) return -1;
                return 1;
             */
            return Integer.compare(o1[1], o2[1]);
        });
        int arrows = 1;
        int xStart, xEnd, firstEnd = points[0][1];
        for (int[] p: points) {
            xStart = p[0];
            xEnd = p[1];
            // If the current balloon starts after the end of another one, one needs one more arrow
            if (firstEnd < xStart) {
                arrows++;
                firstEnd = xEnd;
            }
        }

        return arrows;
    }

    public boolean haveConflict(String[] event1, String[] event2) {
        return event1[0].compareTo(event2[1]) <= 0 && event2[0].compareTo(event1[1]) <= 0;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumNumberOfArrowsToBurstBalloons().findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}}));
    }
}
