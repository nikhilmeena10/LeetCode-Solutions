import java.util.Stack;

public class _32_Longest_Valid_Parantheses {
    public int longestValidParentheses(String s) {
        int max = Integer.MIN_VALUE;
        s += "x";
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && !stack.empty() && s.charAt(stack.peek()) == '(')
                stack.pop();
            else {
                if (stack.empty()) {
                    max = Math.max(max, i);
                } else
                    max = Math.max(max, i - stack.peek() - 1);
                stack.push(i);
            }
        }
        return stack.empty() ? s.length() : max;
    }

}
