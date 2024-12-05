package LeetCode.Leet300_399.Leet340_349.Leet349;

import java.util.Arrays;
import java.util.HashSet;

/**
 * TODO:**方法一** （3ms）
 * <p>
 * 先对元两个数组排序，然后使用双指针找到交集并存放到set集合中。set集合会自动去重
 */
class Solution_1 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hs = new HashSet<>();  // set集合会自动去重
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;

        // 寻找交集，包括重复值
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                // set集合会自动去重
                hs.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] outcome = new int[hs.size()];

        // set集合转数组
        int count = 0;
        for (Integer num : hs) {
            outcome[count] = num;
            count++;
        }

        return outcome;
    }
}
