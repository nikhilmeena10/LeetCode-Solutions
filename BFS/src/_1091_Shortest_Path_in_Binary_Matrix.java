import java.util.ArrayDeque;
import java.util.Queue;

public class _1091_Shortest_Path_in_Binary_Matrix {

    //try using dist array [{-1,-1},{-1,0} ....
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) return -1;
        boolean[][] visited = new boolean[m][n];
        Queue<Cell> q = new ArrayDeque<>();
        q.add(new Cell(0, 0, 1));
        visited[0][0] = true;
        while (!q.isEmpty()) {
            Cell curr = q.remove();
            int x = curr.x;
            int y = curr.y;
            int dist = curr.d;
            if (x == m - 1 && y == n - 1) return dist;
            if (x - 1 >= 0 && grid[x - 1][y] != 1 && !visited[x - 1][y]) {
                q.add(new Cell(x - 1, y, dist + 1));
                visited[x - 1][y] = true;
            }
            if (x - 1 >= 0 && y + 1 < n && grid[x - 1][y + 1] != 1 && !visited[x - 1][y + 1]) {
                q.add(new Cell(x - 1, y + 1, dist + 1));
                visited[x - 1][y + 1] = true;
            }
            if (y + 1 < n && grid[x][y + 1] != 1 && !visited[x][y + 1]) {
                q.add(new Cell(x, y + 1, dist + 1));
                visited[x][y + 1] = true;
            }
            if (x + 1 < m && y + 1 < n && grid[x + 1][y + 1] != 1 && !visited[x + 1][y + 1]) {
                q.add(new Cell(x + 1, y + 1, dist + 1));
                visited[x + 1][y + 1] = true;
            }
            if (x + 1 < m && grid[x + 1][y] != 1 && !visited[x + 1][y]) {
                q.add(new Cell(x + 1, y, dist + 1));
                visited[x + 1][y] = true;
            }
            if (x + 1 < m && y - 1 >= 0 && grid[x + 1][y - 1] != 1 && !visited[x + 1][y - 1]) {
                q.add(new Cell(x + 1, y - 1, dist + 1));
                visited[x + 1][y - 1] = true;
            }
            if (y - 1 >= 0 && grid[x][y - 1] != 1 && !visited[x][y - 1]) {
                q.add(new Cell(x, y - 1, dist + 1));
                visited[x][y - 1] = true;
            }
            if (x - 1 >= 0 && y - 1 >= 0 && grid[x - 1][y - 1] != 1 && !visited[x - 1][y - 1]) {
                q.add(new Cell(x - 1, y - 1, dist + 1));
                visited[x - 1][y - 1] = true;
            }
        }
        return -1;
    }

    class Cell {
        int x, y, d;

        public Cell(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

}
