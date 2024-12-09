package LeetCode.Leet1_99.Leet20_29.Leet1_9.Leet1;

import java.util.HashMap;

/**
 * TODO：==**方法二**== 哈希表 （2ms）
 * 使用哈希表，可以大大缩短查找所需的时间，减少时间复杂度
 */
class Solution_2 {
    public int[] twoSum(int[] nums, int target) {
        // 存放已经查找过的元素，键：已经查找过的元素的值。值：元素对应在原始数组中的索引
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            // 如果哈希表中有与当前元素所配对的那个元素，则说明找到了
            if(map.containsKey(target - nums[i])){
                int[] outcome = new int[2];
                outcome[0] = map.get(target - nums[i]);
                outcome[1] = i;
                return outcome;
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
