
import org.junit.Assert;
import org.junit.Test;

public class LinkedList2Test {

    @Test
    public void find() {
        LinkedList2 list2 = new LinkedList2();
        Assert.assertNull(list2.find(2));
        list2.addInTail(new Node(2));
        Assert.assertEquals(list2.find(2).value, 2);
        Assert.assertNotNull(list2.find(2));
        list2.addInTail(new Node(1));
        list2.addInTail(new Node(3));
        list2.addInTail(new Node(3));
        list2.addInTail(new Node(30));
        Assert.assertEquals(list2.find(3).value, 3);
        Assert.assertNotNull(list2.find(3));
        Assert.assertEquals(list2.find(30).value, 30);
        Assert.assertNotNull(list2.find(30));
    }

    @Test
    public void findAll() {
        LinkedList2 list2 = new LinkedList2();
        Assert.assertEquals(list2.findAll(22).size(), 0);
        list2.addInTail(new Node(22));
        Assert.assertEquals(list2.findAll(22).size(), 1);
        list2.addInTail(new Node(87));
        list2.addInTail(new Node(87));
        list2.addInTail(new Node(872));
        Assert.assertEquals(list2.findAll(87).size(), 2);
        Assert.assertEquals(list2.findAll(87).get(1).value, 87);
        Assert.assertEquals(list2.findAll(872).size(), 1);
    }

    @Test
    public void remove() {
        LinkedList2 list2 = new LinkedList2();
        Assert.assertFalse(list2.remove(1));
        list2.addInTail(new Node(1));
        Assert.assertFalse(list2.remove(2));
        Assert.assertEquals(list2.count(), 1);
        list2.remove(1);
        Assert.assertNull(list2.head);
        for (int i = 2; i <= 5; i++) {
            list2.addInTail(new Node(i));
        }
        Assert.assertTrue(list2.remove(5));
        Assert.assertTrue(list2.remove(3));
        Assert.assertTrue(list2.remove(2));
        Assert.assertEquals(list2.count(), 1);
    }

    @Test
    public void removeAll() {
        LinkedList2 list2 = new LinkedList2();
        for (int i = 0; i <= 6; i++) {
            if (i % 2 == 0) {
                list2.addInTail(new Node(i));
                list2.addInTail(new Node(i));
            }
            list2.addInTail(new Node(i));
        }
        list2.removeAll(6);
        Assert.assertEquals(list2.tail.value, 5);
        Assert.assertEquals(list2.count(), 12);
        list2.removeAll(0);
        list2.removeAll(2);
        Assert.assertEquals(list2.head.value, 1);
        Assert.assertEquals(list2.count(), 6);
    }

    @Test
    public void clear() {
        LinkedList2 list2 = new LinkedList2();
        Assert.assertNull(list2.head);
        for (int i = 0; i <= 5; i++) {
            list2.addInTail(new Node(i));
        }
        list2.clear();
        Assert.assertEquals(list2.count(), 0);
    }

    @Test
    public void insertAfter() {
        LinkedList2 list2 = new LinkedList2();
        list2.insertAfter(null, new Node(7));
        Assert.assertEquals(list2.head.value, 7);
        Assert.assertEquals(list2.count(), 1);
        list2.insertAfter(list2.head, new Node(52));
        Assert.assertEquals(list2.count(), 2);
        Assert.assertEquals(list2.head.next.value, 52);
        list2.insertAfter(list2.tail, new Node(100));
        Assert.assertEquals(list2.tail.value, 100);
        list2.insertAfter(list2.tail.prev, new Node(24));
        Assert.assertEquals(list2.tail.prev.value, 24);
    }
}