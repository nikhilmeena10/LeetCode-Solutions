import java.util.Stack;

public class _112_Path_Sum {

    //My recursive solution
    public boolean hasPathSumRec(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return (sum - root.val) == 0;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sums = new Stack<>();
        stack.push(root);
        sums.push(sum);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            int val = sums.pop();
            if (top.left == null && top.right == null) {
                if (top.val == val) return true;
            }
            if (top.right != null) {
                stack.push(top.right);
                sums.push(val - top.val);
            }
            if (top.left != null) {
                stack.push(top.left);
                sums.push(val - top.val);
            }
        }
        return false;
    }

}
