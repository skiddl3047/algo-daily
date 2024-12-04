package org.D0822;

public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        // Create a StringBuilder to use as a stack to keep track of digits.
        StringBuilder stack = new StringBuilder();
        // Iterate through each character in the input string.
        for (char digit : num.toCharArray()) {
// While the current digit is smaller than the last digit in the stack and we still have digits to remove (k > 0), remove the last digit.
            while (k > 0 && !stack.isEmpty() && stack.charAt(stack.length() - 1) > digit) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            // Append the current digit to the stack (StringBuilder).
            stack.append(digit);
        }
        // If after the iteration we still need to remove more digits, remove from the end.
        while (k > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }
        // Remove leading zeros by finding the index of the first non-zero digit.
        int nonZeroIndex = 0;
        while (nonZeroIndex < stack.length() && stack.charAt(nonZeroIndex) == '0') {
            nonZeroIndex++;
        }
        // Create a new string starting from the first non-zero digit.
        String result = stack.substring(nonZeroIndex);
        // If the resulting string is empty, return "0" instead; otherwise, return the string.
        return result.isEmpty() ? "0" : result;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveKDigits().removeKdigits("1432219",3));
        System.out.println(new RemoveKDigits().removeKdigits("10",2));
    }
}
