import org.junit.Before;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

public class DynArrayTest {

    private DynArray<Integer> array;

    @Before
    public void setUp() {
        array = new DynArray<Integer>(Integer.class);
    }

    public void fillArray(int num) {
        for (int i = 0; i < num; i++) {
            array.append(i);
        }
    }

    @Test
    public void makeArray() {
        setUp();
        assertEquals(array.capacity, 16);
        assertEquals(array.count, 0);
        fillArray(10);
        assertEquals(array.capacity, 16);
        assertEquals(array.count, 10);
        setUp();
        fillArray(17);
        assertEquals(array.capacity, 32);
        assertEquals(array.count, 17);
        setUp();
        array.makeArray(12);
    }

    @Test
    public void getItem() {
        setUp();
        fillArray(5);
        assertEquals(array.getItem(0).intValue(), 0);
        assertEquals(array.getItem(1).intValue(), 1);
        assertEquals(array.getItem(2).intValue(), 2);
        assertEquals(array.getItem(3).intValue(), 3);
        assertEquals(array.getItem(4).intValue(), 4);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getItemExcept() {
        setUp();
        fillArray(5);
        assertNull(array.getItem(5));
    }

    @Test
    public void append() {
        setUp();
        fillArray(5);
        assertEquals(array.capacity, 16);
        assertEquals(array.count, 5);
        array.append(55);
        assertEquals(array.capacity, 16);
        assertEquals(array.count, 6);
        assertEquals(array.getItem(5).intValue(), 55);
        fillArray(11);
        assertEquals(array.capacity, 32);
        assertEquals(array.count, 17);
    }

    @Test
    public void insert_1() {
        setUp();
        array.insert(11, 0);
        array.append(22);
        array.insert(44, 2);
        array.insert(33, 2);
        assertEquals(array.getItem(0).intValue(), 11);
        assertEquals(array.getItem(1).intValue(), 22);
        assertEquals(array.getItem(2).intValue(), 33);
        assertEquals(array.getItem(3).intValue(), 44);
        fillArray(12);
        assertEquals(array.count, 16);
        assertEquals(array.capacity, 16);
        array.insert(55, 4);
        assertEquals(array.count, 17);
        assertEquals(array.capacity, 32);
        fillArray(15);
        assertEquals(array.count, 32);
        assertEquals(array.capacity, 32);
        array.insert(66, 32);
        assertEquals(array.getItem(32).intValue(), 66);
        assertEquals(array.count, 33);
        assertEquals(array.capacity, 64);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void insertExcept() {
        setUp();
        array.insert(100, -1);
        array.insert(200, 15);
        fillArray(12);
        array.insert(300, 72);
    }

    @Test
    public void remove() {
        setUp();
        fillArray(5);
        assertEquals(array.count, 5);
        array.remove(0);
        assertEquals(array.count, 4);
        array.remove(3);
        assertEquals(array.count, 3);
        setUp();
        fillArray(17);
        assertEquals(array.capacity, 32);
        array.remove(16);
        array.remove(15);
        array.remove(14);
        assertEquals(array.capacity, 21);
        array.remove(0);
        array.remove(0);
        array.remove(0);
        array.remove(0);
        assertEquals(array.capacity, 16);
        assertEquals(array.capacity, 16);
        array.remove(0);
        array.remove(0);
        array.remove(0);
        array.remove(0);
        array.remove(0);
        array.remove(0);
        array.remove(0);
        array.remove(0);
        array.remove(0);
        array.remove(0);
        assertEquals(array.capacity, 16);
        assertEquals(array.count, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeExept() {
        setUp();
        array.remove(0);
        fillArray(5);
        array.remove(5);
        fillArray(12);
        array.remove(-1);
    }
}
