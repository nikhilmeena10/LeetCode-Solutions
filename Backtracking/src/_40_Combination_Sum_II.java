import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _40_Combination_Sum_II {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(ans, new ArrayList<>(), candidates, target, 0);
        return ans;
    }

    private void combinationSum2(List<List<Integer>> list, List<Integer> tempList, int[] nums, int rem, int start) {
        if (rem < 0) return;
        else if (rem == 0) {
            list.add(new ArrayList<>(tempList));
        }
        for (int i = start; i < nums.length && nums[i] <= rem; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            tempList.add(nums[i]);
            combinationSum2(list, tempList, nums, rem - nums[i], i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

}
