//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class _2_Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return solve(l1, l2);
    }

    private ListNode solve(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode sumNode = null, sumHead = null;
        int sum = 0, carry = 0;
        while (l1 != null && l2 != null) {
            if (sumNode == null) {
                sum = l1.val + l2.val;
                sumNode = new ListNode(sum % 10);
                sumHead = sumNode;
                carry = sum / 10;
            } else {
                sum = l1.val + l2.val + carry;
                sumNode.next = new ListNode(sum % 10);
                sumNode = sumNode.next;
                carry = sum / 10;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            sum = l1.val + carry;
            sumNode.next = new ListNode(sum % 10);
            sumNode = sumNode.next;
            l1 = l1.next;
            carry = sum / 10;
        }
        while (l2 != null) {
            sum = l2.val + carry;
            sumNode.next = new ListNode(sum % 10);
            sumNode = sumNode.next;
            l2 = l2.next;
            carry = sum / 10;
        }
        while (carry != 0) {
            sum = carry;
            sumNode.next = new ListNode(sum % 10);
            sumNode = sumNode.next;
            carry = sum / 10;
        }
        return sumHead;
    }
}
