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
        int i = 0, j = 0, k =0;
        while (i < array1.length && j < array2.length && k< limit) {
          if(array1[i] < array2[j]) {
              resultArray[k++] = array1[i++];
          } else {
              resultArray[k++] = array2[j++];
          }
        }
        while (i < array1.length && k< limit) {
          resultArray[k++] = array1[i++];
      }
      while ( j < array2.length && k< limit)  {
          resultArray[k++] = array2[j++];
      }
      return resultArray;
    }
}
