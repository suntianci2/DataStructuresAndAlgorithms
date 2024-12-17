package LeetCode.Leet1_99.Leet20_29.Leet24;

/**
 * 方法二  循环（迭代）  （0ms）
 */
class Solution_2 {
    public ListNode swapPairs(ListNode head) {
        ListNode thisNode = head;
        ListNode prevNode = null;   // 指向上一次循环结束后的后面那个节点，用于指向当前循环结束后的第一个节点
        while (thisNode != null) {
            // 获取nextNode
            ListNode nextNode = thisNode.next;
            if (nextNode == null) {
                break;
            }
            ListNode nextNextNode = nextNode.next;
            // 交换两个节点
            thisNode.next = nextNextNode;
            nextNode.next = thisNode;

            if (thisNode == head) {
                // 第一次进循环
                head = nextNode;
                prevNode = thisNode;
            } else {
                // 其余的循环
                prevNode.next = nextNode;
                prevNode = thisNode;
            }
            // 更新thisNode
            thisNode = thisNode.next;
        }
        return head;
    }
}