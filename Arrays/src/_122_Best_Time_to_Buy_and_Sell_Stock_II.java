public class _122_Best_Time_to_Buy_and_Sell_Stock_II {

    //peak-valley approach
    public int maxProfit(int[] prices) {
        int i = 0, N = prices.length - 1;
        int buy = 0, sell = 0, profit = 0;
        while (i < N) {
            while (i < N && prices[i + 1] <= prices[i]) i++;
            buy = prices[i];

            while (i < N && prices[i + 1] > prices[i]) i++;
            sell = prices[i];

            profit += sell - buy;
        }
        return profit;
    }

    //simplified version of above
    public int maxProfit2(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

}
