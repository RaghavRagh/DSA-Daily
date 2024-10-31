import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumSwaps {

    private static int maximumSwap(int num) {
        List<Integer> list = new ArrayList<>();
        while (num != 0) {
            list.add(num % 10);
            num /= 10;
        }
        Collections.reverse(list);
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i : list) {
            max = Math.max(max, i);
        }
        int maxIdx = list.indexOf(max);

        for (int i : list) {
            min = Math.min(min, i);
        }
        int minIdx = list.indexOf(min);

        if (maxIdx > minIdx) {
            swap(list, maxIdx, minIdx);
        }

        StringBuilder s = new StringBuilder();
        for (int i : list) {
            s.append(i);
        }

        return Integer.parseInt(s.toString());
    }

    private static void swap(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static void main(String[] args) {
        int num = 2736;
        System.out.println(maximumSwap(num));
    }
}