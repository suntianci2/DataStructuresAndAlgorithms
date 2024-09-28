package BasicDataStructures.LinkedList.SinglyLinkedListSentinel;


import java.util.Iterator;
import java.util.function.Consumer;

public class SinglyLinkedListSentinel implements Iterable<Integer> {

    // 头节点
    private Node headNode = new Node(666, null);

    // 节点类
    private static class Node {

        // 当前节点的值
        int num;

        // 下一节点位置
        Node next;

        public Node(int num, Node next) {
            this.num = num;
            this.next = next;
        }

    }

    // 头插法
    public void addFirst(int num) {
        headNode.next = new Node(num, headNode.next);
    }

    //尾插法
    public void addLast(int num) {

        // 找到最后一个节点
        Node p = findLast();
        p.next = new Node(num, null);
    }

    // 指定索引插入元素
    public void insert(int index, int value) {
        Node prev = getNode(index - 1);
        if (prev == null) {
            throw new NullPointerException();
        }
        prev.next = new Node(value, prev.next);
    }

    // 删除第一个元素
    public void removeFirst() {
        headNode.next = headNode.next.next;
    }

    // 删除指定索引的元素
    public void remove(int index) {

        Node prev = getNode(index - 1);
        if (prev == null) {
            throw new NullPointerException();
        }

        Node thisNode = prev.next;
        if (thisNode == null) {
            throw new NullPointerException();
        }

        prev.next = thisNode.next;
    }

    // 获取指定索引元素
    public int get(int index) {
        Node p = getNode(index);
        if (p == null) {
            throw new NullPointerException();
        }
        return p.num;
    }

    // 根据索引获取指定节点
    private Node getNode(int index) {
        int i = -1;
        Node p = headNode;
        while (p != null) {
            if (i == index) {
                break;
            }
            p = p.next;
            i++;
        }
        return p;
    }

    // 找到最后一个节点
    private Node findLast() {
        Node p = headNode;
        while (p.next != null) {
            p = p.next;
        }
        return p;

    }

    // 遍历1
    public void foreach(Consumer<Integer> consumer) {
        Node p = headNode.next;
        while (p != null) {
            consumer.accept(p.num);
            p = p.next;
        }

    }

    // 遍历2（迭代器）
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = headNode.next;

            @Override
            public boolean hasNext() {
                return p != null;
            }

            @Override
            public Integer next() {
                int num = p.num;
                p = p.next;
                return num;
            }
        };
    }

}
