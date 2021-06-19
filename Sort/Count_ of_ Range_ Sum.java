class Solution{
 long[] sum;
    int n, lower, upper;
    public int countRangeSum(int[] ns, int lower, int upper) {
        this.upper = upper;
        this.lower = lower;
        if (ns == null || ns.length < 1) return 0;
        n = ns.length;
        sum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + ns[i];
        }
        return merge(0, n + 1);
    }
    
    private int merge(int fr, int to) {
        if (to - fr <= 1) return 0;
        int mid = (fr + to) / 2;
        int cnt = merge(fr, mid) + merge(mid, to);
        int l = mid, r = mid, c = 0, j = mid;
        long[] cache = new long[to - fr];
        for (int i = fr; i < mid; i++, c++) {
            while (l < to && sum[l] - sum[i] < lower) l++;
            while (r < to && sum[r] - sum[i] <= upper) r++;
            while (j < to && sum[i] > sum[j]) cache[c++] = sum[j++];
            cache[c] = sum[i];
            cnt += r - l;
        }
        System.arraycopy(cache, 0, sum, fr, j - fr);
        return cnt;
    }
}
