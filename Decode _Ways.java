class Solution {
    public int numDecodings(String s) {
        int[] m = new int[s.length()];
        Arrays.fill(m, -1);
        return solve(s.length() - 1, s, m);
    }
    
    private int solve(int i, String s, int[] m){
        if(i < 0) return 1;
        if(m[i] == -1){
            int res = s.charAt(i) == '0'? 0: solve(i - 1, s, m);
            if(i > 0 && s.substring(i - 1, i + 1).compareTo("26") <= 0 && s.substring(i - 1, i + 1).compareTo("10") >= 0)
                    res += solve(i - 2, s, m);
            m[i] = res;
        }
        return m[i];
    }
}
