package org.E1213;

public class MinimumNumberOfChangesToMakeBinaryStringBeautiful {

    public int minChanges(String s) {
        int minChangesRequired = 0;
        // Check pairs of characters (i, i+1) with step size 2
        for (int i = 0; i < s.length(); i += 2) {
            // If characters in current pair don't match, we need one change to make them equal
            if (s.charAt(i) != s.charAt(i + 1)) {
                minChangesRequired++;
            }
        }
        return minChangesRequired;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumNumberOfChangesToMakeBinaryStringBeautiful().minChanges("1001"));
    }
}
