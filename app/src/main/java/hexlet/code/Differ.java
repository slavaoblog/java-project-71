package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class Differ {
    public static HashMap<String, Object> getData(Path path) throws Exception {
        String content = new String(Files.readAllBytes(path));
        return Parser.parse(content);
    }

    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        HashMap<String, Object> map1 = getData(absolutePath(filePath1));
        HashMap<String, Object> map2 = getData(absolutePath(filePath2));

        List<Node> differences = DiffCalculator.calculate(map1, map2);
        return Formatter.format(differences, format);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }

    public static Path absolutePath(String path) throws Exception {
        Path absolutePath = Paths.get(path).toAbsolutePath().normalize();
        if (!Files.exists(absolutePath)) {
            throw new Exception("File '" + absolutePath + "' does not exist");
        }
        return absolutePath;
    }
}
