public class StringCompression {
    
    private static String compress(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            int count = 1;
            while (i + 1 < s.length() && s.charAt(i + 1) == currChar) {
                count++;
                i++;
            }
            sb.append(count).append(s.charAt(i));
            count = 1;
        }

        return sb.toString();
    }
    
    public static void main(String[] args) {
        String str = "aabbbbeeeeffggg";
        System.out.println(compress(str));
    }
}
