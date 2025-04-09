package basics;

public class LargestNumber {

    public static void main(String[] args) {
        int[] inputArray = {1,99,98,99,-2};
        System.out.println(new LargestNumber().secondHighest(inputArray));
        System.out.println(new LargestNumber().largestNumber(inputArray));
        System.out.println(new LargestNumber().secondSmallest(inputArray));
    }

    public Integer secondHighest(int[] array) {
        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;
        for (int n : array) {
            if (n > highest) {
                secondHighest = highest;
                highest = n;
            } else if (n > secondHighest && n != highest) {
                secondHighest = n;
            }
        }
        return secondHighest;
    }

    public int largestNumber(int[] nums) {
        int largest = Integer.MIN_VALUE;
        for (int n: nums) {
            if ( n> largest) {
                largest = n;
            }
        }
        return largest;
    }

    public int secondSmallest(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n < smallest) {
                secondSmallest = smallest;
                smallest = n;
            } else if (n < secondSmallest &&  n != smallest) {
                secondSmallest = n;
            }
        }
        return secondSmallest;
    }
}
