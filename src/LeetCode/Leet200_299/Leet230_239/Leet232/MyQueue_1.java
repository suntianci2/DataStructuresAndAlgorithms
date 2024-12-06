package LeetCode.Leet200_299.Leet230_239.Leet232;

import java.util.Stack;

/**
 * TODO:**方法一**	(0ms)
 * <p>
 * 当遇到pop、peek操作时，借用栈2，取出先加入的元素，然后再还原到栈1
 */
class MyQueue_1 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue_1() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();

    }

    public void push(int x) {
        // 将元素压入栈1
        stack1.push(x);
    }

    public int pop() {
        // 将栈1逐元素添加到栈2中
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        // 此时栈2元素为原始栈1元素顺序相反，这时候我们弹出栈顶元素，即为目标元素
        Integer num = stack2.pop();
        // 将栈2逐元素添加到栈1中，恢复原始顺序
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return num;

    }

    public int peek() {
        // 将栈1逐元素添加到栈2中
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        // 此时栈2元素与原始栈1元素顺序相反，这时候我们取出栈顶元素，即为目标元素
        Integer num = stack2.peek();
        // 将栈2逐元素添加到栈1中，恢复原始顺序
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return num;
    }

    public boolean empty() {
        return stack1.isEmpty();
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
