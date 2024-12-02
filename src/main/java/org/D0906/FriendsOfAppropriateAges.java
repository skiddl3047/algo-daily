package org.D0906;

import java.util.Arrays;


/*
Intuition
We need to find each pair of ages[x] and ages[y] that satisfies the 3 rules in the description. Every such pair results in a friend request.
If age[y] > age[x] is true, then age[y] > 100 && age[x] < 100 is also true. Therefore, we don't need to worry about the last rule.
 */

// Best solution -- https://leetcode.com/problems/friends-of-appropriate-ages/solutions/4877333/3-clean-java-solutions-with-comments-from-tle-to-2ms
public class FriendsOfAppropriateAges {

    //Time complexity: O(n ^ 2)
    //Space complexity: O(1)
    public int numFriendRequestsBruteForce(int[] ages) {
        int requestCount = 0;
        // iterate through every pair of users
        for (int i = 0; i < ages.length; i++) {
            // exclusive minimum age based on the provided formula
            int minAge = ages[i] / 2 + 7;
            for (int j = 0; j < ages.length; j++) {
                // if user j is older than minAge and not older than user i
                // then we increment the number of friend requests
                if (i != j && minAge < ages[j] && ages[j] <= ages[i]) {
                    requestCount++;
                }
            }
        }
        return requestCount;
    }

    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int n = ages.length, ans = 0;
        int [] cnt = new int[121];
        for (int i = 0; i<n; i++) {
            int low = 0, high = i-1, res = -1;
            // lower bound
            while (low<=high) {
                int mid = low+ (high-low)/2;
                if (0.5*ages[i]+7.0 >= ages[mid]) {
                    low = mid+1;
                }
                else {
                    high = mid-1;
                    res = mid;
                }
            }
            if (res!=-1) {
                ans+=(i-res);
                ans+=cnt[ages[i]];
            }
            cnt[ages[i]]++;
        }
        return ans;
    }

    //Time complexity: O(n)
    //Space complexity: O(1)
    public int numFriendRequestsPrefixSum(int[] ages) {
        int MAX_AGE = 120;
        // count the frequency of each age value
        int[] ageFreq = new int[MAX_AGE + 1];
        for (int age : ages) {
            ageFreq[age]++;
        }
        // calculate prefix sums
        int[] prefixSums = new int[MAX_AGE + 1];
        prefixSums[0] = ageFreq[0];
        for (int i = 1; i <= MAX_AGE; i++) {
            prefixSums[i] = prefixSums[i - 1] + ageFreq[i];
        }
        // count friend requests
        int requestCount = 0;
        for (int age : ages) {
            // exclusive minimum age based on the provided formula
            int minAge = age / 2 + 7;
            if (minAge < age) {
                // add the number of people in the age range (minAge, age],
                // and subtract 1 because the user cannot send a friend request to itself
                requestCount += prefixSums[age] - prefixSums[minAge] - 1;
            }
        }
         return requestCount;
    }

    public static void main(String[] args) {
        System.out.println(new FriendsOfAppropriateAges().numFriendRequestsPrefixSum(new int[]{16,16}));
        System.out.println(new FriendsOfAppropriateAges().numFriendRequestsPrefixSum(new int[]{16,17,18}));
        System.out.println(new FriendsOfAppropriateAges().numFriendRequestsPrefixSum(new int[]{20,30,100,110,120}));
    }

}
