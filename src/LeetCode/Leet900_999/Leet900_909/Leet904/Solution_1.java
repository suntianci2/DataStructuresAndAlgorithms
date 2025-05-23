package LeetCode.Leet900_999.Leet900_909.Leet904;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/5/12 16:30
 * @Description TODO: 方法一   滑动窗口    4ms 99.67%
 */
class Solution_1 {
    // 也就是找只能有两种元素的最大连续子数组的长度
    public int totalFruit(int[] fruits) {
        int result = 0;  // 存放最终结果
        int a = fruits[0];  // a篮子的水果种类
        int b = -1;  // b篮子的水果种类
        int i = 0;  // 滑动窗口起始位置
        int j = 1;  // 滑动窗口终止位置
        while (j < fruits.length) {
            // 如果当前水果与果篮中其中一种水果相同，窗口向后移动
            if (fruits[j] == a || fruits[j] == b) {
                j++;
            } else {
                if (b == -1) {
                    b = fruits[j];
                    j++;
                } else {
                    // 记录结果
                    // 此时j指向第三个元素，所以这里不需要额外减1
                    result = result > j - i ? result : j - i;
                    // 从当前位置往前寻找所有的前一元素（也就是找到前一种水果开始的位置）
                    int preFruit = fruits[j - 1];
                    i = j - 1;
                    while (i - 1 >= 0 && fruits[i - 1] == preFruit) {
                        i--;
                    }
                    // 此时，滑动窗口起始位置为前一水果的起始位置，j滑动窗口终止位置为新水果的位置
                    // 更换篮子中的水果种类，开始下次循环
                    if (a == fruits[i]) {
                        b = fruits[j];
                    } else {
                        a = fruits[j];
                    }
                }
            }
        }
        // 此时j指向数组最后一个元素的后面一个位置，所以这里不需要额外减1
        return result > j - i ? result : j - i;
    }
}
