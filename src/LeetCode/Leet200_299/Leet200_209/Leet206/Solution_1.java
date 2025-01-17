package LeetCode.Leet200_299.Leet200_209.Leet206;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/1/4 15:10
 * @Description TODO: 方法一   递归  0ms 100%
 */
class Solution_1 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode nextNode = head.next;
        // 反转前面的链表
        ListNode newHead = reverseList(nextNode);
        // 将当前节点添加到尾部，并且将当前节点的next置为null
        nextNode.next = head;
        head.next = null;
        return newHead;
    }
}
