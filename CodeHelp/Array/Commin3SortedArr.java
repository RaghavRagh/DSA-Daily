import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Commin3SortedArr {
    
    private static List<Integer> commonElements(List<Integer> list1, List<Integer> list2, List<Integer> list3) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : list1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i : list2) {
            map.computeIfPresent(i, (k, v) -> v + 1);
        }

        for (int i : list3) {
            map.computeIfPresent(i, (k, v) -> v + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 2) {
                ans.add(entry.getKey());
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 5, 10, 20, 40, 80);
        List<Integer> list2 = Arrays.asList(6, 7, 20, 80, 100);
        List<Integer> list3 = Arrays.asList(3, 4, 15, 20, 30, 70, 80, 120);

        List<Integer> ans = commonElements(list1 , list2, list3);
        System.out.println(ans);
    }
}