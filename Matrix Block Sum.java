class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
         int m = mat.length, n = mat[0].length;
    int[][] dp = new int[m][n];
    dp[0][0] = mat[0][0];
    for(int i = 1; i<n; i++){
        dp[0][i] = dp[0][i-1] + mat[0][i];
    }
    for(int i = 1; i<m; i++){
        dp[i][0] = dp[i-1][0] + mat[i][0];
    }
    for(int i = 1; i <m; i++ ){
      for(int j = 1; j<n ; j++){
          dp[i][j] = dp[i-1][j]+dp[i][j-1] - dp[i-1][j-1] + mat[i][j];
      }  
    }
      int rmin , rmax, cmin, cmax; 
      for(int i = 0; i <m; i++ ){
      for(int j = 0; j<n ; j++){
          rmin = i -k -1;
          rmax = Math.min(m-1,i + k);
          cmin = j - k-1;
          cmax = Math.min(n-1,j + k);
          mat[i][j] = dp[rmax][cmax];
          if(rmin>=0 &&cmin >=0) mat[i][j] += dp[rmin][cmin];
          if(rmin >=0) mat[i][j] -= dp[rmin][cmax];
          if(cmin >=0) mat[i][j] -= dp[rmax][cmin];
          }  
    }
    return mat;
    }
}
