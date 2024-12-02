import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PoisonousPlants {
    
    // O(n)^3
    private static int poisonousPlants(List<Integer> p) {
        int days = 0;
        List<Integer> plants = new ArrayList<>(p);
        boolean finalDay = false;
        
        do {
            int pCount = p.size();
            for (int i = 1; i < pCount; i++) {
                if (p.get(i - 1) < p.get(i)) {
                    plants.remove(i - (pCount - plants.size()));
                }
                if (i == pCount - 1) {
                    if (p.equals(plants)) {
                        finalDay = true;
                    } else {
                        days++;
                        p = new ArrayList<>(plants);
                    }
                }
            }
        } while (!finalDay && p.size() > 1);

        return days;
    }

    // 
    private static int poisonousPlants2(List<Integer> p) {
        int days = 0;
        int[] life = new int[p.size()];
        Arrays.fill(life, 1);
        life[0] = Integer.MAX_VALUE;
        Stack<Integer> st = new Stack<>();
        st.push(0);

        for (int i = 1; i < p.size(); i++) {
            while (life[i] > life[st.peek()] || (p.get(i) <= p.get(st.peek()) && life[st.peek()] != Integer.MAX_VALUE)) {
                life[i] = Math.max(life[i], life[st.peek()] + 1);
                st.pop();
            }

            if (p.get(i) <= p.get(st.peek()) && life[st.peek()] == Integer.MAX_VALUE) {
                life[i] = Integer.MAX_VALUE;
            }

            if (life[i] != Integer.MAX_VALUE) {
                days = Math.max(days, life[i]);
            }

            st.push(i);
        }

        return days;
    }
    
    public static void main(String[] args) {
        List<Integer> p = Arrays.asList(4, 3, 7, 5, 6, 4, 2);
        System.out.println(poisonousPlants2(p));
    }
}
