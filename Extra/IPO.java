import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class IPO {

    private static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < capital.length; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(profits[i]);
            temp.add(capital[i]);
            list.add(temp);
        }

        list.sort((a, b) -> a.get(1) - b.get(1));

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        int i = 0;
        for (int j = 0; j < k; j++) {
            while (i < profits.length && list.get(i).get(1) <= w) {
                pq.add(list.get(i++).get(0));
            }
            if (!pq.isEmpty()) {
                w += pq.poll();
            }
        }

        return w;
    }

    
    public static void main(String[] args) {
        int[] profits = {1,2,3};
        int[] capital = {0,1,1};
        int k = 2;
        int w = 0;
        System.out.println(findMaximizedCapital(k, w, profits, capital));
    }
}
