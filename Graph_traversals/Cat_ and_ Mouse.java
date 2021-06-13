class Solution 
{
    public int catMouseGame(int[][] graph) 
    {
        int n = graph.length;
        int[][][] f = new int[n + n][n][n];
        fill(f, -1);
        
        return find(graph, f, 0, 1, 2);
    }
    
    int find(int[][] graph, int[][][] f, int t, int x, int y)
    {
        if (t == graph.length * 2) return 0; // draw
        if (x == 0) return 1; 
        if (x == y) return 2; 
        if (f[t][x][y] != -1) return f[t][x][y];
        
        if (t % 2 == 0)
        {
           
            boolean cat_win = true;
            for (int next : graph[x])
            {
                int r = find(graph, f, t + 1, next, y);
                if (r == 1)
                {
                    return f[t][x][y] = 1;
                }
                if (r == 0)
                {
                    cat_win = false;
                }
            }
            if (cat_win) return f[t][x][y] = 2;
            else return f[t][x][y] = 0;
        }
        else
        {
            boolean mouse_win = true;
            for (int next : graph[y])
            {
                if (next == 0) continue; 
                int r = find(graph, f, t + 1, x, next);
                if (r == 2)
                {
                    return f[t][x][y] = 2;
                }
                if (r == 0)
                {
                    mouse_win = false;
                }
            }
            if (mouse_win) return f[t][x][y] = 1;
            else return f[t][x][y] = 0;
        }
    }
    
    void fill(int[][][] f, int val)
    {
        for (int i = 0; i < f.length; ++i)
        {
            for (int j = 0; j < f[i].length; ++j)
            {
                Arrays.fill(f[i][j], val);
            }
        }
    }
}
