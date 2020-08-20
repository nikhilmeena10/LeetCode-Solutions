import java.util.ArrayList;
import java.util.List;

public class _20 {

    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode runner = head;
        while (runner != null) {
            list.add(runner);
            runner = runner.next;
        }
        int i = 0, j = list.size() - 1;
        while (i <= j) {
            if (j - i == 1) {
                ListNode f = list.get(i);
                ListNode s = list.get(j);
                s.next = null;
            } else if (j == i) {
                ListNode f = list.get(i);
                f.next = null;
            } else {
                ListNode f = list.get(i);
                ListNode s = list.get(j);
                s.next = f.next;
                f.next = s;
            }
            i++;
            j--;
        }
    }

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    

}
