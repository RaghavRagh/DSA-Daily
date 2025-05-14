import java.util.Arrays;

public class JobSequencingProblem {

    static class Job {
        int id, deadline, profit;

        public Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    static int[] jobScheduling(Job jobs[]) {
        Arrays.sort(jobs, (a, b) -> (b.profit - a.profit));

        int max = 0;
        for (Job job : jobs) {
            if (job.deadline > max) {
                max = job.deadline;
            }
        }

        int limit[] = new int[max];
        Arrays.fill(limit, -1);
        int maxProfit = 0;
        int maxJob = 0;
        
        for (Job job : jobs) {
            for (int i = job.deadline - 1; i >= 0; i--) {
                if (limit[i] == -1) {
                    limit[i] = job.id;
                    maxProfit += job.profit;
                    maxJob++;
                    break;
                }
            }
        }

        return new int[]{maxJob, maxProfit};
    }

    public static void main(String[] args) {
        Job jobs[] = new Job[6];

        jobs[0] = new Job(1, 2, 300);
        jobs[1] = new Job(2, 5, 200);
        jobs[2] = new Job(3, 3, 190);
        jobs[3] = new Job(4, 3, 180);
        jobs[4] = new Job(5, 4, 120);
        jobs[5] = new Job(6, 2, 100);

        int[] ans = jobScheduling(jobs);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
