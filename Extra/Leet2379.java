public class Leet2379 {

    // O(n)
    private static int minimumRecolors2(String blocks, int k) {
        int left = 0, whites = 0, minWhite = Integer.MAX_VALUE;

        for (int right = 0; right < blocks.length(); right++) {
            if (blocks.charAt(right) == 'W') {
                whites++;
            }

            if (right - left + 1 == k) {
                minWhite = Math.min(whites, minWhite);
                if (blocks.charAt(left) == 'W') {
                    whites--;
                }
                left++;
            }
        }

        return minWhite;
    }
    
    // TC - O(n * k)
    private static int minimumRecolors(String blocks, int k) {
        if (blocks.length() < k)
            return 0;

        int i = 0, j = k, sum = Integer.MAX_VALUE;
        while (j <= blocks.length()) {
            sum = Math.min(getSum(blocks.substring(i, j)), sum);
            i++;
            j++;
        }

        return sum;
    }

    private static int getSum(String s) {
        int WCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'W')
                WCount++;
        }

        return WCount;
    }

    public static void main(String[] args) {
        String blocks = "BWWWBB";
        System.out.println(minimumRecolors(blocks, 6));
        System.out.println(minimumRecolors2(blocks, 6));
    }
}
