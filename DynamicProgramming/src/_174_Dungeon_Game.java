public class _174_Dungeon_Game {

    //TODO thoroughly go through logic
    public int calculateMinimumHP(int[][] dungeon) {
        int r = dungeon.length;
        int c = dungeon[0].length;
        int[][] dp = new int[r][c];
        for (int i = r - 1; i >= 0; i--) {
            for (int j = c - 1; j >= 0; j--) {
                if (i + 1 < r && j + 1 < c) {
                    int val1 = Math.max(1, dp[i][j + 1] - dungeon[i][j]);
                    int val2 = Math.max(1, dp[i + 1][j] - dungeon[i][j]);
                    dp[i][j] = Math.min(val1, val2);
                } else if (i + 1 < r) {
                    dp[i][j] = Math.max(1, dp[i + 1][j] - dungeon[i][j]);
                } else if (j + 1 < c) {
                    dp[i][j] = Math.max(1, dp[i][j + 1] - dungeon[i][j]);
                } else {
                    dp[i][j] = Math.max(1, 1 - dungeon[i][j]);
                }
            }
        }
        return dp[0][0];
    }
}
