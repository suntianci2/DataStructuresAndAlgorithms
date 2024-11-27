package BasicDataStructures.Queue.BlockingQueue1;

import BasicDataStructures.Queue.BlockingQueue;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// 单锁实现阻塞队列
public class BlockingQueue1<E> implements BlockingQueue<E> {
    private E[] array;
    private int size = 0;
    private int head = 0;
    private int tail = 0;

    // 单锁，添加和移除元素共用的锁
    private ReentrantLock lock = new ReentrantLock();

    // 条件变量，当添加元素的时候队列已满，则进入阻塞状态
    private Condition tailWaits = lock.newCondition();

    // 条件变量2，当移除元素的时候队列已空，则进入阻塞状态
    private Condition headWaits = lock.newCondition();


    public BlockingQueue1(int capacity) {
        array = (E[]) new Object[capacity];
    }

    @Override
    public void offer(E e) throws InterruptedException {
        // 加上可打断的锁
        lock.lockInterruptibly();
        try {
            // 队列为满，进入阻塞状态
            while (isFull()) {
                // 循环休眠，以防万一出现假唤醒
                tailWaits.await();
                // 休眠后，该线程进入阻塞状态，等待其他线程唤醒它
            }
            // 执行相应逻辑
            array[tail++] = e;
            size++;
            // 循环数组索引调整
            if (tail == array.length) {
                tail = 0;
            }
            // 唤醒头部条件变量，表示当且队列已经不为空了
            headWaits.signal();
        } finally {
            // 释放锁
            lock.unlock();
        }

    }

    @Override
    public boolean offer(E e, long timeout) throws InterruptedException {
        // 加上可打断的锁
        lock.lockInterruptibly();
        try {
            // 队列为满，进入阻塞状态
            long t = TimeUnit.MILLISECONDS.toNanos(timeout);
            while (isFull()) {
                // 循环休眠，以防万一出现假唤醒
                t = tailWaits.awaitNanos(t);
                // 休眠后，该线程进入阻塞状态，等待其他线程唤醒它
                // 当剩余时间小于0，则说明等待时间超过了指定时间，则退出，添加失败
                if(t <= 0){
                    return false;
                }
            }
            // 执行相应逻辑
            array[tail++] = e;
            size++;
            // 循环数组索引调整
            if (tail == array.length) {
                tail = 0;
            }
            // 唤醒头部条件变量，表示当且队列已经不为空了
            headWaits.signal();
            return true;
        } finally {
            // 释放锁
            lock.unlock();
        }

    }

    @Override
    public E poll() throws InterruptedException {
        // 加上可打断的锁
        lock.lockInterruptibly();
        try {
            // 队列为空，进入阻塞状态
            while (isEmpty()) {
                // 循环休眠，以防万一出现假唤醒
                headWaits.await();
            }
            // 逻辑代码
            E e = array[head];
            array[head++] = null;
            // 循环数组索引调整
            if(head == array.length){
                head = 0;
            }
            size--;
            // 唤醒尾部条件变量，表明现在队列已经不满了
            tailWaits.signal();
            return e;
        }finally {
            // 释放锁
            lock.unlock();
        }
    }

    @Override
    public E poll(long timeout) throws InterruptedException {
        // 加上可打断的锁
        lock.lockInterruptibly();
        try {
            // 队列为空，进入阻塞状态
            long t = TimeUnit.MILLISECONDS.toNanos(timeout);
            while (isEmpty()) {
                // 循环休眠，以防万一出现假唤醒
                t = headWaits.awaitNanos(t);
                // 休眠后，该线程进入阻塞状态，等待其他线程唤醒它
                // 当剩余时间小于0，则说明等待时间超过了指定时间，则退出，添加失败
                if(t <= 0){
                    return null;
                }
            }
            // 逻辑代码
            E e = array[head];
            array[head++] = null;
            // 循环数组索引调整
            if(head == array.length){
                head = 0;
            }
            size--;
            // 唤醒尾部条件变量，表明现在队列已经不满了
            tailWaits.signal();
            return e;
        }finally {
            // 释放锁
            lock.unlock();
        }
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
