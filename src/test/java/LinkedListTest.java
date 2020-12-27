import junit.framework.TestCase;
import org.junit.Assert;

import static org.hamcrest.CoreMatchers.is;

public class LinkedListTest extends TestCase {

    public void testNorm() {
        LinkedList list = new LinkedList();
        Assert.assertNull(list.head);
    }

    public void testFindAll() {
        LinkedList list = new LinkedList();
        Assert.assertEquals(list.findAll(51).size(), 0);
        list.addInTail(new Node(51));
        list.addInTail(new Node(52));
        list.addInTail(new Node(52));
        list.addInTail(new Node(54));
        list.addInTail(new Node(52));
        Assert.assertEquals(list.findAll(51).size(), 1);
        Assert.assertEquals(list.findAll(51).get(0).value, 51);
        Assert.assertEquals(list.findAll(52).size(), 3);
        Assert.assertEquals(list.findAll(50).size(), 0);
    }

    public void testRemoveEmptyList() {
        LinkedList list = new LinkedList();
        Assert.assertThat(list.remove(0), is(false));
    }

    public void testRemoveFirstElement() {
        LinkedList list = new LinkedList();
        Assert.assertEquals(list.count(), 0);
        list.addInTail(new Node(8));
        Assert.assertEquals(list.head.value, 8);
        Assert.assertThat(list.remove(3), is(false));
        Assert.assertThat(list.remove(8), is(true));
        Assert.assertNull(list.head);
        list.addInTail(new Node(5));
        list.addInTail(new Node(55));
        list.addInTail(new Node(155));
        Assert.assertEquals(list.count(), 3);
        Assert.assertEquals(list.head.value, 5);
        Assert.assertThat(list.remove(5), is(true));
        Assert.assertThat(list.remove(5), is(false));
        Assert.assertEquals(list.head.value, 55);
        Assert.assertEquals(list.tail.value, 155);
        Assert.assertEquals(list.count(), 2);

    }

    public void testRemoveMidleElement() {
        LinkedList list = new LinkedList();
        list.addInTail(new Node(3));
        list.addInTail(new Node(33));
        list.addInTail(new Node(331));
        list.addInTail(new Node(3331));
        Assert.assertEquals(list.count(), 4);
        Assert.assertThat(list.remove(313), is(false));
        Assert.assertThat(list.remove(33), is(true));
        Assert.assertThat(list.remove(331), is(true));
        Assert.assertEquals(list.head.next.value, 3331);
        Assert.assertEquals(list.count(), 2);
    }

    public void testRemoveAllEmptyList() {
        LinkedList list = new LinkedList();
        Assert.assertEquals(list.count(), 0);
        list.removeAll(5);
        Assert.assertNull(list.head);
    }

    public void testRemoveAll() {
        LinkedList list = new LinkedList();
        for (int i = 1; i < 20; i++) {
            list.addInTail(new Node(i));
            if (i == 7 || i == 8 || i == 11 || i == 19) {
                list.addInTail(new Node(i));
                list.addInTail(new Node(i));
            }
        }
        Assert.assertEquals(list.count(), 27);
        Assert.assertEquals(list.findAll(7).size(), 3);
        list.removeAll(7);
        Assert.assertEquals(list.findAll(7).size(), 0);
        list.removeAll(11);
        list.removeAll(18);
        list.removeAll(19);
        Assert.assertEquals(list.count(), 17);
        Assert.assertEquals(list.tail.value, 17);
    }

    public void testClear() {
        LinkedList list = new LinkedList();
        Assert.assertNull(list.head);
        list.clear();
        Assert.assertNull(list.head);
        list.addInTail(new Node(2));
        Assert.assertNotNull(list.head);
        list.clear();
        Assert.assertNull(list.head);
        list.addInTail(new Node(2));
        list.addInTail(new Node(3));
        list.addInTail(new Node(2));
        list.clear();
        Assert.assertNull(list.head);
        Assert.assertEquals(list.count(), 0);
    }

    public void testInsertAfter() {
        LinkedList list = new LinkedList();
        list.insertAfter(null, new Node(1));
        Assert.assertEquals(list.tail.value, 1);
        list.insertAfter(list.tail, new Node(8));
        Assert.assertEquals(list.tail.value, 8);
        list.addInTail(new Node(2));
        list.insertAfter(list.head.next, new Node(55));
        Assert.assertEquals(list.head.value, 1);
        Assert.assertEquals(list.tail.value, 2);
        Assert.assertEquals(list.head.next.value, 8);
        Assert.assertEquals(list.head.next.next.value, 55);
    }
}