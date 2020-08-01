import java.util.HashSet;
import java.util.Set;

public class _983_Minimum_Cost_For_Tickets {
    public int mincostTickets(int[] days, int[] costs) {
        int len = days.length;
        Set<Integer> set = new HashSet<>();
        for (int day : days) {
            set.add(day);
        }
        int[] dp = new int[366];
        dp[0] = 0;
        int start = days[0];
        int end = days[len - 1];
        for (int i = start; i <= end; i++) {
            if (!set.contains(i)) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + costs[0];
                dp[i] = Math.min(dp[i], dp[Math.max(i - 7, 0)] + costs[1]);
                dp[i] = Math.min(dp[i], dp[Math.max(i - 30, 0)] + costs[2]);
            }
        }
        return dp[end];
    }
}
