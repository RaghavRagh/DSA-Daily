public class CompareVersionNumbers {
    
    private static int compareVersion(String version1, String version2) {
        String[] v1Parts = version1.split("\\.");
        String[] v2Parts = version2.split("\\.");
        
        int maxLength = Math.max(v1Parts.length, v2Parts.length);
        
        for (int i = 0; i < maxLength; i++) {
            int num1 = i < v1Parts.length ? Integer.parseInt(v1Parts[i]) : 0;
            int num2 = i < v2Parts.length ? Integer.parseInt(v2Parts[i]) : 0;
            
            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            }
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
        String version1 = "1.0.1";
        String version2 = "1.0";
        System.out.println(compareVersion(version1, version2));
    }
}
