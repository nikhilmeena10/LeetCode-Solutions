import java.util.Arrays;

public class _322_Coin_Change {

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    //2d dp --> see how it is dp[i][j-....] instead of dp[i-1][j-....]
    //this is because coin supply is infinite, so we can try for lower values
    //of the amount itself. If only one coin of each was allowed, we would have to
    //use another and hence, i-1
    public int coinChange2(int[] coins, int amount) {
        int len = coins.length;
        int[][] dp = new int[len + 1][amount + 1];
        for (int i = 0; i <= len; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i <= len; i++) {
            dp[i][0] = 0;
        }
        int min = Integer.MAX_VALUE;
        for (int j = 1; j <= amount; j++) {
            for (int i = 1; i <= len; i++) {
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], (dp[i][j - coins[i - 1]] == Integer.MAX_VALUE) ? Integer.MAX_VALUE : 1 + dp[i][j - coins[i - 1]]);
                }
                min = Math.min(min, dp[i][j]);
            }
        }
        return dp[len][amount] == Integer.MAX_VALUE ? -1 : dp[len][amount];
    }

}
