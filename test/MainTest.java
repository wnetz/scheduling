import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    final static int GOOD_DATA_LEN = 26;
    final static int BAD_DATA_LEN = 24;
    final static String GOOD_DATA_FILENAME = "./test/goodInput.txt";
    final static String BAD_DATA_FILENAME = "./test/badInput.txt";

    @DisplayName("Test valid events")
    @Test
    void testFillEventsGood() {
        Main.fillEvents(GOOD_DATA_FILENAME);
        assertEquals(GOOD_DATA_LEN, Main.events.size());
    }

    @DisplayName("Test invalid events")
    @Test
    void testFillEventsBad() {
        Main.fillEvents(BAD_DATA_FILENAME);
        assertEquals(BAD_DATA_LEN, Main.events.size());
    }
}