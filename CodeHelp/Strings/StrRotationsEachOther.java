public class StrRotationsEachOther {
    
    private static boolean areRotations(String text, String pattern) {
        if (text.length() != pattern.length()) {
            return false;
        }
        
        for (int i = 0; i < text.length(); i++) {
            if (text.equals(pattern)) {
                return true;
            }
            
            char last = text.charAt(text.length() - 1);
            text = last + text.substring(0, text.length() - 1);
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        String text = "abcd", pattern = "cdab";
        System.out.println(areRotations(text, pattern));
    }
}
