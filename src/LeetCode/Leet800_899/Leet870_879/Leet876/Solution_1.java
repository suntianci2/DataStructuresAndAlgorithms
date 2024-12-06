package LeetCode.Leet800_899.Leet870_879.Leet876;

/**
 * TODO:**方法一**
 * <p>
 * 先求长度，再找中间节点（0ms）
 */
class Solution_1 {
    public ListNode middleNode(ListNode head) {
        int len = 0;
        ListNode thisNode = head;
        // 计算出链表的长度
        while (thisNode != null) {
            len++;
            thisNode = thisNode.next;
        }
        // 找到中间节点
        thisNode = head;
        while (len > 1) {
            thisNode = thisNode.next;
            len -= 2;
        }
        return thisNode;
    }
}
