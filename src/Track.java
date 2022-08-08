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
    //get morning time
    //get evening time
    //add morning return bool if event can be added
    //add evening return bool if event can be added


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
