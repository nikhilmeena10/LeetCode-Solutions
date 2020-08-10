public class _10 {

    public int titleToNumber(String s) {
        int len = s.length();
        int pow = len - 1;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            int val = s.charAt(i) - 'A' + 1;
            sum += Math.pow(26, pow) * val;
            pow--;
        }
        return sum;
    }

}
