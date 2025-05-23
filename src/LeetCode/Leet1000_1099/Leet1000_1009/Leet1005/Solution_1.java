package LeetCode.Leet1000_1099.Leet1000_1009.Leet1005;

import java.util.Arrays;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/5/16 8:53
 * @Description TODO: 方法一   贪心    2ms 98.89%
 */
class Solution_1 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        int i = 0;
        while (i < nums.length) {
            // 如果k=0了，后面的数求和即可
            if (k == 0) {
                sum += nums[i];
                i++;
                continue;
            }

            // 如果k不为0，当前元素取反
            nums[i] = -nums[i];

            // 如果以下情况同时满足，i指针才往后移（贪心）
            // 1.当前元素不是最后一个元素
            // 2.当前元素大于下一元素（也就是说，下一元素取反的总和要比当前元素取反总和更大）
            //  例如: nums[i] > 0，nums[i + 1] < 0，则下次应nums[i + 1]取反
            //        nums[i] > nums[i + 1] > 0，则下次应nums[i + 1]取反，要比nums[i]取反带来的损失更小
            //        nums[i] < 0，nums[i + 1] > 0，下次继续nums[i]取反
            if (i != nums.length - 1 && nums[i] > nums[i + 1]) {
                sum += nums[i];
                i++;
            }
            k--;
        }
        return sum;
    }
}
