package LeetCode.Leet500_599.Leet540_549.Leet541;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/1/5 18:35
 * @Description TODO: 方法一 模拟  0ms 100%
 *                  注意转变一下题目思路，虽然题目是每计数2k个字符，反转前k个
 *                  但等价为，每计数k个或小于k个，则反转，然后跳过k个，再开始计数。
 */
class Solution_1 {
    public String reverseStr(String s, int k) {
        if(k == 1){
            return s;
        }
        char[] sArr = s.toCharArray();
        // 注意起始位置为-1，这样计数两个则表示技术到了 -1 + 2 = 1 索引处的元素
        int curIndex = -1;
        while(curIndex < sArr.length){
            // 前k个字符必定反转
            curIndex += k;
            if(curIndex < sArr.length){
                reverse(sArr, curIndex - k + 1, curIndex);
            }else{
                reverse(sArr, curIndex - k + 1, sArr.length - 1);
            }
            // 跳过k个字符
            curIndex += k;
        }
        return new String(sArr);
    }

    // 反转数组中索引从start到end（包含start和end）的元素
    public void reverse(char[] arr, int start, int end){
        int len = end - start + 1;
        for(int i = 0;i < len / 2;i++){
            char temp = arr[start + i];
            arr[start + i] = arr[end - i];
            arr[end - i] = temp;
        }
    }
}
