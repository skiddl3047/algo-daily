package lakshmi.thryv;

import java.util.HashMap;
import java.util.Map;

public class LonelyInteger {

    public static void main(String[] args) {
        int[] inputArray = {4,1,1,2,3,2,4};
        Integer lonelyInteger = findLonelyInteger(inputArray);
        System.out.println(lonelyInteger);
        int[] inputArray1 = {1};
        lonelyInteger = findLonelyInteger(inputArray1);
        System.out.println(lonelyInteger);
        int[] inputArray2 = {1,1,2};
        lonelyInteger = findLonelyInteger(inputArray2);
        System.out.println(lonelyInteger);
        int[] inputArray3 = {1,1,2,2};
        lonelyInteger = findLonelyInteger(inputArray3);
        System.out.println(lonelyInteger);
    }

    private static Integer findLonelyInteger(int[] inputArray) {
        Integer lonelyInteger = null;
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for(int num : inputArray) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) +1);
        }

        for(int n: frequencyMap.keySet()) {
            if (frequencyMap.get(n) == 1) {
                lonelyInteger = n;
            }
        }
        return lonelyInteger;
    }
}
