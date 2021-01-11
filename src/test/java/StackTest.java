import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class StackTest {

    private Stack<Integer> stack;

    public void setUp() {
        stack = new Stack<>();
    }

    @Test
    public void size() {
        setUp();
        assertEquals(stack.size(), 0);
        stack.push(123);
        assertEquals(stack.size(), 1);
        stack.push(234);
        assertEquals(stack.size(), 2);
    }

    @Test
    public void pop() {
        setUp();
        assertNull(stack.pop());
        stack.push(1);
        assertEquals(stack.pop().intValue(), 1);
        assertEquals(stack.size(), 0);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        assertEquals(stack.pop().intValue(), 4);
        assertEquals(stack.peek().intValue(), 3);
        assertEquals(stack.size(), 2);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.push(70);
        assertEquals(stack.size(), 9);
        assertEquals(stack.pop().intValue(), 70);
        assertEquals(stack.peek().intValue(), 60);
        assertEquals(stack.size(), 8);
        assertEquals(stack.pop().intValue(), 60);
        assertEquals(stack.peek().intValue(), 50);
        assertEquals(stack.size(), 7);
    }

}