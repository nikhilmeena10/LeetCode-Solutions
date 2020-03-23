public class _61_Rotate_List {

    //My solution
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        int count = 0;
        ListNode ehead = head;
        while (ehead != null) {
            count++;
            ehead = ehead.next;
        }
        k = k % count;
        if (k == 0) return head;
        ListNode tr = head;
        for (int i = 1; i < count - k; i++) {
            tr = tr.next;
        }
        ListNode newHead = tr.next;
        tr.next = null;
        ListNode dummyHead = newHead;
        while (newHead.next != null) {
            newHead = newHead.next;
        }
        newHead.next = head;
        return dummyHead;
    }

    //Nice solution in discussion
    /*
    ListNode *rotateRight(ListNode *head, int k) {
        if (head == NULL || head->next == NULL || k == 0) return head;
        int len = 1;
        ListNode *tail = head;

        //find the end of list
        while (tail->next != NULL) {
        tail = tail->next;
        len++;
        }

        //form a circle
        tail->next = head;
        k = k % len;
            for (int i = 0; i < len - k; i++) {
            tail = tail->next;
        }
        head = tail->next;
        tail->next = NULL;
            return head;
    }
     */

}
