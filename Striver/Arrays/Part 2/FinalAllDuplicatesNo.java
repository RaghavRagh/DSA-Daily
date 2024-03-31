import java.util.ArrayList;
import java.util.List;

public class FinalAllDuplicatesNo {

    // SC-O(n)
    private static List<Integer> findDuplicates1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int[] count = new int[nums.length + 1];

        for (int freq : nums) {
            count[freq]++;
        }

        for(int i = 1; i < nums.length; i++) {
            if (count[i] == 2) {
                list.add(i);
            }
        }

        return list;
    }

    private static List<Integer> findDuplicates2(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                list.add(index + 1);
            }

            nums[index] = -nums[index];
        }

        return list;
    }
    
    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        List<Integer> list = findDuplicates2(nums);
        System.out.println(list);
    }
}
