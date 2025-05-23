package LeetCode.Leet500_599.Leet500_509.Leet504;

/**
 * TODO:**方法一	循环**	（1ms）
 *
 * 使用StringBuilder拼接字符串
 */
class Solution_1 {
    public String convertToBase7(int num) {
        if(num >= 0){
            return ToBaseN(num, 7).reverse().toString();
        }else{
            return ToBaseN(-num, 7).append('-').reverse().toString();
        }

    }

    public StringBuilder ToBaseN(int num,int n){
        StringBuilder sb = new StringBuilder();
        while(num >= n){
            sb.append(num % n);
            num /= n;
        }
        sb.append(num);
        return sb;
    }
}
