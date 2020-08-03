public class _3 {

    public boolean isPalindrome(String s) {
        if (s == null) return false;
        int len = s.length();
        if (len == 0) return true;
        int i = 0, j = len - 1;
        while (i <= j) {
            while (i < len && !Character.isLetterOrDigit(s.charAt(i))) i++;
            if (i > j) break;
            char ci = Character.toLowerCase(s.charAt(i));
            while (j >= 0 && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if (j < i) break;
            char cj = Character.toLowerCase(s.charAt(j));
            if (ci != cj) return false;
            i++;
            j--;
        }
        return true;
    }

}
