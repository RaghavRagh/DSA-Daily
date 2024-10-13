import java.util.HashMap;

public class SubArrSumEqualsK {

    private static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefix = 0, count = 0;
        map.put(0, 1);

        for (int num : nums) {
            prefix += num;
            if (map.containsKey(prefix - k)) {
                count += map.get(prefix - k);
            }

            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }

        return count;
    }

    // TC - O(n)^2
    private static int subarraySum2(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, -3 };
        int k = 3;
        System.out.println(subarraySum(arr, k));
    }
}
