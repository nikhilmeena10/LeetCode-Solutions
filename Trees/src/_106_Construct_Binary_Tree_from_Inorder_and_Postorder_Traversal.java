import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {

    //Official solution
    int post_idx;
    int[] postorder;
    int[] inorder;
    HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    public TreeNode helper(int in_left, int in_right) {
        // if there is no elements to construct subtrees
        if (in_left > in_right)
            return null;

        // pick up post_idx element as a root
        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);

        // root splits inorder list
        // into left and right subtrees
        int index = idx_map.get(root_val);

        // recursion
        post_idx--;
        // build right subtree
        root.right = helper(index + 1, in_right);
        // build left subtree
        root.left = helper(in_left, index - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        // start from the last postorder element
        post_idx = postorder.length - 1;

        // build a hashmap value -> its index
        int idx = 0;
        for (Integer val : inorder)
            idx_map.put(val, idx++);
        return helper(0, inorder.length - 1);
    }

    //Solution using hashmap from discussion
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) return null;
        int ilen = inorder.length;
        int plen = postorder.length;
        if (ilen != plen) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < ilen; i++) {
            map.put(inorder[i], i);
        }
        return buildTreePostIn(inorder, 0, ilen - 1, postorder, 0, plen - 1, map);
    }

    public TreeNode buildTreePostIn(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, Map<Integer, Integer> map) {
        if (ps > pe || is > ie) return null;
        int val = postorder[pe];
        int index = map.get(val);
        TreeNode root = new TreeNode(val);
        //TODO What is this??? ps+index-is-1 ps+index-is
        root.left = buildTreePostIn(inorder, is, index - 1, postorder, ps, ps + index - is - 1, map);
        root.right = buildTreePostIn(inorder, index + 1, ie, postorder, ps + index - is, pe - 1, map);
        return root;
    }

    //My solution
    //last element of postorder array is root, find root in inorder, construct left and right subtrees from this index
    public TreeNode mybuildTree(int[] inorder, int[] postorder) {
        int inlen = inorder.length;
        int postlen = postorder.length;
        if (inlen == 0 || postlen == 0) return null;
        int rootval = postorder[postlen - 1];
        TreeNode root = new TreeNode(rootval);
        if (inlen == 1 || postlen == 1) return root;
        int partition = postlen - 1;
        while (inorder[partition] != rootval) {
            partition--;
        }
        int[] inright = Arrays.copyOfRange(inorder, partition + 1, inlen);
        int[] postright = Arrays.copyOfRange(postorder, partition, postlen - 1);
        int[] inleft = Arrays.copyOfRange(inorder, 0, partition);
        int[] postleft = Arrays.copyOfRange(postorder, 0, partition);
        root.right = buildTree(inright, postright);
        root.left = buildTree(inleft, postleft);
        return root;
    }
}
