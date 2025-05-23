package LeetCode.Leet100_199.Leet130_139.Leet135;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/5/18 10:17
 * @Description TODO: 方法一    两次遍历   2ms 99.08%
 *                  初始化糖果都给一个，然后从前往后遍历，从后往前遍历，按照规则更新糖果值
 */
class Solution_1 {
    public int candy(int[] ratings) {
        int[] nums = new int[ratings.length];
        // 所有人先给一个糖果
        for(int i = 0;i < ratings.length;i++){
            nums[i] = 1;
        }

        // 从左向右遍历，增加糖果
        for(int i = 1;i < ratings.length;i++){
            if(ratings[i] > ratings[i - 1]) {
                // 取两者较大值，因为两侧均要满足ratings大的nums更大
                nums[i] = Math.max(nums[i], nums[i - 1] + 1);
            }
        }


        // 从右向左遍历，增加糖果
        for(int i = ratings.length - 2;i >= 0;i--){
            if(ratings[i] > ratings[i + 1]){
                // 取两者较大值，因为两侧均要满足ratings大的nums更大
                nums[i] = Math.max(nums[i], nums[i + 1] + 1);
            }
        }

        // 计算总和
        int total = 0;
        for(int num : nums){
            total += num;
        }
        return total;

    }
}
