public class RemoveDuplicates {

    private static void removeDuplicates(int[] nums) {
        int i = 0;
        for(int j = 0; j < nums.length; j++) {
            if(nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3, 4 };
        removeDuplicates(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
