import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PoisonousPlants {
    
    private static int poisonousPlants(List<Integer> p) {
        Stack<int[]> s = new Stack<>();
        int maxDays = 0;

        for (int pest : p) {
            int daysToDie = 0;
            while (!s.isEmpty() && pest > s.peek()[0]) {
                daysToDie = Math.max(daysToDie, s.pop()[1]);
            }

            daysToDie  = s.isEmpty() ? 0 : daysToDie + 1;
            s.push(new int[]{pest, daysToDie});
            maxDays = Math.max(daysToDie, maxDays);
        }

        return maxDays;
    }
    
    public static void main(String[] args) {
        List<Integer> p = Arrays.asList(4, 3, 7, 5, 6, 4, 2);
        System.out.println(poisonousPlants(p));
    }
}
