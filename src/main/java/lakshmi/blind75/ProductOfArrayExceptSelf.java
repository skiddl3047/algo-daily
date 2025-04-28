package lakshmi.blind75;

// **Time Complexity**:
// The algorithm consists of three separate loops:
//  1. **First Loop (leftProductArray)**: Iterates from the second last element to the first element → **O(n)**
//  2. **Second Loop (rightProductArray)**: Iterates from the second element to the last element → **O(n)**
//  3. **Third Loop (finalResultProductArray)**: Iterates over all elements once → **O(n)**
// Since these loops run sequentially (not nested), the total time complexity is:
// O(n) + O(n) + O(n) = O(n)

// **Space Complexity**:
// The algorithm uses three additional arrays:
// 1. `leftProductArray` → **O(n)**
// 2. `rightProductArray` → **O(n)**
// 3. `finalResultProductArray` → **O(n)**
// Thus, the total extra space used is:
// O(n) + O(n) + O(n) = O(n)
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] input = {1, 2, 4, 5};
        int [] ans = findProductOfArrayExceptSelf(input);
        for(int num : ans) {
            System.out.println(num);
        }
    }

    private static int[] findProductOfArrayExceptSelf(int[] input) {
        int[] leftProductArray = new int[input.length];
        leftProductArray[input.length-1] = 1;
        for (int i = input.length-2; i >= 0 ; i--) {
            leftProductArray[i] =  input[i+1] * leftProductArray[i+1];
        }

        int[] rightProductArray = new int[input.length];
        rightProductArray[0] = 1;
        for (int i = 1; i < input.length; i++) {
            rightProductArray[i] =  input[i-1] * rightProductArray[i-1];
        }

        int[] finalResultProductArray = new int[input.length];
        for (int i=0; i<input.length; i++) {
            finalResultProductArray[i] = leftProductArray[i] * rightProductArray[i];
        }
        return finalResultProductArray;
    }
}
