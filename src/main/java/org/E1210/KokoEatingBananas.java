package org.E1210;
/*
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.



Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], h = 6
Output: 23


Constraints:

1 <= piles.length <= 104
piles.length <= h <= 109
1 <= piles[i] <= 109
 */
public class KokoEatingBananas {

    /*
    Complexity Analysis:

        Let n be the length of the input array piles and m be the maximum number of bananas in a single pile from piles.

        Time complexity: O(n⋅log m)
        The initial search space is from 1 to m, it takes log m comparisons to reduce the search space to 1.
        For each eating speed middle, we traverse the array and calculate the overall time Koko spends, which takes O(n) for each traversal.
        To sum up, the time complexity is O(n⋅log m).

        Space complexity: O(1)
        For each eating speed middle, we iterate over the array and calculate the total hours Koko spends, which costs constant space.
        Therefore, the overall space complexity is O(1).
     */
    public int minEatingSpeed(int[] piles, int h) {
        // Initalize the left and right boundaries
        int left = 1, right = 1;
        for (int pile : piles)
            right = Math.max(right, pile);
        while (left < right) {
            // Get the middle index between left and right boundary indexes. hourSpent stands for the total hour Koko spends.
            int middle = left + (right-left) / 2;
            int hourSpent = 0;
            // Iterate over the piles and calculate hourSpent. We increase the hourSpent by ceil(pile / middle)
            for (int pile : piles) {
                hourSpent += (int) Math.ceil((double) pile / middle);
            }
            // Check if middle is a workable speed, and cut the search space by half.
            if (hourSpent <= h)
                right = middle;
            else
                left = middle + 1;
        }
        // Once the left and right boundaries coincide, we find the target value, that is, the minimum workable eating speed.
        return right;
    }
    /*
        For those who don't understand this problem, please upvote if it helps, thanks.

        piles = [3,6,7,11], h = 8
        k = 1 to 11 bananas per hours

        k = 1,
        3/1 + 6/1 + 7/1 + 11/1 = 3 + 6 + 7 + 11 = 27hrs > 8 hrs = Not enough time

        k = 2,
        3/2 + 6/2 + 7/2 + 11/2 = 2 + 3 + 4 + 6 = 15 hrs > 8 hrs = Not enough time

        k = 3,
        3/3 + 6/3 + 7/3 + 11/3 = 1+ 2+ 3 + 4 = 10hrs > 8 hrs = Not enough time

        k = 4,
        3/4 + 6/4 + 7/4 + 11/4 = 1 + 2 + 2 + 3 = 8hrs = GOOD

        k = 5,
        3/5 + 6/5 + 7/5 + 11/5 = 1 + 2 + 2 + 3 = 8hrs = GOOD, but not the minimum k

        k = 6,
        3/6 + 6/6 + 7/6 + 11/6 = 1 + 1 + 2 + 2 = 4hrs = GOOD, but not the minimum k
        .
        .
        .
        So the answer is k=4 .
     */

    public static void main(String[] args) {
        System.out.println(new KokoEatingBananas().minEatingSpeed(new int[]{3,6,7,11}, 8));
        System.out.println(new KokoEatingBananas().minEatingSpeed(new int[]{30,11,23,4,20}, 5));
        System.out.println(new KokoEatingBananas().minEatingSpeed(new int[]{30,11,23,4,20}, 6));
    }
}
