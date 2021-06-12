class Solution {
    int i=0,l=-1;
    TreeNode find(String s,int level){
        if(i>=s.length())
            return null;
        if(l==-1){
         int count=0;
        while(s.charAt(i)=='-')
        {
            i++;
            count++;
        }
            if(count<level){l=count;return null;}
         l=-1;
           
            int num=0;
            while(i<s.length()&&s.charAt(i)!='-')num=num*10+(s.charAt(i++)-'0');
            TreeNode root=new TreeNode(num);
            root.left=find(s,level+1);
            root.right=find(s,level+1);
             return root;
        }
        else if(l<level)return null;
         l=-1;
         int num=0;
            while(i<s.length()&&s.charAt(i)!='-')num=num*10+(s.charAt(i++)-'0');
            TreeNode root=new TreeNode(num);
            root.left=find(s,level+1);
            root.right=find(s,level+1);
        return root; 
    }
    public TreeNode recoverFromPreorder(String traversal) {
        return find(traversal,0);
    }
}
