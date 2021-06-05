class Solution {
public boolean helper(TreeNode node)
{
if(node==null)
return false;

    boolean left=helper(node.left);
    boolean right=helper(node.right);
    if(left==false)node.left=null;
    
    if(right==false)node.right=null;
    
    boolean current=false;
    if(node.val==1)
        current=true;
        
    if(!left && !right)
        return current;
   else
       return true;
    
}

public TreeNode pruneTree(TreeNode root) {
    if(helper(root)==false)
        root=null;
    return root;
    
}

}
