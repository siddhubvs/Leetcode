class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
          int len = pushed.length;
        if (len == 0) return true;
        int idx = 0;
		
        for (int p : pushed) {
            if (p == popped[0]) break;
            idx++;
        }
        pushed[idx] = -1;
        for (int j = 1; j < len; j++) {
            int p = popped[j];
            int last = idx;
            while (idx >= 0 && pushed[idx] < 0) idx--;
            if (idx >= 0 && pushed[idx] == p) {
			   
                pushed[idx] = -1;
                continue;
            }
            
            idx = last;
            for (int i = idx + 1; i < len; i++) {
                if (p == pushed[i]) {
				   
                    idx = i;
                    pushed[i] = -1;
                    break;
                }
            }
                
            if (idx == last) return false;
        } 
        
        return true;
    }
}
