import java.util.HashSet;

public class SubArrW0Sum {

    private static boolean findSum(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        for (int i : arr) {
            sum += i;
            if (i == 0 || sum == 0 || set.contains(sum)) {
                return true;
            }

            set.add(sum);
        }

        return false;
    }
    
    public static void main(String[] args) {
        int[] arr = { 4, 2, -3, 1, 6 };
        System.out.println(findSum(arr));
    }
}
