package LeetCode.Leet900_999.Leet930_939.Leet933;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * TODO:==**方法一	队列**==	（20ms）
 */
class RecentCounter_1 {

    Queue<Integer> queue;

    public RecentCounter_1() {
        queue = new ArrayDeque<>();
    }

    public int ping(int t) {
        queue.offer(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }
}
