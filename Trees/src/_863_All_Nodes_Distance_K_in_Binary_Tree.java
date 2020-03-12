import java.util.*;

public class _863_All_Nodes_Distance_K_in_Binary_Tree {

    Map<TreeNode, Integer> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        find(root, target);
        dfs(root, target, K, map.get(root), res);
        return res;
    }

    private int find(TreeNode root, TreeNode target) {
        if (root == null) return -1;
        if (root == target) {
            map.put(root, 0);
            return 0;
        }
        int left = find(root.left, target);
        if (left >= 0) {
            map.put(root, left + 1);
            return left + 1;
        }
        int right = find(root.right, target);
        if (right >= 0) {
            map.put(root, right + 1);
            return right + 1;
        }
        return -1;
    }

    private void dfs(TreeNode root, TreeNode target, int k, int length, List<Integer> res) {
        if (root == null) return;
        if (map.containsKey(root)) length = map.get(root);
        if (length == k) res.add(root.val);
        dfs(root.left, target, k, length + 1, res);
        dfs(root.right, target, k, length + 1, res);
    }

    //My BFS solution
    private Map<Integer, List<Integer>> adj;

    public List<Integer> distanceK2(TreeNode root, TreeNode target, int K) {
        adj = new HashMap<>();
        buildGraph(root);
        return bfs(target, K);
    }

    private List<Integer> bfs(TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        int layer = 0;
        int count = 1;
        q.add(target.val);
        boolean[] visited = new boolean[adj.size() + 1];
        while (true) {
            while (!q.isEmpty()) {
                int i = q.remove();
                visited[i] = true;
                ans.add(i);
            }
            if (layer == k) return ans;
            else {
                for (int v : ans) {
                    for (int w : adj.get(v)) {
                        if (!visited[w]) {
                            q.add(w);
                        }
                    }
                }
            }
            ans = new ArrayList<>();
            layer++;
        }
    }

    private void buildGraph(TreeNode root) {
        if (root == null) return;
        if (!adj.containsKey(root.val)) {
            adj.put(root.val, new ArrayList<>());
        }
        if (root.left != null) {
            List<Integer> list = adj.get(root.val);
            list.add(root.left.val);
            adj.put(root.val, list);
            List<Integer> l2 = adj.get(root.left.val);
            if (l2 == null) {
                l2 = new ArrayList<>();
                l2.add(root.val);
                adj.put(root.left.val, l2);
            } else {
                l2.add(root.val);
                adj.put(root.left.val, l2);
            }
        }
        if (root.right != null) {
            List<Integer> list = adj.get(root.val);
            list.add(root.right.val);
            adj.put(root.val, list);
            List<Integer> l2 = adj.get(root.right.val);
            if (l2 == null) {
                l2 = new ArrayList<>();
                l2.add(root.val);
                adj.put(root.right.val, l2);
            } else {
                l2.add(root.val);
                adj.put(root.right.val, l2);
            }
        }
        buildGraph(root.left);
        buildGraph(root.right);
    }


}
