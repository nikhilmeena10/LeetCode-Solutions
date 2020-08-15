public class _474_Ones_and_Zeroes {

    //TODO - see how to use 2d dp
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len + 1][m + 1][n + 1];
        for (int si = 1; si <= len; si++) {
            String s = strs[si - 1];
            int zero = 0, one = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') one++;
                else zero++;
            }
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    if (si == 0) {
                        dp[si][i][j] = 0;
                    } else if (i >= zero && j >= one) {
                        dp[si][i][j] = Math.max(dp[si - 1][i][j], 1 + dp[si - 1][i - zero][j - one]);
                    } else {
                        dp[si][i][j] = dp[si - 1][i][j];
                    }
                }
            }
        }
        return dp[len][m][n];
    }

}
