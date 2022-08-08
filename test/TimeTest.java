import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeTest {
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
}
