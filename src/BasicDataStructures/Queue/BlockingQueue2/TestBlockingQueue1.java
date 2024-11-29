package BasicDataStructures.Queue.BlockingQueue2;

import org.junit.Test;

public class TestBlockingQueue1 {
    @Test
    public void testNormalOfferAndPop() throws InterruptedException {
        BlockingQueue2<Integer> integerBlockingQueue1 = new BlockingQueue2<>(5);
        // 开辟一个子线程
        Thread thread1 = new Thread(() -> {
            try {
                integerBlockingQueue1.offer(2);
                integerBlockingQueue1.offer(4);
                integerBlockingQueue1.offer(6);
                integerBlockingQueue1.offer(7);
                integerBlockingQueue1.offer(8);
                integerBlockingQueue1.offer(9);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "子线程1");
        thread1.start();


        System.out.println(integerBlockingQueue1.poll());
    }

    @Test
    public void testMaxTimeOffer() throws InterruptedException {
        BlockingQueue2<Integer> integerBlockingQueue1 = new BlockingQueue2<>(5);
        // 开辟一个子线程
        Thread thread1 = new Thread(() -> {
            try {
                System.out.println(integerBlockingQueue1.offer(2, 5000));
                System.out.println(integerBlockingQueue1.offer(4, 5000));
                System.out.println(integerBlockingQueue1.offer(6, 5000));
                System.out.println(integerBlockingQueue1.offer(7, 5000));
                System.out.println(System.currentTimeMillis());
                System.out.println(integerBlockingQueue1.offer(8, 5000));
                System.out.println(integerBlockingQueue1.offer(9, 5000));
                System.out.println(System.currentTimeMillis());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "子线程1");
        thread1.start();
        Thread.sleep(3000);
        System.out.println(integerBlockingQueue1.poll());
        Thread.sleep(2000);

    }

    @Test
    public void testMaxTimePoll() throws InterruptedException {
        BlockingQueue2<Integer> integerBlockingQueue1 = new BlockingQueue2<>(5);
        // 开辟一个子线程
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(3000);
                System.out.println(integerBlockingQueue1.offer(1, 5000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "子线程1");
        thread1.start();
        System.out.println(System.currentTimeMillis());
        System.out.println(integerBlockingQueue1.poll(5000));
        System.out.println(System.currentTimeMillis());
    }
}
