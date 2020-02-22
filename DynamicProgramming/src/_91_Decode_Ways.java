public class _91_Decode_Ways {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) > '0' && s.charAt(i) <= '9') {
                dp[i + 1] += dp[i];
            }
            if (i > 0) {
                int t = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
                if (t >= 10 && t <= 26) {
                    dp[i + 1] += dp[i - 1];
                }
            }
        }
        return dp[len];
    }

}
