import java.util.ArrayDeque;
import java.util.Queue;

public class _9 {

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Cell> q = new ArrayDeque<>();
        int onec = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Cell(i, j));
                } else if (grid[i][j] == 1) onec++;
            }
        }
        if (onec == 0) return 0;
        if (q.isEmpty()) return -1;
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            boolean didOneRot = false;
            for (int qi = 1; qi <= size; qi++) {
                Cell cell = q.remove();
                int i = cell.i;
                int j = cell.j;
                if (i + 1 < m && grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 2;
                    q.add(new Cell(i + 1, j));
                    didOneRot = true;
                }
                if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                    grid[i][j - 1] = 2;
                    q.add(new Cell(i, j - 1));
                    didOneRot = true;
                }
                if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                    q.add(new Cell(i - 1, j));
                    didOneRot = true;
                }
                if (j + 1 < n && grid[i][j + 1] == 1) {
                    grid[i][j + 1] = 2;
                    q.add(new Cell(i, j + 1));
                    didOneRot = true;
                }
                grid[i][j] = 0;
            }
            if (didOneRot) count++;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) return -1;
            }
        }
        return count;
    }

    class Cell {
        int i, j;

        public Cell(int r, int c) {
            i = r;
            j = c;
        }
    }

}
