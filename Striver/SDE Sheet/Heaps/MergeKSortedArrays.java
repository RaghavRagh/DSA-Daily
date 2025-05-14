import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

    static class ArrayEntry implements Comparable<ArrayEntry> {
        int value;
        int arrayIndex;
        int elementIndex;

        public ArrayEntry(int value, int arrayIndex, int elementIndex) {
            this.value = value;
            this.arrayIndex = arrayIndex;
            this.elementIndex = elementIndex;
        }

        @Override
        public int compareTo(ArrayEntry o) {
            return Integer.compare(this.value, o.value);
        }

    }

    private static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>();

        // Initialize the heap with the first element of each array
        for (int i = 0; i < k; i++) {
            if (kArrays.get(i).size() > 0) {
                minHeap.offer(new ArrayEntry(kArrays.get(i).get(0), i, 0));
            }
        }

        // Extract the smallest element from the heap and add the next element of that
        // array to the heap
        while (!minHeap.isEmpty()) {
            ArrayEntry entry = minHeap.poll();
            ans.add(entry.value);

            int nextElementIndex = entry.elementIndex + 1;
            if (nextElementIndex < kArrays.get(entry.arrayIndex).size()) {
                minHeap.offer(new ArrayEntry(
                        kArrays.get(entry.arrayIndex).get(nextElementIndex),
                        entry.arrayIndex,
                        nextElementIndex));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(3, 5, 9));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3, 8));
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);

        ArrayList<Integer> ans = mergeKSortedArrays(list, 2);
        System.out.println(ans);
    }
}
