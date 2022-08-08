public class Time
{
    private int hour;
    private int min;
    private boolean am;

    /**
     * object that holds minutes and hours
     * @param h if given hour is less than 1 hour will be set to 1 if hour is greater than 12 it will roll over
     * @param m if given minute is less than 0 minute will be set to 0 if minute is greater than 60 it will roll over
     * @param a if true time will be AM else time will be PM unless affected by rollover
     */
    public Time(int h, int m, boolean a)
    {
        hour = h < 1 ? 1 : h;
        min = m < 0 ? 1 : m;
        am = a;
        checkTime();
    }

    /**
     *
     * @param h if given hour is less than 1 hour will be set to 1 if hour is greater than 12 it will roll over
     * @param m if given minute is less than 0 minute will be set to 0 if minute is greater than 60 it will roll over
     * @param a if true time will be AM else time will be PM unless affected by rollover
     */
    public void setTime(int h, int m, boolean a)
    {
        hour = h;
        min = m;
        am = a;
        checkTime();
    }

    /**
     *
     * @param m number of minutes to add
     */
    public void addTime(int m)
    {
        min += m;
        checkTime();
    }

    /**
     * makes sure that hours minutes and pm are correct
     */
    private void checkTime()
    {
        hour += min/60;
        min = min%60;
        if(hour >= 12)
        {
            am = am ? false : true;
            hour = hour > 12 ? 1 : hour;
        }
    }

    @Override
    public String toString() {
        return (hour < 10 ? "0" + hour: hour) + ":"+(min<10? "0" + min: min)+ (am?"AM":"PM");
    }

    /**
     *
     * @return returns hour
     */
    public int getHour()
    {
        return hour;
    }
}
