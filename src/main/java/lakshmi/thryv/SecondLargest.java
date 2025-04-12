package lakshmi.thryv;

// Time Complexity = O(n)
// Space Complexity = O(1)
public class SecondLargest {
    public static void main(String[] args) {
        int[] array = {-100, -100, -99, 98};
        int secondLargest = findSecondLargest(array);
        System.out.println(secondLargest);
    }

    private static int findSecondLargest(int[] array) {
        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int n : array) {
            if (n >= firstLargest) {
                secondLargest = firstLargest;
                firstLargest = n;
            }
        }
        return secondLargest;
    }
}