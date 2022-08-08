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
        events.forEach(e -> System.out.println(e));



        //createTracks

        //print solution

    }
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
                .collect(Collectors.toList()));
    }
    public void createTracks()
    {
        //tracks = total time / 420
        /*
        copy events
        while(copy != 0)
        {
            solve with tracks
            tracks ++
        }
         */
    }
}
