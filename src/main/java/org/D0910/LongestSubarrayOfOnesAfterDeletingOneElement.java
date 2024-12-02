package org.D0910;

/*
Given a binary array nums, you should delete one element from it.
Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.



Example 1:
Input: nums = [1,1,0,1]
Output: 3
Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.

Example 2:
Input: nums = [0,1,1,1,0,1,1,0,1]
Output: 5
Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].

Example 3:
Input: nums = [1,1,1]
Output: 2
Explanation: You must delete one element.


Constraints:
1 <= nums.length <= 105
nums[i] is either 0 or 1.
 */
public class LongestSubarrayOfOnesAfterDeletingOneElement {
/*
    Initialize three variables:

a. zeroCount to 0; this is the number of zeroes in the current window.

b. longestWindow to 0; this is the longest window having at most one 0 we have seen so far.

c. start to 0; this is the left end of the window from where it starts.

Iterate over the array from index i to array.length - 1 (inclusive), and keep counting the zeroes in the variable zeroCount.

After every element, check if the zeroCount exceeds 1; if yes, keep removing elements from the left until the value of zeroCount becomes <= 1.

Update the variable longestWindow with the current window length, i.e. i - start. Note that this subtraction will give the number of elements in the window minus 1, as we need to delete one element too.

Return longestWindow.

 */
    /*
Here, N is the size of the array nums.

Time complexity: O(N)

Each element in the array will be iterated over twice at most.
Each element will be iterated over for the first time in the for loop;
then, it might be possible to re-iterate while shrinking the window in the while loop.
No element can be iterated more than twice. Therefore, the total time complexity would be O(N).

Space complexity: O(1)

Apart from the three variables, we don't need any extra space; hence the total space complexity is constant.
*/
    public int longestSubarray(int[] nums) {
        // Number of zero's in the window.
        int zeroCount = 0;
        int longestWindow = 0;
        // Left end of the window.
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            zeroCount += (nums[i] == 0 ? 1 : 0);
            // Shrink the window until the count of zero's is less than or equal to 1.
            while (zeroCount > 1) {
                zeroCount -= (nums[start] == 0 ? 1 : 0);
                start++;
            }
            longestWindow = Math.max(longestWindow, i - start);
        }
        return longestWindow;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubarrayOfOnesAfterDeletingOneElement().longestSubarray(new int[]{1,1,0,1}));
        System.out.println(new LongestSubarrayOfOnesAfterDeletingOneElement().longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));
        System.out.println(new LongestSubarrayOfOnesAfterDeletingOneElement().longestSubarray(new int[]{1,1,1}));
    }
}
