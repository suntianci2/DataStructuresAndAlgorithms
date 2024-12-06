package LeetCode.Leet200_299.Leet290_299.Leet290;

import java.util.HashMap;

/**
 * TODO:==**方法一	哈希表**==	（1ms）
 */
class Solution_1 {
    public boolean wordPattern(String pattern, String s) {
        char[] patArr = pattern.toCharArray();
        String[] sArr = s.split(" ");
        if (patArr.length != sArr.length) {
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < patArr.length; i++) {
            // 哈希表中不包含该键
            if (!map.containsKey(patArr[i])) {
                // 包含该值
                if (map.containsValue(sArr[i])) {
                    return false;
                }
                // 不包含该值
                map.put(patArr[i], sArr[i]);
                continue;
            }
            // 判断当前单词是否满足规则
            if (!(map.get(patArr[i])).equals(sArr[i])) {
                return false;
            }
        }
        return true;
    }
}
