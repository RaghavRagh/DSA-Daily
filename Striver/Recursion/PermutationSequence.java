import java.util.ArrayList;

public class PermutationSequence {

    private static String getPermutation(int n, int k) {
        int fact = 1;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            fact *= i;
            list.add(i);
        }

        list.add(n);
        String ans = "";
        k--;

        while (true) {
            ans = ans + list.get(k / fact);
            list.remove(k / fact);
            if (list.size() == 0) {
                break;
            }

            k %= fact;
            fact /= list.size();
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 3;
        int k = 3;
        String ans = getPermutation(n, k);
        System.out.println(ans);
    }
}
