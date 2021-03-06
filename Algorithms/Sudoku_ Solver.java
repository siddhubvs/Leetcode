class Solution{
private char[][] b;
private boolean[][] row = new boolean[9][9];
private boolean[][] col = new boolean[9][9];
private boolean[][] block = new boolean[9][9];
public void solveSudoku(char[][] board) {
    b = board;
    int num, k;
    for (int i=0; i<9; i++) {
        for (int j=0; j<9; j++) {
            if(board[i][j]!='.') {
                num = board[i][j]-'1'; 
                k = i/3*3 + j/3;
                row[i][num] = col[j][num] = block[k][num] = true;
            }
        }
    }
    Helper(0);
}
public boolean Helper(int ind){
    if(ind==81) return true; 
    int i=ind/9, j=ind%9, num, k;
    if(b[i][j]!='.') return Helper(ind+1);
    else{
        for(char f='1'; f<='9'; f++){
            num = f-'1'; 
            k= i/3*3 + j/3;
            if(!row[i][num] && !col[j][num] && !block[k][num]){
                b[i][j]= f;
                row[i][num] = col[j][num] = block[k][num] = true;
                if(Helper(ind+1)) return true;                
                b[i][j]='.';
                row[i][num] = col[j][num] = block[k][num] = false;
            }
        }
        return false;
    }
}
}
