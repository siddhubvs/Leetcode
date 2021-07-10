class Solution {
    public boolean hasAllCodes(String s, int k) {
       
        int n = 1 << k;
        
        int bitmask = n - 1;
        
        int hashValue = 0;
        boolean[] found = new boolean[n];
        
        for(int i = 0; i < s.length(); i++){
            
            int bit = s.charAt(i) - '0';
            
            
            hashValue <<= 1;
            hashValue = hashValue & bitmask;
            
            
            hashValue = hashValue | bit;
            
            if(i >= k - 1 && !found[hashValue]){
                found[hashValue] = true;
                n--;
                
                
                if(n == 0) return true;
            }
            
        }
        
        return false;
    }
}
