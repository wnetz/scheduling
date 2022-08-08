import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    final static int GOOD_DATA_LEN = 26;
    final static int BAD_DATA_LEN = 24;
    final static String GOOD_DATA_FILENAME = "./test/goodInput.txt";
    final static String BAD_DATA_FILENAME = "./test/badInput.txt";

    @DisplayName("Test midnight rollover")
    @Test
    void testMidnight(){
        Time time = new Time(11,59,false);
        time.addTime(1);
        assertEquals("12:00AM",time.toString());
    }
    @DisplayName("Test noon rollover")
    @Test
    void testNoon(){
        Time time = new Time(11,59,true);
        time.addTime(1);
        assertEquals("12:00PM",time.toString());
    }
    @DisplayName("Test large addition of time")
    @Test
    void testLargeAddition(){
        Time time = new Time(6,30,true);
        time.addTime(125);
        assertEquals("08:35AM",time.toString());
    }
    @DisplayName("Test invalid time initialization")
    @Test
    void testInvalidTime(){
        Time time = new Time(15,3867,false);
        assertEquals("01:27AM",time.toString());
    }
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