package org.D0823;

import java.util.ArrayList;
import java.util.List;

/*
A positive integer is considered uniform if all of its digits are equal. For example,
222 - 222 is uniform, while
223 - 223 is not.
Given two positive integers

A and B determine the number of uniform integers between


A and B inclusive.
Please take care to write a solution which runs within the time limit.

A = 75
B = 300
Expected Return Value = 5

 In the first case, the uniform integers between  75 and  300 are 77,  88, 99, 111, and 222.
 */
public class UniformInteger {

    List<Long> result = new ArrayList<>();
    public int getUniformIntegerCountInInterval(long A, long B) {
        // Write your code here
        int count = 0;

        // Iterate over each possible single digit (1 to 9)
        for (int digit = 1; digit <= 9; digit++) {
            long uniformNumber = digit;

            // Generate numbers by repeating the digit
            while (uniformNumber <= B) {
                // Check if the generated uniform number is within the range [A, B]
                if (uniformNumber >= A) {
                    count++;
                    result.add(uniformNumber);
                }
                // Extend the number by adding one more digit repetition
                uniformNumber = uniformNumber * 10 + digit; // key part of generating uniform numbers
                // 1, (1*10 + 1= 11), (11*10+1 = 111) .... (4, (4*10 + 4 = 44))
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new UniformInteger().getUniformIntegerCountInInterval(75, 300));
        System.out.println(new UniformInteger().getUniformIntegerCountInInterval(1, 9));
    }
}
