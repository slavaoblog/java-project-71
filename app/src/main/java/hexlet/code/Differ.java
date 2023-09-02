package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Differ {
    public static HashMap<String, String> getData(Path path) throws Exception {
        String content = new String(Files.readAllBytes(path));
        return Parser.parse(content);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        HashMap<String, String> map1 = getData(absolutePath(filePath1));
        HashMap<String, String> map2 = getData(absolutePath(filePath2));

        Set<String> combinedKeySet = new LinkedHashSet<>();
        combinedKeySet.addAll(map1.keySet());
        combinedKeySet.addAll(map2.keySet());

        Set<String> sortedKeySet = combinedKeySet.stream()
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));

        StringBuilder result = new StringBuilder("{\n");
        for (String key : sortedKeySet) {
            if (!map1.containsKey(key)) {
                result.append("  + ").append(key).append(": ").append(map2.get(key)).append("\n");
            } else if (!map2.containsKey(key)) {
                result.append("  - ").append(key).append(": ").append(map1.get(key)).append("\n");
            } else if (map1.get(key).equals(map2.get(key))) {
                result.append("    ").append(key).append(": ").append(map1.get(key)).append("\n");
            } else if (!map1.get(key).equals(map2.get(key))) {
                result.append("  - ").append(key).append(": ").append(map1.get(key)).append("\n")
                        .append("  + ").append(key).append(": ").append(map2.get(key)).append("\n");
            }
        }
        result.append("}");
        return result.toString();
    }

    public static Path absolutePath(String path) throws Exception {
        Path absolutePath = Paths.get(path).toAbsolutePath().normalize();
        if (!Files.exists(absolutePath)) {
            throw new Exception("File '" + absolutePath + "' does not exist");
        }
        return absolutePath;
    }
}
