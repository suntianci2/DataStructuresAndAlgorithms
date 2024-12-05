package LeetCode.Leet300_399.Leet350_359.Leet350;

/**
 * TODO:==**方法二	新数组（哈希表）**==	（0ms）
 * <p>
 * 利用一个新数组，原数组元素作为新数组下标，对应的新数组元素作为原数组元素出现的次数
 */
class Solution_2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        // 索引为nums1的元素，索引对应的值为nums1元素出现的次数
        int[] count1 = new int[1001];
        for (int num : nums1) {
            count1[num] += 1;
        }

        int[] outcome = new int[nums1.length];
        int t = 0;
        // 找到count1数组中以nums2元素为索引对应元素值>0的索引，该索引即为重复的值
        for (int num : nums2) {
            if (count1[num] > 0) {
                outcome[t++] = num;
                //元素个数-1，确保后续循环记录重复值
                count1[num]--;
            }
        }

        int[] finalOutcome = new int[t];
        for (int i = 0; i < t; i++) {
            finalOutcome[i] = outcome[i];
        }
        return finalOutcome;
    }
}
