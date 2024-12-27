package LeetCode.Leet1_99.Leet10_19.Leet15;

import java.util.*;

/**
 * @ClassName Solution_1
 * @Description TODO: 方法一 双指针 29ms 87.17%
 *                  先排序，然后用双指针（严格来讲是三指针）
 * @Author 孙天赐
 * @Date 2024/12/25 17:09
 */
class Solution_1 {
    public List<List<Integer>> threeSum(int[] nums) {
        // 存放答案
        List<List<Integer>> result = new ArrayList<>();
        // 进行排序，方便后续使用双指针法
        Arrays.sort(nums);
        // 起始指针，每次循环的起始位置，从最左边开始，每次循环往右移动一位
        int startIndex = 0;
        while (startIndex < nums.length - 2) {
            // 如果第一个元素已经大于0了，则后面都不会存在答案了
            if (nums[startIndex] > 0) {
                break;
            }
            // 防止startIndex导致的重复
            if (startIndex > 0 && nums[startIndex] == nums[startIndex - 1]) {
                startIndex++;
                continue;
            }
            // 左指针，从起始指针的右侧开始
            int leftIndex = startIndex + 1;
            // 右指针，从数组最后开始
            int rightIndex = nums.length - 1;
            // 循环，直到两个指针相遇
            while (leftIndex < rightIndex) {

                int sum = nums[startIndex] + nums[leftIndex] + nums[rightIndex];
                if (sum < 0) {
                    // 三指针和小于0，左指针右移，增大和
                    leftIndex++;
                } else if (sum > 0) {
                    // 三指针和大于0，右指针左移，减小和
                    rightIndex--;
                } else {
                    // 三指针和等于0，找到答案，记录答案，左指针右移，右指针左移，继续寻找是否会有答案
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[startIndex]);
                    tempList.add(nums[leftIndex]);
                    tempList.add(nums[rightIndex]);
                    result.add(tempList);
                    // 防止leftIndex导致的重复
                    while (leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex + 1]) {
                        leftIndex++;
                    }
                    // 防止rightIndex导致的重复
                    while (leftIndex < rightIndex && nums[rightIndex] == nums[rightIndex - 1]) {
                        rightIndex--;
                    }
                    // 两个指针的位置都移动
                    leftIndex++;
                    rightIndex--;
                }

            }
            startIndex++;
        }
        return result;
    }
}
