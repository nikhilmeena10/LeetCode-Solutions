public class _13 {
    class CombinationIterator {

        private String s;
        private int[] arr;
        private int len;
        private int count;
        private int total;

        public CombinationIterator(String characters, int combinationLength) {
            s = characters;
            arr = new int[combinationLength];
            len = combinationLength;
            for (int i = 0; i < combinationLength; i++) {
                arr[i] = i;
            }
            count = 0;
            total = 0;
            long run = 1;
            int num = s.length(), den = 1;
            for (int i = 1; i <= len; i++) {
                run *= num;
                run /= den;
                num--;
                den++;
            }
            total = (int) run;
        }

        public String next() {
            if (hasNext()) {
                StringBuilder sb = new StringBuilder();
                for (int ci : arr) {
                    sb.append(s.charAt(ci));
                }
                int end = s.length() - 1;
                int i = 0, j;
                for (j = len - 1; j >= 0; j--, end--) {
                    int index = arr[j];
                    if (index != (end)) {
                        i = j;
                        break;
                    }
                }
                arr[i] += 1;
                i++;
                while (i < len) {
                    arr[i] = arr[i - 1] + 1;
                    i++;
                }
                count++;
                return sb.toString();
            } else return null;
        }

        public boolean hasNext() {
            return count < total;
        }
    }

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
}
