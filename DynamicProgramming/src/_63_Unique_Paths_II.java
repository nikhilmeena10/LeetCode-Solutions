public class _63_Unique_Paths_II {

    //TODO: Check 1D solution
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        if (obstacleGrid[0][0] != 1) dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (obstacleGrid[i][j] == 0 && i - 1 >= 0 && j - 1 >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else if (obstacleGrid[i][j] == 0 && i - 1 >= 0) {
                    dp[i][j] = dp[i - 1][j];
                } else if (obstacleGrid[i][j] == 0 && j - 1 >= 0) {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[n - 1][m - 1];
    }

}
