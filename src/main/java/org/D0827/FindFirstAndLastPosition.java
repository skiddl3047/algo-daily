package org.D0827;

public class FindFirstAndLastPosition {

/*
    Time Complexity: O(logN) considering there are N elements in the array.
    This is because binary search takes logarithmic time to scan an array of N elements.
    Why? Because at each step we discard half of the array we are scanning and hence, we're done after a logarithmic number of steps.
    We simply perform binary search twice in this case.
    Space Complexity: O(1) since we only use space for a few variables and our result array, all of which require constant space.
 */
        public int[] searchRange(int[] nums, int target) {
            int firstOccurrence = this.findBound(nums, target, true);
            if (firstOccurrence == -1)
                return new int[] { -1, -1 };
            int lastOccurrence = this.findBound(nums, target, false);
            return new int[] { firstOccurrence, lastOccurrence };
        }

        private int findBound(int[] nums, int target, boolean isFirst) {
            int N = nums.length;
            int begin = 0, end = N - 1;

            while (begin <= end) {
                int mid = (begin + end) / 2;

                if (nums[mid] == target) {
                    if (isFirst) {
                        // This means we found our lower bound.
                        if (mid == begin || nums[mid - 1] != target) {
                            return mid;
                        }
                        // Search on the left side for the bound.
                        end = mid - 1;
                    } else {
                        // This means we found our upper bound.
                        if (mid == end || nums[mid + 1] != target) {
                            return mid;
                        }
                        // Search on the right side for the bound.
                        begin = mid + 1;
                    }
                } else if (nums[mid] > target) {
                    end = mid - 1;
                } else {
                    begin = mid + 1;
                }
            }
            return -1;
        }
}
