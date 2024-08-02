public class NoOfSubstringWDominantOnes {
    
    private static int numberOfSubstrings(String s) {
        int res = 0;
        int left = 0;
        int ones = 0, zeros = 0;
    
        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) == '1') {
                ones++;
            } else {
                zeros++;
            }
    
            while (ones < zeros * zeros && left <= right) {
                if (s.charAt(left) == '1') {
                    ones--;
                } else {
                    zeros--;
                }
                left++;
            }
    
            res += (right - left + 1);
        }
    
        return res;
    }
    
    public static void main(String[] args) {
        String s = "00011";
        System.out.println(numberOfSubstrings(s));
    }
}
