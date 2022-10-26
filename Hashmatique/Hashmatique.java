import java.util.HashMap;
import java.util.Set;

public class Hashmatique {

    public HashMap create() {
        HashMap<String, String> myHashMap = new HashMap<String, String>();
        myHashMap.put("Song 1", "Lyrics 1");
        myHashMap.put("Song 2", "Lyrics 2");
        myHashMap.put("Song 3", "Lyrics 3");
        myHashMap.put("Song 4", "Lyrics 4");

        return myHashMap;
    }
    
    public String getByTitle(HashMap hm, String searchKey) {
        return hm.get(searchKey).toString();
    }

    public void printAll(HashMap hm) {
        Set<String> keys = hm.keySet();
        for (String key : keys) {
            System.out.printf("\n Key: %s | Value: %s", key, hm.get(key));
        }
    }
    
}