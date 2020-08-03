import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _279_Perfect_Squares {

    //discuss
    //since only i-1 is needed, convert to 1D array
    //we are going from 1,2,3..., so i-1 case is covered sequentially
    public int numSquares2(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while (j * j <= i) {
                min = Math.min(min, dp[i - j * j] + 1);
                j++;
            }
            dp[i] = min;
        }
        return dp[n];
    }

    //my Sol
    public int numSquares(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            int sq = i * i;
            if (sq <= n) list.add(sq);
        }
        int r = list.size();
        int c = n;
        int[][] dp = new int[r + 1][c + 1];
        for (int j = 1; j <= c; j++) {
            dp[0][j] = Integer.MAX_VALUE;
        }
        for (int j = 1; j <= c; j++) {
            for (int i = 1; i <= r; i++) {
                if (list.get(i - 1) > j) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - list.get(i - 1)]);
            }
        }
        return dp[r][c];
    }

}
