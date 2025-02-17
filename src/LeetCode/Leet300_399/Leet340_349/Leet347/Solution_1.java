package LeetCode.Leet300_399.Leet340_349.Leet347;

import java.util.*;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/1/26 11:27
 * @Description TODO: 方法一   哈希表+优先级队列（大顶堆）  12ms    90.37%
 *                      缺点：队列中存放有每个元素的出现次数，我们只需要前k个，所以有很多多余的元素，也会出现多余的比较
 */
class Solution_1 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        // 统计每个数字出现的次数
        for (int num : nums) {
            // getOrDefault(num, 0)：获取键num对应的值，如果键num不存在，则值为0
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 定义优先级队列
        // compare方法：自定义优先级队列的优先级比较方式
        // 该方法中，出现次数越多的元素，优先级越高
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] part1, int[] part2) {
                return part2[1] - part1[1];
            }
        });


        // 将哈希表中的键值对逐个放入到优先级队列中
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            queue.offer(new int[]{entry.getKey(), entry.getValue()});
        }

        // 提取答案
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll()[0];
        }

        return result;
    }
}
