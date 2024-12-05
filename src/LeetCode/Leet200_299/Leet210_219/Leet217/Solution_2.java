package LeetCode.Leet200_299.Leet210_219.Leet217;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO:==**方法二	哈希表**==	（7ms）
 * <p>
 * 逐个向哈希表中添加元素，若出现添加元素方法返回false，则表示该元素已经存在在哈希表中，返回true
 */
class Solution_2 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        for (int num : nums) {
            if (!hs.add(num)) {
                return true;
            }
        }
        return false;
    }
}
