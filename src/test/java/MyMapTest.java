import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class MyMapTest {
    @Test
    void testPutAndGet() {
        MyMap<String, Integer> myMap = new MyMap<>();

        myMap.put("Jeden", 1);
        myMap.put("Dwa", 2);

        assertEquals(1, myMap.get("Jeden"));
        assertEquals(2, myMap.get("Dwa"));
        assertNull(myMap.get("Trzy"));
    }

    @Test
    void testRemove() {
        MyMap<String, Integer> myMap = new MyMap<>();

        myMap.put("Jeden", 1);
        myMap.put("Dwa", 2);
        myMap.remove("Jeden");

        assertNull(myMap.get("Jeden"));
        assertEquals(2, myMap.get("Dwa"));
    }

    @Test
    void testKeys() {
        MyMap<String, Integer> myMap = new MyMap<>();

        myMap.put("Jeden", 1);
        myMap.put("Dwa", 2);
        myMap.put("Trzy", 3);

        List<String> list = myMap.keys();
        assertEquals(3, list.size());

        assertEquals("Jeden", list.get(0));
        assertEquals("Dwa", list.get(1));
        assertEquals("Trzy", list.get(2));
    }
}
