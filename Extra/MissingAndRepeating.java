public class MissingAndRepeating {

    static int[] findTwoElement(int[] arr) {
        int n = arr.length;
        int sum = (n * (n + 1) / 2) + 1;

        for (int i : arr) {
            sum -= i;
        }

        int slow = 0, fast = 0;
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }

        int[] res = new int[2];
        res[0] = sum;
        res[1] = slow;

        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 3 };
        int[] res = findTwoElement(arr);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
