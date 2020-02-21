public class _62_Unique_Paths {

    //https://leetcode.com/problems/unique-paths/discuss/22958/Math-solution-O(1)-space
    //Math solution : (m+n)!/m!n! (m-=1, n-=1)
    public int uniquePathsMaths(int m, int n) {
        if (m == 1 && n == 1) return 1;
        if (m < n) {
            int tmp = m;
            m = n;
            n = tmp;
        }
        m -= 1;
        n -= 1;
        long ans = 1;
        for (int i = m + 1, j = 1; i <= m + n; i++, j++) {
            ans *= i;
            ans /= j;
        }
        return (int) ans;
    }

    //My solution
    //See O(n) space solution as well
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i - 1 >= 0 && j - 1 >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else if (i - 1 >= 0) {
                    dp[i][j] = dp[i - 1][j];
                } else if (j - 1 >= 0) {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[n - 1][m - 1];
    }

}
