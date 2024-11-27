import java.util.HashSet;
import java.util.Set;

public class UnionAndIntersection {
    
    private static int union(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr1) {
            set.add(i);
        }

        for (int i : arr2) {
            set.add(i);
        }

        return set.size();
    }

    private static int intersection(int[] arr1, int[] arr2) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : arr1) {
            set.add(i);
        }

        for (int i : arr2) {
            if (set.contains(i)) {
                count++;
            }
        }

        return count;
    }
    
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {6, 4, 7, 5, 8};
        System.out.println("Union: " + union(arr1, arr2));
        System.out.println("Intersection: " + intersection(arr1, arr2));
    }
}
