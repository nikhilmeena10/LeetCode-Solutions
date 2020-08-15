import java.util.ArrayList;
import java.util.List;

public class _120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> first = triangle.get(0);
        List<Integer> two = new ArrayList<>();
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> level = triangle.get(i);
            for (int j = 0; j < level.size(); j++) {
                if (j == 0) {
                    two.add(first.get(0) + level.get(0));
                } else if (j == level.size() - 1) {
                    two.add(first.get(first.size() - 1) + level.get(level.size() - 1));
                } else {
                    two.add(level.get(j) + Math.min(first.get(j - 1), first.get(j)));
                }
            }
            first = two;
            two = new ArrayList<>();
        }
        int min = first.get(0);
        for (int i : first) {
            min = Math.min(min, i);
        }
        return min;
    }
}
