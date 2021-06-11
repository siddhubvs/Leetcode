class Solution{
public boolean isEvenOddTree(TreeNode root) {
if (root.val % 2 == 0)
		return false;
boolean level = false;
int prev = Integer.MAX_VALUE;
Queue<TreeNode> queue = new LinkedList<>();
queue.add(root);
while (!queue.isEmpty()) {
	int count = queue.size();
	 for (int i = 0; i < count; i++) {
			TreeNode rem = queue.poll();
			TreeNode left = rem.left, right = rem.right;
			if (left != null) {
				int val = left.val;
				if (level) {
					if (val % 2 == 0 || val <= prev)
						return false;
					prev = val;
					queue.add(left);
				} else {
					if (val % 2 != 0 || val >= prev)
						return false;
					prev = val;
					queue.add(left);
				}
			}
			if (right != null) {
				int val = right.val;
				if (level) {
					if (val % 2 == 0 || val <= prev)
						return false;
					prev = val;
					queue.add(right);
				} else {
					if (val % 2 != 0 || val >= prev)
						return false;
					prev = val;
					queue.add(right);
				}
			}
		}
if (level){
			level = false;
			prev = Integer.MAX_VALUE;
} else {
			level = true;
			prev = Integer.MIN_VALUE;
		}
}
	return true;
}
}
