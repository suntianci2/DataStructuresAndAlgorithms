package LeetCode.Leet200_299.Leet230_239.Leet239;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/1/25 11:50
 * @Description TODO: 方法二   单调队列    30ms    71.12%
 */
class Solution_2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 单调队列，元素值为数组下标。数组下标单调递增 ，数组下标对应的值单调递减
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        // 先将前k个元素插入到单调队列中
        for (int i = 0; i < k; i++) {
            // 从队列尾部移除小于当前索引处元素值的索引
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            // 从尾部添加当前索引值
            deque.offerLast(i);
        }
        result[0] = nums[deque.peekFirst()];

        // 每次循环，滑动窗口移动一位
        for (int i = 1; i < nums.length - k + 1; i++) {
            // 从队列尾部移除索引元素值小于滑动窗口新进入的值的索引值
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i + k - 1]) {
                deque.pollLast();
            }
            // 从尾部添加滑动窗口新进入的值
            deque.offerLast(i + k - 1);

            // 从队列头部移除不在滑动窗口内的元素
            while (!deque.isEmpty() && deque.peekFirst() < i) {
                deque.pollFirst();
            }

            // 将结果添加到result中
            result[i] = nums[deque.peekFirst()];
        }
        return result;
    }
}