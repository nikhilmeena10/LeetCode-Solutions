public class _14_Longest_Common_Prefix {

    public String longestCommonPrefix(String[] strs) {
        if ((strs == null) || (strs.length == 0)) return "";
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            if (i >= strs[0].length()) return sb.toString();
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                String s = strs[j];
                if (i >= s.length()) return sb.toString();
                if (s.charAt(i) != ch) return sb.toString();
            }
            sb.append(ch);
            i++;
        }
    }

}
