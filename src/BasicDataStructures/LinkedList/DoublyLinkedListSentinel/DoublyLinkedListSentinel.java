package BasicDataStructures.LinkedList.DoublyLinkedListSentinel;


import java.util.Iterator;
import java.util.function.Consumer;

public class DoublyLinkedListSentinel implements Iterable<Integer> {

    // 头节点
    private Node headNode;
    private Node tailNode;

    // 节点类
    private static class Node {
        Node prev;
        Node next;
        int value;

        public Node(Node prev,Node next,int value){
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    }

    public DoublyLinkedListSentinel(){
        // 先把两个节点创建出来，再对元素赋值
        headNode = new Node(null,null,666);
        tailNode = new Node(null,null,666);
        headNode.next = tailNode;
        tailNode.prev = headNode;
    }

    // 头插法
    public void addFirst(int num) {
        insert(0,num);
    }

    //尾插法
    public void addLast(int num) {
        Node prev =  tailNode.prev;
        Node insertedNode = new Node(prev,tailNode,num);
        prev.next = insertedNode;
        tailNode.prev = insertedNode;
    }

    // 指定索引插入元素
    public void insert(int index, int value) {
        Node prev = getNode(index - 1);
        if (prev == null){
            throw new NullPointerException();
        }

        Node next = prev.next;
        Node insertedNode = new Node(prev,next,value);
        prev.next = insertedNode;
        next.prev = insertedNode;
    }

    // 删除第一个节点
    public void removeFirst() {
        remove(0);
    }

    // 删除指定索引的节点
    public void remove(int index) {
        Node node = getNode(index);
        if (node == null || node == headNode || node == tailNode){
            throw new NullPointerException();
        }
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;

    }

    // 删除最后一个节点
    public  void removeLast(){
        Node thisNode = tailNode.prev;
        if (thisNode == headNode){
            throw new NullPointerException();
        }
        Node prev = thisNode.prev;
        if (prev == headNode){
            throw new NullPointerException();
        }
        prev.next = tailNode;
        tailNode.prev = prev;

    }


    // 获取指定索引元素
    public int get(int index) {

        return 0;
    }

    // 根据索引获取指定节点
    private Node getNode(int index) {
        int i = -1;
        Node node = headNode;
        while (node != null){
            if (i == index){
                break;
            }
            node = node.next;
            i++;
        }
        return node;
    }


    // 遍历1
    public void foreach(Consumer<Integer> consumer) {
        Node node = headNode.next;
        while (node.next != null){
            consumer.accept(node.value);
            node = node.next;
        }
    }

    // 遍历2（迭代器）
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = headNode.next;
            @Override
            public boolean hasNext() {
                return p != tailNode;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }

}
