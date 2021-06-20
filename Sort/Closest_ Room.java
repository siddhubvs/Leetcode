class Solution{
public int[] closestRoom(int[][] rooms, int[][] queries) {
    int[] res = new int[queries.length];
    int[][] qs = new int[queries.length][];
    for (var i = 0; i < queries.length; ++i) 
        qs[i] = new int[] { queries[i][0], queries[i][1], i};
    Arrays.sort(rooms, (a, b) -> b[1] - a[1]);        
    Arrays.sort(qs, (a, b) -> b[1] - a[1]);    
    int id = 0;
    var ids = new TreeSet<Integer>();
    for (var q : qs) {
        for(; id < rooms.length && rooms[id][1] >= q[1]; ++id)
            ids.add(rooms[id][0]);
        Integer ans1 = ids.floor(q[0]), ans2 = ids.ceiling(q[0]);    
        if (ans1 != null && ans2 != null)
            res[q[2]] = q[0] - ans1 <= ans2 - q[0] ? ans1 : ans2;
        else
            res[q[2]] = ans1 == null && ans2 == null ? -1 : ans1 == null ? ans2 : ans1;
    }
    return res;
}
}
