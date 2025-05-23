public class CountAndSay {
    
    private static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String result = "1";
        for (int i = 2; i <= n; i++) {
            result = getNextSequence(result);
        }

        return result;
    }

    private static String getNextSequence(String sequence) {
        StringBuilder nextSequence = new StringBuilder();
        int length = sequence.length();
        int count = 1;

        for (int i = 1; i < length; i++) {
            if (sequence.charAt(i) == sequence.charAt(i - 1)) {
                count++;
            } else {
                nextSequence.append(count).append(sequence.charAt(i - 1));
                count = 1;
            }
        }

        nextSequence.append(count).append(sequence.charAt(length - 1));

        return nextSequence.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
}
