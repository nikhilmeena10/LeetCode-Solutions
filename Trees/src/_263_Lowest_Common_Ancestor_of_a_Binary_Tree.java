import java.util.*;

public class _263_Lowest_Common_Ancestor_of_a_Binary_Tree {

    public TreeNode lowestCommonAncestorRec(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p) return root;
        if (root == q) return root;
        TreeNode leftLCA = lowestCommonAncestorRec(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestorRec(root.right, p, q);
        if (leftLCA != null && rightLCA != null) return root;
        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    //Keep list of parents of all nodes. Traverse till p and q are both in this parent map
    //Add all parents of p to a set. Keep going up the ancestor tree for q till you merge with this
    //parent path of p. Point of merge is LCA
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        parent.put(root, null);
        queue.add(root);
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode curr = queue.remove();
            if (curr.left != null) {
                parent.put(curr.left, curr);
                queue.add(curr.left);
            }
            if (curr.right != null) {
                parent.put(curr.right, curr);
                queue.add(curr.right);
            }
        }
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        while (!ancestors.contains(q)) {
            q = parent.get(q);
        }
        return q;
    }

}
