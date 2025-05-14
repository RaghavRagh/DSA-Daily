public class BooksAllocationProb {

    private static int allocateBooks(int[] arr, int n, int m) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        int s = 0;
        int e = sum;
        int ans = -1;

        while (s <= e) {
            int mid = (s + e) >> 1;
            if (isPossible(arr, n, m, mid)) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return ans;
    }

    private static boolean isPossible(int[] arr, int n, int m, int mid) {
        int studentCnt = 1;
        int pageSum = 0;

        for (int i : arr) {
            if (pageSum + i <= mid) {
                pageSum += i;
            } else {
                studentCnt++;
                if (studentCnt > m || i > mid) {
                    return false;
                }
                pageSum = i;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40 };
        int n = arr.length;
        int m = 2;
        System.out.println(allocateBooks(arr, n, m));
    }
}
