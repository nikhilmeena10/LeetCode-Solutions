import java.util.ArrayList;
import java.util.List;

public class _650_2_Keys_Keyboard {

    //Official sol
    public int minSteps2(int n) {
        int sum = 0, div = 2;
        while (n != 1) {
            while (n > 0 && n % div == 0) {
                sum += div;
                n /= div;
            }
            div++;
        }
        return sum;
    }

    //My sol
    public int minSteps(int n) {
        if (n <= 1) return 0;
        int[] dp = new int[n + 1];
        dp[1] = 0;
        List<Integer> f = new ArrayList<>();
        f = getFactors(n);
        for (int i : f) {
            List<Integer> factors = getFactors(i);
            dp[i] = i;
            for (int j : factors) {
                int div = i / j;
                dp[i] = Math.min(dp[i], dp[j] + div);
            }
        }
        dp[n] = n;
        for (int j : f) {
            int div = n / j;
            dp[n] = Math.min(dp[n], dp[j] + div);
        }
        return dp[n];
    }

    private List<Integer> getFactors(int a) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i < a; i++) {
            if (a % i == 0) factors.add(i);
        }
        return factors;
    }
}
