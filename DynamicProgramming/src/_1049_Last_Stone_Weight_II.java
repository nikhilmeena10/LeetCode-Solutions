public class _1049_Last_Stone_Weight_II {

    //question is essentially to divide the array into two sets such that the difference of their
    //sums is minimum. The best case for one subset sum is to be total_sum/2. So we try to find if
    //there exists a subset with sum as close to total_sum/2 as possible. This closest sum can then
    //be used to find the minimum difference as S1-S2 or (total_sum - S2) -S2 = total_sum - 2*S2.
    //To check if there exists a subset from the given array with sum equal to any of 1...total_sum/2
    //we can use a knapsack style dp.
    public int lastStoneWeightII(int[] stones) {
        int total = 0;
        int n = stones.length;
        for (int i = 0; i < n; i++) {
            total += stones[i];
        }
        boolean[][] dp = new boolean[n + 1][total / 2 + 1];
        int maxS2 = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= total / 2; j++) {
                if (stones[i - 1] == j) dp[i][j] = true;
                else if (j > stones[i - 1]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - stones[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
                if (dp[i][j]) maxS2 = Math.max(maxS2, j);
            }
        }
        /*int maxS2 = 0;
        for(int j=total/2; j>=0; j--) {
            if(dp[n][j]) {
                maxS2 = j;
                break;
            }
        }*/
        return total - 2 * maxS2;
    }

}
