package org.D0808;

import java.util.Arrays;
import java.util.Random;

public class RandomPickWithWeight {

    private final Random random;
    private final int[] wSums;

    public RandomPickWithWeight(int[] w) {
        this.random = new Random();
        for(int i=1; i<w.length; ++i)
            w[i] += w[i-1];
        this.wSums = w;
    }

    public int pickIndex() {
        int len = wSums.length;
        int target = random.nextInt(wSums[len-1]) + 1;
        int left = 0, right = len - 1;
        // search position
        while(left < right){
            int mid = left + (right-left)/2;
            if (wSums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;  // Narrow the range to [low, mid] instead of excluding mid
            }
        }
        return left;
    }

    public static void main(String[] args) {
        //RandomPickWithWeight randomPickWithWeight = new RandomPickWithWeight(new int[]{1,2,3,4});
        RandomPickWithWeight randomPickWithWeight = new RandomPickWithWeight(new int[]{1,2,1});
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
    }
}
