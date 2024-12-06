package LeetCode.Leet200_299.Leet220_229.Leet225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * TODO:==**方法二	一个队列**==	（0ms）
 * <p>
 * 相比方法一，每次遇到**pop**和**top**方法，不借用其他队列，找到最后加入的元素。相比方法一，空间复杂度更低
 * <p>
 * 类似的，也可以在添加元素的时候移动值，使得刚刚添加的元素到队列出口处，**pop**和**top**方法直接从出口取出元素即可。
 */
class MyStack_2 {
    private Queue<Integer> queue;

    public MyStack_2() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        // 将元素压入队列1
        queue.offer(x);
    }

    public int pop() {
        int len = queue.size();
        // 循环 len-1 次，从queue中取出元素再放入queue中
        for (int i = 0; i < len - 1; i++) {
            queue.offer(queue.poll());
        }
        // 此时，下一个取出的元素即为目标元素
        int num = queue.poll();
        return num;
    }

    public int top() {
        int len = queue.size();
        // 循环 len-1 次，从queue中取出元素再放入queue中
        for (int i = 0; i < len - 1; i++) {
            queue.offer(queue.poll());
        }
        // 此时，下一个取出的元素即为目标元素
        int num = queue.poll();
        // 记得把这个元素再放到队列中
        queue.offer(num);
        return num;
    }

    public boolean empty() {
        return queue.isEmpty();
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
