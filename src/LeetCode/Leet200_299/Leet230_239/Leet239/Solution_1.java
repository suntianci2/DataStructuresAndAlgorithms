package LeetCode.Leet200_299.Leet230_239.Leet239;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/1/24 21:32
 * @Description TODO: 方法一   优先级队列   85ms    17.71%
 */

class Solution_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 记录结果
        int[] result = new int[nums.length - k + 1];
        // 定义优先级队列，寻找最大值
        // 优先级队列中存储的元素为二元组。其中第一个元素为元素值，第二个元素为元素在原数组中的索引
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            // 重写compare方法（返回值大于0：pair2优先级更高。返回值小于0：pair1优先级更高）
            // 如果两个元素值不相等，返回的则是后面一个元素值减去前面一个元素值
            // 目的是为了：数值越大的元素优先级越高，排在队列的前面
            // 如果两个元素值相等，返回的则是后面一个元素索引减去前面一个元素索引
            // 当值相同时，索引越低优先级越高，因为后续滑动窗口需要根据索引判断元素是否还在窗口内。较小索引的元素更早进入窗口，按索引升序排列可以避免优先级混乱。
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair1[1] - pair2[1];
            }
        });

        // 首先，将前k个元素放入优先级队列中
        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }

        // 获取第一个窗口位置的结果
        result[0] = pq.peek()[0];

        // 循环移动滑动窗口
        for (int i = k; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});

            // 弹出最大值中不在滑动窗口内的元素（在滑动窗口左边界外侧的元素）
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            result[i - k + 1] = pq.peek()[0];
        }

        return result;
    }
}