class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m]; 

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, vis, 0))
                        return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, boolean[][] vis, int index) {
        if (index == word.length())
            return true;
            
        int n = board.length;
        int m = board[0].length;
        
        if (i < 0 || i >= n || j < 0 || j >= m || vis[i][j] || board[i][j] != word.charAt(index))
            return false;
            
        vis[i][j] = true;

        boolean found = dfs(board, word, i + 1, j, vis, index + 1) ||
                        dfs(board, word, i, j + 1, vis, index + 1) ||
                        dfs(board, word, i - 1, j, vis, index + 1) ||
                        dfs(board, word, i, j - 1, vis, index + 1);
                        
        vis[i][j] = false; 

        return found;
    }
}
