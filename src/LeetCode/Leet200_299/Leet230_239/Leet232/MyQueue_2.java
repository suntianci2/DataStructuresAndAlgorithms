package LeetCode.Leet200_299.Leet230_239.Leet232;

import java.util.Stack;

/**
 * TODO:==**方法二**==	（0ms）
 * <p>
 * 对**方法一**的优化。
 * <p>
 * 当遇到pop、peek操作时，检测栈2是否为空，如果为空，则将栈1的元素逆向放到栈2中。如果不为空，直接对栈2执行操作。这样避免了**方法一**中来回运输元素所产生的时间成本。
 */
class MyQueue_2 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue_2() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();

    }

    public void push(int x) {
        // 将元素压入栈1
        stack1.push(x);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            // 若栈2为空，将栈1逐元素添加到栈2中
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        // 栈2元素与原始栈1元素顺序相反，这时候我们弹出栈顶元素，即为目标元素
        return stack2.pop();

    }

    public int peek() {
        if (stack2.isEmpty()) {
            // 若栈2为空，将栈1逐元素添加到栈2中
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        // 栈2元素为原始栈1元素顺序相反，这时候我们弹出栈顶元素，即为目标元素
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
