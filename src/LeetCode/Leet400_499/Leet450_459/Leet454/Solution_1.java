package LeetCode.Leet400_499.Leet450_459.Leet454;

import java.util.HashMap;

/**
 * TODO: 方法一    哈希表     151ms   26.84%
 * 利用一个哈希map存放nums1和num2元素和（键）及其出现次数（值）
 * 然后通过计算nums3和nums4元素和，寻找map中是否存在满足条件的键
 */
class Solution_1 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int outcome = 0;
        // 记录nums1和nums2两两元素和，键为和的值，值为该和出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        // 记录所有可能的nums1元素和nums2元素的和及其出现的次数
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                } else {
                    map.put(sum, 1);
                }
                // 上面的if-else可以替换为一段代码：map.put(i + j, map.getOrDefault(i + j, 0) + 1)
                // 方法getOrDefault(k, v)：如果存在键k，则返回其对应的值。如果不存在键，返回v。
            }
        }

        // 计算每个nums3元素和nums4元素的和，判断map中是否存在相应的键，为该和的负数
        for (int i : nums3) {
            for (int j : nums4) {
                int sum = i + j;
                // 如果满足，也就是说满足了nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
                if (map.containsKey(-sum)) {
                    // 累加该和出现的次数
                    outcome += map.get(-sum);
                }
            }
        }

        return outcome;
    }
}
