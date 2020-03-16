public class _117_Populating_Next_Right_Pointers_in_Each_Node_II {

    //dummyhead and p point to next level. use p to traverse that level and update next
    //once level is completed, move curr to dummyhead.next, meaning first element in next level
    //set next to null so that it doesn't point to older level. p will start setting the next pointers for the
    //next lower level again
    public Node connect(Node root) {
        if (root == null) return null;
        Node curr = root;
        Node nextDummyHead = new Node(0);
        Node p = nextDummyHead;
        while (curr != null) {
            if (curr.left != null) {
                p.next = curr.left;
                p = p.next;
            }
            if (curr.right != null) {
                p.next = curr.right;
                p = p.next;
            }
            if (curr.next != null) {
                curr = curr.next;
            } else {
                curr = nextDummyHead.next;
                nextDummyHead.next = null;
                p = nextDummyHead;
            }
        }
        return root;
    }

}
