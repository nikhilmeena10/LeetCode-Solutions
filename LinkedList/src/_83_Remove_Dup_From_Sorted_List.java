/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class _83_Remove_Dup_From_Sorted_List {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode dummy = head;
        while ((head != null) && (head.next != null)) {
            if (head.next.val == head.val) {
                ListNode tmp = head.next;
                while ((tmp != null) && (tmp.val == head.val)) {
                    tmp = tmp.next;
                }
                head.next = tmp;
            }
            head = head.next;
        }
        return dummy;
    }
}

//Official solution:
/*
public ListNode deleteDuplicates(ListNode head) {
    ListNode current = head;
    while (current != null && current.next != null) {
        if (current.next.val == current.val) {
            current.next = current.next.next;
        } else {
            current = current.next;
        }
    }
    return head;
}
 */
