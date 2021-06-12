class Solution {
int camera = 0;
    public int minCameraCover(TreeNode root) {
        if(getCamera(root)==-1)
            camera++;
        return camera;
    }
    public int getCamera(TreeNode root)  
    {
        if(root == null)
            return 0;
        int left = getCamera(root.left);
        int right = getCamera(root.right);
        if(left==0 && right == 0) 
            return -1;
        if(left == -1 || right == -1)
        {
            camera++;
            return 1;
        }
        return 0;
    }
 }
