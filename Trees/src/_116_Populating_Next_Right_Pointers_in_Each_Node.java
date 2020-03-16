import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class _116_Populating_Next_Right_Pointers_in_Each_Node {

    //Solution in discussion
    public Node connect(Node root) {
        Node levelStart = root;
        while (levelStart != null) {
            Node curr = levelStart;
            while (curr != null) {
                if (curr.left != null) curr.left.next = curr.right;
                if (curr.right != null && curr.next != null) curr.right.next = curr.next.left;
                curr = curr.next;
            }
            levelStart = levelStart.left;
        }
        return root;
    }

    //My Solution
    //will it work for any binary tree?
    public Node myconnect(Node root) {
        if (root == null) return null;
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Node> list = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node curr = q.remove();
                list.add(curr);
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
            for (int i = 0; i < list.size() - 1; i++) {
                list.get(i).next = list.get(i + 1);
            }
            list.get(list.size() - 1).next = null;
        }
        return root;
    }

}
