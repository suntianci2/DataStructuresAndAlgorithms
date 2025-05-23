package LeetCode.Leet300_399.Leet370_379.Leet376;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/5/10 15:59
 * @Description TODO: 方法一	模拟	0ms	100%
 */
class Solution_1 {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length == 1){
            return nums.length;
        }
        int[] arr = new int[nums.length - 1];  // 存放差值
        // 计算差值数组
        for(int i = 0;i < nums.length - 1;i++){
            arr[i] = nums[i + 1] - nums[i];
        }

        // 寻找最大摆动序列（双指针）
        int result = 1;  // 最终结果
        int finalValue = arr[0];  // 存放当前摆动序列最后一个元素值
        int startIndex = 0;
        // 找到起始位置（第一个非0的位置）
        while(startIndex < arr.length && arr[startIndex] == 0){
            if(startIndex < arr.length - 1){
                finalValue = arr[startIndex + 1];
            }
            startIndex++;
        }
        // 寻找答案
        // 若数组全为0，则答案为1
        if(startIndex == arr.length){
            return 1;
        }
        // 从开始位置寻找答案
        for(int i = startIndex;i < arr.length;i++){
            if((finalValue > 0 && arr[i] < 0) || (finalValue < 0 && arr[i] > 0)){
                result++;
                finalValue = arr[i];
            }
        }
        return result + 1;
    }
}
