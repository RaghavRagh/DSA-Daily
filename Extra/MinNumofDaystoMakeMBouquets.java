import java.util.Arrays;

public class MinNumofDaystoMakeMBouquets {

    private static int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        int low = Arrays.stream(bloomDay).min().getAsInt();
        int high = Arrays.stream(bloomDay).max().getAsInt();

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(bloomDay, m, k, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private static boolean isPossible(int[] bloomDay, int m, int k, int day) {
        int count = 0;
        int noOfB = 0;

        for (int i : bloomDay) {
            if (i <= day) {
                count++;
            } else {
                noOfB += (count / k);
                count = 0;
            }
        }

        noOfB += (count / k);
        return noOfB >= m;
    }

    public static void main(String[] args) {
        int[] bloomDay = { 7, 7, 7, 7, 12, 7, 7 };
        int m = 2, k = 3;
        System.out.println(minDays(bloomDay, m, k));
    }
}
