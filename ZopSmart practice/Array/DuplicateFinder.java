import java.util.HashSet;

public class DuplicateFinder {

    public static int findDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) {
                return num;
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 5, 5, 2 };
        int duplicate = findDuplicate(nums);
        System.out.println("Duplicate number: " + duplicate);
    }
}