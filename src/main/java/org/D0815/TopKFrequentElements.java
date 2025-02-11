package org.D0815;

import java.util.*;

public class TopKFrequentElements {

    public int[] topKFrequentWithStream(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        int[] res = map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
        return res;
    }

    /*
    for the heap solution, it's better to use a min heap of size k rather than using a max heap and then removing max k times.
    Using the min heap, you would remove min and add the next frequency.
    by the end, you are left with k most frequent ones and removing the min gives you the answer.

    You can reduce this to n log k and not n log n

    and even for values like k = 1e9, log k is around 30 so the complexity is around O(30*n) which is basically O(n)
     */

    /*
    Insertion (add): O(logk), where 𝑘 is the size limit (2 in this case).
    Removal (poll): 𝑂(logk).
    Total for 𝑛 n elements: 𝑂 (n logk).
     */
    /*
    Overall Time Complexity Combining all steps: O(N) for adding elements to map
                                                 + O(N log K) for adding elements to queue
                                                 + O(K log K) for polling elements from queue
                          Final Time Complexity: O(N log K).
    Overall Space Complexity : O(N) (for the frequency map) + O(K) (for the heap) + O(K) (for the result array).
      Final Space Complexity : O(N + K).
     */
    public int[] topKFrequentWithPriorityQueueMinHeap(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int num: nums)
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0)+1);

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(k, Comparator.comparingInt(Map.Entry::getValue)); //Min-Heap
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()){
            minHeap.add(entry);
            if (minHeap.size() > k)
                minHeap.poll(); // Remove the least frequent element
        }
        int[] ans = new int[k];
        for(int i=0;i< k;i++){
            ans[i] = minHeap.poll().getKey();
        }
        /* for descending order
        for(int i= k-1;i >=0 ;i--){
            ans[i] = minHeap.poll().getKey();
        } */
        return ans;
    }

    public int[] bottomKFrequentWithPriorityQueueMaxHeap(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int num: nums)
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0)+1);

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue()); //Min-Heap
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()){
            maxHeap.add(entry);
            if (maxHeap.size() > k)
                maxHeap.poll(); // Remove the most frequent element
        }
        int[] ans = new int[k];
        for(int i=0;i< k;i++){
            ans[i] = maxHeap.poll().getKey();
        }
        /* for reverse order
        for(int i= k-1;i >=0 ;i--){
            ans[i] = minHeap.poll().getKey();
        } */
        return ans;
    }

    /*

    Approach 1 (Max-Heap): Time Complexity: Building the frequencyMap: O(n).
    Adding all entries to the max-heap: O(nlogn). Since the heap size grows to 𝑛 n, and each addition takes O(logn).
    Polling k elements from the heap: O(klogn).

    Space Complexity:  O(n) for the max-heap (storing all entries).
    Overall Time Complexity: O(nlogn+klogn), dominated by O(nlogn).

    Approach 2 (Min-Heap): Time Complexity: Building the frequencyMap: O(n).
    Adding 𝑛 n elements to the min-heap, with a fixed size of  k:
    Each addition or removal (via poll()) takes O(logk). Thus, iterating through 𝑛 n entries: O(nlogk).
    Polling 𝑘 elements from the heap: O(klogk).

    Space Complexity: O(k) for the min-heap (storing at most k entries).
    Overall Time Complexity: O(nlogk + klogk), dominated by O(nlogk).


    (Min-Heap) is more efficient when 𝑘 ≪ 𝑛 k≪n, as its time complexity is 𝑂 ((nlogk), compared to 𝑂 (nlogn) for the max-heap approach.
    The reduction in heap size drastically improves performance for large input sizes where 𝑘 k is small.

    Why Min-Heap is Better for Top 𝑘 k Frequent Elements:
    Smaller Heap Size: Approach 2 maintains a heap of size 𝑘 k, while Max Heap maintains a heap of size 𝑛 n.
    Fewer Comparisons: Inserting into a smaller heap results in faster operations.
    When to Prefer Approach 1: If 𝑘 k is close to 𝑛 n, Approach 1 may perform similarly or even better,
    as it avoids frequent heap removals during traversal.
     */

    public int[] topKFrequentWithPriorityQueueMaxHeap(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int n = nums.length;
        for(int num: nums)
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0)+1); // Order of n O(n)

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue()-a.getValue()); //Max-Heap
        maxHeap.addAll(frequencyMap.entrySet());
        int[] ans = new int[k];
        for(int i=0;i< k;i++){
            ans[i] = maxHeap.poll().getKey();
        }
        return ans;
    }

    public int[] topKFrequentOptimal(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int n : nums) {
            max = Math.max(max, n);
            min = Math.min(min, n);
        }

        int[] freq = new int[max - min + 1];

        for (int n : nums) {
            freq[n - min]++;
        }

        ArrayList<Integer>[] freqArr = new ArrayList[nums.length+1];

        for (int i=0; i<freq.length; i++) {
            if (freq[i] > 0) {
                if (freqArr[freq[i]] == null) {
                    freqArr[freq[i]] = new ArrayList<Integer>();
                }
                freqArr[freq[i]].add(i + min);
            }
        }

        int[] res = new int[k];

        int kk = 0;
        for (int i=freqArr.length-1; i>=0; i--) {
            if (freqArr[i] != null) {
                for (int j = 0; j < freqArr[i].size(); j++) {
                    res[kk] = freqArr[i].get(j);
                    kk++;

                    if (kk >= k) {
                        return res;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TopKFrequentElements().topKFrequentWithStream(new int[]{1,1,1,2,2,3}, 2)));
        System.out.println(Arrays.toString(new TopKFrequentElements().topKFrequentWithPriorityQueueMinHeap(new int[]{10,10,10,20,20,30}, 2)));
        System.out.println(Arrays.toString(new TopKFrequentElements().bottomKFrequentWithPriorityQueueMaxHeap(new int[]{10,20,20,30}, 2)));
        System.out.println(Arrays.toString(new TopKFrequentElements().topKFrequentWithPriorityQueueMaxHeap(new int[]{10,10,10,20,20,30}, 2)));
    }

    int[] unique;
    Map<Integer, Integer> count;

    public void swap(int a, int b) {
        int tmp = unique[a];
        unique[a] = unique[b];
        unique[b] = tmp;
    }

    public int partition(int left, int right, int pivot_index) {
        int pivot_frequency = count.get(unique[pivot_index]);
        // 1. Move pivot to end
        swap(pivot_index, right);
        int store_index = left;

        // 2. Move all less frequent elements to the left
        for (int i = left; i <= right; i++) {
            if (count.get(unique[i]) < pivot_frequency) {
                swap(store_index, i);
                store_index++;
            }
        }

        // 3. Move the pivot to its final place
        swap(store_index, right);

        return store_index;
    }

    public void quickselect(int left, int right, int k_smallest) {
        // Sort a list within left..right till kth less frequent element takes its place.
        // base case: the list contains only one element
        if (left == right) return;
        //Select a random pivot_index
        Random random_num = new Random();
        int pivot_index = left + random_num.nextInt(right - left);
        // Find the pivot position in a sorted list
        pivot_index = partition(left, right, pivot_index);
        // If the pivot is in its final sorted position
        if (k_smallest == pivot_index) {
            return;
        } else if (k_smallest < pivot_index) {
            // go left
            quickselect(left, pivot_index - 1, k_smallest);
        } else {
            // go right
            quickselect(pivot_index + 1, right, k_smallest);
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        // Build hash map: character and how often it appears
        count = new HashMap<>();
        for (int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        // Array of unique elements
        int n = count.size();
        unique = new int[n];
        int i = 0;
        for (int num: count.keySet()) {
            unique[i] = num;
            i++;
        }
        // kth top frequent element is (n - k)th less frequent.
        // Do a partial sort: from less frequent to the most frequent, till
        // (n - k)th less frequent element takes its place (n - k) in a sorted array.
        // All elements on the left are less frequent.
        // All the elements on the right are more frequent.
        quickselect(0, n - 1, n - k);
        // Return top k frequent elements
        return Arrays.copyOfRange(unique, n - k, n);
    }
}
