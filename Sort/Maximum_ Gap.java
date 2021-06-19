public class Solution {
public int maximumGap(int[] nums) {
    if (nums == null || nums.length < 2) {
        return 0;
    }
    int m = nums[0];
    for (int i = 1; i < nums.length; i++) {
        m = Math.max(m, nums[i]);
    }
    
    int exp = 1; 
    int R = 10; 

    int[] a = new int[nums.length];
    
    while (m / exp > 0) { 
        int[] count = new int[R];
        
        for (int i = 0; i < nums.length; i++) {
            count[(nums[i] / exp) % 10]++;
        }
        
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        
        for (int i = nums.length - 1; i >= 0; i--) {
            a[--count[(nums[i] / exp) % 10]] = nums[i];
        }
        
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
        exp *= 10;
    }
    
    int max = 0;
    for (int i = 1; i < a.length; i++) {
        max = Math.max(max, a[i] - a[i - 1]);
    }
     
    return max;
}
}
