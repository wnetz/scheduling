public class Time
{
    private int hour;
    private int min;
    private boolean am;

    public Time(int h, int m, boolean a)
    {
        hour = h;
        min = m;
        am = a;
    }
    public void setTime(int h, int m, boolean a)
    {
        hour = h;
        min = m;
        am = a;
    }
    public void addTime(int m)
    {
        min += m;
        hour += min/60;
        min = min%60;
        if(hour > 12)
        {
            hour = 1;
            am = am ? false : true;
        }
    }

    @Override
    public String toString() {
        return (hour < 10 ? "0" + hour: hour) + ":"+(min<10? "0" + min: min)+ (am?"AM":"PM");
    }

    public int getHour()
    {
        return hour;
    }
}
