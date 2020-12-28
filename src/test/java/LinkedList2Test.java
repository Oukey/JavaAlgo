
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

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
        list2.showList();
    }

    @Test
    public void findAll() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void removeAll() {
    }

    @Test
    public void clear() {
    }

    @Test
    public void count() {
    }

    @Test
    public void insertAfter() {
    }
}