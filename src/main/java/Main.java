/*
{
    "ipad": {
        "air": {},
        "pro": {
            "compare": {},
            "accessories": {},
            "specs": {}
        }
    }
}

/ipad/pro/max
*/


import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.json.JSONObject;

class Main {
    private static final String startJson = "{\n" +
            "   \"ipad\":{\n" +
            "      \"air\":{\n" +
            "         \n" +
            "      },\n" +
            "      \"pro\":{\n" +
            "         \"compare\":{\n" +
            "            \n" +
            "         },\n" +
            "         \"accessories\":{\n" +
            "            \n" +
            "         },\n" +
            "         \"specs\":{\n" +
            "            \n" +
            "         }\n" +
            "      }\n" +
            "   }\n" +
            "}";

    private static final String path = "ipad/pro/max/15";

    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject(startJson);
        addKeys(jsonObject, path);
        System.out.println(jsonObject);
    }

    public static void addKeys(JSONObject jsonObj, String path) {
        String [] keys = path.split("/");
        String key = keys[0];
        if(!jsonObj.has(key)) {
            JSONObject value = new JSONObject();
            jsonObj.put(key, value);
        }
        String newPath = Stream.of(keys).skip(1).collect(Collectors.joining("/"));
        if (newPath.length() > 0) {
            addKeys((JSONObject) jsonObj.get(key), newPath);
        }
    }
}
