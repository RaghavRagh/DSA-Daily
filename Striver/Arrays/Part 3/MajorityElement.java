import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MajorityElement {

    // TC-O(n) SC-O(1)
    static int majorityElement1(int[] nums) {
        int ele = -1;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                count = 1;
                ele = nums[i];
            } else if (nums[i] == ele) {
                count++;
            } else {
                count--;
            }
        }

        int counter1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == ele) {
                counter1++;
            }
        }

        if (counter1 > nums.length / 2) {
            return ele;
        }

        return -1;
    }

    // TC-O(n) SC-O(n)
    static int majorityElement2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int majorityCount = nums.length / 2;
        for (int num : map.keySet()) {
            if (map.get(num) > majorityCount) {
                return num;
            }
        }

        return -1;
    }

    // advanced java
    static int majorityEleAdvancedJava(int[] nums) {
        Map<Integer, Long> frequencyMap = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        long majorityCount = nums.length / 2;
        for (Map.Entry<Integer, Long> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > majorityCount) {
                return entry.getKey();
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
        // int ans = majorityElement2(nums);

        int ans2 = majorityElement1(nums);
        System.out.println(ans2);
    }
}