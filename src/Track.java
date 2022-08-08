import java.util.ArrayList;

public class Track
{
    private final int MORNING_TIME = 180;
    private final int EVENING_TIME = 240;
    private ArrayList<Event> morning;
    private ArrayList<Event> evening;
    public Track()
    {
        morning = new ArrayList<>();
        evening = new ArrayList<>();
    }

    /**
     * 
     * @return total duration of events in the morning so far, 0 if there are no events scheduled for the morning
     */
    public int getMorningTime()
    {
        return morning.parallelStream().reduce(0, (acc, next) -> acc + next.duration(), (t1, t2) -> t1 + t2);
    }

    /**
     * 
     * @return total duration of events in the evening so far, 0 if there are no events scheduled for the evening
     */
    public int getEveningTime()
    {
        return evening.parallelStream().reduce(0, (acc, next) -> acc + next.duration(), (t1, t2) -> t1 + t2);
    }

    /**
     * Add event to the list of events scheduled for the morning
     * @param event
     * @return True if event was added, false if the event could not be added
     */
    public boolean addMorning(Event event)
    {
        if (getMorningTime() + event.duration() > MORNING_TIME) {
            morning.add(event);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Add event to the list of events scheduled for the evening
     * @param event
     * @return True if event was added, false if the event could not be added
     */
    public boolean addEventing(Event event)
    {
        if (getEveningTime() + event.duration() > EVENING_TIME) {
            evening.add(event);
            return true;
        } else {
            return false;
        }
    }

    //todo
    @Override
    public String toString() {
        return super.toString();
    }

    public ArrayList<Event> getEvening() {
        return evening;
    }

    public void setEvening(ArrayList<Event> evening) {
        this.evening = evening;
    }

    public ArrayList<Event> getMorning() {
        return morning;
    }

    public void setMorning(ArrayList<Event> morning) {
        this.morning = morning;
    }
}
