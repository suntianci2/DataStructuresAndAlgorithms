package LeetCode.Leet400_499.Leet400_409.Leet_405;

/**
 * TODO:==**方法一	位运算**==	（0ms）
 */
class Solution_1 {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        // 每次处理4位
        for (int i = 0; i < 8; i++) {
            // 如果已经结束，则退出循环
            if (num == 0) {
                break;
            }
            sb.append(Hex(num & 0xF));
            num = num >>> 4;
        }
        return sb.reverse().toString();
    }

    // 计算0~16整数的一位16进制数值
    public char Hex(int num) {
        if (num < 10) {
            return (char) (num + '0');
        } else {
            return (char) (num - 10 + 'a');
        }
    }
}
