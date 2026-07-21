class Solution {
    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();

        boolean pacific[][] = new boolean[n][m];
        boolean atlantic[][] = new boolean[n][m];
        Queue<int[]> pacificQ = new ArrayDeque<>();
        Queue<int[]> atlanticQ = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            pacificQ.offer(new int[]{i, 0});
            atlanticQ.offer(new int[]{i, m-1});
        }

        for (int j = 0; j < m; j++) {
            pacificQ.offer(new int[]{0, j});
            atlanticQ.offer(new int[]{n-1, j});
        }
        bfs(heights, pacificQ, pacific);
        bfs(heights, atlanticQ, atlantic);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j])
                    res.add(Arrays.asList(i, j));
            }
        }

        return res;
    }

    void bfs(int[][] heights, Queue<int[]> q, boolean[][] visited) {
        int n = heights.length;
        int m = heights[0].length;

        while (!q.isEmpty()) {
            int curInd[] = q.poll();
            visited[curInd[0]][curInd[1]] = true;

            for (int[] d : dir) {
                int x = curInd[0] + d[0];
                int y = curInd[1] + d[1];

                if (x < 0 || y < 0 || x >= n || y >= m) continue;
                if (heights[x][y] < heights[curInd[0]][curInd[1]]) continue;
                if (visited[x][y]) continue;

                q.offer(new int[]{x, y});
            }
        }
    }
}
