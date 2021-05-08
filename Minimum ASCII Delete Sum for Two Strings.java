class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m=s1.length(),n=s2.length();
        int[][] d = new int[m + 1][n + 1];
        for(int i = 1; i <=m; i++){
            d[i][0] = d[i-1][0] + s1.charAt(i-1); 
        }
        for(int i = 1; i <=n; i++){
            d[0][i] = d[0][i-1] + s2.charAt(i-1); 
        }
        for(int i=1;i<=m;++i){
            int first=s1.charAt(i-1);
            for(int j=1;j<=n;++j){
                int second=s2.charAt(j-1);
                if(first==second)
                    d[i][j]=d[i-1][j-1]; 
                else
                    d[i][j]=Math.min(d[i-1][j-1]+first+second,
                             Math.min(d[i-1][j]+first,d[i][j-1]+second)); 
            }
        }
        return d[m][n];
    }
}
