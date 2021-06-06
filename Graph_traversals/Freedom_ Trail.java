class Solution {
    public int findRotateSteps(String ring, String key) {
        List<Integer>[] indexs = new List[26];
        for (int i = 0; i < 26; i++) {
            indexs[i] = new ArrayList<>();
        }
        for (int i = 0; i < ring.length(); i++) {
            indexs[ring.charAt(i) - 'a'].add(i);
        }
        int[][] dp = new int[key.length()][ring.length()];
        return dfs(dp, indexs, 0, 0, ring.length(), key.toCharArray());
    }
    
    public int dfs(int[][] dp, List<Integer>[] indexs, int pos, int pre, int n, char[] chs) {
        if (pos == chs.length) return 0;
        if (dp[pos][pre] > 0) return dp[pos][pre];
        int min = Integer.MAX_VALUE;
        for (int index : indexs[chs[pos] - 'a']) {
            int d = Math.abs(index - pre);
            int move = Math.min(d, n - d) + 1;
            min = Math.min(min, move + dfs(dp, indexs, pos + 1, index, n, chs));
        }
        dp[pos][pre] = min;
        return min;
    }
}
