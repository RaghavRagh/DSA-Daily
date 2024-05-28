import java.util.*;

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(key, pair.key) && Objects.equals(value, pair.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}

public class MaximumCombinations {

    public List<Integer> maxCombinations(int N, int K, List<Integer> A, List<Integer> B) {
        List<Integer> ans = new ArrayList<>();
        Collections.sort(A);
        Collections.sort(B);
        PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> pq = new PriorityQueue<>(
                Collections.reverseOrder(Comparator.comparingInt(Pair::getKey)));
        Set<Pair<Integer, Integer>> s = new HashSet<>();
        pq.add(new Pair<>(A.get(N - 1) + B.get(N - 1), new Pair<>(N - 1, N - 1)));
        s.add(new Pair<>(N - 1, N - 1));

        while (K > 0 && !pq.isEmpty()) {
            Pair<Integer, Pair<Integer, Integer>> p = pq.poll();
            int sum = p.getKey();
            int i = p.getValue().getKey();
            int j = p.getValue().getValue();
            ans.add(sum);

            if (i > 0 && !s.contains(new Pair<>(i - 1, j))) {
                pq.add(new Pair<>(A.get(i - 1) + B.get(j), new Pair<>(i - 1, j)));
                s.add(new Pair<>(i - 1, j));
            }

            if (j > 0 && !s.contains(new Pair<>(i, j - 1))) {
                pq.add(new Pair<>(A.get(i) + B.get(j - 1), new Pair<>(i, j - 1)));
                s.add(new Pair<>(i, j - 1));
            }

            K--;
        }

        return ans;
    }

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(1, 2, 3);
        List<Integer> B = Arrays.asList(4, 5, 6);
        MaximumCombinations maxCombo = new MaximumCombinations();
        List<Integer> result = maxCombo.maxCombinations(3, 3, A, B);
        System.out.println(result); // Output: [9, 8, 8]
    }
}