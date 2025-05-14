import java.util.PriorityQueue;

public class MedianFromDataStream {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFromDataStream() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        // either both the heaps will have equal no. of elements or
        // max heap will have one more element than the min-heap
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == 0) {
            return 0;
        } else if (maxHeap.size() == minHeap.size()) {
            // we have even no. of elements, take avg of middle two
            return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
        }
        // because max-heap will have one more element than min-heap
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        MedianFromDataStream md = new MedianFromDataStream();
        md.addNum(3);
        md.addNum(1);
        System.out.println("Median is: " + md.findMedian());
        md.addNum(5);
        System.out.println("Median is: " + md.findMedian());
        md.addNum(4);
        System.out.println("Median is: " + md.findMedian());

        // System.out.println("Median is: " + md.findMedian());
        // md.addNum(1);
        // md.addNum(2);
        // System.out.println("Median is: " + md.findMedian());
        // md.addNum(3);
        // System.out.println("Median is: " + md.findMedian());
    }
}
