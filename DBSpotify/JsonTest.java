import java.io.FileNotFoundException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonTest {

    public static void main (String aargs[])
    {
        JSONParser parser = new JSONParser();
        try {
            JSONArray tracks = (JSONArray) parser.parse(new FileReader("./Sample.json"));
        } catch (FileNotFoundException e) { e.printStackTrace(); }
    }
}