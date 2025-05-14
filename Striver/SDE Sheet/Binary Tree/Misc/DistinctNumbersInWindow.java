import java.util.ArrayList;
import java.util.HashMap;

public class DistinctNumbersInWindow {

    // TC - O(n)
    // SC - O(n)
    private static ArrayList<Integer> dNum(ArrayList<Integer> A, int B) {
        int n = A.size();
        if (n < B) {
            return new ArrayList<>();
        }

        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < B; i++) {
            map.put(A.get(i), map.getOrDefault(A.get(i), 0) + 1);
        }
        res.add(map.size());

        for (int i = B; i < A.size(); i++) {
            if (map.get(A.get(i - B)) == 1) {
                map.remove(A.get(i - B));
            } else {
                map.put(A.get(i - B), map.get(A.get(i - B)) - 1);
            }
            map.put(A.get(i), map.getOrDefault(A.get(i), 0) + 1);
            res.add(map.size());
        }

        return res;
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(1);
        A.add(3);
        A.add(4);
        A.add(2);
        A.add(3);

        int B = 4;
        ArrayList<Integer> res = dNum(A, B);
        System.out.println(res);
    }
}