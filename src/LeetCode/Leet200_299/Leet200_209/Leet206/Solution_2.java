package LeetCode.Leet200_299.Leet200_209.Leet206;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/1/4 15:11
 * @Description TODO: 方法二   双指针+迭代  0ms 100%
 */
class Solution_2 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode thisNode = head;
        ListNode nextNode = head.next;
        thisNode.next = null;
        while(nextNode != null){
            ListNode nextNextNode = nextNode.next;
            nextNode.next = thisNode;
            // 本轮循环反转结束，将nextNode作为下一轮循环的thisNode，nextNextNode作为下一轮循环的nextNode
            thisNode = nextNode;
            nextNode = nextNextNode;
        }
        return thisNode;
    }
}
