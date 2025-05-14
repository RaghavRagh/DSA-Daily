import java.util.Stack;

public class TheCelebrityProblem {

    // TC - O(n^2)
    // SC - O(1)
    private static int findCelebrity1(int[][] M, int n) {
        // check each person if it is celebrity or not
        for (int i = 0; i < n; i++) {
            if (isCelebrity(M, i, n)) {
                return i;
            }
        }

        return -1;
    }

    // TC - O(n)
    // SC - O(n)
    private static int findCelebrity2(int[][] M, int n) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            s.push(i);
        }

        while (s.size() > 1) {
            int element1 = s.pop();
            int element2 = s.pop();

            if (M[element1][element2] == 1) {
                s.push(element2);
            } else {
                s.push(element1);
            }
        }

        int candidate = s.peek();

        if (isCelebrity(M, candidate, n)) {
            return candidate;
        }

        return -1;
    }

    // TC - O(n)
    // SC - O(1)
    private static int findCelebrity3(int[][] M, int n) {
        int left = 0;
        int right = n - 1;

        // Identify a candidate
        while (left < right) {
            if (M[left][right] == 1) {
                left++;
            } else {
                right--;
            }
        }

        // left is the candidate
        int candidate = left;

        // verify the candidate
        if (isCelebrity(M, candidate, n)) {
            return candidate;
        }

        return -1;
    }

    private static boolean isCelebrity(int[][] M, int candidate, int n) {
        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                if (M[candidate][i] == 1 || M[i][candidate] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] M = {
                { 0, 1, 0, 1 },
                { 0, 0, 0, 1 },
                { 1, 1, 0, 0 },
                { 0, 0, 0, 0 }
        };
        int n = M.length;
        System.out.println(findCelebrity1(M, n));
        System.out.println(findCelebrity2(M, n));
        System.out.println(findCelebrity3(M, n));
    }
}