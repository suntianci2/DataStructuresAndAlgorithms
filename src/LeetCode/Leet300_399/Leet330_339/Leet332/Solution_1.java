package LeetCode.Leet300_399.Leet330_339.Leet332;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/4/15 16:54
 * @Description TODO: 方法一   递归回溯    超时（由于超时，所以不知道代码是否完全正确，但还是通过了部分测试用例）
 *                  1.递归回溯寻找答案，并动态维护最小路径
 *                  2.使用校验开关，控制两个答案之间的大小值校验只需进行一次
 */
class Solution_1 {
    List<List<String>> allResult = new ArrayList<>();
    List<String> minResult = new ArrayList<>();  // 记录最小路径结果
    List<String> result = new ArrayList<>();  // 记录当前路径
    boolean item = false;  // 校验开关，控制需不需要进行多个答案之间的大小值校验

    public List<String> findItinerary(List<List<String>> tickets) {
        doFindItinerary(tickets, "JFK");
        return minResult;
    }

    public void doFindItinerary(List<List<String>> tickets, String startLocation) {
        // 找到一个答案
        if (tickets.size() == 0) {
            result.add(startLocation);
            minResult = new ArrayList<>(result);
            result.remove(result.size() - 1);
            // 找到一个答案，继续打开校验开关
            item = false;
            return;
        }
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).get(0).equals(startLocation)) {
                String nextLocation = tickets.get(i).get(1);
                // 如果已有最小结果的路径小于等于当前路径，则不再继续递归回溯
                if (!minResult.isEmpty()) {
                    String minResultLocation = minResult.get(result.size());
                    if (!minResultLocation.equals(nextLocation)) {
                        // 在不相等的情况下才判断，如果已有最小结果的路径小于等于当前路径，则不再继续递归回溯
                        // 此判断只会进行一次，若会继续递归回溯，后面深入递归将不再判断
                        if (!item && smaller(minResultLocation, nextLocation)) {
                            continue;
                        }
                        // 用于标识，已通过校验，后续不再校验
                        item = true;
                    }
                }

                // 递归
                List<String> temp = tickets.remove(i);
                result.add(startLocation);

                doFindItinerary(tickets, nextLocation);
                // 回溯
                result.remove(result.size() - 1);
                tickets.add(i, temp);
            }
        }
    }

    // 判断两个字符串的大小
    public boolean smaller(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return s1.length() < s2.length();
        }
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 == c2) {
                continue;
            }
            if (c1 < c2) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
