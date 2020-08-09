import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _8 {

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //my original sol, considering all sums ending at current node and updating list which maintains it: 51ms
    class Solution1 {

        int count;

        public int pathSum(TreeNode root, int sum) {
            count = 0;
            calc(root, sum, new ArrayList<>());
            return count;
        }

        private void calc(TreeNode root, int sum, List<Integer> list) {
            if (root == null) return;
            if (root.val == sum) count++;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == (sum - root.val)) count++;
                list.set(i, list.get(i) + root.val);
            }
            list.add(root.val);
            calc(root.left, sum, list);
            calc(root.right, sum, list);
            for (int i = 0; i < list.size() - 1; i++) {
                list.set(i, list.get(i) - root.val);
            }
            list.remove(list.size() - 1);
        }

    }

    //taking hint from discussion, using prefixsum to check for prefixsum-sum and not sum-currval --2ms
    class Solution2 {

        int count;

        public int pathSum(TreeNode root, int sum) {
            count = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            dfs(root, sum, map, 0);
            return count;
        }

        public void dfs(TreeNode root, int sum, Map<Integer, Integer> map, int prefixSum) {
            if (root == null) return;
            prefixSum += root.val;
            if (map.containsKey(prefixSum - sum)) {
                count += map.get(prefixSum - sum);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
            dfs(root.left, sum, map, prefixSum);
            dfs(root.right, sum, map, prefixSum);
            map.put(prefixSum, map.get(prefixSum) - 1);
        }
    }
}
