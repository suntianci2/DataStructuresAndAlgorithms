package BasicDataStructures.Deque;

// 双端队列
public interface Deque<E> {
    // 向头添加元素
    boolean offerFirst(E e);

    // 向尾添加元素
    boolean offerLast(E e);

    // 从头移除元素
    E pollFirst();

    // 从尾移除元素
    E pollLast();

    // 返回头部第一个元素值
    E peekFirst();

    // 返回尾部第一个元素值
    E peekLast();

    // 判断双端队列是否为
    boolean isEmpty();

    // 判断是否为满
    boolean isFull();
}
