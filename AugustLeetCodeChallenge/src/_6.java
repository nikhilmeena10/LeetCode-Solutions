import java.util.ArrayList;
import java.util.List;

public class _6 {

    //no extra space and O(n) time
    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) ans.add(Math.abs(nums[i]));
            nums[index] = -nums[index];
        }
        return ans;
    }

    //my sol
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[nums[i] - 1]++;
            if (arr[nums[i] - 1] == 2) list.add(nums[i]);
        }
        return list;
    }
}
