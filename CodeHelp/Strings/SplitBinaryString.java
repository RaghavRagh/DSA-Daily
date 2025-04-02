public class SplitBinaryString {

    private static int split(String s) {
        int count0 = 0, count1 = 0, count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                count0++;
            } else {
                count1++;
            }

            if (count0 == count1) {
                count++;
            }
        }

        return count == 0 ? -1 : count;
    }

    public static void main(String[] args) {
        String s = "001110010";
        System.out.println(split(s));
    }
}
