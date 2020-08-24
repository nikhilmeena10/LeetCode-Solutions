import java.util.ArrayDeque;
import java.util.Queue;

public class _24 {

    //iterative
    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) return 0;
        int ans = 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            if (node.left != null) {
                if (node.left.left == null && node.left.right == null) ans += node.left.val;
                else q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
        return ans;
    }

    //recursive
    public int sumOfLeftLeaves(TreeNode root) {
        return calc(root, false);
    }

    private int calc(TreeNode root, boolean isLeft) {
        if (root == null) return 0;
        if (root.left == null && root.right == null && isLeft) return root.val;
        return calc(root.left, true) + calc(root.right, false);
    }

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

}
