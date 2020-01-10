public class _19_Remove_Nth_Node_From_EOL {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode slowptr = dummyHead, fastptr = dummyHead;
        for (int i = 0; i <= n; i++) {
            fastptr = fastptr.next;
        }
        while (fastptr != null) {
            fastptr = fastptr.next;
            slowptr = slowptr.next;
        }
        slowptr.next = slowptr.next.next;
        return dummyHead.next;
    }
}
