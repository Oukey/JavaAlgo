import org.junit.Test;

import static org.junit.Assert.*;

public class DequeTest {
    private Deque<Integer> data;

    public void setUp() {
        data = new Deque<>();
    }

    @Test
    public void addFront() {
        setUp();
        assertEquals(data.size(), 0);
        data.addFront(1);
        data.addFront(2);
        data.addFront(3);
        assertEquals(data.size(), 3);
        assertEquals(data.removeFront().intValue(), 3);
        assertEquals(data.removeFront().intValue(), 2);
        assertEquals(data.removeFront().intValue(), 1);
        assertNull(data.removeFront());
        assertEquals(data.size(), 0);
    }

    @Test
    public void addTail() {
        setUp();
        data.addTail(1);
        data.addTail(2);
        data.addTail(3);
        assertEquals(data.removeTail().intValue(), 3);
        assertEquals(data.removeTail().intValue(), 2);
        assertEquals(data.removeTail().intValue(), 1);
        data.show();

    }

    @Test
    public void remove() {
        setUp();
        data.addTail(1);
        data.addFront(0);
        data.addFront(-1);
        data.addTail(2);
        data.addFront(-2);
        data.addTail(3);
        data.addFront(-3);
        assertEquals(data.removeFront().intValue(), -3);
        assertEquals(data.removeTail().intValue(), 3);
        assertEquals(data.removeFront().intValue(), -2);
        assertEquals(data.removeTail().intValue(), 2);
        assertEquals(data.removeFront().intValue(), -1);
        assertEquals(data.removeTail().intValue(), 1);
        assertEquals(data.removeFront().intValue(), 0);
        assertNull(data.removeTail());
    }
}
