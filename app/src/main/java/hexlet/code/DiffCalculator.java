package hexlet.code;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class DiffCalculator {
    public static List<Node> calculate(Map<String, Object> map1, Map<String, Object> map2) {
        Set<String> combinedKeySet = new LinkedHashSet<>();
        combinedKeySet.addAll(map1.keySet());
        combinedKeySet.addAll(map2.keySet());

        Set<String> sortedKeySet = combinedKeySet.stream()
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));

        List<Node> result = new ArrayList<>();

        for (String key : sortedKeySet) {
            if (!map1.containsKey(key)) {
                result.add(new Node("added", key, map1.get(key), map2.get(key)));
            } else if (!map2.containsKey(key)) {
                result.add(new Node("deleted", key, map1.get(key), map2.get(key)));
            } else if (!Objects.equals(map1.get(key), map2.get(key))) {
                result.add(new Node("changed", key, map1.get(key), map2.get(key)));
            } else {
                result.add(new Node("unchanged", key, map1.get(key), map2.get(key)));
            }
        }
        return result;
    }
}
