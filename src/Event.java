public record Event(String description, int duration) implements Comparable
{
    @Override
    public int compareTo(Object o) {
        return 0;
    }
    @Override
    public String toString() {
        return null;
    }
}
