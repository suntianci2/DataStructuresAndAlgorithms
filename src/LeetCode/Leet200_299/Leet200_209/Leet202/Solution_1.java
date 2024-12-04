package LeetCode.Leet200_299.Leet200_209.Leet202;

import java.util.HashSet;

/**
 * TODO:**方法一	哈希Set**（1ms）
 * <p>
 * 使用哈希集合存放每一次运算后的元素，若某一次运算后与集合中的元素出现重复，则说明进入了无限循环。
 */
class Solution_1 {
    public boolean isHappy(int n) {
        HashSet<Integer> hs = new HashSet<>();
        while (n != 1) {
            // 计算每个位上的数字的平方和
            int newN = 0;
            while (n != 0) {
                newN += Math.pow(n % 10, 2);
                n /= 10;
            }
            n = newN;
            // 若哈希表中已经存在了这个值，说明出现了无限循环
            if (!hs.add(newN)) {
                return false;
            }
        }
        return true;
    }
}
