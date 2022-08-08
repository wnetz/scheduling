import java.util.ArrayList;

public class Track
{
    public static final int MORNING_TIME = 180;
    public static final int EVENING_TIME = 299;
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
        if (getMorningTime() + event.duration() < MORNING_TIME) {
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
    public boolean addEvening(Event event)
    {
        if (getEveningTime() + event.duration() < EVENING_TIME) {
            evening.add(event);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString()
    {
        String track = "";
        Time time = new Time(9,0,true);
        for(Event event:morning)
        {
            track = track + time + "\t" + event + "\n";
            time.addTime(event.duration());
        }
        time.setTime(12,0,false);
        track = track + time + "\tLunch\n";
        time.setTime(1,0,false);
        for(Event event:evening)
        {
            track = track + time + "\t" + event + "\n";
            time.addTime(event.duration());
        }
        if(time.getHour() < 4)
        {
            time.setTime(4,0,false);
        }
        track = track + time + "\tNetworking event";
        return track;
    }

    public ArrayList<Event> getEvening() {
        return evening;
    }
    public ArrayList<Event> getMorning() {
        return morning;
    }

    public void setEvening(ArrayList<Event> evening) {
        this.evening = evening;
    }
    public void setMorning(ArrayList<Event> morning) {
        this.morning = morning;
    }
}
