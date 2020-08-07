import java.util.*;

public class _7 {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();
        vt(root, 0, 0, map);
        for (Map.Entry<Integer, Map<Integer, List<Integer>>> entry : map.entrySet()) {
            int x = entry.getKey();
            Map<Integer, List<Integer>> map2 = entry.getValue();
            List<Integer> inner = new ArrayList<>();
            for (Map.Entry<Integer, List<Integer>> entry2 : map2.entrySet()) {
                int y = entry2.getKey();
                List<Integer> ylist = entry2.getValue();
                Collections.sort(ylist);
                inner.addAll(ylist);
            }
            ans.add(inner);
        }
        return ans;
    }

    private void vt(TreeNode root, int x, int y, Map<Integer, Map<Integer, List<Integer>>> map) {
        if (map.containsKey(x)) {
            Map<Integer, List<Integer>> map2 = map.get(x);
            if (map2.containsKey(y)) {
                List<Integer> list = map2.get(y);
                list.add(root.val);
                map2.put(y, list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(root.val);
                map2.put(y, list);
            }
            map.put(x, map2);
        } else {
            Map<Integer, List<Integer>> map2 = new TreeMap<>(Collections.reverseOrder());
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            map2.put(y, list);
            map.put(x, map2);
        }
        if (root.left != null) {
            vt(root.left, x - 1, y - 1, map);
        }
        if (root.right != null) {
            vt(root.right, x + 1, y - 1, map);
        }
    }

    //Definition for a binary tree node.
    class TreeNode {
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
}
