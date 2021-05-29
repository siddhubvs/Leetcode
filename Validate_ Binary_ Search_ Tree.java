public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,null,null); 
        
    }
    public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if(root==null) return true;
        if(min!=null && root.val<=min.val) return false;
        if(max!=null && root.val>=max.val) return false;
        if(!isValidBST(root.left, min, root)) return false;
        if(!isValidBST(root.right, root, max)) return false;
        return true;
    }
}
