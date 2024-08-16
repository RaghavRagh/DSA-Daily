import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

class Solution {
    public static int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        Integer[] boxed = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        Arrays.sort(boxed, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                int freqA = map.get(a);
                int freqB = map.get(b);
                if (freqA != freqB) {
                    return freqA - freqB; // Sort by frequency in ascending order.
                } else {
                    return b - a; // If frequencies are the same, sort by value in descending order.
                }
            }
        });

        for (int i = 0; i < nums.length; i++) {
            nums[i] = boxed[i];
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 2, 2, 3 };
        int[] res = frequencySort(nums);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}