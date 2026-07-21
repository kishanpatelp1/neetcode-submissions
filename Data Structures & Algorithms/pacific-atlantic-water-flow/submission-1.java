class Solution {
    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();

        boolean pacific[][] = new boolean[n][m];
        boolean atlantic[][] = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            dfs(heights, pacific, i, 0);
            dfs(heights, atlantic, i, m-1);
        }

        for (int j = 0; j < m; j++) {
            dfs(heights, pacific, 0, j);
            dfs(heights, atlantic, n-1, j);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j])
                    res.add(Arrays.asList(i, j));
            }
        }

        return res;
    }

    void dfs(int[][] heights, boolean[][] visited, int r, int c) {
        visited[r][c] = true;
        int n = heights.length;
        int m = heights[0].length;

        for (int[] d : dir) {
            int x = r + d[0];
            int y = c + d[1];

            if (x < 0 || y < 0 || x >= n || y >= m) continue;
            if (heights[x][y] < heights[r][c]) continue;
            if (visited[x][y]) continue;

            dfs(heights, visited, x, y);
        }
    }
}
