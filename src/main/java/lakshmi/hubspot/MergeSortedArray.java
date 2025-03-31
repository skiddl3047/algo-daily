package lakshmi.hubspot;

//The time complexity of the given algorithm is O(limit) because the while loop
// runs at most limit times, selecting elements from array1 and array2 in sorted order.

//The space complexity is O(limit) because the algorithm creates a new array of size
// limit to store the merged elements.
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] array1 = {1,3,5,7,9,10,11};
        int[] array2 = {2,4,6,8};
        int limit = 4;
        int[] mergedArray = mergeSortedArray(array1, array2, limit);
        for (int n : mergedArray) {
            System.out.println(n);
        }
    }

    private static int[] mergeSortedArray(int[] array1, int[] array2, int limit) {
        int resultArrayLength = Math.min(limit, array1.length + array2.length);
        int[] resultArray =  new int[resultArrayLength];
        int array1Idx = 0, array2Idx = 0, currentLimit =0;
        while (array1Idx < array1.length && array2Idx < array2.length && currentLimit< limit) {
          if(array1[array1Idx] < array2[array2Idx]) {
              resultArray[currentLimit++] = array1[array1Idx++];
          } else {
              resultArray[currentLimit++] = array2[array2Idx++];
          }
        }
        while (array1Idx < array1.length && currentLimit< limit) {
          resultArray[currentLimit++] = array1[array1Idx++];
        }
        while ( array2Idx < array2.length && currentLimit< limit)  {
              resultArray[currentLimit++] = array2[array2Idx++];
        }
      return resultArray;
    }
}
