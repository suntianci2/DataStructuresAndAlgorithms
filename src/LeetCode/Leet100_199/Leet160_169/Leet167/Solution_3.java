package LeetCode.Leet100_199.Leet160_169.Leet167;

import java.util.HashMap;

/**
 * TODO: **方法三**  哈希表 （5ms）
 * 使用一个哈希表存放已经遇到过的元素和其下标
 * 缺点：无法利用已经排序来解题，空间复杂度高
 */
class Solution_3 {
    public int[] twoSum(int[] numbers, int target) {
        // 键：数组中的元素。值：元素在数组中的索引
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                int[] outcome = new int[2];
                return new int[]{map.get(target - numbers[i]), i + 1};
            }
            // 注意数组下标从1开始
            map.put(numbers[i], i + 1);
        }
        return new int[]{-1, -1};
    }
}
