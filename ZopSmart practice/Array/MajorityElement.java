public class MajorityElement {

    private static int majorityElement(int[] nums) {
        int count = 0, candidate = -1;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        count = 0;
        for (int i : nums) {
            if (i == candidate) {
                count++;
            }
        }

        if (count > (nums.length) / 2) {
            return candidate;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(majorityElement(nums));
    }
}
