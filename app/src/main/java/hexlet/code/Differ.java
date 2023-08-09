package hexlet.code;

import org.codehaus.jackson.map.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Differ {
    public static Map getData(Path path) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        StringBuilder sb = new StringBuilder();
        Files.readAllLines(path).stream()
                .forEach(str -> sb.append(str));
        Map map = mapper.readValue(sb.toString(), HashMap.class);
        Map<String, String> result = new HashMap<>();
        for (Object key : map.keySet()) {
            result.put((String) key, "" + map.get(key));
        }
        return result;
    }

    public static String generate(Map map1, Map map2) {
        Set<String> combinedKeySet = new LinkedHashSet<>();
        combinedKeySet.addAll(map1.keySet());
        combinedKeySet.addAll(map2.keySet());
//        как здесь избежать создания второго сета?
        Set<String> sortedKeySet = combinedKeySet.stream()
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
        StringBuilder result = new StringBuilder("{\n");
        for (String key : sortedKeySet) {
            if (!map1.containsKey(key)) {
                result
                        .append("  + " + key + ": " + map2.get(key) + "\n");
            } else if (!map2.containsKey(key)) {
                result
                        .append("  - " + key + ": " + map1.get(key) + "\n");
            } else if (map1.get(key).equals(map2.get(key))) {
                result
                        .append("    " + key + ": " + map1.get(key) + "\n");
            } else if (!map1.get(key).equals(map2.get(key))) {
                result
                        .append("  - " + key + ": " + map1.get(key) + "\n")
                        .append("  + " + key + ": " + map2.get(key) + "\n");
            }
        }
        result.append("}");
        return result.toString();
    }
}
