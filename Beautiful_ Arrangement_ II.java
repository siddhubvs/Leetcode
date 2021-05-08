class Solution {
    public int[] constructArray(int n, int k) {
       int[] result = new int[n];
        int start = 1;
        int end = k + 1;
        int idx = 0;
        while(start < end) {
            result[idx++] = start++;
            result[idx++] = end--;
        }
        if(start == end) {
            result[idx++] = start;
        }
        
        for(int j = k + 2; j <= n; ++j) {
            result[idx++] = j;
        }
        
        return result; 
    }
}
