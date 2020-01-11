/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class _876_Middle_of_the_Linked_List {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while ((fast != null) && (fast.next != null)) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
