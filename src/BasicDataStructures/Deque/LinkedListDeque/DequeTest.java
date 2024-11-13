package BasicDataStructures.Deque.LinkedListDeque;

import org.junit.Test;

public class DequeTest {

    @Test
    public void LinkedListDequeOfferTest() {
        LinkedListDeque<Integer> deque = new LinkedListDeque<>(5);
        System.out.println(deque.isEmpty());
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerFirst(3);

        deque.offerLast(4);
        deque.offerLast(5);
        System.out.println(deque.isFull());
        for (Integer i : deque) {
            System.out.println(i);
        }

    }


    @Test
    public void LinkedListDequePeekTest() {
        LinkedListDeque<Integer> deque = new LinkedListDeque<Integer>(5);
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerFirst(3);
        deque.offerFirst(4);
        deque.offerFirst(5);

        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());
        for (Integer i : deque) {
            System.out.println(i);
        }

        System.out.println("----------------------------");

        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());
        for (Integer i : deque) {
            System.out.println(i);
        }
    }
}
