import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class EventTest {
    // five hours
    final static int MAX_EVENT_DURATION = 300;

    @DisplayName("Test event comparison")
    @Test
    void testCompareTo() {
        int low = MAX_EVENT_DURATION/2-1;
        int high = MAX_EVENT_DURATION/2+1;

        for ( ; low > 0 && high < MAX_EVENT_DURATION; low--, high++) {
            Event lowDur = new Event("foo", low);
            Event highDur = new Event("bar", high);

            assertTrue(lowDur.compareTo(highDur) < 0);
        }
    }
}