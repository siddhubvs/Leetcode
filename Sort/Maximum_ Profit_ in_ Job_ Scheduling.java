class Solution {
    class Job implements Comparable<Job> {
        int start, end, profit;
        Job(int start, int end, int profit) {
          this.start = start;
          this.end = end;
          this.profit = profit;
        }

        @Override
        public int compareTo(Job job) {
            return this.end - job.end;
        }
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];
        int[] dp = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        
        Arrays.sort(jobs);
        
        for (int i = 1; i <= n; i++) { 
            dp[i] = dp[i - 1];
            int lastJob = i - 1;
            while (lastJob >= 0 && jobs[i - 1].start < jobs[lastJob].end) {  
                lastJob--;
            }
            dp[i] = Math.max(dp[i - 1], jobs[i - 1].profit + dp[lastJob + 1]);
        }
        
        return dp[n];
    }
} 
