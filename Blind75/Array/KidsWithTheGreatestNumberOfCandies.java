// 1431
// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {

    static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        
        int max = Arrays.stream(candies).max().orElse(0);
        System.out.println(max);

        for(int i = 0; i < candies.length; i++) {
            candies[i] += extraCandies;
            if(candies[i] >= max) {
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int candies[] = { 2, 3, 5, 1, 3 };
        int extraCandies = 3;
        List<Boolean> list = kidsWithCandies(candies, extraCandies);
        System.out.println(list);
    }
}
