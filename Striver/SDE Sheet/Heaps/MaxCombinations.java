import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class MaxCombinations {

    static class Element {
        int sum, i, j;

        Element(int sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
    }

    private static List<Integer> maxCombinations(int N, int K, List<Integer> A, List<Integer> B) {
        List<Integer> ans = new ArrayList<>();
        Collections.sort(A);
        Collections.sort(B);
        PriorityQueue<Element> pq = new PriorityQueue<>(Comparator.comparingInt(e -> -e.sum));
        Set<String> s = new HashSet<>();

        pq.add(new Element(A.get(N - 1) + B.get(N - 1), N - 1, K - 1));
        s.add((N - 1) + "," + (N - 1));

        while (K > 0 && !pq.isEmpty()) {
            Element p = pq.poll();
            ans.add(p.sum);
            int i = p.i;
            int j = p.j;

            if (i > 0 && !s.contains((i - 1) + "," + j)) {
                pq.add(new Element(A.get(i - 1) + B.get(j), i - 1, j));
                s.add((i - 1) + "," + j);
            }

            if (j > 0 && !s.contains(i + "," + (j - 1))) {
                pq.add(new Element(A.get(i) + B.get(j - 1), i, j - 1));
                s.add(i + "," + (j - 1));
            }

            K--;
        }

        return ans;
    }

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(1, 2, 3);
        List<Integer> B = Arrays.asList(4, 5, 6);
        int N = A.size();
        int K = 3;
        List<Integer> ans = maxCombinations(N, K, A, B);
        System.out.println(ans);
    }
}