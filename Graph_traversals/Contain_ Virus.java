class Solution {
    int m, n;
    int[] dx = new int[]{1,-1,0,0};
    int[] dy = new int[]{0,0,1,-1};
    
    boolean[][] visited;
    List<Set<Integer>> region;
    List<Set<Integer>> frontier;
    List<Integer> perimeter;
    
    public int containVirus(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int ans = 0;
        
        while (true) {
            visited = new boolean[m][n];
            region = new ArrayList<>();
            frontier = new ArrayList<>();
            perimeter = new ArrayList<>();
            
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1 && !visited[i][j]) {
                        frontier.add(new HashSet<>());
                        region.add(new HashSet<>());
                        perimeter.add(0);
                        dfs(grid, i, j);
                    }
                }
            }
        
            if (region.size() == 0) return ans;
            
            int max = 0;
            for (int i = 1; i < frontier.size(); i++) {
                if (frontier.get(i).size() > frontier.get(max).size()) max = i;
            }
            ans += perimeter.get(max);
            
            for (int i = 0; i < region.size(); ++i) {
                if (i == max) {
                    for (int code: region.get(i))
                        grid[code / n][code % n] = -1;
                } else {
                    for (int code: region.get(i)) {
                        int r = code / n, c = code % n;
                        for (int k = 0; k < 4; k++) {
                            int nr = r + dx[k], nc = c + dy[k];
                            if (nr >= 0 && nr < m && 
                                nc >= 0 && nc < n && 
                                grid[nr][nc] == 0)
                                grid[nr][nc] = 1;
                        }
                    }
                }
            }
        }
    }
    
    private void dfs(int[][] grid, int x, int y) {
        int len = region.size();
        region.get(len-1).add(x * n + y);
        visited[x][y] = true;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k], ny = y + dy[k];
            if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
            if (grid[nx][ny] == 1 && !visited[nx][ny]) dfs(grid, nx, ny);
            else if (grid[nx][ny] == 0) {
                frontier.get(len-1).add(nx * n + ny);
                perimeter.set(len-1, perimeter.get(len-1)+1);
            }
        }
    }
}
