package org.D0912;

import java.util.ArrayList;
import java.util.List;

public class SubSetsII {

    /*Time complexity: O(n⋅2^n)

As we can see in the diagram above, this approach does not generate any duplicate subsets. Thus, in the worst case (array consists of n distinct elements), the total number of recursive function calls will be 2^n. Also, at each function call, a deep copy of the subset currentSubset generated so far is created and added to the subsets list. This will incur an additional O(n) time (as the maximum number of elements in the currentSubset will be n). So overall, the time complexity of this approach will be O(n⋅2^n).

Space complexity: O(n)

The space complexity of the sorting algorithm depends on the implementation of each programming language. For instance, in Java, the Arrays.sort() for primitives is implemented as a variant of quicksort algorithm whose space complexity is O(logn). In C++ sort() function provided by STL is a hybrid of Quick Sort, Heap Sort and Insertion Sort with the worst case space complexity of O(logn). Thus the use of inbuilt sort() function adds O(logn) to space complexity.

The recursion call stack occupies at most O(n) space. The output list of subsets is not considered while analyzing space complexity. So, the space complexity of this approach is O(n).*/
    int k;
    List<List<Integer>> output = new ArrayList<>();
    List<Integer> temp = new ArrayList<Integer>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        for(k=0; k <= n; k++){
            backtrack(0, nums);
        }
        return output;
    }


    public void backtrack(int start, int[] nums){
        if(temp.size() == k){
            output.add(new ArrayList<Integer>(temp));
            return;
        }

        for(int i = start; i < nums.length; i++){
            //System.out.println("nums[i-1] : "+nums[i-1]+" nums[i] : "+nums[i]);
            if(i > start && nums[i-1] == nums[i]) //i > start is the key here
                continue;
            temp.add(nums[i]);
            backtrack(i+1, nums);
            temp.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new SubSetsII().subsetsWithDup(new int[]{1,2,2,3}));
    }
}
//[[], [1], [2], [1, 2], [2, 2], [1, 2, 2]]
//[[], [1], [2], [1, 2], [2, 2], [1, 2, 2]]
