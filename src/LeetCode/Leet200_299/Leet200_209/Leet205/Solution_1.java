package LeetCode.Leet200_299.Leet200_209.Leet205;

import java.util.HashMap;

/**
 * TODO:==**方法一	哈希表**==	(7ms)
 */
class Solution_1 {
    public boolean isIsomorphic(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < sArr.length; i++) {
            // 集合中不包括s的键
            if (!map.containsKey(sArr[i])) {
                // 集合中包括t的值
                if (map.containsValue(tArr[i])) {
                    return false;
                }
                // 集合中不包括t的值
                map.put(sArr[i], tArr[i]);
                continue;
            }
            // 将当前映射规则添加到map集合中
            if (map.get(sArr[i]) != tArr[i]) {
                return false;
            }
        }
        return true;
    }
}