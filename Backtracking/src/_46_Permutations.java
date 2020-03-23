import java.util.ArrayList;
import java.util.List;

public class _46_Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        permute(list, new boolean[nums.length], new ArrayList<>(), nums);
        return list;
    }

    private static void permute(List<List<Integer>> list, boolean[] visited, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) continue;
                visited[i] = true;
                tempList.add(nums[i]);
                permute(list, visited, tempList, nums);
                tempList.remove(tempList.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> list = permute(nums);
    }

}
