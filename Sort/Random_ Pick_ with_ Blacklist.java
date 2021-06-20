class Solution {
    HashSet<Integer> banned;
    List<Integer> allowed;
    Random r;
    int N;
    
    public Solution(int N, int[] blacklist) {
        this.N = N;
        banned = new HashSet<Integer>();
        allowed = new ArrayList<Integer>();
        
        for(int x : blacklist){
            banned.add(x);
        }
        
        int M = banned.size();
        if(M >= (N/3)){
            for(int i = 0; i < N; i++){
                if(!banned.contains(i)){
                    allowed.add(i);
                }
            }
        }
        
        r = new Random();
    }
    
    public int pick() {
        if(allowed.size() > 0){
            
            int index = r.nextInt(allowed.size());
            return allowed.get(index);
        }else{
            while(true){
                int index = r.nextInt(N);
                if(!banned.contains(index))
                    return index;
            }
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */
