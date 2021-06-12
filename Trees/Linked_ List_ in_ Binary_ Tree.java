class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        boolean ans = check(head, root);
        if (root!=null && !ans)
        {
            ans |= isSubPath(head, root.left);
            ans |= isSubPath(head, root.right);
        }
        return ans;
    }
public boolean check(ListNode head, TreeNode root){
        if (head==null)
            return true;
        if (root==null)
            return false;
        if (root.val==head.val)
            return check(head.next, root.left) || check(head.next, root.right);
        return false;
        
    }
}
