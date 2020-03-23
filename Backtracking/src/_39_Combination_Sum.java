import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _39_Combination_Sum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain < 0) return;
        if (remain == 0) list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length && nums[i] <= remain; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, remain - nums[i], i); //not i+1 because duplicates allowed
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 7};
        int target = 7;
        List<List<Integer>> ans = combinationSum(nums, target);
    }

}
