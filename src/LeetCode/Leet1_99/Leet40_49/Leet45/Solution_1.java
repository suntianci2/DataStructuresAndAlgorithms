package LeetCode.Leet1_99.Leet40_49.Leet45;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/5/15 8:29
 * @Description TODO: 方法一   模拟  2ms 24.85%
 *                  计算第i次跳跃可以到达的范围，判断终点是否在该范围内
 */
class Solution_1 {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        // 可以跳跃到的范围（初始化为第0次跳跃可以到达的范围）
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            // 计算第i次跳跃可以到达的范围
            int temp = 0;
            for (int j = startIndex; j <= endIndex; j++) {
                // nums[j] + j 表示从j位置跳跃可以到达的最大距离
                temp = Math.max(nums[j] + j, temp);
            }
            startIndex = i;
            endIndex = temp;
            // 判断 n - 1 是否在第i次跳跃的可达范围内
            if (nums.length - 1 <= endIndex) {
                return i;
            }
        }
        return -1;
    }
}
