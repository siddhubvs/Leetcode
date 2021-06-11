class Solution {
    public int[] getCoprimes(int[] nums, int[][] edges) {
        int n = nums.length;
        int[][] computedGcd = new int[51][51];
        for (int i = 1; i <= 50; ++i) {
            for (int j = i; j <= 50; ++j) {
                if (gcd(i, j) == 1) {
                    computedGcd[i][j] = computedGcd[j][i] = 1;
                }
            }
        }
        int[] parent = new int[n];
        List<List<Integer>> g = new ArrayList<>();
        Map<Integer, int[][]> curPath = new HashMap<>();
        int[][] temp = new int[51][2];
        for (int[] row : temp)
            Arrays.fill(row, -1);
        curPath.put(0, temp);
        
        for (int i = 0; i < n; ++i) {
            g.add(new ArrayList<Integer>());
        }
        
        for (int[] ed : edges) {
            g.get(ed[0]).add(ed[1]);
            g.get(ed[1]).add(ed[0]);
        }
        
        parent[0] = -1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        
        int[] res = new int[n];
        res[0] = -1;
        int d = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            while (sz-- > 0) {
                int cur = q.poll();
                for (int chd : g.get(cur)) {
                    if (chd != parent[cur]) {
                        parent[chd] = cur;
                        q.offer(chd);
                    }
                }

                if (cur == 0)
                    continue;
                else {
                    int anc = parent[cur];
                    temp = curPath.get(anc).clone();
                    temp[nums[anc]] = new int[]{anc, d-1};
                    
                    int minD = Integer.MAX_VALUE;
                    for (int v = 1; v <= 50; ++v) {
                        if (temp[v][0] != -1 && computedGcd[v][nums[cur]] == 1) {
                            if (d - temp[v][1] < minD) {
                                minD = d - temp[v][1];
                                res[cur] = temp[v][0];
                            }
                        }
                    }
                    curPath.put(cur, temp);
                    if (minD == Integer.MAX_VALUE)
                        res[cur] = -1;
                }
            }
            d ++;
        }
        
        return res;
    }
    
    public int gcd(int a, int b)
    {
        
        if (b == 0)
            return a;
        
        else
            return gcd(b, a % b);
    }
}
