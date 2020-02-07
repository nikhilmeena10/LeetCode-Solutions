import java.util.ArrayList;
import java.util.List;

public class _103_Binary_Tree_Zigzag_Level_Order_Traversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        preOrderDFS(ans, root, 0);
        return ans;
    }

    private void preOrderDFS(List<List<Integer>> list, TreeNode node, int level) {
        if (node == null) return;
        if (level >= list.size()) {
            list.add(new ArrayList<>());
        }
        if (level % 2 == 0) list.get(level).add(node.val);
        else list.get(level).add(0, node.val);
        preOrderDFS(list, node.left, level + 1);
        preOrderDFS(list, node.right, level + 1);
    }

}
