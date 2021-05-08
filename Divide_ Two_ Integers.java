class Solution {
    public int divide(int dividend, int divisor) {
      if(dividend==Integer.MIN_VALUE){
			if(divisor==-1) 
				return Integer.MAX_VALUE;
			else if(divisor>0) 
				return -1+divide(dividend+divisor,divisor);
			else 
				return 1+divide(dividend-divisor,divisor);
		}
		long dividend_long=dividend;
		long divisor_long=divisor;
		boolean minus=false;
		if((dividend_long>=0&&divisor_long>0)||(dividend_long<=0&&divisor_long<0))
			minus=false;
		else
			minus=true;
		return (int) (minus?-recursive(Math.abs(dividend_long),Math.abs(divisor_long)):recursive(Math.abs(dividend_long),Math.abs(divisor_long)));
    
    }
    public long recursive(long dividend,long divisor) {
		long d=divisor,count=1;
		if(dividend<d) {
			return 0;
		}
		while(dividend>=(d+d)) {
			d+=d;
			count+=count;
		}
		return count+recursive(dividend-d,divisor);  
    }
}
