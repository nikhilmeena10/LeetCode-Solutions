import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _47_Permutations_II {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        Arrays.sort(nums);
        permuteUnique(ans, new ArrayList<>(), new boolean[nums.length], nums);
        return ans;
    }

    public void permuteUnique(List<List<Integer>> list, List<Integer> tempList, boolean[] used, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                used[i] = true;
                tempList.add(nums[i]);
                permuteUnique(list, tempList, used, nums);
                tempList.remove(tempList.size() - 1);
                used[i] = false;
            }
        }
    }

}
