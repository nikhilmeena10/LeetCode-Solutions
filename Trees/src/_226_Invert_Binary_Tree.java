import java.util.ArrayDeque;
import java.util.Queue;

public class _226_Invert_Binary_Tree {

    public TreeNode invertTreeRec(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        TreeNode left = invertTreeRec(root.left);
        TreeNode right = invertTreeRec(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.remove();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }

}
