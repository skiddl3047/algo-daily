package org.E1220;

public class NumberOfOneBits {

    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n = n & (n - 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfOneBits().hammingWeight(4));
        System.out.println(new NumberOfOneBits().hammingWeight(127));
    }
}
