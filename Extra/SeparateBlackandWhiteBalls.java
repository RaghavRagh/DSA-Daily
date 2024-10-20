public class SeparateBlackandWhiteBalls {

    private static long minimumSteps(String s) {
        long swaps = 0;
        int blackBallCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                swaps += (long) blackBallCount;
            } else {
                blackBallCount++;
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        String s = "0011000010";
        System.out.println(minimumSteps(s));
    }
}
