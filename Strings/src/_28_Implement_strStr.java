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

}
