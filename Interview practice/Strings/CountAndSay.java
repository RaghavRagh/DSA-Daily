public class CountAndSay {

    private static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String res = "1";
        for (int i = 2; i <= n; i++) {
            res = getNextSequence(res);
        }

        return res;
    }

    private static String getNextSequence(String seq) {
        StringBuilder sb = new StringBuilder();
        int count = 1;

        for (int i = 1; i < seq.length(); i++) {
            if (seq.charAt(i) == seq.charAt(i - 1)) {
                count++;
            } else {
                sb.append(count).append(seq.charAt(i - 1));
                count = 1;
            }
        }

        sb.append(count).append(seq.charAt(seq.length() - 1));
        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println(countAndSay(n));
    }
}
