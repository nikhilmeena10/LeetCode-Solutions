import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

//https://leetcode.com/articles/merge-k-sorted-list/

class _23_Merge_k_Sorted_Lists {

    public ListNode mergeKLists(ListNode[] lists) {
        Comparator<ListNode> cmp = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode one, ListNode two) {
                return one.val - two.val;
            }
        };
        Queue<ListNode> queue = new PriorityQueue<>(cmp);
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        ListNode head = new ListNode(0);
        ListNode lk = head;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            head.next = new ListNode(node.val);
            head = head.next;
            node = node.next;
            if (node != null) queue.add(node);
        }
        return lk.next;
    }
}
