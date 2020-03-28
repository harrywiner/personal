import java.util.ArrayList;

public class SpotifyAnalyser {

    private ArrayList<SpotifyWrapper> wrappers;

    // TODO in input method check of wrappers[0] is null
    // TODO statistical model of time when you listen to a song
    // TODO day most listened


    // Constructors
    public SpotifyAnalyser()
    {
        wrappers = new ArrayList<SpotifyWrapper>();
    }

    public SpotifyAnalyser(String path)
    {
        wrappers = new ArrayList<SpotifyWrapper>();
        add(path);
    }

    public SpotifyAnalyser(String paths[])
    {
        wrappers = new ArrayList<SpotifyWrapper>();

        for(String path : paths)
            add(path); 
    }

    public void add(String path)
    {
        wrappers.add(new SpotifyWrapper(path));
    }

    // While loop through calls to find, counting each date, setting one to max and saving the max as a string
    public String dayMostListened()
    {
        String base = wrappers.get(0).find("endTime").substring(17, 28);
        System.out.println(base);
        
        return base;
    }

    public int listenTime(String str, int i)
    {
        // find every time that the string is repeated and add the listen time to the total
        int total = 0;
        while(wrappers.get(i).find(str) != null)
        {
                String line = wrappers.get(i).find("msPlayed");

                if (line != null) {
                    int time = Integer.parseInt(line.substring(17));
                    if(time > 0)
                        total += time;
                }
        }
        return total;
    }
    public int listenTime(String str)
    {
        int total = 0;
        for(int i = 0; i < wrappers.size(); i++)
        {
            total += listenTime(str, i);
        }
        return total;
    }

    public int timesPlayed(String str, int i)
    {
        int count = 0; 
        String line = "";

        while(wrappers.get(i).find(str) != null)
        {
            line = wrappers.get(i).find("msPlayed");
            if (Integer.parseInt(line.substring(17)) >= 10000)
                count++;
        }
        return count;
    }

    public int timesPlayed(String str)
    {
        int total = 0;

        for(int i = 0; i < wrappers.size(); i++)
        {
            total += timesPlayed(str, i);
        }
        return total;
    }
    public static void main(String[] aargs)
    {
        SpotifyAnalyser sa;
        if(aargs.length == 0) {
            String input[] = {"../json/StreamingHistory0.json", "../json/StreamingHistory1.json","../json/StreamingHistory2.json"};
            sa = new SpotifyAnalyser(input);
        } else 
            sa = new SpotifyAnalyser(aargs);

        String str = "Althea";

        //System.out.println(sa.dayMostListened());
        long time = sa.timesPlayed(str);
        
        System.out.println(time + " ms");
        System.out.println(time/1000 + " Seconds");
        System.out.println(time/1000/60 + " Minutes");
        System.out.println(time/1000/60/60 + " Hours");
        System.out.println(time/1000/60/60/24 + " Days");
    }
}