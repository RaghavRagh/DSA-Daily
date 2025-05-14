// import java.util.Stack;

public class DailyTemperatures {

    private static int[] dailyTemperatures(int[] temperatures) {
        // int[] res = new int[temperatures.length];

        // TC - O(n^2)
        // for (int i = 0; i < temperatures.length; i++) {
        // int count = 0;
        // for (int j = i + 1; j < temperatures.length; j++) {
        // count++;
        // if (temperatures[j] > temperatures[i]) {
        // res[i] = count;
        // break;
        // }
        // }
        // }

        // TC - O(n)
        // Stack<Integer> s = new Stack<>();
        // for (int i = temperatures.length - 1; i >= 0; i--) {
        // while (!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]) {
        // s.pop();
        // }

        // if (!s.isEmpty()) {
        // res[i] = s.peek() - i;
        // }

        // s.push(i);
        // }

        // return res;

        int N = temperatures.length;
        int maxTemperature = 0;
        int[] daysToWait = new int[N];

        for (int i = N - 1; i >= 0; i--) {
            if (maxTemperature <= temperatures[i]) {
                maxTemperature = temperatures[i];
                continue;
            }
 
            int increment = 1;
            while (temperatures[i + increment] <= temperatures[i]) {
                increment += daysToWait[i + increment];
            }
            daysToWait[i] = increment;
        }
        return daysToWait;
    }

    public static void main(String[] args) {
        int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };
        int[] ans = dailyTemperatures(temperatures);

        for (int i : ans) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
