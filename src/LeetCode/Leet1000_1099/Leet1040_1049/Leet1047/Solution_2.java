package LeetCode.Leet1000_1099.Leet1040_1049.Leet1047;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/1/17 18:12
 * @Description TODO: 方法二   双指针     5ms     93.14%
 */
class Solution_2 {
    public String removeDuplicates(String s) {
        char[] sArr = s.toCharArray();
        if (sArr.length == 1) {
            return s;
        }
        int index1 = 0;  // 前指针
        int index2 = 1;  // 后指针
        while (index2 < sArr.length) {
            // 前指针不指向元素（表明当前的结果没有元素），或两指针处元素不相等，则将后指针元素放到前指针+1的位置处，等价于将当前元素添加到最后
            if (index1 < 0 || sArr[index1] != sArr[index2]) {
                sArr[++index1] = sArr[index2];
            } else { // 两指针处元素相等，则前指针向前移动一位，等价于丢弃最后一个元素
                index1--;
            }
            // 无论哪种情况，index2都要向前移动一位，即下一次循环处理下一个元素
            index2++;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= index1; i++) {
            result.append(sArr[i]);
        }
        return result.toString();
    }
}
