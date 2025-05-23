package LeetCode.Leet1_99.Leet60_69.Leet69;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/5/10 15:57
 * @Description TODO: 方法一	二分查找	1ms	93.99%
 */
class Solution_1 {
    public int mySqrt(int x) {
        // 二分查找左边界
        int left = 0;
        // 二分查找右边界
        int right = x;
        // 结果
        int result = 0;
        while(true){
            int middle = (left + right) / 2;
            if(left == right - 1 || middle == 0){
                if(right * right == x){
                    result = right;
                }else{
                    result = left;
                }
                break;
            }
            // 不能用middle * middle < x，可能middle * middle会越界，两边各除以middle即可
            if(middle < x / middle){
                left = middle;
            }else if(middle > x / middle){
                right = middle;
            }else{
                result = middle;
                break;
            }
        }
        return result;
    }
}
