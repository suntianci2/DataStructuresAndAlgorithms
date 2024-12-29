package LeetCode.Leet1_99.Leet10_19.Leet18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2024/12/29 11:18
 * @Description TODO: 方法一   双指针（严格来讲是四指针）   17ms    31.09%
 * 第一层循环控制第一个指针startIndex，从前面开始
 * 第二层循环控制第二个指针endIndex，从后面开始
 * 第三层循环控制startIndex和endIndex组成的窗口内部的两个指针index1和index2，分别从startIndex + 1和endIndex + 1开始
 */
class Solution_1 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        // 每次外循环开始的起始位置
        int startIndex = 0;
        while (startIndex < nums.length - 3) {
            // startIndex去重
            if (startIndex != 0 && nums[startIndex] == nums[startIndex - 1]) {
                startIndex++;
                continue;
            }

            // 每次内循环的终止位置
            int endIndex = nums.length - 1;
            while (startIndex < endIndex - 2) {
                // endIndex去重
                if (endIndex != nums.length - 1 && nums[endIndex] == nums[endIndex + 1]) {
                    endIndex--;
                    continue;
                }
                int index1 = startIndex + 1;
                int index2 = endIndex - 1;
                // 内内循环，移动index1和index2
                while (index1 < index2) {
                    // 用long保存结果，因为可能存在int类型溢出。
                    // 分段加，要是一起加的话，是先计算加的结果，然后再放到sum中，计算加的结果会溢出
                    long sum = nums[startIndex];
                    sum += nums[endIndex];
                    sum += nums[index1];
                    sum += nums[index2];
                    // 找到答案
                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[startIndex]);
                        temp.add(nums[index1]);
                        temp.add(nums[index2]);
                        temp.add(nums[endIndex]);
                        result.add(temp);
                        // 移动
                        index1++;
                        index2--;
                        // 去重
                        while (index1 < index2 && nums[index1] == nums[index1 - 1]) {
                            index1++;
                        }
                        while (index1 < index2 && nums[index2] == nums[index2 + 1]) {
                            index2--;
                        }
                        // 和比目标小，则左指针右移
                    } else if (sum < target) {
                        index1++;
                        // 和比目标大，则右指针左移
                    } else {
                        index2--;
                    }
                }
                endIndex--;
            }
            startIndex++;
        }
        return result;
    }
}
