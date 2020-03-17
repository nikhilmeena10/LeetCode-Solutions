import java.util.Stack;

public class _1130_Minimum_Cost_Tree_From_Leaf_Values {

    //Array has leaf nodes given in inorder traversal. We need to choose for each node, whether
    //to pair it with its left or right node. Since we want minimum total sum, keeping smallest node
    //at bottom would be better as it would be multiplied and then discarded.Larger node at bottom would
    //keep contributing to product and lead to larger sum. Hence, choose min of both neighbours and
    //add to product. Discard smallest of the three, keep second smallest. Use stack for O(n) complexity
    public int mctFromLeafValues(int[] arr) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        for (int i : arr) {
            while (i >= stack.peek()) {
                int mid = stack.pop();
                ans += mid * Math.min(i, stack.peek());
            }
            stack.push(i);
        }
        while (stack.size() > 2) {
            ans += stack.pop() * stack.peek();
        }
        return ans;
    }


}
