package LeetCode.Leet300_399.Leet340_349.Leet349;

import java.util.HashSet;

/**
 * TODO:==**方法二**==	（2ms）
 * <p>
 * 取一个数组的元素，在另一个数组中寻找是否包含这个元素。如果包含，就放到set集合中
 * 将寻找元素的数组转化为哈希表，可以更快地在这个数组中寻找指定元素。
 */
class Solution_2 {
    public int[] intersection(int[] nums1, int[] nums2) {
        // 使用哈希表+set，可以减少时间复杂度，也可以去重
        HashSet<Integer> hS1 = new HashSet<>();  // 存放其中一个数组
        HashSet<Integer> hs = new HashSet<>();  // 存放结果
        // 将一数组元素放入哈希表中（用于在这个表中寻找指定元素）
        for (int num : nums1) {
            hS1.add(num);
        }

        // 找交集
        for (int num : nums2) {
            if (hS1.contains(num)) {
                hs.add(num);
            }
        }
        // set转数组
        int[] outcome = new int[hs.size()];
        int count = 0;
        for (int num : hs) {
            outcome[count] = num;
            count++;
        }
        return outcome;
    }
}
