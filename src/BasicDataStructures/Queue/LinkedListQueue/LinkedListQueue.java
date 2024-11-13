package BasicDataStructures.Queue.LinkedListQueue;

import BasicDataStructures.Queue.Queue;

import java.util.Iterator;

// 使用 单向环形带哨兵链表 实现队列
public class LinkedListQueue<E> implements Queue<E>, Iterable<E> {

    // 节点内部类
    public static class Node<E>{
        E value;
        Node next;

        public Node(E value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    // 头节点
    Node<E> head = new Node(null,null);
    // 尾节点
    Node<E> tail = head;

    // 初始化链表
    public LinkedListQueue() {
        tail.next = head;
    }

    // 向尾部添加节点
    @Override
    public boolean offer(E value) {
        Node<E> newNode = new Node<E>(value,head);
        tail.next = newNode;
        tail = newNode;
        return true;
    }

    // 从队头获取值，并移除
    @Override
    public E poll() {
        if(isEmpty()){
            return null;
        }
        Node<E> firstNode = head.next;
        head.next = firstNode.next;
        // 删除节点后队列为空
        if(firstNode == tail){
            tail = head;
        }
        return firstNode.value;
    }

    // 从队头获取值，不移除
    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        }
        return (E) head.next.value;


    }

    // 判断队列是否为空
    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    // 迭代器
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> thisNode = head.next; // 从哨兵节点的下一节点开始
            @Override
            public boolean hasNext() {
                return thisNode != head;
            }

            @Override
            public E next() {
                E value = thisNode.value;
                thisNode = thisNode.next;
                return value;
            }
        };
    }
}
