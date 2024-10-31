import java.util.ArrayList;
import java.util.List;

public class GameofTwoStacks {
    private static int twoStacks(List<Integer> a, List<Integer> b, int maxSum) {
        int currSum = 0, count = 0;
        while (currSum <= maxSum) {
            if (a.get(0) < b.get(0)) {
                if (currSum + a.get(0) <= maxSum) {
                    currSum += a.remove(0);
                    count++;
                } else {
                    break;
                }
            } else {
                if (currSum + b.get(0) <= maxSum) {
                    currSum += b.remove(0);
                    count++;
                } else {    
                    break;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(4);
        a.add(2);
        a.add(4);
        a.add(6);
        a.add(1);

        List<Integer> b = new ArrayList<>();
        b.add(2);
        b.add(1);
        b.add(8);
        b.add(5);

        System.out.println(twoStacks(a, b, 10));
    }
}
