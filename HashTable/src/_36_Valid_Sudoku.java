import java.util.HashSet;
import java.util.Set;

public class _36_Valid_Sudoku {

    //My solution using 3 loops
    public boolean isValidSudoku(char[][] board) {
        Set<Character> nine = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            nine.clear();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!nine.add(board[i][j])) {
                        return false;
                    }
                }
            }
        }
        for (int j = 0; j < 9; j++) {
            nine.clear();
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    if (!nine.add(board[i][j])) {
                        return false;
                    }
                }
            }
        }
        int bi = 0, bj = 0;
        while (bi < 9 && bj < 9) {
            nine.clear();
            for (int i = bi; i < bi + 3; i++) {
                for (int j = bj; j < bj + 3; j++) {
                    if (board[i][j] != '.') {
                        if (!nine.add(board[i][j])) {
                            return false;
                        }
                    }
                }
            }
            bj += 3;
            if (bj >= 9) {
                if (bi < 9) {
                    bi += 3;
                    bj = 0;
                } else {
                    break;
                }
            }
        }
        return true;
    }

    //Interesting solution in discussion; way slower tho
    /*
    public boolean isValidSudoku(char[][] board) {
        Set<String> sudoku = new HashSet<>();
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(board[i][j] != '.') {
                    if(!sudoku.add(board[i][j] + " in row " + i) ||
                    !sudoku.add(board[i][j] + " in column " + j) ||
                    !sudoku.add(board[i][j] + " in box " + i/3 + " " + j/3))
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }
     */

}
