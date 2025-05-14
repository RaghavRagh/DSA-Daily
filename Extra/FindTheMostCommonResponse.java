import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeMap;

public class FindTheMostCommonResponse {

    private static String findCommonResponse(List<List<String>> responses) {
        List<List<String>> list = new ArrayList<>();
        for (var res : responses) {
            List<String> i = new ArrayList<>(new LinkedHashSet<>(res));
            list.add(i);
        }

        TreeMap<String, Integer> map = new TreeMap<>();
        for (var res : list) {
            for (String s : res) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        int maxCount = 0;
        String ans = "";
        for (var entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            if (value > maxCount) {
                maxCount = value;
                ans = key;
            } 
        }

        return ans;
    }
    
    public static void main(String[] args) {
        List<String> subList1 = Arrays.asList("good", "ok", "good", "ok");
        List<String> subList2 = Arrays.asList("ok", "bad", "good", "ok", "ok");
        List<String> subList3 = Arrays.asList("good");
        List<String> subList4 = Arrays.asList("bad");
        List<List<String>> list = new ArrayList<>();
        list.add(subList1);
        list.add(subList2);
        list.add(subList3);
        list.add(subList4);
        System.out.println(findCommonResponse(list));
    }
}
