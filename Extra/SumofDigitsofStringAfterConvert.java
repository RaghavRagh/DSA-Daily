public class SumofDigitsofStringAfterConvert {

    private static int getLucky(String s, int k) {
        String numericString = "";
        for (char ch : s.toCharArray()) {
            numericString += Integer.toString(ch - 'a' + 1);
        }

        while (k-- > 0) {
            int digitSum = 0;
            for (char ch : numericString.toCharArray()) {
                digitSum += ch - '0';
            }
            numericString = Integer.toString(digitSum);
        }

        return Integer.parseInt(numericString);
    }
    
    public static void main(String[] args) {
        String str = "iiii";
        System.out.println(getLucky(str, 1));
    }
}