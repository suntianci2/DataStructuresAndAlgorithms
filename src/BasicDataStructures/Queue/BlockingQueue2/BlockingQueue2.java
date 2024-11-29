package BasicDataStructures.Queue.BlockingQueue2;

import BasicDataStructures.Queue.BlockingQueue;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// 双锁实现阻塞队列，提高效率
// 保证size变量的线程安全
// 防止死锁发生，不使用锁的嵌套
public class BlockingQueue2<E> implements BlockingQueue<E> {
    private E[] array = null;

    // 原子整数类，保证size的线程安全
    private AtomicInteger size = new AtomicInteger(0);
    private int head = 0;
    private int tail = 0;

    // 锁1，添加元素用的锁
    private ReentrantLock tailLock = new ReentrantLock();

    // 锁2，移除元素用的锁
    private ReentrantLock headLock = new ReentrantLock();

    // 条件变量，当添加元素的时候队列已满，则进入阻塞状态
    private Condition tailWaits = tailLock.newCondition();

    // 条件变量2，当移除元素的时候队列已空，则进入阻塞状态
    private Condition headWaits = headLock.newCondition();


    public BlockingQueue2(int capacity) {
        array = (E[]) new Object[capacity];
    }

    @Override
    public void offer(E e) throws InterruptedException {
        // 加上可打断的锁
        tailLock.lockInterruptibly();
        try {
            // 队列为满，进入阻塞状态
            while (isFull()) {
                // 循环休眠，以防万一出现假唤醒
                tailWaits.await();
                // 休眠后，该线程进入阻塞状态，等待其他线程唤醒它
            }
            // 执行相应逻辑
            array[tail++] = e;
            // 循环数组索引调整
            if (tail == array.length) {
                tail = 0;
            }
            // 自增，因为原子整数类的原子性，因此可以保证size的线程安全
            size.getAndIncrement();

        } finally {
            // 释放锁
            tailLock.unlock();
        }
        try {
            // 唤醒条件变量需要配合锁一起使用
            // 放在上一把锁的外面，防止锁的嵌套导致死锁
            headLock.lockInterruptibly();
            // 唤醒头部条件变量，表示当且队列已经不为空了
            headWaits.signal();
        }finally {
            headLock.unlock();

        }

    }

    @Override
    public boolean offer(E e, long timeout) throws InterruptedException {
        // 加上可打断的锁
        tailLock.lockInterruptibly();
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
            // 循环数组索引调整
            if (tail == array.length) {
                tail = 0;
            }
            // 自增，因为原子整数类的原子性，因此可以保证size的线程安全
            size.getAndIncrement();

        } finally {
            // 释放锁
            tailLock.unlock();
        }
        try {
            // 唤醒条件变量需要配合锁一起使用
            // 放在上一把锁的外面，防止锁的嵌套导致死锁
            headLock.lockInterruptibly();
            // 唤醒头部条件变量，表示当且队列已经不为空了
            headWaits.signal();
        }finally {
            headLock.unlock();
        }


        return true;

    }

    @Override
    public E poll() throws InterruptedException {
        E e = null;
        // 加上可打断的锁
        headLock.lockInterruptibly();
        try {
            // 队列为空，进入阻塞状态
            while (isEmpty()) {
                // 循环休眠，以防万一出现假唤醒
                headWaits.await();
            }
            // 逻辑代码
            e = array[head];
            array[head++] = null;
            // 循环数组索引调整
            if(head == array.length){
                head = 0;
            }
            // 自减，因为原子整数类的原子性，因此可以保证size的线程安全
            size.getAndDecrement();
        }finally {
            // 释放锁
            headLock.unlock();
        }
        try {
            // 唤醒条件变量需要配合锁一起使用
            // 放在上一把锁的外面，防止锁的嵌套导致死锁
            // 唤醒尾部条件变量，表明现在队列已经不满了
            tailLock.lockInterruptibly();
            tailWaits.signal();
            return e;
        }finally {
            tailLock.unlock();
        }
    }

    @Override
    public E poll(long timeout) throws InterruptedException {
        E e = null;
        // 加上可打断的锁
        headLock.lockInterruptibly();
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
            e = array[head];
            array[head++] = null;
            // 循环数组索引调整
            if(head == array.length){
                head = 0;
            }
            // 自减，因为原子整数类的原子性，因此可以保证size的线程安全
            size.getAndDecrement();
        }finally {
            // 释放锁
            headLock.unlock();
        }
        try {
            // 唤醒条件变量需要配合锁一起使用
            // 放在上一把锁的外面，防止锁的嵌套导致死锁
            // 唤醒尾部条件变量，表明现在队列已经不满了
            tailLock.lockInterruptibly();
            tailWaits.signal();
            return e;
        }finally {
            tailLock.unlock();
        }
    }

    @Override
    public boolean isFull() {
        return size.get() == array.length;
    }

    @Override
    public boolean isEmpty() {
        return size.get() == 0;
    }
}
