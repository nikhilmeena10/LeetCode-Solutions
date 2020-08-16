public class _16 {

    //TODO optimize, this is slow
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int len = prices.length;
        int totalK = 2;
        int[][] dp = new int[totalK + 1][len];
        for (int k = 1; k <= totalK; k++) {
            for (int i = 1; i < len; i++) {
                int maxProfitSellOnDayI = Math.max(0, prices[i] - prices[0]);
                for (int j = 1; j < i; j++) {
                    maxProfitSellOnDayI = Math.max(maxProfitSellOnDayI, prices[i] - prices[j] + dp[k - 1][j - 1]);
                }
                dp[k][i] = Math.max(dp[k][i - 1], maxProfitSellOnDayI);
            }
        }
        return dp[totalK][len - 1];
    }

}
