package LeetCode.Leet200_299.Leet200_209.Leet206;

import java.util.Stack;

/**
 * @ClassName Solution_3
 * @Author 孙天赐
 * @Date 2025/1/4 15:21
 * @Description TODO: 方法三   栈   1ms 2.58%
 *                     利用栈的特性：先进后出，实现反转
 */
class Solution_3 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode thisNode = head;
        // 按顺序将节点压入栈
        while(thisNode != null){
            stack.push(thisNode);
            thisNode = thisNode.next;
        }
        // 按顺序取出节点，组成反转的链表
        ListNode newHead = stack.pop();
        thisNode = newHead;
        while(!stack.isEmpty()){
            thisNode.next = stack.pop();
            thisNode = thisNode.next;
        }
        thisNode.next = null;
        return newHead;
    }
}
