import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MinimumPlatforms {

    static class Pair {
        int first;
        char second;

        Pair(int first, char second) {
            this.first = first;
            this.second = second;
        }
    }

    private static int findPlatform(int[] arr, int[] dep, int n) {
        ArrayList<Pair> order = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            order.add(new Pair(arr[i], 'a'));
            order.add(new Pair(dep[i], 'd'));
        }

        Collections.sort(order, Comparator.comparingInt((Pair p) -> p.first).thenComparingInt((Pair p) -> p.second));

        int result = 1;
        int plat_needed = 0;

        for (Pair p : order) {
            if (p.second == 'a') {
                plat_needed++;
            } else {
                plat_needed--;
            }

            if(plat_needed > result) {
                result = plat_needed;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
        int ans = findPlatform(arr, dep, arr.length);
        System.out.println(ans);
    }
}
