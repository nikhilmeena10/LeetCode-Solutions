import java.util.Stack;

class MinStack {

    Stack<SE> stack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (!stack.isEmpty()) {
            if (x < stack.peek().min) {
                stack.push(new SE(x, x));
            } else {
                stack.push(new SE(x, stack.peek().min));
            }
        } else {
            stack.push(new SE(x, x));
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().value;
    }

    public int getMin() {
        return stack.peek().min;
    }

    class SE {
        int value;
        int min;

        public SE(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
