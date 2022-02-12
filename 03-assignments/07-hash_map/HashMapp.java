import java.util.HashMap;

public class HashMapp {
    public static void Challange() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("sjshdfjhs", "shhdfjdfhs");
        map.put("shfjdhsjkg", "sjhfsjkah");
        map.put("jhsjkghdks", "sjhgdjg");
        map.put("jhbgjdb", "jdghjegd");

        String val = map.get("MapHash");

        for (String key : map.keySet()) {
            System.out.println(String.format("Track: %s: Lyrics: %s", key, map.get(key)));
        }


    }
}