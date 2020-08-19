import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class _18 {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            list.add(i);
        }
        if (n == 1) {
            list.add(0);
            int[] arr = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                arr[i] = list.get(i);
            }
            return arr;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i : list) {
            q.add(i);
        }
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 1; i <= size; i++) {
                int num = q.remove();
                int d = (int) (Math.log10(num) + 1);
                if (d == n) ans.add(num);
                else {
                    int ld = num % 10;
                    if (k != 0) {
                        if (ld + k <= 9) {
                            q.add(num * 10 + (ld + k));
                        }
                        if (ld - k >= 0) {
                            q.add(num * 10 + (ld - k));
                        }
                    } else {
                        q.add(num * 10 + (ld + k));
                    }
                }
            }
        }
        int[] arr = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            arr[i] = ans.get(i);
        }
        return arr;
    }
}
