package basics;

/*
You are given a sorted integer array 'arr' of size 'n'.
You need to remove the duplicates from the array such that each element appears only once.
Return the length of this new array.
Note:
Do not allocate extra space for another array. You need to do this by modifying the given input array in place with O(1) extra memory.
 */
public class RemoveDuplicates {

    public static void main(String[] agrs) {
        int[] inputAray = {0,1,1,2,2,3,3,4,5};
        System.out.println(new RemoveDuplicates().removeDuplicates(inputAray));
    }

    //1,1,1,2,2,3,3,4,5
    // Two pointer approach
    private int removeDuplicates(int[] inputAray) {
        int i = 0;
        for (int j =1; j< inputAray.length; j++) {
            if(inputAray[i] != inputAray[j]) {
                i++;
                inputAray[i] = inputAray[j];
            }
        }
        return i+1;
    }
}
