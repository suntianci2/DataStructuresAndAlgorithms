package BasicDataStructures.Queue;

public interface Queue<E> {

    // 向队尾插入值
    public boolean offer(E value);

    // 从队头获取值，并移除
    public E poll();

    // 从队头获取值，不移除
    public E peek();

    // 检查队列是否为空
    public boolean isEmpty();

    // 检查队列是否满
    public boolean isFull();
}
