package hubspot;

public class MaxRepeating {

    public int maxRepeating(String sequence, String word) {
        int max = 0;
        int n = sequence.length();
        int m = word.length();
        if (m == 0 || n < m) return 0;

        for (int i = 0; i <= n - m; i++) {
            int current = 0;
            int j = i;
            while (j <= n - m) {
                boolean match = true;
                for (int k = 0; k < m; k++) {
                    if (sequence.charAt(j + k) != word.charAt(k)) {
                        match = false;
                        break;
                    }
                }
                if (!match) break;
                current++;
                j += m;
                max = Math.max(max, current);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxRepeating solution = new MaxRepeating();
        System.out.println(solution.maxRepeating("ababc", "ab")); // Output: 2
        System.out.println(solution.maxRepeating("ababab", "ab")); // Output: 3
        System.out.println(solution.maxRepeating("aaabaaa", "aa")); // Output: 2
    }
}
