public class _28_Implement_strStr {

    //Solution in comments
    public int strStr(String s, String t) {
        if (t.isEmpty()) return 0; // edge case: "",""=>0  "a",""=>0
        for (int i = 0; i <= s.length() - t.length(); i++) {
            for (int j = 0; j < t.length() && s.charAt(i + j) == t.charAt(j); j++)
                if (j == t.length() - 1) return i;
        }
        return -1;
    }

    //My Solution
    public int mystrStr(String haystack, String needle) {
        if ((needle == null) || (needle.length() == 0)) return 0;
        //if((haystack == null) || (haystack.length() == 0)) return 0;
        int curr = 0;
        for (int i = 0; i < haystack.length(); i++) {
            int j = i;
            while ((curr < needle.length()) && (j < haystack.length()) && (haystack.charAt(j) == needle.charAt(curr))) {
                j++;
                curr++;
            }
            if (curr >= needle.length()) {
                return i;
            } else {
                curr = 0;
            }
        }
        return -1;
    }

    //KMP
    public int strStrKMP(String haystack, String needle) {
        if (needle.equals("")) return 0;
        if (haystack.equals("")) return -1;
        int n = haystack.length();
        int m = needle.length();
        int[] lps = new int[m];
        int j = 0;
        computeLPSArray(needle, m, lps);
        int i = 0;
        while (i < n) {
            if (needle.charAt(j) == haystack.charAt(i)) {
                i++;
                j++;
            }
            if (j == m) {
                return i - j;
            } else if (i < n && needle.charAt(j) != haystack.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }
        return -1;
    }

    private void computeLPSArray(String pat, int m, int[] lps) {
        int len = 0;
        int i = 1;
        lps[0] = 0;
        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }

}
