package LeetCode.Leet700_799.Leet700_710.Leet704;

/**
 * @ClassName Solution
 * @Author 孙天赐
 * @Date 2025/4/29 15:14
 * @Description TODO: 方法一	左闭右闭	0ms	100%
 */
class Solution {
    public int search(int[] nums, int target) {
        // 左闭右闭
        int startIndex = 0;
        int endIndex = nums.length - 1;
        while(startIndex <= endIndex){
            int middleIndex = (startIndex + endIndex) / 2;
            if(target < nums[middleIndex]){
                endIndex = middleIndex - 1;
            }else if(target > nums[middleIndex]){
                startIndex = middleIndex + 1;
            }else{
                return middleIndex;
            }
        }

        return -1;
    }
}
