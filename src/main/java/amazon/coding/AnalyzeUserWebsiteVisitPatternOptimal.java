package amazon.coding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyzeUserWebsiteVisitPatternOptimal {

    /*
     Approach:
     1. We are tasked with finding the most visited 3-website pattern among users.
     2. First, we assign unique indices to users, websites, and timestamps for easier processing.
     3. Then, we encode each visit as a combination of user, timestamp, and website index.
     4. The visit data is sorted, and we use an array to track the patterns formed by three distinct website visits by a user.
     5. Finally, we determine the most frequent 3-website pattern and return it, breaking ties lexicographically.

     Explanation:
     - The `userIndexMap`, `websiteIndexMap`, and `timestampIndexMap` help track unique identifiers for users, websites, and timestamps.
     - The `encodedVisits` array stores the combination of these identifiers to efficiently process visit sequences.
     - The `patternCount` array keeps track of unique 3-website patterns and their frequency, allowing us to identify the most frequent one.
    */

    public List<String> mostVisitedPattern(String[] usernames, int[] timestamps, String[] websites) {
        Map<String, Integer> userIndexMap = new HashMap<>(), websiteIndexMap = new HashMap<>();
        Map<Integer, Integer> timestampIndexMap = new HashMap<>();
        String[] uniqueWebsites = websites.clone();
        int[] sortedTimestamps = timestamps.clone();
        Arrays.sort(uniqueWebsites);  // Sort websites to assign indices
        Arrays.sort(sortedTimestamps);     // Sort timestamps to keep chronological order
        int totalVisits = usernames.length;

        // Step 1: Assign indices to users, websites, and timestamps
        for (int i = 0, j = 0; i < totalVisits; i++) {
            String username = usernames[i], website = uniqueWebsites[i];
            if (!userIndexMap.containsKey(username)) {
                userIndexMap.put(username, userIndexMap.size());
            }
            if (!websiteIndexMap.containsKey(website)) {
                websiteIndexMap.put(website, websiteIndexMap.size());
                uniqueWebsites[j++] = website; // Ensure websites are in the correct order
            }
            if (!timestampIndexMap.containsKey(sortedTimestamps[i])) {
                timestampIndexMap.put(sortedTimestamps[i], timestampIndexMap.size());
            }
        }

        int websiteCount = websiteIndexMap.size();
        int[] encodedVisits = new int[totalVisits];
        // Step 2: Combine user, timestamp, and website into a single integer visit identifier
        for (int i = 0; i < totalVisits; i++) {
            int userId = userIndexMap.get(usernames[i]);
            int timestampId = timestampIndexMap.get(timestamps[i]);
            int websiteId = websiteIndexMap.get(websites[i]);
            encodedVisits[i] = userId << 12 | timestampId << 6 | websiteId; // Combine into a unique identifier
        }

        Arrays.sort(encodedVisits); // Step 3: Sort the visits array by the encoded value
        long[] patternCount = new long[websiteCount * websiteCount * websiteCount];  // Step 4: Track 3-website visit patterns
        int bestPatternId = -1, highestCount = 0;

        // Step 5: Generate and count valid 3-website patterns
        for (int i = 0; i < totalVisits; i++) {
            int visit = encodedVisits[i], userId = visit >> 12, firstWebsiteId = (visit & 0x3f) * websiteCount * websiteCount;
            for (int k = i + 2; k < totalVisits && (encodedVisits[k] >> 12) == userId; k++) {
                int secondWebsiteId = firstWebsiteId + (encodedVisits[k] & 0x3f);
                for (int j = i + 1; j < k; j++) {
                    int websiteCombinationId = secondWebsiteId + (encodedVisits[j] & 0x3f) * websiteCount;
                    long f = 1L << userId;
                    // Step 6: Check if the 3-website pattern is unique and track the most frequent one
                    if ((patternCount[websiteCombinationId] & f) == 0) {
                        int currentCount = Long.bitCount(patternCount[websiteCombinationId] |= f);
                        if (currentCount > highestCount || (currentCount == highestCount && websiteCombinationId < bestPatternId)) {
                            highestCount = currentCount;
                            bestPatternId = websiteCombinationId;
                        }
                    }
                }
            }
        }
        // Step 7: Return the most visited 3-website pattern
        return Arrays.asList(
                uniqueWebsites[bestPatternId / websiteCount / websiteCount],
                uniqueWebsites[(bestPatternId / websiteCount) % websiteCount],
                uniqueWebsites[bestPatternId % websiteCount]);
    }


    public static void main(String[] args) {
        String[] username = new String[] {"joe","joe","joe","james","james","james","james","mary","mary","mary"};
        int[] timestamp = new int[] {1,2,3,4,5,6,7,8,9,10};
        String[] website = new String[] {"home","about","career","home","cart","maps","home","home","about","career"};

        System.out.println(new AnalyzeUserWebsiteVisitPatternOptimal().mostVisitedPattern(username, timestamp, website));
    }
}
