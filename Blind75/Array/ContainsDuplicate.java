// 217
// https://leetcode.com/problems/contains-duplicate/description/

import java.util.HashMap;

public class ContainsDuplicate {

    static boolean isDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            if(map.containsKey(num) && map.get(num) >= 1) {
                return true;
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        boolean res = isDuplicate(nums);
        System.out.println(res);
    }
}
