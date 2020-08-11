import java.util.Arrays;

public class _11 {
    public int hIndex(int[] citations) {
        int len = citations.length;
        if (len == 0) return 0;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            if (len <= citations[i]) return len;
            else len--;
        }
        return len;
    }
}
