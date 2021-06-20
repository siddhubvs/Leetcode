public class Solution {
    public String findLongestWord(String s, List<String> d) {
        String longest=null;
        Iterator<String> itr=d.iterator();
        while(itr.hasNext()){
            String dd=itr.next();
            int start=-1;
            boolean flag=true;
            for(int i=0;i<dd.length();i++){
                start=s.indexOf(dd.charAt(i),start+1);
                if(start<0){
                    flag=false;
                    break;
                }
            }
            if(!flag)   continue;
            if(longest==null)   longest=dd;
            else{
                if(dd.length()>longest.length())    longest=dd;
                if(dd.length()==longest.length()&&dd.compareTo(longest)<0)   longest=dd;
            }
        }
        return longest==null?"":longest;
    }
}
