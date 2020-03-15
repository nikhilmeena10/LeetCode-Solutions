import java.util.ArrayList;
import java.util.List;

public class _54_Spiral_Matrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null) return ans;
        int m = matrix.length;
        if (m == 0) return ans;
        int n = matrix[0].length;
        int count = m * n;
        int rb = n - 1;
        int bb = m - 1;
        int lb = 0;
        int tb = 0;
        while (ans.size() < count) {
            for (int j = lb; j <= rb && ans.size() < count; j++) {
                ans.add(matrix[tb][j]);
            }
            for (int i = tb + 1; i <= bb - 1 && ans.size() < count; i++) {
                ans.add(matrix[i][rb]);
            }
            for (int j = rb; j >= lb && ans.size() < count; j--) {
                ans.add(matrix[bb][j]);
            }
            for (int i = bb - 1; i >= tb + 1 && ans.size() < count; i--) {
                ans.add(matrix[i][lb]);
            }
            rb--;
            bb--;
            lb++;
            tb++;
        }
        return ans;
    }

}
