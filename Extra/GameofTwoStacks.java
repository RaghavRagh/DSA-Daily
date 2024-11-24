import java.util.Arrays;
import java.util.List;

public class GameofTwoStacks {
    private static int twoStacks(List<Integer> a, List<Integer> b, int maxSum) {
        int s1Count = 0, s2Count = 0, result = 0, totalSum = 0;
        for (Integer num : a) {
            if (totalSum + num > maxSum) {
                break;
            }
            totalSum += num;
            s1Count++;
        }

        result = s1Count;

        for (Integer num : b) {
            totalSum += num;
            s2Count++;
            while (totalSum > maxSum && s1Count > 0) {
                totalSum -= a.get(s1Count - 1);
                s1Count--;
            }
        }

        return totalSum <= maxSum ? Math.max(s1Count + s2Count, result) : result;
    }

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(4, 2, 4, 6, 1);
        List<Integer> b = Arrays.asList(2, 1, 8, 5);
        System.out.println(twoStacks(a, b, 10));
    }
}
