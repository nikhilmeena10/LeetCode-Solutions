/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class _24_Swap_Nodes_In_Pairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return head;
        if (head.next == null) return head;
        ListNode current = new ListNode(0);
        current.next = head;
        ListNode dummyHead = current;
        ListNode first = null, second = null;
        while ((current.next != null) && (current.next.next != null)) {
            first = current.next;
            second = current.next.next;
            first.next = second.next;
            second.next = first;
            current.next = second;
            current = first;
        }
        return dummyHead.next;
    }
}
