import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TrackTest {
    static Track track;

    @BeforeEach
    void testSetup() {
        // create new track
        track = new Track();
    }

    @Test
    void testGetMorningTime() {
        assertEquals(0, track.getMorningTime());

        track.addMorning(new Event("foo", 30));
        track.addMorning(new Event("bar", 30));
        track.addMorning(new Event("baz", 45));

        assertEquals(105, track.getMorningTime());
        assertEquals(0, track.getEveningTime());
    }

    @Test
    void testGetEveningTime() {
        assertEquals(0, track.getEveningTime());

        track.addEvening(new Event("a", 20));
        track.addEvening(new Event("b", 40));
        track.addEvening(new Event("c", 105));

        assertEquals(165, track.getEveningTime());
        assertEquals(0, track.getMorningTime());
    }

    @Test
    void testAddMorning() {
        track.addMorning(new Event("REALLY LONG TALK", 130));
        track.addMorning(new Event("foo", 50));
        assertEquals(false, track.addMorning(new Event("whatever", 5)));
    }

    @Test
    void testAddEvening() {
        track.addEvening(new Event("EVEN LONGER TALK", 200));
        track.addEvening(new Event("bar", 99));
        assertEquals(false, track.addEvening(new Event("something_else", 10)));
    }
}