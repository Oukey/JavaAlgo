import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HashTableTest {

    private HashTable table;

    public void setUp(int sz, int stp) {
        table = new HashTable(sz, stp);
    }


    @Test
    public void normTest() {
        setUp(5, 2);
        System.out.println(table.size);
        System.out.println(table);
        table.Show();
    }

    @Test
    public void hashFun() {
    }

    @Test
    public void seekSlot() {
    }

    @Test
    public void put() {
        setUp(5, 2);
        table.put("123");
        assertEquals(table.put("333"), 1);
        table.put("1234");
        table.put("123");
        table.put("qwe");
        assertEquals(table.put("asd"), -1);
        table.Show();
    }

    @Test
    public void find() {
        setUp(3, 1);
        assertEquals(table.find("null"), -1);
        table.put("null");
        table.put("1");
        assertEquals(table.find("asdasd"), -1);
        table.put("2");
        assertEquals(table.find("null"), 0);
        assertEquals(table.find("1"), 1);
        assertEquals(table.find("2"), 2);
        assertEquals(table.find("22"), -1);


        table.Show();

    }

    @Test
    public void searchNull() {
    }
}

//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.JUnit4;
//
//import static org.junit.Assert.*;
//
//@RunWith(JUnit4.class)
//public class HashTableTest {
//
//    private HashTable simpleTable;
//
//    private HashTable collisionTable;
//
//    public void setUp() {
//        simpleTable = new HashTable(13, 3);
//        simpleTable.put("1");
//        simpleTable.put("2");
//        simpleTable.put("3");
//        simpleTable.put("4");
//        simpleTable.put("5");
//        simpleTable.put("6");
//        simpleTable.put("7");
//        simpleTable.put("8");
//        simpleTable.put("9");
//        simpleTable.put("10");
//        simpleTable.put("11");
//        simpleTable.put("12");
//        simpleTable.put("13");
//
//        collisionTable = new HashTable(11, 3);
//        collisionTable.put("1");
//        collisionTable.put("2");
//        collisionTable.put("3");
//        collisionTable.put("4");
//        collisionTable.put("5");
//    }
//
//    @Test
//    public void hashFun() {
//        simpleTable = new HashTable(17, 3);
//        int i = simpleTable.hashFun("98");
//        assertTrue(i >= 0 && i < simpleTable.size);
//    }
//
//    @Test
//    public void seekSlot() {
//        setUp();
//        assertEquals(-1, collisionTable.put(null));
//        assertEquals(-1, collisionTable.find(null));
//    }
//
//    @Test
//    public void put() {
//        setUp();
//        assertEquals(13, simpleTable.size);
//        assertEquals(-1, simpleTable.put("zzz"));
//        System.out.println("SIMPLE TABLE");
//        for (String s : simpleTable.slots) {
//            System.out.println(s);
//        }
//
//        System.out.println("COLLISION TABLE");
//        assertNotEquals(-1, collisionTable.put("1"));
//        assertNotEquals(-1, collisionTable.put("1"));
//        assertNotEquals(-1, collisionTable.put("1"));
//        assertNotEquals(-1, collisionTable.put("1"));
//        assertNotEquals(-1, collisionTable.put("1"));
//        assertNotEquals(-1, collisionTable.put("1"));
//        assertEquals(-1, collisionTable.put("1"));
//
//        System.out.println("============================");
//        for (String s : collisionTable.slots) {
//            System.out.println(s);
//        }
//    }
//
//    @Test
//    public void find() {
//        setUp();
//        simpleTable.Show();
//        collisionTable.Show();
//        int simpleIndex = simpleTable.find("1");
//        assertNotEquals(-1, simpleIndex);
//        assertEquals(simpleTable.slots[simpleIndex], "1");
//        assertEquals(-1, simpleTable.find("ffffff"));
//        int collusionIndex = collisionTable.find("1");
//        assertNotEquals(-1, collusionIndex);
//        assertEquals(collisionTable.slots[collusionIndex], "1");
//        collisionTable.put("1");
//        int collusionIndex2 = collisionTable.find("1");
//        assertEquals(collisionTable.slots[collusionIndex2], "1");
//        System.out.println(simpleTable.find("fffff"));
//        assertEquals(-1, collisionTable.find("ffffff"));
//    }
//
//    @Test
//    public void testFind2() {
//        HashTable ht = new HashTable(13, 3);
//        int ab = ht.put("ab");
//        int ba = ht.put("ba");
//        ht.find("ba");
//        assertEquals(ba, ht.find("ba"));
//        assertEquals(ab, ht.find("ab"));
//    }
//}
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


//import static org.junit.Assert.*;
//
//import org.junit.Test;
//
//public class HashTableTest {
//
//    @Test
//    public void test() {
//        HashTable table = new HashTable(17, 2);
//        table.put("John");
//        table.put("Paul");
//        table.put("Sarah");
//        table.put("Alex");
//        table.put("Johnotan");
//        table.put("Michael");
//        table.put("Wayne");
//        table.put("David");
//
//        table.put("Patrice");
//        table.put("Rio");
//        table.put("Nemanja");
//        table.put("Marcus");
//        table.put("Antony");
//        table.put("Ole");
//        table.put("Victor");
//        table.put("Aaron");
//
//        table.put("Luke");
//        assertTrue(table.put("Paul") == -1);
//
//        table.find("John");
//        table.find("Paul");
//        table.find("Sarah");
//        table.find("Alex");
//        table.find("Johnotan");
//        table.find("Michael");
//        table.find("Wayne");
//        table.find("David");
//        table.find("Patrice");
//        table.find("Rio");
//        table.find("Nemanja");
//        table.find("Marcus");
//        table.find("Antony");
//        table.find("Ole");
//        table.find("Victor");
//        table.find("Aaron");
//        table.find("Luke");
//
//    }
//    @Test
//    public void find() {
//    }
//}
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import static org.hamcrest.CoreMatchers.is;
//
//
//public class HashTableTest {
//
//    @BeforeClass
//    public static void globalSetUp() {
//    }
//
//    @Before
//    public void setUp() {
//    }
//
//
//    @Test
//    public void hashFunLength4Step2Test() {
//        HashTable hashtable = new HashTable(4, 2);
//
//
//        Assert.assertThat(hashtable.hashFun("1"), is(0));
//        Assert.assertThat(hashtable.put("1"), is(0));
//        Assert.assertThat(hashtable.hashFun("2"), is(2));
//        Assert.assertThat(hashtable.put("2"), is(2));
//
//        Assert.assertThat(hashtable.hashFun("3"), is(0));
//        Assert.assertThat(hashtable.seekSlot("3"), is(1));
//        Assert.assertThat(hashtable.put("3"), is(1));
//
//        Assert.assertThat(hashtable.hashFun("4"), is(3));
//        Assert.assertThat(hashtable.put("4"), is(3));
//
//        Assert.assertThat(hashtable.hashFun("5"), is(1));
//        Assert.assertThat(hashtable.seekSlot("5"), is(-1));
//        Assert.assertThat(hashtable.put("5"), is(-1));
//
//    }
//    @Test
//    public void hashFunLength5Step2Test() {
//        HashTable hashtable = new HashTable(5, 2);
//
//        Assert.assertThat(hashtable.hashFun("1"), is(0));
//        Assert.assertThat(hashtable.put("1"), is(0));
//        Assert.assertThat(hashtable.hashFun("2"), is(2));
//        Assert.assertThat(hashtable.put("2"), is(2));
//        Assert.assertThat(hashtable.hashFun("3"), is(4));
//        Assert.assertThat(hashtable.put("3"), is(4));
//        Assert.assertThat(hashtable.hashFun("4"), is(1));
//        Assert.assertThat(hashtable.put("4"), is(1));
//        Assert.assertThat(hashtable.hashFun("5"), is(3));
//        Assert.assertThat(hashtable.put("5"), is(3));
//
//        Assert.assertThat(hashtable.hashFun("6"), is(0));
//        Assert.assertThat(hashtable.seekSlot("6"), is(-1));
//        Assert.assertThat(hashtable.put("6"), is(-1));
//    }
//
//    @Test
//    public void hashFunLength5Step1Test() {
//        HashTable hashtable = new HashTable(5, 1);
//
//        Assert.assertThat(hashtable.hashFun("1"), is(0));
//        Assert.assertThat(hashtable.put("1"), is(0));
//        Assert.assertThat(hashtable.hashFun("2"), is(1));
//        Assert.assertThat(hashtable.put("2"), is(1));
//        Assert.assertThat(hashtable.hashFun("3"), is(2));
//        Assert.assertThat(hashtable.put("3"), is(2));
//        Assert.assertThat(hashtable.hashFun("4"), is(3));
//        Assert.assertThat(hashtable.put("4"), is(3));
//        Assert.assertThat(hashtable.hashFun("5"), is(4));
//        Assert.assertThat(hashtable.put("5"), is(4));
//
//        Assert.assertThat(hashtable.hashFun("6"), is(0));
//        Assert.assertThat(hashtable.seekSlot("6"), is(-1));
//        Assert.assertThat(hashtable.put("6"), is(-1));
//        Assert.assertThat(hashtable.hashFun("7"), is(0));
//        Assert.assertThat(hashtable.seekSlot("7"), is(-1));
//        Assert.assertThat(hashtable.put("7"), is(-1));
//    }
//
//    @Test
//    public void hashFunLength17Step3Test() {
//        HashTable hashtable = new HashTable(17, 3);
//
//        Assert.assertThat(hashtable.hashFun("1"), is(0));
//        Assert.assertThat(hashtable.put("1"), is(0));
//        Assert.assertThat(hashtable.find("1"), is(0));
//
//        Assert.assertThat(hashtable.hashFun("2"), is(3));
//        Assert.assertThat(hashtable.put("2"), is(3));
//        Assert.assertThat(hashtable.find("1"), is(0));
//        Assert.assertThat(hashtable.find("2"), is(3));
//
//        Assert.assertThat(hashtable.hashFun("3"), is(6));
//        Assert.assertThat(hashtable.put("3"), is(6));
//        Assert.assertThat(hashtable.find("1"), is(0));
//        Assert.assertThat(hashtable.find("2"), is(3));
//        Assert.assertThat(hashtable.find("3"), is(6));
//
//        Assert.assertThat(hashtable.hashFun("4"), is(9));
//        Assert.assertThat(hashtable.put("4"), is(9));
//        Assert.assertThat(hashtable.find("1"), is(0));
//        Assert.assertThat(hashtable.find("2"), is(3));
//        Assert.assertThat(hashtable.find("3"), is(6));
//        Assert.assertThat(hashtable.find("4"), is(9));
//
//
//        Assert.assertThat(hashtable.hashFun("5"), is(12));
//        Assert.assertThat(hashtable.put("5"), is(12));
//        Assert.assertThat(hashtable.find("1"), is(0));
//        Assert.assertThat(hashtable.find("2"), is(3));
//        Assert.assertThat(hashtable.find("3"), is(6));
//        Assert.assertThat(hashtable.find("4"), is(9));
//        Assert.assertThat(hashtable.find("5"), is(12));
//
//        Assert.assertThat(hashtable.hashFun("6"), is(15));
//        Assert.assertThat(hashtable.put("6"), is(15));
//        Assert.assertThat(hashtable.find("1"), is(0));
//        Assert.assertThat(hashtable.find("2"), is(3));
//        Assert.assertThat(hashtable.find("3"), is(6));
//        Assert.assertThat(hashtable.find("4"), is(9));
//        Assert.assertThat(hashtable.find("5"), is(12));
//        Assert.assertThat(hashtable.find("6"), is(15));
//
//        Assert.assertThat(hashtable.hashFun("7"), is(1));
//        Assert.assertThat(hashtable.put("7"), is(1));
//        Assert.assertThat(hashtable.find("1"), is(0));
//        Assert.assertThat(hashtable.find("2"), is(3));
//        Assert.assertThat(hashtable.find("3"), is(6));
//        Assert.assertThat(hashtable.find("4"), is(9));
//        Assert.assertThat(hashtable.find("5"), is(12));
//        Assert.assertThat(hashtable.find("6"), is(15));
//        Assert.assertThat(hashtable.find("7"), is(1));
//
//        Assert.assertThat(hashtable.hashFun("8"), is(4));
//        Assert.assertThat(hashtable.put("8"), is(4));
//
//        Assert.assertThat(hashtable.hashFun("9"), is(7));
//        Assert.assertThat(hashtable.put("9"), is(7));
//
//        Assert.assertThat(hashtable.hashFun("10"), is(10));
//        Assert.assertThat(hashtable.put("10"), is(10));
//
//        Assert.assertThat(hashtable.hashFun("11"), is(13));
//        Assert.assertThat(hashtable.put("11"), is(13));
//
//        Assert.assertThat(hashtable.hashFun("12"), is(16));
//        Assert.assertThat(hashtable.put("12"), is(16));
//
//        Assert.assertThat(hashtable.hashFun("13"), is(2));
//        Assert.assertThat(hashtable.put("13"), is(2));
//
//        Assert.assertThat(hashtable.hashFun("14"), is(5));
//        Assert.assertThat(hashtable.put("14"), is(5));
//
//        Assert.assertThat(hashtable.hashFun("15"), is(8));
//        Assert.assertThat(hashtable.put("15"), is(8));
//
//        Assert.assertThat(hashtable.hashFun("16"), is(11));
//        Assert.assertThat(hashtable.put("16"), is(11));
//
//        Assert.assertThat(hashtable.hashFun("17"), is(14));
//        Assert.assertThat(hashtable.put("17"), is(14));
//
//        Assert.assertThat(hashtable.hashFun("18"), is(0));
//        Assert.assertThat(hashtable.seekSlot("18"), is(-1));
//        Assert.assertThat(hashtable.put("18"), is(-1));
//        Assert.assertThat(hashtable.find("1"), is(0));
//        Assert.assertThat(hashtable.find("2"), is(3));
//        Assert.assertThat(hashtable.find("3"), is(6));
//        Assert.assertThat(hashtable.find("4"), is(9));
//        Assert.assertThat(hashtable.find("5"), is(12));
//        Assert.assertThat(hashtable.find("6"), is(15));
//        Assert.assertThat(hashtable.find("7"), is(1));
//        Assert.assertThat(hashtable.find("18"), is(-1));
//    }
//}