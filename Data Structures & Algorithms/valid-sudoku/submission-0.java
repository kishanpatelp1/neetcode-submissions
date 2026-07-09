class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean row[][] = new boolean[10][10];
        boolean col[][] = new boolean[10][10];
        boolean box[][] = new boolean[10][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;

                int digit = board[i][j] - '0';
                int boxIndex = i/3 * 3 + j/3;
                if (row[i][digit] || col[j][digit] || box[boxIndex][digit]) return false;
                row[i][digit] = true;
                col[j][digit] = true;
                box[boxIndex][digit] = true;
            }
        }

        return true;
    }
}
