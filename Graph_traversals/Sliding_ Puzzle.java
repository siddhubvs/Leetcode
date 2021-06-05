class Solution {
    public int slidingPuzzle(int[][] board) {
        int pos = 0;
        StringBuilder sb = new StringBuilder();
        int[] dirs = {-1, 1, -3, 3};
        Set<String> visited = new HashSet();
        Queue<String> q = new LinkedList();
        
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }
        q.offer(sb.toString());
        visited.add(sb.toString());
        return bfs(q, dirs, visited);
    }
    
    private int bfs(Queue<String> q, int[] dirs, Set<String> visited) {
        int move = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                String s1 = q.poll();
                if(s1.equals("123450"))
                    return move;
                int pos = s1.indexOf("0");
                for(int dir: dirs) {
                    int idx = pos + dir;
                    if(idx < 0 || idx > 5 || (pos == 2 && dir == 1) || (pos == 3 && dir == -1)) 
                        continue;
                    String s2 = exch(s1, pos, idx);
                    if(!visited.contains(s2)) {
                        visited.add(s2);
                        q.offer(s2);
                    }
                }
            }
            move++;
        }
        return -1;
    }
    
    
    private String exch(String str, int temp, int idx) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(temp, str.charAt(idx));
        sb.setCharAt(idx,  str.charAt(temp));
        return sb.toString();
    }
}
