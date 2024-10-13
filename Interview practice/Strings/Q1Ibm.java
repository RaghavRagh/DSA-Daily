// Given string/sentence need to be reversed and the vowels need to be replaced with numbers from 1-9.In the reversed string replaced numbers should appear in descending order from left to right .If there are more than 9 vowels , numbering should restart from 1.

import java.util.HashSet;

public class Q1Ibm {

    private static String strOperation(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        char[] vowels = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };

        HashSet<Character> set = new HashSet<>();
        for (char c : vowels) {
            set.add(c);
        }

        int count = 9;
        for (int i = 0; i < sb.length(); i++) {
            if (set.contains(sb.charAt(i))) {
                sb.replace(i, i + 1, String.valueOf(count--));
                if (count == 0) {
                    count = 9;
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "Hello World! Raghav this side";
        System.out.println(strOperation(str));
    }
}