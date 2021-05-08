class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
         int n = jobDifficulty.length;
        if (d > n) return -1;
        int[][] dp = new int[d][n];
        
       
        dp[0][0] = jobDifficulty[0];
        for (int j = 1; j < n; j++) {
            dp[0][j] = Math.max(dp[0][j - 1], jobDifficulty[j]);
        }
        
        
        for (int i = 1; i < d; i++) {
            
          for (int j = i; j < n; j++) {
                
                
                int dayMax = jobDifficulty[j];
                
                int minCost = dp[i-1][j-1] + dayMax;
                
                
                for (int k = j-1; k >= i; k--) {

                   
                    dayMax = Math.max(dayMax, jobDifficulty[k]);
                   
                    minCost = Math.min(minCost, dp[i-1][k-1] + dayMax);
                }
                
             
             dp[i][j] = minCost;
            }
        }
        
       return dp[d-1][n-1];      
     }
}
