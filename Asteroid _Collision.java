class Solution {
    public int[] asteroidCollision(int[] asteroids) {
         Stack<Integer> sp = new Stack<>();
        for(int i=0;i<asteroids.length;++i){
        int flag = 0;
        while(!sp.isEmpty() && asteroids[i]<0 && sp.peek() > 0){
                if(sp.peek() < -asteroids[i]){
                   sp.pop();
                    continue;
                    }else if(sp.peek()==-asteroids[i]){
                  flag = 1;
                    sp.pop();
                    break;
                }else{
                   flag = 1;
                    break;
                }
               }
            if(flag==0){
             sp.push(asteroids[i]);
            }
          }
        int[] ans = new int[sp.size()];
        int i=sp.size()-1;
        while(!sp.isEmpty()){
            ans[i--] = sp.pop();
        }
        return ans;
       }
    }
