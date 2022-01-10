package json;

import domain.BasicStudent;
import domain.Student;

import java.util.HashMap;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {

    private HashMap<String, Json> map = new HashMap<>();

    public JsonObject(JsonPair... jsonPairs) {
        for (JsonPair pair:jsonPairs) {
            map.put(pair.key, pair.value);
        }
    }

    @Override
    public String toJson() {
        if (map.isEmpty()) return "{}";
        String s = "{";

        for (String key:map.keySet()) {
            s += key;
            s += ": ";
            s += map.get(key).toJson();
            s += ", ";
        }

        s = s.substring(0, s.length() - 2);
        s += "}";

        return s;
    }

    public void add(JsonPair jsonPair) {
        map.put(jsonPair.key, jsonPair.value);
    }

    public Json find(String name) {
        return map.get(name);
    }

    public JsonObject projection(String... names) {
        JsonObject jRes = new JsonObject();
        for (String name: names) {
            if (!(find(name) == null)) {
                jRes.add(new JsonPair(name, find(name)));
            }
        }
        return jRes;
    }
}
