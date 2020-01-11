/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class _1290_Convert_Binary_To_Integer {
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        while (head != null) {
            ans = ans * 2 + head.val; // also ans = (ans << 1) | head.val;
            head = head.next;
        }
        return ans;
    }
}

/*
        https://www.quora.com/While-converting-a-binary-number-to-a-decimal-number-it-starts-from-right-to-left-Why

        Finding the value of a number represented as a sequence of digits dn…d2d1d0 in any base b is a matter of evaluating the sum:

        ∑i=0-n dibi=dnbn+⋯+d2b2+d1b+d0

        You can do this in either direction.

        In particular, to do it left to right (most significant digit first) it is simply a matter of iterating the function:

        f(n,d)=(b×n)+d

        which adds the digit d to the right of existing number n.

        Starting from zero we have f(0,dn)=dn, then f(dn,dn−1)=dnb+dn−1, and so on.

        Going right to left is, if anything, more complicated, especially if the number is fractional and has a non-terminating representation with no “rightmost” digit

 */
