public class _10 {

    //also see alternate solution in discuss. What if length was not known previously?
    //remember result = result*26 + s.charAt(i)-'A'-1 going from 0 to ....
    //similar to converting binary to decimal when length is not known before
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
