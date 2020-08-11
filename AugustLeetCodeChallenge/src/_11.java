import java.util.Arrays;

public class _11 {

    //check discuss on count/bucket sort technique
    //plus also post on whether sorting allowed in interview or not
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
