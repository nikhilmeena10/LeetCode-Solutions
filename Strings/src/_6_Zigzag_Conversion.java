public class _6_Zigzag_Conversion {
    public String convert(String s, int numRows) {
        int len = s.length();
        StringBuilder[] sbl = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbl[i] = new StringBuilder();
        }
        int i = 0, idx = 0;
        while (i < len) {
            for (idx = 0; idx < numRows && i < len; idx++) {
                sbl[idx].append(s.charAt(i++));
            }
            for (idx = numRows - 2; idx >= 1 && i < len; idx--) {
                sbl[idx].append(s.charAt(i++));
            }
        }
        for (int j = 1; j < numRows; j++) {
            sbl[0].append(sbl[j]);
        }
        return sbl[0].toString();
    }
}
