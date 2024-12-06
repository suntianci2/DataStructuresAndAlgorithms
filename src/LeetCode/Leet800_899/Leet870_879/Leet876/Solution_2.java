package LeetCode.Leet800_899.Leet870_879.Leet876;

/**
 * TODO:==**方法二**==
 * <p>
 * 双指针，快慢指针，快指针一次走两步，慢指针一次走一步。一次遍历即可找到节点（0ms）
 */
class Solution_2 {
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode firstNode = head;
        ListNode secondNode = head;
        while (firstNode != null && firstNode.next != null) {
            firstNode = firstNode.next.next;
            secondNode = secondNode.next;
        }
        return secondNode;
    }
}
