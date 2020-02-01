import java.io.*;


public class SpotifyWrapper {



    /* Data structures idea
    *   put everything into a spreadsheet?
    *   Row 1: Name
    *   Row 2: Times
    *   Row 3: Listen time
    */

    private BufferedReader br;

    // Credit 1: https://stackoverflow.com/questions/5421653/reset-buffer-with-bufferedreader-in-java


    public SpotifyWrapper(String path)
    {
        // Save the json file as something call instantiate stuff
        File file = new File(path); 
        try {
            br = new BufferedReader(new FileReader(file)); 
            br.mark(0);
        } catch (Exception e){ e.printStackTrace(); }  
    }

    public String readLine()
    { 
        try {
            return br.readLine(); 
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    void print()
    {
        try {
            if(!br.ready())
                br.reset();
            String st; 
            while ((st = br.readLine()) != null) 
                System.out.println(st);
        } catch (IOException e) { e.printStackTrace(); }
    }

    // add add a new version of the json to the existing one in the storage
    private void load(File file)
    {
        try {
            br.close();
            br = new BufferedReader(new FileReader(file)); 
        } catch (Exception e){ e.printStackTrace(); }
    }

    public void reset()
    {
        // TODO: how the shit
    }

    public String find(String str)
    {
        // find the number of times a string appears in the file       
        try {
            String line = "";

            while(line != null && !line.contains(str))
            { line = br.readLine(); } 
            return line;
        } catch (IOException e) { e.printStackTrace(); }
        return null;
    }
}