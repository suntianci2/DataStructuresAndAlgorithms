package LeetCode.Leet1_99.Leet20_29.Leet24;

/**
 * TODO: 方法一  递归  （0ms）
 */
class Solution_1 {
    public ListNode swapPairs(ListNode head) {
        // 第一个节点为空，则直接返回空
        if (head == null) {
            return null;
        }
        ListNode thisNode = head;
        ListNode nextNode = head.next;
        // 第二个节点不为空，则递归进行交换，然后返回新的头节点。否则直接返回第一个节点作为头节点
        if (nextNode != null) {
            ListNode nextNextNode = nextNode.next;
            // 先递归交换后面的节点
            nextNextNode = swapPairs(nextNextNode);
            // 然后再交换节点thisNode和nextNode
            thisNode.next = nextNextNode;
            nextNode.next = thisNode;
            // 直接返回新的头节点。
            return nextNode;
        }
        return head;
    }
}