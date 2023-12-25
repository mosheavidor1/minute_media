package api_users.infra.api.json;

import java.util.HashMap;
import java.util.Map;

public class JsonBody {


        private final Map<String, String> jsonMap;

        public JsonBody() {
            this.jsonMap = new HashMap<>();
        }

        public void addProperty(String key, String value) {
            jsonMap.put(key, value);
        }

        public Map<String, String> getJsonMap() {
            return jsonMap;
        }
    }


