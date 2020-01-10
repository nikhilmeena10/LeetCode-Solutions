class _21_Merge_Two_Sorted_Lists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode l3 = new ListNode(0);
        ListNode dummyHead = l3;
        while ((l1 != null) && (l2 != null)) {
            if (l1.val < l2.val) {
                l3.next = new ListNode(l1.val);
                l1 = l1.next;
                l3 = l3.next;
            } else {
                l3.next = new ListNode(l2.val);
                l2 = l2.next;
                l3 = l3.next;
            }
        }
        if (l1 == null) {
            l3.next = l2;
        }
        if (l2 == null) {
            l3.next = l1;
        }
        return dummyHead.next;
    }
}
