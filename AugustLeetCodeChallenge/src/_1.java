public class _1 {
    public boolean detectCapitalUse(String word) {
        int len = word.length();
        int count = 0;
        boolean first = false;
        for (int i = 0; i < len; i++) {
            char ch = word.charAt(i);
            if (Character.isUpperCase(ch)) {
                if (i == 0) first = true;
                count++;
                if (count < (i + 1)) return false;
            }
        }
        if (count == len) return true;
        if (count == 0) return true;
        if (count == 1 && first) return true;
        return false;
    }
}
