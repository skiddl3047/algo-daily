package basics;

public class SortedArray {

    public static void main(String[] args) {
        int[] inputArray = {10, 20, 30, 40, 50};
        int[] secondInputArray = {10, 0, 30, 40, 50};
        System.out.println(new SortedArray().isSortedArray(inputArray));
        System.out.println(new SortedArray().isSortedArray(secondInputArray));
    }

    private boolean isSortedArray(int[] inputArray ) {
        for (int i =1 ; i< inputArray.length; i++) {
           if(inputArray[i] < inputArray[i-1]) {
               return false;
           }
        }
        return true;
    }
}
