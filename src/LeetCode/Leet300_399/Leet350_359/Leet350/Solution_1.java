package LeetCode.Leet300_399.Leet350_359.Leet350;

import java.util.Arrays;

/**
 * TODO:**方法一	排序**	（2ms）
 * <p>
 * 先排序，再循环找结果
 */
class Solution_1 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] outcome = new int[nums1.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                outcome[k] = nums1[i];
                i++;
                j++;
                k++;
            }
        }
        int[] finalOutcome = new int[k];
        for (int t = 0; t < k; t++) {
            finalOutcome[t] = outcome[t];
        }
        return finalOutcome;
    }
}
