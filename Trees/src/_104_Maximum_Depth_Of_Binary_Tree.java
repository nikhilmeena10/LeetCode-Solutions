import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _104_Maximum_Depth_Of_Binary_Tree {

    //Simple Recursive Solution
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftMax = root.left == null ? 0 : maxDepth(root.left);
        int rightMax = root.right == null ? 0 : maxDepth(root.right);
        return 1 + Math.max(leftMax, rightMax);
    }

    //My solution: Rec + DFS
    int maxLevel;

    public int maxDepthMine(TreeNode root) {
        preOrder(root, 1);
        return maxLevel;
    }

    private void preOrder(TreeNode root, int level) {
        if (root == null) return;
        maxLevel = Math.max(level, maxLevel);
        preOrder(root.left, level + 1);
        preOrder(root.right, level + 1);
    }

    //Iterative DFS
    public int maxDepthItDFS(TreeNode root) {
        if (root == null) return 0;

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> depth = new Stack<>();
        stack.push(root);
        depth.push(1);
        int max = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int curDepth = depth.pop();
            max = Math.max(curDepth, max);
            // PUSH RIGHT FIRST - to pop left first
            if (node.right != null) {
                stack.push(node.right);
                depth.push(curDepth + 1);
            }
            if (node.left != null) {
                stack.push(node.left);
                depth.push(curDepth + 1);
            }
        }
        return max;
    }

    //Iterative BFS
    public int maxDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            count++;
        }
        return count;
    }

}
