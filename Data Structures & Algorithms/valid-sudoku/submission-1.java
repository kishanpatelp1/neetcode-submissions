class Solution { 
    public boolean isValidSudoku(char[][] board) {
        int row[] = new int[10];
        int col[] = new int[10];
        int box[] = new int[10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;

                int digit = board[i][j] - '0';
                int boxIndex = i/3 * 3 + j/3;
                int mask = 1 << digit;
                if ((row[i] & mask)  != 0 || (col[j] & mask) != 0 || (box[boxIndex] & mask) != 0) return false;
                row[i] = (row[i] | mask);
                col[j] = col[j] | mask;
                box[boxIndex] |= mask;
            }
        }

        return true;
    }
}
