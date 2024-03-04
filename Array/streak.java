import java.util.Arrays;

public class streak {

    static int[] sortSquare(int[] arr) {
        return Arrays.stream(arr).map(x -> x * x).sorted().toArray();
    }

    public static void main(String[] args) {
        int[] arr = { -4, -1, 0, 3, 10 };
        int[] ans = sortSquare(arr);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
