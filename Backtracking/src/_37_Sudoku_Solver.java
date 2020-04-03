public class _37_Sudoku_Solver {

    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int i, int j) {
        if (j == 9) {
            return solve(board, i + 1, 0);
        }
        if (i == 9) {
            return true;
        }
        if (board[i][j] != '.') {
            return solve(board, i, j + 1);
        }
        for (int k = 1; k <= 9; k++) {
            if (insertPossible(i, j, (char) (k + 48), board)) {
                board[i][j] = (char) (k + 48);
                if (solve(board, i, j + 1)) return true;
                board[i][j] = '.';
            }
        }
        return false;
    }

    private boolean insertPossible(int x, int y, char c, char[][] board) {
        //check row
        for (int j = 0; j < 9; j++) {
            if (board[x][j] == c) return false;
        }
        //check column
        for (int i = 0; i < 9; i++) {
            if (board[i][y] == c) return false;
        }
        //check box
        int row = x / 3 * 3;
        int col = y / 3 * 3;
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (board[i][j] == c) return false;
            }
        }
        return true;
    }

}
