package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;

public class Parser {
    public static HashMap<String, String> parse(String content) throws Exception {
        return parseContent(content);
//        ObjectMapper mapper = new ObjectMapper();
//        StringBuilder sb = new StringBuilder();
//        Files.readAllLines(path)
//                .forEach(sb::append);
//        HashMap map = mapper.readValue(sb.toString(), HashMap.class);
//        HashMap<String, String> result = new HashMap<>();
//        for (Object key : map.keySet()) {
//            result.put((String) key, "" + map.get(key));
//        }
//        return result;
    }

    public static HashMap<String, String> parseContent(String content) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        return objectMapper.readValue(content, new TypeReference<HashMap<String, String>>() { });
    }
}

