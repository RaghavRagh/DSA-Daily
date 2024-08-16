import java.util.ArrayList;
import java.util.List;

public class MaxDistanceInArr {
    
    private static int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int maxDistance = 0;

        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> currArr = arrays.get(i);
            int currMin = currArr.get(0);
            int currMax = currArr.get(currArr.size() - 1);

            maxDistance = Math.max(maxDistance, Math.abs(currMax - min));
            maxDistance = Math.max(maxDistance, Math.abs(max - currMin));

            min = Math.min(min, currMin);
            max = Math.max(max, currMax);
        }

        return maxDistance;
    }
    
    public static void main(String[] args) {
        List<Integer> list1 = List.of(2,2,3);
        List<Integer> list2 = List.of(1, 5);
        List<Integer> list3 = List.of(1,2,3);

        List<List<Integer>> arrays = new ArrayList<>();
        arrays.add(list1);
        arrays.add(list2);
        arrays.add(list3);

        System.out.println(maxDistance(arrays));
    }
}
