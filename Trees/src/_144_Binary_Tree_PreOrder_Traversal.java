import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _144_Binary_Tree_PreOrder_Traversal {

    //Iterative
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            ans.add(curr.val);
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }
        return ans;
    }

    //Recursive
    public List<Integer> preorderTraversalRec(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preOrder(root, ans);
        return ans;
    }

    public void preOrder(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        ans.add(root.val);
        preOrder(root.left, ans);
        preOrder(root.right, ans);
    }

}
