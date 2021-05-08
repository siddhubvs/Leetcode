class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
	int max = 0;
  while (left < right) {
		int value = Math.min(height[left], height[right]) * (right - left);
    if (height[left] < height[right])
			left++;
		else
			right--;
     if (value > max)
			max = value;
	}
	return max;
    }
}
