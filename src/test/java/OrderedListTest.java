import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderedListTest {

    private OrderedList<Integer> list;

    @Before
    public void setUp() {
        list = new OrderedList<Integer>(true);
    }

    @Test
    public void normTest() {
        setUp();
        list.add(1);
        list.add(11);
        list.add(-1);
        list.add(-11);
        list.printList();

    }

    @Test
    public void compare() {
        setUp();
        assertEquals(list.compare(1, 1), 0);
        assertEquals(list.compare(-1123, 2434), -1);
        assertEquals(list.compare(-1, -2), 1);
        assertEquals(list.compare(-1, 0), -1);
        assertEquals(list.compare(0, -1), 1);
        OrderedList<String> listS = new OrderedList<>(true);
        assertEquals(listS.compare("-1", "-1"), 0);
        assertEquals(listS.compare("123", "111"), 1);
        assertEquals(listS.compare("1dfcsdvsd1v", "qasd"), -1);

    }

    @Test
    public void add() {
        setUp();
        assertEquals(list.count(), 0);
        list.add(1);
        list.add(10);
        list.add(0);
        list.add(0);
        list.add(-1);
        list.add(1);
        list.printList();

        assertEquals(list.count(), 6);
    }

    @Test
    public void find() {
        setUp();
        list.printList();

        assertNull(list.find(1));
        list.add(1);
        list.add(10);
        list.add(0);
        list.add(0);
        list.add(-1);
        list.add(1);
        list.add(0);
        list.printList();
//        assertNotNull(list.find(1));
    }

    @Test
    public void delete() {
        setUp();
        list.add(1);
        list.add(2);
        list.add(0);
        list.add(-11);
        list.delete(20);
        list.delete(2);
        list.delete(-11);
        list.delete(0);
        list.delete(1);
        list.delete(1);
        list.printList();
    }

    @Test
    public void clear() {
    }

    @Test
    public void count() {
    }

    @Test
    public void getAll() {
    }
}