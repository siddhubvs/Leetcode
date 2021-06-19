class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int score=0;
        int n=tokens.length-1;
        for(int i=0;i<=n;){
            if(P>=tokens[i]){
                P-=tokens[i];
                score++;
                i++;
            }
            else if(score>0&&(n-i)>1){
                P+=tokens[n];
                n--;
                score--;
            }
            else
                break;
        }
        return score;
    }
}
