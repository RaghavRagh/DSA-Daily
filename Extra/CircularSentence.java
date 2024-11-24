public class CircularSentence {
    
    private static boolean  isCircularSentence(String s) {
        String[] words = s.trim().split(" ");
        
        for (int i = 0; i < words.length - 1; i++) {
            if (words[i].charAt(words[i].length() - 1) != words[i + 1].charAt(0)) {
                return false;
            }
        }

        return words[0].charAt(0) == words[words.length - 1].charAt(words[words.length  - 1].length() - 1);
    }

    
    public static void main(String[] args) {
        String s = "leetcode exercises sound delightful";
        System.out.println(isCircularSentence(s));
    }
}
