import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class NMeetingsIn1Room {

    // Greedy Approach
    static class Meeting {
        int start, end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    // TC - O(nlogn)
    // SC - O(n)
    private static int maxMeetingsGreedy(int start[], int end[], int n) {
        Meeting[] meetings = new Meeting[n];

        for (int i = 0; i < n; i++) {
            meetings[i] = new Meeting(start[i], end[i]);
        }

        Arrays.sort(meetings, Comparator.comparingInt(m -> m.end));

        int last = -1; 
        int res = 0;

        for (Meeting meeting : meetings) {
            if (meeting.start > last) {
                last = meeting.end;
                res++;
            }
        }

        return res;
    }

    // Dynamic Programming
    // TC - O(n^2)
    // SC - O(n)
    public int maxMeetingsDynamic(int[] start, int[] end, int n) {
        List<int[]> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            meetings.add(new int[]{end[i], start[i]});
        }
        meetings.sort((a, b) -> a[0] - b[0]);
    
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
    
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (meetings.get(j)[0] < meetings.get(i)[1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
    
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };
        int ans = maxMeetingsGreedy(start, end, end.length);
        System.out.println(ans);
    }
}