class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 1) 
        return nums.length;
    int count = 1;
    for(int i = 1; i < nums.length; i++) {
        if (nums[i] != nums[i - 1]) {
            nums[count] = nums[i];
            count++;
        }
    }
    return count;
        
    }
}
