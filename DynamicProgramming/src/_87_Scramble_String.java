public class _87_Scramble_String {

    //
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;
        int[] charset = new int[26];
        int len = s1.length();
        for (int i = 0; i < len; i++) {
            charset[s1.charAt(i) - 'a']++;
            charset[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (charset[i] != 0) return false;
        }
        for (int i = 1; i < len; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            } else if (isScramble(s1.substring(0, i), s2.substring(len - i)) && isScramble(s1.substring(i), s2.substring(0, len - i))) {
                return true;
            }
        }
        return false;
    }

    //TODO Understand how 3D dp is visualized
    //https://leetcode.com/problems/scramble-string/discuss/29396/Simple-iterative-DP-Java-solution-with-explanation
    public boolean isScrambleDP(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;
        int len = s1.length();
        boolean[][][] F = new boolean[len][len][len + 1];
        for (int k = 1; k <= len; k++) {
            for (int i = 0; i + k <= len; i++) {
                for (int j = 0; j + k <= len; j++) {
                    if (k == 1) {
                        F[i][j][k] = (s1.charAt(i) == s2.charAt(j));
                    } else {
                        for (int q = 1; q < k && !F[i][j][k]; q++) {
                            F[i][j][k] = (F[i][j][q] && F[i + q][j + q][k - q]) || (F[i][j + k - q][q] && F[i + q][j][k - q]);
                        }
                    }
                }
            }
        }
        return F[0][0][len];
    }

}
