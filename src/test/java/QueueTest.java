import org.junit.Test;

//import java.util.Queue;

import static org.junit.Assert.*;

public class QueueTest {

    private Queue<Integer> queue;

    public void setUp() {
        queue = new Queue<>();
    }

    public void toPrint() {
        while (queue.size() > 0) {
            System.out.println(queue.dequeue());
        }
    }

    @Test
    public void test1() {
        setUp();
        assertEquals(queue.size(), 0);
        queue.enqueue(1);
        assertEquals(queue.size(), 1);
        assertEquals(queue.dequeue().intValue(), 1);
        assertNull(queue.dequeue());

    }

    @Test
    public void test2() {
        setUp();
        queue.enqueue(2);
        queue.enqueue(4);
        queue.enqueue(6);
        queue.enqueue(8);
        queue.enqueue(88);
        assertEquals(queue.size(), 5);
        assertEquals(queue.dequeue().intValue(), 2);
        assertEquals(queue.dequeue().intValue(), 4);
        assertEquals(queue.dequeue().intValue(), 6);
        assertEquals(queue.dequeue().intValue(), 8);
        assertEquals(queue.dequeue().intValue(), 88);
        assertEquals(queue.size(), 0);
    }

//    @Test
//    public void test3() {
//        setUp();
//        queue.enqueue(1);
//        queue.enqueue(2);
//        queue.enqueue(3);
//        queue.enqueue(4);
//        queue.enqueue(5);
//        assertNull(queue.rotate(queue, 6));
//        Queue<Integer> rotate = queue.rotate(queue, 5);
//        toPrint();
//        assertEquals(queue.size(), 0);
//
//    }
}