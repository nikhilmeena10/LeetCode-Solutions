import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _145_Binary_Tree_Postorder_Traversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return ans;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            ans.addFirst(curr.val);
            if (curr.left != null) stack.push(curr.left);
            if (curr.right != null) stack.push(curr.right);
        }
        return ans;
    }

}
