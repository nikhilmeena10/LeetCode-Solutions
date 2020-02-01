public class _5_Longest_Palindromic_Substring {

    //simple soln from comments
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        int start = 0, end = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            int left = i, right = i;
            while (left >= 0 && s.charAt(left) == c) {
                left--;
            }
            while (right < len && s.charAt(right) == c) {
                right++;
            }
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
                left--;
                right++;
            }
            left = left + 1;
            if (end - start < right - left) {
                start = left;
                end = right;
            }
        }
        return s.substring(start, end);
    }

    //Official soln
    /*public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }*/

    //my initial dp soln
    /*public String longestPalindrome(String s) {
        if (s == null) return s;
        int len = s.length();
        if (len == 0) return s;
        int[][] matrix = new int[len][len];
        int max = 0;
        int i = 0, j = 0, k = 0;
        int ai = 0, aj = 0;
        while (j < len) {
            for (i = 0; j < len; j++, i++) {
                if (i == j) {
                    matrix[i][j] = 1;
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        if (matrix[i + 1][j - 1] != 0) {
                            matrix[i][j] = 2 + matrix[i + 1][j - 1];
                        } else {
                            if (Math.abs(j - i) == 1) {
                                matrix[i][j] = 2;
                            }
                        }
                    }
                }
                if (max < matrix[i][j]) {
                    max = matrix[i][j];
                    ai = i;
                    aj = j;
                }
            }
            k++;
            j = k;
        }
        return s.substring(ai, aj + 1);
    }*/
}
