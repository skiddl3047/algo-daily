package org.D0904;

/*
Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.

Example 1:
Input: num1 = "11", num2 = "123"
Output: "134"

Example 2:
Input: num1 = "456", num2 = "77"
Output: "533"
Example 3:

Input: num1 = "0", num2 = "0"
Output: "0"
 */
public class AddStrings {

    /*
    Time Complexity : O(max(N1, N2)) Where N1 and N2 are length of nums1 and nums2. we do max(N1,N2) iterations at most
    Space Complexity : O(max(N1, N2)) because the length of the new string is at most max(N1,N2)+1

     */
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();

        int carry = 0;
        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;
        while (n1 >= 0 || n2 >= 0) {
            int x1 = n1 >= 0 ? num1.charAt(n1) - '0' : 0;
            int x2 = n2 >= 0 ? num2.charAt(n2) - '0' : 0;
            int value = (x1 + x2 + carry) % 10;
            carry = (x1 + x2 + carry) / 10;
            res.append(value);
            n1--;
            n2--;
        }

        if (carry != 0)
            res.append(carry);

        return res.reverse().toString();
    }
}
