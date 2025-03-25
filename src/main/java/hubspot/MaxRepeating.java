package hubspot;

public class MaxRepeating {

    public int maxRepeating(String sequence, String word) {
        int max = 0;
        int sequenceLen = sequence.length();
        int wordLen = word.length();
        if (wordLen == 0 || sequenceLen < wordLen) return 0;

        for (int i = 0; i <= sequenceLen - wordLen; i++) {
            int current = 0;
            int j = i;
            while (j <= sequenceLen - wordLen) {
                boolean match = true;
                for (int k = 0; k < wordLen; k++) {
                    if (sequence.charAt(j + k) != word.charAt(k)) {
                        match = false;
                        break;
                    }
                }
                if (!match) break;
                current++;
                j += wordLen;
                max = Math.max(max, current);
            }
        }
        return max;
    }

    public int maxRepeatingContainsMethod(String sequence, String word) {
        int maxRepeating = 0;
        StringBuilder sb = new StringBuilder(word);
        while (sequence.contains(sb.toString())) {
            maxRepeating++;
            sb.append(word);
        }
        return maxRepeating;
    }

    public static void main(String[] args) {
        MaxRepeating solution = new MaxRepeating();
        System.out.println(solution.maxRepeating("ababc", "ab")); // Output: 2
        System.out.println(solution.maxRepeating("ababab", "ab")); // Output: 3
        System.out.println(solution.maxRepeating("aaabaaa", "aa")); // Output: 2
    }
}
