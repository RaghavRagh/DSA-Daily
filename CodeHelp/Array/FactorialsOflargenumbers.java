import java.math.BigInteger;
import java.util.ArrayList;

public class FactorialsOflargenumbers {

    private static ArrayList<Integer> factorial(int num) {
        ArrayList<Integer> ans = new ArrayList<>();
        BigInteger fact = new BigInteger("1");
        for (int i = num; i > 1; i--) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }

        String s = fact.toString();
        for (char ch : s.toCharArray()) {
            ans.add(ch - '0');
        }

        return ans;
    }

    public static void main(String[] args) {
        int num = 88;
        ArrayList<Integer> ans = factorial(num);
        System.out.println(ans);
    }
}   