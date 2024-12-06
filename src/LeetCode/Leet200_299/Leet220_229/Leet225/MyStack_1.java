package LeetCode.Leet200_299.Leet220_229.Leet225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * TODO:**方法一	两个单向队列**	（0ms）
 * <p>
 * 每当碰到**pop**和**top**方法，借用第二个队列，来找到队列中最后加入的元素
 */
class MyStack_1 {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    // 构造方法
    public MyStack_1() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        // 将元素压入队列1
        queue1.offer(x);
    }

    public int pop() {
        // 将元素逐个放入queue2中，直至queue中剩余一个元素
        while (queue1.size() != 1) {
            queue2.offer(queue1.poll());
        }
        // 此时，剩余的元素即为目标元素
        int num = queue1.poll();
        // 再将queue2中的元素放回queue1中，保证queue2始终为空
        while (!queue2.isEmpty()) {
            queue1.offer(queue2.poll());
        }
        return num;
    }

    public int top() {
        // 将元素逐个放入queue2中，直至queue中剩余一个元素
        while (queue1.size() != 1) {
            queue2.offer(queue1.poll());
        }
        // 此时，剩余的元素即为目标元素
        int num = queue1.poll();
        // 在将目标元素加入到queue2队列，保持原始队列结构
        queue2.offer(num);
        // 再将queue2中的元素放回queue1中，保证queue2始终为空
        while (!queue2.isEmpty()) {
            queue1.offer(queue2.poll());
        }
        return num;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
