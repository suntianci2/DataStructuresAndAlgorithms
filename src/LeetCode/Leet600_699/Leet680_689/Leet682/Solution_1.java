package LeetCode.Leet600_699.Leet680_689.Leet682;

import java.util.ArrayList;

/**
 * TODO:**方法一	集合**	（2ms）
 * <p>
 * 定义一个集合存储每次得分。集合可以理解成**变长数组**
 */
class Solution_1 {
    public int calPoints(String[] operations) {
        ArrayList<Integer> list = new ArrayList<>();
        for (String s : operations) {
            if ("C".equals(s)) {
                //前一次得分无效
                list.remove(list.size() - 1);
            } else if ("D".equals(s)) {
                // 本回合新获得的得分是前一次得分的两倍
                list.add(2 * list.get(list.size() - 1));
            } else if ("+".equals(s)) {
                // 本回合新获得的得分是前两次得分的总和
                list.add(list.get(list.size() - 1) + list.get(list.size() - 2));
            } else {
                // 是数字的情况
                list.add(Integer.parseInt(s));
            }
        }
        int sum = 0;
        for (Integer i : list) {
            sum += i;
        }
        return sum;
    }
}
