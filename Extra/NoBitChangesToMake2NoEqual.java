public class NoBitChangesToMake2NoEqual {

    private static int minChanges(int n, int k) {
        if (n == k) return 0;
        if ((n & k) != k) return -1;

        int xor = n ^ k;
        
        int changes = 0;
        for (int i = 0; i < 32; i++) {
            if ((xor & (1 << i)) > 0 && (n & (1 << i)) > 0) {
                changes++;
            }
        }

        return changes;        
    }
    
    public static void main(String[] args) {
        System.out.println(minChanges(13, 4));
    }
}