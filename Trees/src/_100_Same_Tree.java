import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _100_Same_Tree {

    //Recursive
    public boolean isSameTreeRec(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && isSameTreeRec(p.left, q.left) && isSameTreeRec(p.right, q.right);
    }

    //Two stacks
    //Should you use deque instead of java.util.stack?
    public boolean isSameTreeStacks(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        Stack<TreeNode> stackP = new Stack<>();
        Stack<TreeNode> stackQ = new Stack<>();
        stackP.push(p);
        stackQ.push(q);
        while (!stackP.empty() && !stackQ.empty()) {
            TreeNode np = stackP.pop();
            TreeNode nq = stackQ.pop();
            if (np.val != nq.val) return false;
            if (np.left != null && nq.left != null) {
                stackP.push(np.left);
                stackQ.push(nq.left);
            } else if (np.left != null || nq.left != null) {
                return false;
            }
            if (np.right != null && nq.right != null) {
                stackP.push(np.right);
                stackQ.push(nq.right);
            } else if (np.right != null || nq.right != null) {
                return false;
            }
        }
        return true;
    }

    //Using single queue
    public boolean isSameTreeQueue(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);
        while (!queue.isEmpty()) {
            TreeNode f = queue.poll();
            TreeNode s = queue.poll();
            if (f == null && s == null) {
                continue;
            } else if (f == null || s == null || f.val != s.val) {
                return false;
            }
            queue.add(f.left);
            queue.add(s.left);
            queue.add(f.right);
            queue.add(s.right);
        }
        return true;
    }

}
