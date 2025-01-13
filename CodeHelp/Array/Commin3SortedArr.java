import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Commin3SortedArr {

    private static List<Integer> commonElements(List<Integer> list1, List<Integer> list2, List<Integer> list3) {
        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        int last = Integer.MIN_VALUE;
        while (i < list1.size() && j < list2.size() && k < list3.size()) {
            if (list1.get(i).equals(list2.get(j)) && list1.get(i).equals(list3.get(k)) && !list1.get(i).equals(last)) {
                last = list1.get(i);
                ans.add(list1.get(i));
                i++;
                j++;
                k++;
            } else if (list1.get(i) < list2.get(j)) {
                i++;
            } else if (list2.get(j) < list3.get(k)) {
                j++;
            } else {
                k++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 5, 10, 20, 40, 80);
        List<Integer> list2 = Arrays.asList(6, 7, 20, 80, 100);
        List<Integer> list3 = Arrays.asList(3, 4, 15, 20, 30, 70, 80, 120);

        List<Integer> ans = commonElements(list1, list2, list3);
        System.out.println(ans);
    }
}