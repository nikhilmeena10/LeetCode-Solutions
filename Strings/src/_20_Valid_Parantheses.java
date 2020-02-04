import java.util.Stack;

public class _20_Valid_Parantheses {

    public boolean isValid(String s) {
        if ((s == null) || (s.length() == 0)) return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty()) {
                if ((ch == '(') || (ch == '{') || (ch == '[')) {
                    stack.push(ch);
                } else return false;
            } else {
                if (ch == ')') {
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if (ch == '}') {
                    if (stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if (ch == ']') {
                    if (stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    stack.push(ch);
                }
            }
        }
        return stack.isEmpty();
    }

}
