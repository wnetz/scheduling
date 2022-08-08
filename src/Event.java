public record Event(String description, int duration) implements Comparable<Event>
{
    @Override
    public String toString() {
        return description + "\t" + (duration == 5 ? "lighting" : duration + " min");
    }

    @Override
    public int compareTo(Event o) {
        return Integer.compare(duration, o.duration);
    }
}
