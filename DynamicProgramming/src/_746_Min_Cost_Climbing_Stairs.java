public class _746_Min_Cost_Climbing_Stairs {

    //O(1) space
    public int minCostClimbingStairs2(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len];
        int first = cost[0];
        int second = cost[1];
        for (int i = 2; i < len; i++) {
            int curr = Math.min(first, second) + cost[i];
            first = second;
            second = curr;
        }
        return Math.min(first, second);
    }

    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < len; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[len - 1], dp[len - 2]);
    }

}
