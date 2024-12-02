package org.D0830;

/*
You are given an integer num. You can swap two digits at most once to get the maximum valued number.

Return the maximum valued number you can get.


Example 1:
Input: num = 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.

Example 2:
Input: num = 9973
Output: 9973
Explanation: No swap.


Constraints:

0 <= num <= 108
 */
public class MaximumSwap {

    //This approach makes sure that, at each position from right to left,
    // we know if there’s a larger digit to the right that could replace a smaller digit on the left to make a maximum number.
    // Maximizing by Swapping Smallest Leftmost with Largest Rightmost
    public int maximumSwap(int num) {
        char[] numStr = Integer.toString(num).toCharArray();
        int n = numStr.length;
        int maxDigitIndex = -1, swapIdx1 = -1, swapIdx2 = -1;

        // Traverse the string from right to left, tracking the max digit and  potential swap
        //this lets us efficiently track the largest possible digits to the right of each position,
        // ensuring we make the swap that leads to the maximum possible number.
        //We want to find the smallest possible leftmost digit that can be swapped with a larger digit to its right. By doing so, we maximize the swapped number.

        // Why Not Traverse Left to Right?
        // If we traversed left to right:

        // We would encounter digits in the natural order, but we wouldn’t yet know if a larger digit is available to the right.
        // Therefore, if we find a digit that we might want to swap,
        // we’d have to continue looking to the end of the array to find the largest one, making it less efficient and harder to guarantee the best possible swap.
        for (int i = n - 1; i >= 0; --i) {
            if (maxDigitIndex == -1 || numStr[i] > numStr[maxDigitIndex]) {
                maxDigitIndex = i; // Update the index of the max digit
            } else if (numStr[i] < numStr[maxDigitIndex]) {
                swapIdx1 = i; // Mark the smaller digit for swapping
                swapIdx2 = maxDigitIndex; // Mark the larger digit for swapping
            }
        }

        // Perform the swap if a valid swap is found
        if (swapIdx1 != -1) { // if (swapIdx1 != -1 && swapIdx2 != -1) {
            char temp = numStr[swapIdx1];
            numStr[swapIdx1] = numStr[swapIdx2];
            numStr[swapIdx2] = temp;
        }
        System.out.println("swapIdx1 -- "+swapIdx1+" swapIdx2 -- "+swapIdx2);
        return Integer.parseInt(new String(numStr)); // Return the new number or the original if no
        // swap occurred
    }

    public static void main(String[] args) {
        System.out.println(new MaximumSwap().maximumSwap(2736));
        //System.out.println(new MaximumSwap().maximumSwapTry(2736));
        System.out.println(new MaximumSwap().maximumSwap(2637));
        //System.out.println(new MaximumSwap().maximumSwapTry(2637));

        System.out.println(new MaximumSwap().maximumSwap(9973));
        //System.out.println(new MaximumSwap().maximumSwapTry(9973));
    }

    public int maximumSwapTry(int num) {
        char[] numStr = Integer.toString(num).toCharArray();
        int n = numStr.length;
        int maxDigitIndex = -1, swapIdx1 = -1, swapIdx2 = -1;

        //Invalid Approach
        for (int i = 0; i < n; i++) {
            if (maxDigitIndex == -1 || numStr[i] > numStr[maxDigitIndex]) {
                maxDigitIndex = i; // Update the index of the max digit
            } else if (numStr[i] < numStr[maxDigitIndex]) {
                swapIdx1 = i; // Mark the smaller digit for swapping
                swapIdx2 = maxDigitIndex; // Mark the larger digit for swapping
            }
        }

        // Perform the swap if a valid swap is found
        if (swapIdx1 != -1) { // if (swapIdx1 != -1 && swapIdx2 != -1) {
            char temp = numStr[swapIdx1];
            numStr[swapIdx1] = numStr[swapIdx2];
            numStr[swapIdx2] = temp;
        }
        //System.out.println("swapIdx1 -- "+swapIdx1+" swapIdx2 -- "+swapIdx2);
        return Integer.parseInt(new String(numStr)); // Return the new number or the original if no
        // swap occurred
    }
}
