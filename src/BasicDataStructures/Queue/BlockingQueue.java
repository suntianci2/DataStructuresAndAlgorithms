package BasicDataStructures.Queue;

// 阻塞队列
public interface BlockingQueue<E> {
    // 添加元素，若队列满则永远处于等待状态
    void offer(E e) throws InterruptedException;

    // 添加元素，若队列满则处于等待状态，最多等待 timeout 毫秒
    boolean offer(E e,long timeout) throws InterruptedException;

    // 删除元素，若队列空则永远处于等待状态
    E poll() throws InterruptedException;

    // 删除元素，若队列空则处于等待状态，最多等待 timeout 毫秒
    E poll(long timeout) throws InterruptedException;

    // 判断队列是否已满
    boolean isFull();

    // 判断队列是否为空
    boolean isEmpty();
}
