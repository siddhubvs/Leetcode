class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        Arrays.sort(points, (a,b)-> Integer.compare(a[0],b[0]));
        int res = 1, minRight = points[0][1];
        for(int i = 1; i < points.length; i++){
            if(points[i][0] <= minRight){
                minRight = Math.min(minRight, points[i][1]);
                continue;
            }else {
                minRight = points[i][1];
                res++;
            }
        }
        return res;
    }
}
