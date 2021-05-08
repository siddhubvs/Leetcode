class Solution {
    public int numPairsDivisibleBy60(int[] time) {
         if(time == null || time.length==0 ) return 0;
        int[] remainders = new int[60];
        int pair = 0;
        for(int i = 0 ; i < time.length; i++) {
            int remainder = time[i] % 60;
            if(remainder == 0) {
                 pair += remainders[0];
            }else {
                 pair += remainders[60 - remainder];
            }
            remainders[remainder]++; 
        }
        return pair;
    }
}
