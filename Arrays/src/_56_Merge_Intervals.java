import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _56_Merge_Intervals {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 1) return intervals;
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] curr = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= curr[1]) {
                curr[1] = Math.max(curr[1], intervals[i][1]);
            } else {
                ans.add(curr);
                curr = intervals[i];
            }
        }
        ans.add(curr);
        return ans.toArray(new int[0][]);
    }

}
