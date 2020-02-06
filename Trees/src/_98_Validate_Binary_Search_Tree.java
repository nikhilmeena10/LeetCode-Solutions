import java.util.Stack;

public class _98_Validate_Binary_Search_Tree {

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root, prev = null;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (prev != null && prev.val >= curr.val) return false;
            prev = curr;
            curr = curr.right;
        }
        return true;
    }
}
