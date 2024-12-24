import java.util.ArrayList;
import java.util.Arrays;

public class TwosumPairswith0Sum {
    

    private static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int i = 0, j = arr.length - 1;

        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum < 0) {
                i++;
            } else if (sum > 0) {
                j--;
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[j]);
                ans.add(list);
                i++; j--;
                while (i < j && arr[i] == arr[i - 1]) {
                    i++;
                }

                while (j > i && arr[j] == arr[j + 1]) {
                    j--;
                }
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        int[] arr = {6, 1, 8, 0, 4, -9, -1, -10, -6, -5};
        ArrayList<ArrayList<Integer>> ans = getPairs(arr);
        System.out.println(ans);
    }
}
