package org.D0901;

public class SumOfTwoIntegers {

    public int getSum(int a, int b) {
        //The loop runs until there is no carry left to add (i.e., b == 0), meaning all the bits have been correctly summed.
        while (b != 0) {
            // Bitwise XOR (a ^ b): This operation performs addition without considering any carry.
            // For each bit in a and b, XOR returns 1 if the bits are different and 0 if they’re the same.
            // This gives the result as if there were no carry.
            int answer = a ^ b;
            //This part computes the carry. The a & b operation gives 1 wherever both bits in a and b are 1.
            // Left-shifting the result by one (<< 1) shifts the carry to the next higher bit position,
            // preparing it to be added in the next iteration.
            int carry = (a & b) << 1;
            a = answer;
            b = carry;
        }

        return a;
    }

    public static void main(String[] args) {
        System.out.println(new SumOfTwoIntegers().getSum(67,1));
        System.out.println(new SumOfTwoIntegers().getSum(10,1));
        System.out.println(new SumOfTwoIntegers().getSum(1,20));
        System.out.println(new SumOfTwoIntegers().getSum(1,2));
    }
}
