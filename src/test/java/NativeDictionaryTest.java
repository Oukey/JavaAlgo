import org.junit.Test;

import static org.junit.Assert.*;

public class NativeDictionaryTest {

    private NativeDictionary<String> dict;

    public void setUp() {
        dict = new NativeDictionary<>(5, String.class);
    }

    @Test
    public void normTest() {
        setUp();
        dict.Show();
    }

    @Test
    public void isKey() {
        setUp();
        assertFalse(dict.isKey("1"));
        assertFalse(dict.isKey("null"));
        dict.put("1", "one");
        assertTrue(dict.isKey("1"));
        dict.put("2", "two");
        dict.put("3", "three");
        dict.put("1", "three");
        dict.put("4", "four");
        dict.put("5", "five");
        dict.put("5", "five");
        dict.put("6", "six");
        assertTrue(dict.isKey("5"));
        assertTrue(dict.isKey("4"));
        assertTrue(dict.isKey("3"));
        assertTrue(dict.isKey("2"));
        assertFalse(dict.isKey("6"));
        assertFalse(dict.isKey("6"));
    }

    @Test
    public void put() {
    }

    @Test
    public void get() {
        setUp();
        dict.Show();
        assertNull(dict.get(""));
        dict.put("1", "_1_");
        assertNull(dict.get(""));
        assertEquals(dict.get("1"), "_1_");
        dict.put("2", "_2_");
        dict.put("3", "_3_");
        dict.put("4", "_4_");
        dict.put("4", "_4_");
        assertEquals(dict.get("4"), "_4_");
        assertEquals(dict.get(""), null);
        dict.put("55", "555");
        assertEquals(dict.get("55"), "555");
    }
}
