package LeetCode.Leet300_399.Leet340_349.Leet347;

import java.util.*;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/1/26 12:30
 * @Description TODO: 方法二   哈希表+优先级队列（小顶堆） 优化   12ms    90.37%
 *                  队列中只有前k个元素，去除了不必要的比较
 */
class Solution_2 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        // 统计每个数字出现的次数
        for (int num : nums) {
            // getOrDefault(num, 0)：获取键num对应的值，如果键num不存在，则值为0
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 定义优先级队列
        // compare方法：自定义优先级队列的优先级比较方式
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] part1, int[] part2) {
                return part1[1] - part2[1];
            }
        });

        // 将哈希表中的键值对逐个放入到优先级队列中
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            // 如果队列中元素个数已经有k个了
            if (queue.size() == k) {
                // 如果新元素的出现个数大于堆顶元素的出现次数，
                // 则弹出堆顶元素，加入新元素
                // 否则，什么都不做
                if (entry.getValue() > queue.peek()[1]) {
                    queue.poll();
                    queue.offer(new int[]{entry.getKey(), entry.getValue()});
                }
            } else {
                // 如果队列中元素个数还没有k个，直接加入
                queue.offer(new int[]{entry.getKey(), entry.getValue()});
            }
        }

        // 提取答案
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll()[0];
        }

        return result;
    }
}
