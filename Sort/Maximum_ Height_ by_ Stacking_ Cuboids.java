class Solution {
     public int maxHeight(int[][] cs) {
        int max = 0;
        for(int[] c : cs) Arrays.sort(c);
        Arrays.sort(cs, (x, y) -> (x[0] + x[1] * 100 + x[2] * 10000) - (y[0] + y[1] * 100 + y[2] * 10000));
        int[] dp = new int[cs.length];
        for (int i = 0; i < cs.length; i++) {
            dp[i] = cs[i][2];
            for (int j = 0; j < i; j++)
                if (cs[i][1] >= cs[j][1] && cs[i][0] >= cs[j][0])
                    dp[i] = Math.max(dp[i], dp[j] + cs[i][2]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
