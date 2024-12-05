package LeetCode.Leet300_399.Leet340_349.Leet349;

/**
 * TODO:**方法三** （0ms）
 * <p>
 * 定义一个足够大的数组用于存放结果
 */
class Solution_3 {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] num = new int[1002];  // 用来保存交集的临时数组
        int[] Va1 = new int[1002];  // 标记 nums1 中的元素
        int n = 0;  // 记录交集元素的个数

        // 遍历 nums1，标记其中的元素
        for (int i = 0; i < nums1.length; i++) {
            if (Va1[nums1[i]] == 0) {
                Va1[nums1[i]] = 1;
            }
        }

        // 遍历 nums2，如果 nums2 中的元素在 nums1 中存在，就将其加入结果数组
        for (int i = 0; i < nums2.length; i++) {
            if (Va1[nums2[i]] == 1) {
                Va1[nums2[i]] = 2;  // 标记已处理，避免重复
                num[n] = nums2[i];
                n++;
            }
        }

        // 手动创建一个长度为 n 的新数组，用来保存前 n 个交集的元素
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = num[i];
        }

        return result;
    }
}
