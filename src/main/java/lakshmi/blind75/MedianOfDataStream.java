package lakshmi.blind75;

import java.util.PriorityQueue;

//Time Complexity:
// addNum(int num): Inserting into a heap: O(log n)
// Potential re-balancing (poll + offer): O(log n)
// Total Time: O(log n) per insertion
//
//findMedian():
// Just peek operations on heaps: O(1)
//
// Total Time: O(1) per query
//
//Space Complexity:
// Two heaps store all the numbers.
// maxHeap + minHeap store n elements in total.
// Total Space: O(n), where n is the number of elements added
public class MedianOfDataStream {

    public static void main(String[] args) {
        MedianOfDataStream medianOfDataStream = new MedianOfDataStream();
        medianOfDataStream.addNum(11);
        medianOfDataStream.addNum(12);
        double median = medianOfDataStream.findMedian();
        System.out.println(median);
        medianOfDataStream.addNum(13);
        median = medianOfDataStream.findMedian();
        System.out.println(median);
        medianOfDataStream.addNum(9);
        median = medianOfDataStream.findMedian();
        System.out.println(median);

        System.out.println("---------------------------");
        MedianOfDataStream medianOfDataStream1 = new MedianOfDataStream();
        medianOfDataStream1.addNumWithMinHeap(11);
        medianOfDataStream1.addNumWithMinHeap(12);
        median = medianOfDataStream1.findMedianWithMinHeap();
        System.out.println(median);
        medianOfDataStream1.addNumWithMinHeap(13);
        median = medianOfDataStream1.findMedianWithMinHeap();
        System.out.println(median);
        medianOfDataStream1.addNumWithMinHeap(9);
        median = medianOfDataStream1.findMedianWithMinHeap();
        System.out.println(median);
    }

    PriorityQueue<Integer> minQueue;
    PriorityQueue<Integer> maxQueue;

    public MedianOfDataStream() {
        minQueue = new PriorityQueue<>();
        maxQueue = new PriorityQueue<>((a,b) -> (b-a));
    }

    private void addNum(int n) {
      if(maxQueue.isEmpty() || n <= maxQueue.peek()) {
          maxQueue.offer(n);
      } else {
          minQueue.offer(n);
      }

      if (maxQueue.size() > minQueue.size() + 1) {
          minQueue.offer(maxQueue.poll());
      } else if (minQueue.size() > maxQueue.size()) {
          maxQueue.offer(minQueue.poll());
      }
    }

    private double findMedian() {
        return maxQueue.size() > minQueue.size() ? maxQueue.peek() :
                (double) (maxQueue.peek() + minQueue.peek()) * 0.5;
    }

    private void addNumWithMinHeap(int n) {
        if(minQueue.isEmpty() || n >= minQueue.peek()) {
            minQueue.offer(n);
        } else {
            maxQueue.offer(n);
        }

        if (minQueue.size() > maxQueue.size() + 1) {
            maxQueue.offer(minQueue.poll());
        } else if (maxQueue.size() > minQueue.size()) {
            minQueue.offer(maxQueue.poll());
        }
    }

    private double findMedianWithMinHeap() {
        return minQueue.size() > maxQueue.size() ? minQueue.peek() :
                (double) (maxQueue.peek() + minQueue.peek()) * 0.5;
    }
}
