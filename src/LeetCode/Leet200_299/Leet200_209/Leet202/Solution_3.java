package LeetCode.Leet200_299.Leet200_209.Leet202;

/**
 * TODO:==**方法三	龟兔赛跑算法**==（0ms）
 * <p>
 * 快慢指针。**快指针**每次计算当前数的下下个快乐数，**慢指针**每次计算当前数的下一个快乐数。若两个数相遇，则说明出现了无限循环
 */
class Solution_3 {
    public boolean isHappy(int n) {
        int slow = n; // 慢指针，每次计算当前数的下一个快乐数
        int fast = happyNum(n); // 快指针，每次计算当前数的下下个快乐数
        while (slow != fast && fast != 1) {
            slow = happyNum(slow);
            fast = happyNum(happyNum(fast));
        }
        // 判断是因为相遇出了循环，还是值为1出了循环
        if (fast == 1) { // 值为1
            return true;
        } else { // 相遇
            return false;
        }
    }

    // 计算一个数的快乐数
    public int happyNum(int n) {
        int newN = 0;
        while (n != 0) {
            newN += Math.pow(n % 10, 2);
            n /= 10;
        }
        return newN;
    }
}
