class Solution {
    public int stoneGameVII(int[] stones) {
         int[] m = new int[stones.length - 1];
        int[] sum = new int[stones.length - 1];
        for (int i = 0; i < stones.length - 1; i++) {
            m[i] = Math.max(stones[i], stones[i + 1]);
            sum[i] = stones[i] + stones[i + 1];
        }
        int size = 2;
        while (size < stones.length) {
            for (int i = 0; i < stones.length - size; i++) {
                m[i] = Math.max(sum[i] - m[i], sum[i + 1] - m[i + 1]);
                sum[i] += stones[i + size];
            }
            size++;
        }
        return m[0];  
    }
}
