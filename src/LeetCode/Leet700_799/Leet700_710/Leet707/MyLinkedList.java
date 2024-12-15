package LeetCode.Leet700_799.Leet700_710.Leet707;

/**
 * TODO: 双向链表   （7ms）
 */
class MyLinkedList {

    //双向链表
    Node headNode; // 头哨兵节点
    Node tailNode; // 尾哨兵节点

    // 节点类
    class Node{
        int val;
        Node next;
        Node prev;
    }

    // 初始化链表，具有两个哨兵节点
    public MyLinkedList() {
        headNode = new Node();
        tailNode = new Node();
        headNode.next = tailNode;
        tailNode.prev = headNode;
    }

    // 返回下标为 index 的节点的值，如果下标无效，则返回 -1 。
    public int get(int index) {
        int i = 0;
        Node thisNode = headNode.next;
        while(thisNode != tailNode){
            if(i == index){
                return thisNode.val;
            }
            thisNode = thisNode.next;
            i++;
        }
        return -1;
    }

    // 向头部添加元素
    public void addAtHead(int val) {
        Node newNode = new Node();
        newNode.val = val;
        // 更新新节点的前后节点
        newNode.next = headNode.next;
        newNode.prev = headNode;
        // 更新后一个节点的前节点为新节点
        headNode.next.prev = newNode;
        // 更新哨兵头节点的后节点为新节点
        headNode.next = newNode;

    }

    // 向尾部添加元素
    public void addAtTail(int val) {
        Node newNode = new Node();
        newNode.val = val;
        // 更新新节点的前后节点
        newNode.next = tailNode;
        newNode.prev = tailNode.prev;
        // 更新前一节点的后节点为新节点
        tailNode.prev.next = newNode;
        // 更新哨兵尾节点的前节点为新节点
        tailNode.prev = newNode;
    }

    // 向指定索引添加元素
    public void addAtIndex(int index, int val) {
        int i = 0;
        Node thisNode = headNode.next;
        while(thisNode != tailNode){
            // 如果进入if，则表明找到了指定的节点，往该节点前面插入新节点
            if(index == i){
                Node newNode = new Node();
                newNode.val = val;
                newNode.next = thisNode;
                newNode.prev = thisNode.prev;
                thisNode.prev.next = newNode;
                thisNode.prev = newNode;
                break;
            }
            thisNode = thisNode.next;
            i++;
        }

        // 如果进入此if，表明index等于链表的长度，则将节点插入链表尾部
        if(thisNode == tailNode && index == i){
            Node newNode = new Node();
            newNode.val = val;
            newNode.next = thisNode;
            newNode.prev = thisNode.prev;
            thisNode.prev.next = newNode;
            thisNode.prev = newNode;
        }
    }

    public void deleteAtIndex(int index) {
        int i = 0;
        Node thisNode = headNode.next;
        while(thisNode != tailNode){
            // 如果进入了if，则表明找到了待删除的节点，删除该节点即可
            if(index == i){
                thisNode.prev.next = thisNode.next;
                thisNode.next.prev = thisNode.prev;
                break;
            }
            thisNode = thisNode.next;
            i++;
        }

    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
