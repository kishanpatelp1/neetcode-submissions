class Solution { 
    public int maxAreaOfIsland(int[][] grid) { 
        int m = grid.length; 
        int n = grid[0].length; 
        Queue<int[]> q = new LinkedList<>(); 
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; 
        int max = 0; 
        
        for (int i = 0; i < m; i++) { 
            for (int j = 0; j < n; j++) { 
                if (grid[i][j] == 1) { 
                    q.offer(new int[]{i, j}); 
                    grid[i][j] = 0;
                    int area = 0; 
                    
                    while (!q.isEmpty()) { 
                        int[] index = q.poll(); 
                        area++;
                        
                        for (int[] d : dir) { 
                            int r = index[0] + d[0]; 
                            int c = index[1] + d[1]; 
                            
                            if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1) { 
                                q.offer(new int[]{r, c});
                                grid[r][c] = 0; 
                            } 
                        } 
                    } 
                    max = Math.max(max, area); 
                } 
            } 
        } 
        return max;
    } 
}
