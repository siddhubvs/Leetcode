class Solution {
    public int maxSubArray(int[] nums) {
        int [] d = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for (int i=0;i<nums.length;i++) {
            if (i == 0) {
                d[i] = nums[i];
            } else {
                d[i] = Math.max(d[i-1] + nums[i], nums[i]);
            }
            max = Math.max(max, d[i]);
        }
        return max;
    }
}
