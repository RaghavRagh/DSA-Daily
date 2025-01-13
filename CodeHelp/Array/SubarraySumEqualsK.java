import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubarraySumEqualsK {

    public static List<Integer> subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (map.containsKey(sum - k)) {
                int start = map.get(sum - k) + 1;
                List<Integer> subarray = new ArrayList<>();

                for (int j = start; j <= i; j++) {
                    subarray.add(nums[j]);
                }

                return subarray;
            }

            map.put(sum, i);
        }

        return new ArrayList<>();
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 3, 6, 5, 5, 1 };
        //            0, 1, 2, 3, 4, 5, 6, 7 -- actual array
        //            1, 2, 3, 4, 5, 6, 7, 8 -- human readable
        //           -1, 0, 1, 2, 3, 4, 5, 6 -- used for programming here
        int k = 11;
        List<Integer> result = subarraySum(arr, k);
        System.out.println(result);
    }
}
