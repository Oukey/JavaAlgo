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
// ##################################
//import org.junit.Test;
//
//import java.util.ArrayList;
//
//import static org.junit.Assert.*;
//
//public class OrderedListTest {
//
//    @Test
//    public void compare() {
//        OrderedList list = new OrderedList(true);
//        assertEquals(0, list.compare(25, 25));
//        assertEquals(-1, list.compare(199, 200));
//        assertEquals(1, list.compare(99, 78));
//    }
//
//    @Test
//    public void add() {
//        OrderedList list = new OrderedList(true);
//        list.add(1);
//        list.add(13);
//        list.add(-8);
//        list.add(21);
//        list.add(-555);
//        list.add(79);
//        list.add(25);
//        assertEquals(7, list.len);
//        assertEquals(79, list.tail.value);
//        assertEquals(-555, list.head.value);
//        assertEquals(25, list.tail.prev.value);
//
//    }
//
//    @Test
//    public void find() {
//        OrderedList list = new OrderedList(true);
//        list.add(1);
//        list.add(13);
//        list.add(-8);
//        list.add(21);
//        list.add(-555);
//        list.add(79);
//        list.add(25);
//        assertEquals(null, list.find(99));
//        assertEquals(-555, list.find(-555).value);
//        assertEquals(null, list.find(77));
//        list.printList();
//        System.out.println(list.len);
//        System.out.println(list.find(13));
//    }
//
//    @Test
//    public void delete() {
//        OrderedList list = new OrderedList(true);
//        list.add(1);
//        list.add(13);
//        list.add(-8);
//        list.add(21);
//        list.add(-555);
//        list.add(79);
//        list.add(25);
//        list.delete(-555);
//        assertEquals(-8, list.head.value);
//        list.delete(79);
//        assertEquals(25, list.tail.value);
//    }
//
//    @Test
//    public void clear() {
//        OrderedList list = new OrderedList(true);
//        list.add(1);
//        list.add(13);
//        list.add(-8);
//        list.add(21);
//        list.add(-555);
//        list.add(79);
//        list.add(25);
//        list.add(121);
//        list.clear(true);
//        assertEquals(0, list.len);
//        assertEquals(null, list.head);
//        assertEquals(null, list.tail);
//
//    }
//
//    @Test
//    public void getAll() {
//        OrderedList list = new OrderedList(true);
//        list.add(1);
//        list.add(13);
//        list.add(-8);
//        list.add(21);
//        list.add(-555);
//        list.add(79);
//        list.add(25);
//        list.add(121);
//        ArrayList<Node> list1 = list.getAll();
//        assertEquals(8, list1.size());
//        assertEquals(-555, list1.get(0).value);
//        assertEquals(121, list1.get(7).value);
//    }
//}

// ##################################

//

//import org.junit.Test;
//
//import java.util.ArrayList;
//
//public class OrderedListTest {
//    public static void Start() {
//        testAddInt();
//        testAddString();
//        testDelete();
//        testFind();
//    }
//
//    @Test
//    public static void testAddInt() {
//        OrderedList<Integer> x = new OrderedList<>(true);
//        OrderedList<Integer> a = new OrderedList<>(true);
//        OrderedList<Integer> b = new OrderedList<>(true);
//        OrderedList<Integer> c = new OrderedList<>(false);
//        boolean testb = true;
//        boolean testc = true;
//
//        a.add(1);
//
//
//        if (a.head.value != 1 || a.tail.value != 1 || a.count() != 1) {
//            System.out.println("testAddInt # 1 failed");
//        } else {
//            System.out.println("testAddInt # 1 passed");
//        }
//
//        int[] array = new int[100];
//        for (int i = 0; i < array.length; i++) {
//            array[i] = (int) (Math.random() * 100);
//        }
//        int max = array[0];
//        int min = array[0];
//        for (int value : array) {
//            if (value > max) {
//                max = value;
//            } else if (value < min) {
//                min = value;
//            }
//        }
//
//        for (int value : array) {
//            b.add(value);
//        }
//
//        if (b.head.value != min && b.tail.value != max && b.count() != array.length) {
//            testb = false;
//        }
//
//        ArrayList<Node<Integer>> arrayList = b.getAll();
//        for (int i = 0; i < arrayList.size() - 1; i++) {
//            if ((Integer) arrayList.get(i).value > (Integer) arrayList.get(i + 1).value) {
//                testb = false;
//                System.out.println(2);
//                break;
//            }
//        }
//
//        if (testb) {
//            System.out.println("testAddInt # 2 passed");
//        } else {
//            System.out.println("testAddInt # 2 failed");
//        }
//
//
//        for (int value : array) {
//            c.add(value);
//        }
//        if (b.head.value != max && b.tail.value != min && b.count() != array.length) {
//            testc = false;
//        }
//        ArrayList<Node<Integer>> arrayList1 = c.getAll();
//        for (int i = 0; i < arrayList1.size() - 1; i++) {
//            if ((Integer) arrayList1.get(i).value < (Integer) arrayList1.get(i + 1).value) {
//                testb = false;
//                System.out.println(2);
//                break;
//            }
//        }
//        if (testc) {
//            System.out.println("testAddInt # 3 passed");
//        } else {
//            System.out.println("testAddInt # 3 failed");
//        }
//
//    }
//
//    public static void testAddString() {
//        OrderedList<String> a = new OrderedList<>(true);
//        OrderedList<String> b = new OrderedList<>(true);
//        OrderedList<String> c = new OrderedList<>(false);
//        boolean testb = true;
//        boolean testc = true;
//
//        a.add("Hello");
//
//        if (a.head.value.equals("Hello") && a.tail.value.equals("Hello") && a.count() == 1) {
//            System.out.println("testAddString # 1 passed");
//        } else {
//            System.out.println("testAddString # 1 failed");
//        }
//
//
//        String[] array = {"b", "a", "d", "c", "e", "f", "g", "i", "h"};
//        for (String aa : array) {
//            b.add(aa);
//        }
//
//        if (!a.head.value.equals("a") && !a.tail.value.equals("i") && b.count() != array.length) {
//            testb = false;
//        }
//
//        ArrayList<Node<String>> arrayList = b.getAll();
//        for (int i = 0; i < arrayList.size() - 1; i++) {
//            String first = (String) arrayList.get(i).value;
//            String second = (String) arrayList.get(i + 1).value;
//            if (first.compareTo(second) > 0) {
//                testb = false;
//                break;
//            }
//        }
//
//
//        if (testb) {
//            System.out.println("testAddString # 2 passed");
//        } else {
//            System.out.println("testAddString # 2 failed");
//        }
//
//        for (String aa : array) {
//            c.add(aa);
//        }
//
//        if (!a.head.value.equals("a") && !a.tail.value.equals("i") && c.count() != array.length) {
//            testc = false;
//        }
//
//
//        ArrayList<Node<String>> arrayList1 = b.getAll();
//        for (int i = 0; i < arrayList1.size() - 1; i++) {
//            String first = (String) arrayList1.get(i).value;
//            String second = (String) arrayList1.get(i + 1).value;
//            if (second.compareTo(first) > 0) {
//                testb = false;
//                break;
//            }
//        }
//
//        if (testc) {
//            System.out.println("testAddString # 3 passed");
//        } else {
//            System.out.println("testAddString # 3 failed");
//        }
//    }
//
//    public static void testDelete() {
//        OrderedList<Integer> a = new OrderedList<>(true);
//        OrderedList<Integer> b = new OrderedList<>(true);
//        OrderedList<String> c = new OrderedList<>(false);
//
//        boolean testb = true;
//        boolean testc = true;
//
//
//        a.add(1);
//        a.delete(1);
//
//        if (a.head == null && a.tail == null && a.count() == 0) {
//            System.out.println("testDelete # 1 passed");
//        } else {
//            System.out.println("testDelete # 1 failed");
//        }
//
//        for (int i = 1; i <= 10; i++) {
//            b.add(i);
//
//        }
//
//        b.delete(10);
//
//        if (b.head.value != 1 && b.tail.value != 9 && b.count() != 9) {
//            testb = false;
//        }
//
//        b.delete(1);
//
//        if (b.head.value != 2 && b.tail.value != 9 && b.count() != 9) {
//            testb = false;
//        }
//
//        b.delete(5);
//
//        if (b.head.value != 2 && b.tail.value != 9 && b.count() != 8) {
//            testb = false;
//        }
//
//        if (testb) {
//            System.out.println("testDelete # 2 passed");
//        } else {
//            System.out.println("testDelete # 2 failed");
//
//        }
//
//
//        String[] array = {"b", "a", "d", "c", "e", "f", "g", "i", "h"};
//        for (String aa : array) {
//            c.add(aa);
//        }
//
//        c.delete("i");
//
//        if (!c.head.value.equals("h") && !c.tail.value.equals("a") && c.count() != 8) {
//            testc = false;
//        }
//
//        c.delete("a");
//
//        if (!c.head.value.equals("h") && !c.tail.value.equals("b") && c.count() != 7) {
//            testc = false;
//        }
//
//        c.delete("e");
//
//        if (!c.head.value.equals("h") && !c.tail.value.equals("b") && c.count() != 6) {
//            testc = false;
//        }
//
//        if (testc) {
//            System.out.println("testDelete # 3 passed");
//        } else {
//            System.out.println("testDelete # 3 failed");
//
//        }
//    }
//
//    public static void testFind() {
//        OrderedList<Integer> a = new OrderedList<>(true);
//        OrderedList<String> b = new OrderedList<>(true);
//        boolean testb = true;
//
//        Node a0 = a.find(1);
//        for (int i = 1; i <= 10; i++) {
//            a.add(i);
//        }
//        Node a1 = a.find(1);
//        Node a2 = a.find(111);
//        if (a1.value.equals(1) && a2 == null && a0 == null) {
//            System.out.println("testFind # 1 passed");
//        } else {
//            System.out.println("testFind # 1 failed");
//        }
//
//
//        String[] array = {"b", "a", "d", "c", "e", "f", "g", "i", "h"};
//        for (String aa : array) {
//            b.add(aa);
//        }
//
//        Node b1 = b.find("a");
//        Node b2 = b.find("fddfs");
//        if (b1.value.equals("a") && b2 == null) {
//            System.out.println("testFind # 2 passed");
//        } else {
//            System.out.println("testFind # 2 failed");
//        }
//
//    }
//}


///////###############################

//import junit.framework.TestCase;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.JUnit4;
//
//@RunWith(JUnit4.class)
//public class OrderedListTest extends TestCase {
//
//    private OrderedList<Integer> ascOrderedListInt;
//    private OrderedList<Integer> descOrderedListInt;
//    private OrderedList<String> ascOrderedListStr;
//    private OrderedList<String> descOrderedListStr;
//
//    public void setUp() {
//        ascOrderedListInt = new OrderedList<>(true);
//        ascOrderedListInt.add(0);
//        ascOrderedListInt.add(1);
//        ascOrderedListInt.add(2);
//        ascOrderedListInt.add(3);
//        ascOrderedListInt.add(10);
//        ascOrderedListInt.add(20);
//
//        descOrderedListInt = new OrderedList<>(false);
//        descOrderedListInt.add(20);
//        descOrderedListInt.add(10);
//        descOrderedListInt.add(3);
//        descOrderedListInt.add(2);
//        descOrderedListInt.add(1);
//        descOrderedListInt.add(0);
//
//        ascOrderedListStr = new OrderedList<>(true);
//        ascOrderedListStr.add("a");
//        ascOrderedListStr.add("b");
//        ascOrderedListStr.add("e");
//        ascOrderedListStr.add("f");
//        ascOrderedListStr.add("x");
//        ascOrderedListStr.add("z");
//
//        descOrderedListStr = new OrderedList<>(false);
//        descOrderedListStr.add("z");
//        descOrderedListStr.add("x");
//        descOrderedListStr.add("d");
//        descOrderedListStr.add("c");
//        descOrderedListStr.add("b");
//        descOrderedListStr.add("a");
//    }
//
//    @Test
//    public void testCompare() {
//        setUp();
//        assertEquals(0, ascOrderedListInt.compare(3, 3));
//        assertEquals(-1, ascOrderedListInt.compare(1, 31));
//        assertEquals(1, ascOrderedListInt.compare(31, 1));
//        assertEquals(0, descOrderedListStr.compare("a", "a"));
//        assertEquals(-1, descOrderedListStr.compare("a", "c"));
//        assertEquals(1, descOrderedListStr.compare("c", "a"));
//    }
//
//    @Test
//    public void testAddAsc() {
//        ascOrderedListInt = new OrderedList<>(true);
//        assertNull(ascOrderedListInt.head);
//        assertNull(ascOrderedListInt.tail);
//        assertEquals(0, ascOrderedListInt.count());
//        ascOrderedListInt.add(0);
//        assertEquals(null, ascOrderedListInt.head.prev);
//        assertEquals(Integer.valueOf(0), ascOrderedListInt.head.value);
//        assertEquals(null, ascOrderedListInt.head.next);
//        assertEquals(null, ascOrderedListInt.tail.prev);
//        assertEquals(Integer.valueOf(0), ascOrderedListInt.tail.value);
//        assertEquals(null, ascOrderedListInt.tail.next);
//        assertEquals(1, ascOrderedListInt.count());
//        ascOrderedListInt.add(1);
//        assertEquals(null, ascOrderedListInt.head.prev);
//        assertEquals(Integer.valueOf(0), ascOrderedListInt.head.value);
//        assertEquals(Integer.valueOf(1), ascOrderedListInt.head.next.value);
//        assertEquals(Integer.valueOf(0), ascOrderedListInt.tail.prev.value);
//        assertEquals(Integer.valueOf(1), ascOrderedListInt.tail.value);
//        assertEquals(null, ascOrderedListInt.tail.next);
//        assertEquals(2, ascOrderedListInt.count());
//        ascOrderedListInt.add(5);
//        assertEquals(null, ascOrderedListInt.head.prev);
//        assertEquals(Integer.valueOf(0), ascOrderedListInt.head.value);
//        assertEquals(Integer.valueOf(1), ascOrderedListInt.head.next.value);
//        assertEquals(Integer.valueOf(5), ascOrderedListInt.head.next.next.value);
//        assertEquals(Integer.valueOf(1), ascOrderedListInt.tail.prev.value);
//        assertEquals(Integer.valueOf(5), ascOrderedListInt.tail.value);
//        assertEquals(null, ascOrderedListInt.tail.next);
//        assertEquals(3, ascOrderedListInt.count());
//        ascOrderedListInt.add(-1);
//        assertEquals(null, ascOrderedListInt.head.prev);
//        assertEquals(Integer.valueOf(-1), ascOrderedListInt.head.value);
//        assertEquals(Integer.valueOf(0), ascOrderedListInt.head.next.value);
//        assertEquals(Integer.valueOf(1), ascOrderedListInt.head.next.next.value);
//        assertEquals(Integer.valueOf(1), ascOrderedListInt.tail.prev.value);
//        assertEquals(Integer.valueOf(5), ascOrderedListInt.tail.value);
//        assertEquals(null, ascOrderedListInt.tail.next);
//        assertEquals(4, ascOrderedListInt.count());
//        ascOrderedListInt.add(2);
//        assertEquals(null, ascOrderedListInt.head.prev);
//        assertEquals(Integer.valueOf(-1), ascOrderedListInt.head.value);
//        assertEquals(Integer.valueOf(0), ascOrderedListInt.head.next.value);
//        assertEquals(Integer.valueOf(1), ascOrderedListInt.head.next.next.value);
//        assertEquals(Integer.valueOf(2), ascOrderedListInt.head.next.next.next.value);
//        assertEquals(Integer.valueOf(2), ascOrderedListInt.tail.prev.value);
//        assertEquals(Integer.valueOf(5), ascOrderedListInt.tail.value);
//        assertEquals(null, ascOrderedListInt.tail.next);
//        assertEquals(5, ascOrderedListInt.count());
//    }
//
//    @Test
//    public void testStrAsc() {
//        setUp();
//        ascOrderedListStr.add(" c ");
//        ascOrderedListStr.getAll().forEach(s -> System.out.println(s.value));
//    }
//
//    @Test
//    public void testAddDesc() {
//        descOrderedListInt = new OrderedList<>(false);
//        assertNull(descOrderedListInt.head);
//        assertNull(descOrderedListInt.tail);
//        assertEquals(0, descOrderedListInt.count());
//        descOrderedListInt.add(0);
//        assertEquals(null, descOrderedListInt.head.prev);
//        assertEquals(Integer.valueOf(0), descOrderedListInt.head.value);
//        assertEquals(null, descOrderedListInt.head.next);
//        assertEquals(null, descOrderedListInt.tail.prev);
//        assertEquals(Integer.valueOf(0), descOrderedListInt.tail.value);
//        assertEquals(null, descOrderedListInt.tail.next);
//        assertEquals(1, descOrderedListInt.count());
//        descOrderedListInt.add(1);
//        assertEquals(null, descOrderedListInt.head.prev);
//        assertEquals(Integer.valueOf(1), descOrderedListInt.head.value);
//        assertEquals(Integer.valueOf(0), descOrderedListInt.head.next.value);
//        assertEquals(Integer.valueOf(1), descOrderedListInt.tail.prev.value);
//        assertEquals(Integer.valueOf(0), descOrderedListInt.tail.value);
//        assertEquals(null, descOrderedListInt.tail.next);
//        assertEquals(2, descOrderedListInt.count());
//        descOrderedListInt.add(5);
//        assertEquals(null, descOrderedListInt.head.prev);
//        assertEquals(Integer.valueOf(5), descOrderedListInt.head.value);
//        assertEquals(Integer.valueOf(1), descOrderedListInt.head.next.value);
//        assertEquals(Integer.valueOf(0), descOrderedListInt.head.next.next.value);
//        assertEquals(Integer.valueOf(1), descOrderedListInt.tail.prev.value);
//        assertEquals(Integer.valueOf(0), descOrderedListInt.tail.value);
//        assertEquals(null, descOrderedListInt.tail.next);
//        assertEquals(3, descOrderedListInt.count());
//        descOrderedListInt.add(-1);
//        assertEquals(null, descOrderedListInt.head.prev);
//        assertEquals(Integer.valueOf(5), descOrderedListInt.head.value);
//        assertEquals(Integer.valueOf(1), descOrderedListInt.head.next.value);
//        assertEquals(Integer.valueOf(0), descOrderedListInt.head.next.next.value);
//        assertEquals(Integer.valueOf(0), descOrderedListInt.tail.prev.value);
//        assertEquals(Integer.valueOf(-1), descOrderedListInt.tail.value);
//        assertEquals(null, descOrderedListInt.tail.next);
//        assertEquals(4, descOrderedListInt.count());
//        descOrderedListInt.add(2);
//        assertEquals(null, descOrderedListInt.head.prev);
//        assertEquals(Integer.valueOf(5), descOrderedListInt.head.value);
//        assertEquals(Integer.valueOf(2), descOrderedListInt.head.next.value);
//        assertEquals(Integer.valueOf(1), descOrderedListInt.head.next.next.value);
//        assertEquals(Integer.valueOf(0), descOrderedListInt.head.next.next.next.value);
//        assertEquals(Integer.valueOf(0), descOrderedListInt.tail.prev.value);
//        assertEquals(Integer.valueOf(-1), descOrderedListInt.tail.value);
//        assertEquals(null, descOrderedListInt.tail.next);
//        assertEquals(5, descOrderedListInt.count());
//        descOrderedListInt.add(10);
//        assertEquals(null, descOrderedListInt.head.prev);
//        assertEquals(Integer.valueOf(10), descOrderedListInt.head.value);
//        assertEquals(Integer.valueOf(5), descOrderedListInt.head.next.value);
//        assertEquals(Integer.valueOf(2), descOrderedListInt.head.next.next.value);
//        assertEquals(Integer.valueOf(1), descOrderedListInt.head.next.next.next.value);
//        assertEquals(Integer.valueOf(0), descOrderedListInt.tail.prev.value);
//        assertEquals(Integer.valueOf(-1), descOrderedListInt.tail.value);
//        assertEquals(null, descOrderedListInt.tail.next);
//        assertEquals(6, descOrderedListInt.count());
//    }
//
//    @Test
//    public void testFind() {
//        setUp();
//        assertEquals(Integer.valueOf(0), ascOrderedListInt.find(0).value);
//        assertEquals(Integer.valueOf(20), ascOrderedListInt.find(20).value);
//        assertEquals(Integer.valueOf(3), ascOrderedListInt.find(3).value);
//    }
//
//    @Test
//    public void testDelete() {
//        setUp();
//        ascOrderedListInt.delete(0);
//        assertEquals(Integer.valueOf(1), ascOrderedListInt.head.value);
//        assertEquals(5, ascOrderedListInt.count());
//        ascOrderedListInt.delete(3);
//        assertEquals(4, ascOrderedListInt.count());
//        ascOrderedListInt.delete(20);
//        assertEquals(3, ascOrderedListInt.count());
//        assertEquals(Integer.valueOf(10), ascOrderedListInt.tail.value);
//    }
//
//    @Test
//    public void testClear() {
//        setUp();
//        ascOrderedListInt.clear(true);
//        assertNull(ascOrderedListInt.head);
//        assertNull(ascOrderedListInt.tail);
//        assertEquals(0, ascOrderedListInt.count());
//    }
//
//    @Test
//    public void testCount() {
//        setUp();
//        assertEquals(6, ascOrderedListInt.count());
//    }
//
//    @Test
//    public void testAscArray() {
//        ascOrderedListInt = new OrderedList<>(true);
//        ascOrderedListInt.add(0);
//        ascOrderedListInt.add(2);
//        ascOrderedListInt.add(1);
//        ascOrderedListInt.add(1);
//        ascOrderedListInt.add(2);
//        ascOrderedListInt.add(1);
//        ascOrderedListInt.add(0);
//        ascOrderedListInt.getAll().forEach(s -> System.out.println(s.value));
//    }
//
//    @Test
//    public void testDescArray() {
//        ascOrderedListInt = new OrderedList<>(false);
//        ascOrderedListInt.add(0);
//        ascOrderedListInt.add(2);
//        ascOrderedListInt.add(1);
//        ascOrderedListInt.add(1);
//        ascOrderedListInt.add(2);
//        ascOrderedListInt.add(1);
//        ascOrderedListInt.add(0);
//        ascOrderedListInt.getAll().forEach(s -> System.out.println(s.value));
//    }
//
//}