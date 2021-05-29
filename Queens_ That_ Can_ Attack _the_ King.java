 class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
       List<List<Integer>> ans =new ArrayList<>(); 
       boolean [][]b=new boolean[8][8];
        
       for(int i=0;i<queens.length;i++){
           b[queens[i][0]][queens[i][1]]=true;}
        
       int [][]moves={{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1}};
           for(int i=0;i<moves.length;i++){
               int k=king[0]+moves[i][0];
               int l=king[1]+moves[i][1];
               while(k>=0 && l>=0 && k<8 && l<8){
                   if(b[k][l]){
                       List<Integer> ls=new ArrayList<>();
                       ls.add(k);
                       ls.add(l);
                       ans.add(ls);
                       break;
                   }
                k=k+moves[i][0];
                l=l+moves[i][1];
               }
           }
        return ans;
    }
}
