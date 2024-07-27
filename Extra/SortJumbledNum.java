import java.util.Arrays;
import java.util.Comparator;

public class SortJumbledNum {

    private int mapNumber(int num, int[] mapping) {
        if (num == 0) {
            return mapping[0];
        }
        
        int mappedNum = 0;
        int multiplier = 1;

        while (num > 0) {
            int digit = num % 10;
            mappedNum += mapping[digit] * multiplier;
            multiplier *= 10;
            num /= 10;
        }

        return mappedNum;
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        int[][] mappedNums = new int[n][2];

        for (int i = 0; i < n; i++) {
            mappedNums[i][0] = nums[i];
            mappedNums[i][1] = mapNumber(nums[i], mapping);
        }

        Arrays.sort(mappedNums, Comparator.comparingInt((a) -> a[1]));

        int[] sortedArray = new int[n];

        for (int i = 0; i < n; i++) {
            sortedArray[i] = mappedNums[i][0];
        }

        return sortedArray;
    }

    public static void main(String[] args) {
        int[] mapping = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        int[] nums = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[] res = new SortJumbledNum().sortJumbled(mapping, nums);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
