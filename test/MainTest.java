import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    final static int GOOD_DATA_LEN = 26;
    final static int BAD_DATA_LEN = 25;


    @DisplayName("Test valid events")
    @Test
    void testFillEventsGood() {
        Main.fillEvents("./goodInput.txt");
        assertEquals(GOOD_DATA_LEN, Main.events.size());
    }

    @DisplayName("Test invalid events")
    @Test
    void testFillEventsBad() {
        Main.fillEvents("./badInput.txt");
        assertEquals(BAD_DATA_LEN, Main.events.size());
    }
}