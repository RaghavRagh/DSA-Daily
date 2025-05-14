import java.util.Arrays;
import java.util.List;

public class Leetcode_2824 {

    private static int countPairs(List<Integer> nums, int target) {
        nums.sort(null);
        int res = 0, i = 0, j = nums.size() - 1;

        while (i < j) {
            if (nums.get(i) + nums.get(j) < target) {
                res += (j - i);
                i++;
            } else {
                j--;
            }
        }

        return res;
    }
    
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(-1, 1, 2, 3, 1);
        int target = 2;
        System.out.println(countPairs(nums, target));
    }
}
