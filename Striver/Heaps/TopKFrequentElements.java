import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.AbstractMap.SimpleEntry;

public class TopKFrequentElements {

    // bucket sort
    @SuppressWarnings("unchecked")
    private static int[] topKFrequent1(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        int[] res = new int[k];
        int counter = 0;

        for (int pos = bucket.length - 1; pos >= 0 && counter < k; pos--) {
            if (bucket[pos] != null) {
                for (Integer i : bucket[pos]) {
                    if (counter < k) {
                        res[counter++] = i;
                    }
                }
            }
        }

        return res;
    }

    // using Max heap
    private static int[] topKFrequent2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<SimpleEntry<Integer, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> b.getValue().compareTo(a.getValue()));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.offer(new SimpleEntry<>(entry.getKey(), entry.getValue()));
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll().getKey();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 3, 3, 4 };
        int k = 2;
        int[] ans = topKFrequent1(nums, k);
        for (int i : ans) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] res = topKFrequent2(nums, k);
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
