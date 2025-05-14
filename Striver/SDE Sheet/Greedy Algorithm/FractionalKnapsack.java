import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

    static class Item {
        int value, weight;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    private static double fractionalKanpsack(int W, Item[] items, int n) {
        Arrays.sort(items, Comparator.comparingDouble((Item i) -> (double) i.value / i.weight).reversed());

        int currWeight = 0;
        double finalValue = 0.0;

        for (int i = 0; i < n; i++) {

            if (currWeight + items[i].weight <= W) {
                currWeight += items[i].weight;
                finalValue += items[i].value;
            } else {
                int remain = W - currWeight;
                finalValue += ((double) items[i].value / (double) items[i].weight) * (double) remain;
                break;
            }
        }

        return finalValue;
    }

    public static void main(String[] args) {
        int n = 3;
        int W = 50;
        Item[] items = { new Item(60, 10), new Item(100, 20), new Item(120, 30) };
        double ans = fractionalKanpsack(W, items, n);
        System.out.println(ans);
    }
}
