import java.util.ArrayList;
import java.util.List;

public class _109_Convert_Sorted_List_to_BST {

    //O(n) time and O(logn) space solution in discussion
    /*ListNode list;
    public TreeNode sortedListToBST(ListNode head) {
        list = head;
        int size = count(head);
        return generate(0, size-1);
    }

    private int count(ListNode node) {
        int cnt = 0;
        while(node != null) {
            node = node.next;
            cnt++;
        }
        return cnt;
    }

    private TreeNode generate(int start, int end) {
        if(start > end) return null;
        int mid = start + (end-start)/2;

        TreeNode left = generate(start, mid-1);

        TreeNode root = new TreeNode(list.val);
        root.left = left;
        list = list.next;

        TreeNode right = generate(mid+1, end);
        root.right = right;
        return root;
    }*/

    //My solution
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        TreeNode root = createBST(list, 0, list.size() - 1);
        return root;
    }

    private TreeNode createBST(List<Integer> list, int start, int end) {
        if (start > end) return null;
        else if (start == end) {
            TreeNode node = new TreeNode(list.get(start));
            return node;
        } else {
            int mid = start + (end - start) / 2;
            TreeNode root = new TreeNode(list.get(mid));
            root.left = createBST(list, start, mid - 1);
            root.right = createBST(list, mid + 1, end);
            return root;
        }

    }

}
