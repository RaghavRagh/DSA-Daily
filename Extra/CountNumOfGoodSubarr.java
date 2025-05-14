import java.util.HashMap;

public class CountNumOfGoodSubarr {

    private static long countGood(int[] nums, int k) {
        int n = nums.length;
        if (n == 1 && k > 1) {
            return 0;
        }

        long res = 0;
        int i = 0, pairs = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < n; j++) {
            int num = nums[j];
            int count = map.getOrDefault(num, 0);
            pairs += count;
            map.put(num, count + 1);

            while (pairs >= k) {
                res += n - j;
                int leftNum = nums[i];
                int leftCount = map.get(leftNum);
                map.put(leftNum, leftCount - 1);
                pairs -= leftCount - 1;
                i++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 4, 3, 2, 2, 4 };
        System.out.println(countGood(nums, 2));
    }
}
