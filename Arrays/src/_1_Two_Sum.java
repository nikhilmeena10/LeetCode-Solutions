import java.util.HashMap;
import java.util.Map;

class _1_Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (numsMap.containsKey(other)) {
                return new int[]{numsMap.get(other), i};
            }
            numsMap.put(nums[i], i);
        }
        return null;
    }
}
