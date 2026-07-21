class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean vis[][] = new boolean[n][m];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == '1') {
                    dfs(grid, vis, i, j);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    void dfs(char[][] grid, boolean[][] vis, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || vis[r][c] || grid[r][c] == '0'){
            return;
        }

        vis[r][c] = true;

        dfs(grid, vis, r+1, c);
        dfs(grid, vis, r, c+1);
        dfs(grid, vis, r-1, c);
        dfs(grid, vis, r, c-1);
    }
}
