class Solution {
    public int distinctEchoSubstrings(String text) {
        if(text.length()==0) return 0;
		
        int[] ht = new int[text.length()]; 		
        ht[0] = text.charAt(0);
        for(int i=1; i<text.length(); i++) ht[i]=ht[i-1]+text.charAt(i);
        
        Set<String> set = new HashSet<>();
        
        for(int i=0; i<text.length()-1; i++){
            for(int len=1; len<text.length(); len++){
                int j = i+len;
                if(j+len>text.length()) break;
 
                int a = (i==0?ht[j-1]:ht[j-1]-ht[i-1]);
                int b = ht[j+len-1]-ht[j-1];

                if(a==b){ 	// if a<>b, not impossible match
                    String s1 = text.substring(i, j);
                    String s2 = text.substring(j, j+len);
                    if(s1.equals(s2)) set.add(s1);
                }
            }
        }
        
        return set.size();
    }
}
