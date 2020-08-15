import java.util.Arrays;

public class _15 {

    //also check how sorting by end of interval works
    //basically compare the ends of intervals. An interval ending
    //earlier will allow more intervals to be used after it. Hence, if
    //overlap occurs, remove the one which has a larger end. Update end
    //as you go forward
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int end = intervals[0][1];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (end > intervals[i][0]) {
                count++;
                end = Math.min(end, intervals[i][1]);
            } else {
                end = intervals[i][1];
            }
        }
        return count;
    }
}
