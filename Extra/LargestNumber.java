import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    
    static String largestNumber(int[] nums) {
        String[] numStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numStr, new Comparator<String>() {
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);
            }
        });

        if (numStr[0].equals("0")){
            return "0";
        }

        StringBuilder res = new StringBuilder();
        for (String num : numStr) {
            res.append(num);
        }

        return res.toString();
    }
    
    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        System.out.println(largestNumber(nums));
    }
}
