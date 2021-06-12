class Solution {
    int a;
    public int maxPathSum(TreeNode root) {
        a = Integer.MIN_VALUE;
        dfs(root);
	    return a;
}
private int dfs(TreeNode root){
	if (root == null){
		return 0;
	}
	int left = Math.max(0, dfs(root.left));
	int right = Math.max(0, dfs(root.right));
	if (root.left != null && root.right != null){
		a = Math.max(a, left + right + root.val);
		return Math.max(left, right) + root.val;
	}
	if (root.left == null){
		a = Math.max(a, right + root.val);
		return right + root.val;
	}	
	else {
		a = Math.max(a, left + root.val);
		return  left + root.val;
	}
}

}
