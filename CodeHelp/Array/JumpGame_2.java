public class JumpGame_2 {

    static int minJumpsRecur(int i, int[] arr) {
        
        // Return 0 when last element is reached.
        if (i >= arr.length - 1)
            return 0;

        // Traverse through all the points
        // reachable from arr[i].
        // Recursively, get the minimum number
        // of jumps needed to reach array end from
        // these points.
        int ans = Integer.MAX_VALUE;
        for (int j = i + 1; j <= i + arr[i]; j++) {
            int val = minJumpsRecur(j, arr);
            if (val != Integer.MAX_VALUE)
                ans = Math.min(ans, 1 + val);
        }

        return ans;
    }

    static int minJumps(int[] arr) {

        int ans = minJumpsRecur(0, arr);
        
        // If end cannot be reached.
        if (ans == Integer.MAX_VALUE) 
            return -1;
            
        return ans;
    }
    
    public static void main(String[] args) {
        int[] nums = { 2, 3, 0, 1, 4 };
        // System.out.println(jump(nums));
        System.out.println(minJumps(nums));
    }
}
