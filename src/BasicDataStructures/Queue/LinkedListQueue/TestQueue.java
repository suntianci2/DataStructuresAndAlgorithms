package BasicDataStructures.Queue.LinkedListQueue;

import org.junit.Test;

import java.util.Iterator;

public class TestQueue {

    @Test
    public void OfferTest(){
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        queue.offer(1);
        queue.offer(5);
        queue.offer(7);
        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void isEmptyTest(){
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        System.out.println(queue.isEmpty());
        queue.offer(1);
        System.out.println(queue.isEmpty());
    }

    @Test
    public void peekTest(){
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        System.out.println(queue.peek());
        queue.offer(1);
        System.out.println(queue.peek());
        queue.offer(5);
        System.out.println(queue.peek());
        queue.offer(7);
        System.out.println(queue.peek());
    }

    @Test
    public void pollTest(){
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        queue.offer(1);
        queue.offer(5);
        queue.offer(7);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
