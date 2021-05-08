class Solution {
	public void wiggleSort(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length;
		int mid = (n % 2 == 0)? n / 2 - 1: n / 2;
		int[] temp = Arrays.copyOf(nums, n);
		int idx = 0;
		for (int i = 0; i <= mid; i++) {
			nums[idx] = temp[mid - i];
			if (idx + 1 < n) {
				nums[idx+1] = temp[n - i - 1];
			}
			idx += 2;
		}
	}
}
