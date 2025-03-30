package lakshmi.blind75;

//The algorithm follows these complexities:
//
//  1. **Time Complexity:**
//   - The formula for the sum of the first \( n \) natural numbers, \( (n \times (n+1)) / 2 \), runs in **O(1)** time.
//   - Calculating the sum of the array using a loop or Java Streams takes **O(n)** time.
//   - Overall, the algorithm runs in **O(n)** time.
//
//  2. **Space Complexity:**
//  - The algorithm uses only a few integer variables (`n`, `expectedSum`, `actualSum`).
//  - No extra data structures are used apart from the input array.
//  - The space complexity is **O(1)** (constant space).

//XOR Operation
//
//Time Complexity: O(n) (single loop iterates through the array)
//Space Complexity: O(1) (only a few integer variables used)

public class MissingNumber {
    public static void main(String[] args) {
        int[] input = {3, 1, 0};
        int missingNumber = findMissingNumberWithMath(input);
        int missingNumber1 = findMissingNumberWithXor(input);
        System.out.println(missingNumber);
        System.out.println(missingNumber1);
    }

    private static int findMissingNumberWithXor(int[] input) {
        int xOrResult = 0;
        int arrayLength = input.length;
        for (int i = 0; i <= arrayLength; i++) {
            // xOrResult = xOrResult ^ i;
            xOrResult ^= i;
        }
        for (int n : input) {
            // xOrResult = xOrResult ^ n;
            xOrResult ^= n;
        }
        return xOrResult;
    }

    private static int findMissingNumberWithMath(int[] input) {
        int arrayLength = input.length;
        int sumOfInput = 0;
        int sumOfNumbers = (arrayLength * (arrayLength+1))/2;
        for(int n : input) {
            sumOfInput = sumOfInput+n;
        }
        // Above for loop can be simplified
        // sumOfInput = Arrays.stream(input).sum();
        return sumOfNumbers - sumOfInput;
    }
}
