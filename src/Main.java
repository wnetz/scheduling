import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main
{
    static ArrayList<Track> tracks;
    static ArrayList<Event> events;

    public static void main(String[] args)
    {
        System.out.println("Hello World");

        fillEvents();
        events = new ArrayList<>(events.stream().sorted().collect(Collectors.toList()));

        //initialise track to the theoretical minimum number of tracks
        int numTracks = events.parallelStream().reduce(0, (acc, next) -> acc + next.duration(), (t1, t2) -> t1 + t2) / (Track.MORNING_TIME+Track.EVENING_TIME);
        createTracks(numTracks);

        //make deep copy of events
        ArrayList<Event> eventsCopy = new ArrayList<>();
        for(Event event: events)
        {
            eventsCopy.add(event);
        }

        //while no solution exists increment the number of tracks
        while (!solve(eventsCopy))
        {
            numTracks++;
            createTracks(numTracks);
            //make deep copy of events
            eventsCopy = new ArrayList<>();
            for(Event event: events)
            {
                eventsCopy.add(event);
            }
        }

        for(Track track:tracks)
        {
            System.out.println(track + "\n");
        }

    }

    /**
     * fill events with input fotm file
     */
    public static void fillEvents()
    {
        List<String> evnts = new ArrayList<>();
        try
        {
            evnts = Files.readAllLines(Paths.get("./src/input.txt"));
        }
        catch (IOException e)
        {
            System.out.println("no File");
        }
        // have to use \\^ instead of ^ because ^ is an escape charector
        events = new ArrayList<>(evnts.stream()
                .filter(event -> event.split("\\^").length == 2)
                .map(a->
                {
                    String[] event = a.split("\\^");
                    if(event[1].equals("lightning"))
                    {
                        return new Event(event[0],5);
                    }
                    else
                    {
                        try
                        {
                            return new Event(event[0], Integer.valueOf(event[1]));
                        }
                        catch (NumberFormatException e)
                        {
                            System.out.println(event[1] +  " is an invalid time");
                            return null;
                        }

                    }
                })
                .filter(duration -> duration != null)
                .collect(Collectors.toList()));
    }

    public static void createTracks(int numTracks)
    {
        tracks = new ArrayList<>();
        for (int i = 0; i < numTracks; i++) {
            tracks.add(new Track());
        }
    }

    public static boolean solve(ArrayList<Event> events)
    {
        int size;
        do
        {
            size = events.size();
            for (Track track : tracks)
            {
                if(events.size()>0)
                {
                    if(!track.addMorning(events.get(events.size()-1)))
                    {
                        if(track.addEvening(events.get(events.size()-1)))
                        {
                            events.remove(events.get(events.size()-1));
                        }
                    }
                    else
                    {
                        events.remove(events.get(events.size()-1));
                    }
                }
            }
        }
        while (size != events.size());
        return events.size()==0;
    }
}
