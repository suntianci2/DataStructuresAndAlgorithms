package LeetCode.Leet1_99.Leet40_49.Leet46;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/4/4 12:48
 * @Description TODO: 方法一   递归回溯    1ms 96.69%
 */
class Solution_1 {
    List<List<Integer>> result = new ArrayList<>();  // 存储结果集
    List<Integer> nowResult = new ArrayList<>();  // 存储单个结果
    List<Integer> numsList = new ArrayList<>();  // 存储当前数字列表

    public List<List<Integer>> permute(int[] nums) {
        // 将数组转换为List集合
        for (int i = 0; i < nums.length; i++) {
            numsList.add(nums[i]);
        }
        // 递归寻找答案
        doPermute();
        return result;
    }

    // 递归寻找答案
    public void doPermute() {
        // 递归终止条件：找到答案（当前数字列表为空）
        if (numsList.isEmpty()) {
            result.add(new ArrayList<>(nowResult));
        }
        // 使用一个局部变量存储当前数字列表，避免直接操作成员变量而出现并发修改异常
        List<Integer> list = new ArrayList<>(numsList);
        // 递归寻找答案，将当前元素作为第一个元素，并在剩下元素中寻找答案
        for (int i = 0; i < list.size(); i++) {
            Integer num = list.get(i);
            nowResult.add(num);  // 当前元素添加进结果中
            numsList.remove(i);  // 移除当前元素，用于后续在剩下元素中寻找答案
            doPermute();  // 递归寻找答案
            nowResult.remove(nowResult.size() - 1);  // 回溯
            numsList.add(i, num);  // 回溯，向当前位置(i)插入num
        }

    }

}
