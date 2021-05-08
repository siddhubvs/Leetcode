class Solution {
    public int maxSumDivThree(int[] nums) {
        int res = 0;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for(int n : nums){
            res += n;
            if(n%3==1){
                if(min1!=Integer.MAX_VALUE)
                    min2 = Math.min(min2, n+min1);
                min1 = Math.min(min1, n);
            }
            if(n%3==2){
                if(min2!=Integer.MAX_VALUE)
                    min1 = Math.min(min1, n+min2);
                min2 = Math.min(min2, n);
            }
        }
        if(res%3 == 1)
            res-=min1;
        if(res%3==2)
            res-=min2;
        return res;
    }
        
    }
