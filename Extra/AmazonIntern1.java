import java.util.HashMap;

public class AmazonIntern1 {

    private static int numTrips(int[] weights) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : weights) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int rounds = 0;
        for (int count : map.values()) {
            if (count == 1) {
                return -1;
            }

            rounds += count / 3;
            count %= 3;

            if (count > 0) {
                rounds++;
            }
        }

        return rounds;
    }

    public static void main(String[] args) {
        int[] weights = { 2, 2, 3, 3, 2, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4 };
        System.out.println(numTrips(weights));
    }
}
