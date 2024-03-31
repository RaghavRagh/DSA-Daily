import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {

    private static List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int count1 = 0, count2 = 0;
        int element1 = -1, element2 = -1;

        for (int i = 0; i < nums.length; i++) {
            if (count1 == 0 && nums[i] != element2) {
                count1 = 1;
                element1 = nums[i];
            } else if (count2 == 0 && nums[i] != element1) {
                count2 = 1;
                element2 = nums[i];
            } else if (nums[i] == element1) {
                count1++;
            } else if (nums[i] == element2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == element1)
                count1++;
            if (nums[i] == element2)
                count2++;
        }

        int min = nums.length / 3;
        if (count1 > min) {
            list.add(element1);
        }

        if (count2 > min) {
            list.add(element2);
        }

        return list;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2 };

        List<Integer> list = new ArrayList<>();
        list = majorityElement(arr);
        System.out.println(list);
    }
}
